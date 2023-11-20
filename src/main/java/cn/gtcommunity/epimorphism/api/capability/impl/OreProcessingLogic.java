package cn.gtcommunity.epimorphism.api.capability.impl;

import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.EPMetaTileEntityIntegratedOreFactory;
import gregtech.api.GTValues;
import gregtech.api.capability.*;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.GTUtility;
import gregtech.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;
/*
* Referenced some code from GT5 Unofficial
*
* https://github.com/GTNewHorizons/GT5-Unofficial/
* */

//TODO 重写配方逻辑以添加满箱检测和更好的配方检测
public class OreProcessingLogic implements IWorkable{
    private static final int MAX_PARA = 1024;

    private static final HashSet<Integer> isCrushedOre = new HashSet<>();
    private static final HashSet<Integer> isCrushedPureOre = new HashSet<>();
    private static final HashSet<Integer> isPureDust = new HashSet<>();
    private static final HashSet<Integer> isImpureDust = new HashSet<>();
    private static final HashSet<Integer> isThermal = new HashSet<>();
    private static final HashSet<Integer> isOre = new HashSet<>();

    private ItemStack[] midProduct;

    protected int[] overclockResults;

    private int progressTime = 0;
    protected int maxProgressTime;
    private boolean isActive;
    protected boolean canRecipeProgress = true;
    protected int recipeEUt;

    protected List<FluidStack> fluidOutputs;
    protected NonNullList<ItemStack> itemOutputs;
    protected boolean workingEnabled = true;
    protected boolean hasNotEnoughEnergy;
    protected boolean wasActiveAndNeedsUpdate;
    protected boolean isOutputsFull;

    private int mode = 0;
    private static boolean init = false;
    private boolean isVoidStone = false;
    private final EPMetaTileEntityIntegratedOreFactory metaTileEntity;
    public OreProcessingLogic(EPMetaTileEntityIntegratedOreFactory metaTileEntity) {
        this.metaTileEntity = metaTileEntity;
        //  初始化HashSet
        if (!init) initHash();
    }

    public IEnergyContainer getEnergyContainer() {return metaTileEntity.getEnergyContainer();}

    protected IItemHandlerModifiable getInputInventory() {return metaTileEntity.getInputInventory();}

    protected IItemHandlerModifiable getOutputInventory() {return metaTileEntity.getOutputInventory();}

    protected IMultipleTankHandler getInputTank() {return metaTileEntity.getInputFluidInventory();}
    protected long getEnergyCapacity() {
        return getEnergyContainer().getEnergyCapacity();
    }

    protected List<ItemStack> getInputItems() {
        List<ItemStack> list = new ArrayList<>();
        for (int index = 0; index < getInputInventory().getSlots(); index++) {
            // Skip this slot if it is empty.
            final ItemStack currentInputItem = getInputInventory().getStackInSlot(index);
            if (currentInputItem.isEmpty())
                continue;
            list.add(getInputInventory().getStackInSlot(index));
        }
        return list;
    }

    private boolean depleteInput(FluidStack fluid) {
        if (fluid == null) {
            return false;
        }
        IMultipleTankHandler inputTank = getInputTank();
        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }
        return false;
    }
    //  对要处理的物品进行矿辞分类建表（尤其适用于半路产物加入）
    private static void initHash() {
        for (String name : OreDictionary.getOreNames()) {
            if (name == null || name.isEmpty()) continue;
            if (name.startsWith("crushedPurified")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isCrushedPureOre.add(EPUniverUtil.stackToInt(stack));
                }
            } else if (name.startsWith("crushedCentrifuged")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isThermal.add(EPUniverUtil.stackToInt(stack));
                }
            } else if (name.startsWith("crushed")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isCrushedOre.add(EPUniverUtil.stackToInt(stack));
                }
            } else if (name.startsWith("dustImpure")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isImpureDust.add(EPUniverUtil.stackToInt(stack));
                }
            } else if (name.startsWith("dustPure")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isPureDust.add(EPUniverUtil.stackToInt(stack));
                }
            } else if (name.startsWith("ore")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    isOre.add(EPUniverUtil.stackToInt(stack));
                }
            }
        }
    }

    //  对中间产物进行配方检测，输出加入t_product，无输出则向t_product加入stack
    @SafeVarargs
    private void doMac(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.MACERATOR_RECIPES
                            .findRecipe(GTValues.V[14], Collections.singletonList(stack), Collections.emptyList());
                    if (recipe != null) {
                        t_product.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    @SafeVarargs
    private void doWash(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.ORE_WASHER_RECIPES.findRecipe(
                            GTValues.V[14],
                            Collections.singletonList(stack),
                            Collections.singletonList(Materials.DistilledWater.getFluid(Integer.MAX_VALUE))
                            );
                    if (recipe != null) {
                        t_product.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    @SafeVarargs
    private void doThermal(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.THERMAL_CENTRIFUGE_RECIPES
                            .findRecipe(GTValues.V[14],  Collections.singletonList(stack), Collections.emptyList());
                    if (recipe != null) {
                        t_product.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    @SafeVarargs
    private void doCentrifuge(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.CENTRIFUGE_RECIPES
                            .findRecipe(GTValues.V[14], Collections.singletonList(stack), Collections.emptyList());
                    if (recipe != null) {
                        t_product.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    @SafeVarargs
    private void doSift(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.SIFTER_RECIPES
                            .findRecipe(GTValues.V[14], Collections.singletonList(stack), Collections.emptyList());
                    if (recipe != null) {
                        t_product.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    //  化学浸洗，额外计算消耗的液体并消耗，向t_product加入已浸洗物品的产物和未浸洗物品
    @SafeVarargs
    private void doChemWash(HashSet<Integer>... tables) {
        List<ItemStack> t_product = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                int t_id = EPUniverUtil.stackToInt(stack);
                if (checkTypes(t_id, tables)) {
                    Recipe recipe = RecipeMaps.CHEMICAL_BATH_RECIPES.findRecipe(
                            GTValues.V[14],
                            Collections.singletonList(stack),
                            GTUtility.fluidHandlerToList(getInputTank()));
                    if (recipe != null && !recipe.getFluidInputs().isEmpty()) {
                        FluidStack t_input_fluid = recipe.getFluidInputs().get(0).getInputFluidStack()
                                .copy();
                        int t_stored = getFluidAmount(t_input_fluid);
                        int t_washed = Math.min(t_stored / t_input_fluid.amount, stack.getCount());
                        depleteInput(new FluidStack(t_input_fluid.getFluid(), t_washed * t_input_fluid.amount));
                        t_product.addAll(getOutputStack(recipe, t_washed));
                        if (t_washed < stack.getCount()) {
                            t_product.add(EPUniverUtil.copyAmountUnsafe(stack.getCount() - t_washed, stack));
                        }
                    } else {
                        t_product.add(stack);
                    }
                } else {
                    t_product.add(stack);
                }
            }
        }
        doCompress(t_product);
    }

    // 查询存储的fluid数量
    private int getFluidAmount(FluidStack fluid) {
        int t_amt = 0;
        if (fluid == null) return 0;
        for (FluidStack t_fluid : GTUtility.fluidHandlerToList(getInputTank()))
        {
            if (t_fluid.isFluidEqual(fluid)) {
                t_amt += fluid.amount;
            }
        }
        return t_amt;
    }

    private void recipeProcessing() {
        int tCharged = MAX_PARA;
        List<ItemStack> tInput = getInputItems();
        List<FluidStack> tInputFluid = GTUtility.fluidHandlerToList(getInputTank());

        //  初始化蒸馏水和润滑油数量
        int t_lube = 0;
        int t_water = 0;
        //  计算蒸馏水和润滑油数量
        for (FluidStack fluid : tInputFluid) {
            if (fluid != null && fluid.isFluidEqual(Materials.DistilledWater.getFluid(1))) {
                t_water += fluid.amount;
            } else if (fluid != null && fluid.isFluidEqual(Materials.Lubricant.getFluid(1))) {
                t_lube += fluid.amount;
            }
        }

        tCharged = Math.min(tCharged, t_lube / 2);
        tCharged = Math.min(tCharged, t_water / 200);
        tCharged = (int) Math.min(tCharged, getMaxVoltage() / 30L);

        List<ItemStack> tOres = new ArrayList<>();
        int tRealUsed = 0;

        for (ItemStack ore : tInput) {
            if (tCharged <= 0) break;
            int t_id = EPUniverUtil.stackToInt(ore);
            if (t_id == 0) continue;
            if (isPureDust.contains(t_id) || isImpureDust.contains(t_id)
                    || isCrushedPureOre.contains(t_id)
                    || isThermal.contains(t_id)
                    || isCrushedOre.contains(t_id)
                    || isOre.contains(t_id)) {
                if (ore.getCount() <= tCharged) {
                    tRealUsed += ore.getCount();
                    tOres.add(GTUtility.copy(ore));
                    tCharged -= ore.getCount();
                    ore.setCount(0);
                } else {
                    tRealUsed = tCharged;
                    tOres.add(EPUniverUtil.copyAmountUnsafe(tCharged, ore));
                    ore.setCount(ore.getCount() - tCharged);
                    tCharged = 0;
                    break;
                }
            }
        }

        if (tRealUsed != 0) {
            overclockResults = calculateOverclock(tRealUsed);
            depleteInput(Materials.DistilledWater.getFluid(tRealUsed * 200));
            depleteInput(Materials.Lubricant.getFluid(tRealUsed * 2));

            midProduct = tOres.toArray(new ItemStack[0]);
            switch (mode) {
                case 0 -> {
                    doMac(isOre);
                    doWash(isCrushedOre);
                    doThermal(isCrushedPureOre, isCrushedOre);
                    doMac(isThermal, isOre, isCrushedOre, isCrushedPureOre);
                }
                case 1 -> {
                    doMac(isOre);
                    doWash(isCrushedOre);
                    doMac(isOre, isCrushedOre, isCrushedPureOre);
                    doCentrifuge(isImpureDust, isPureDust);
                }
                case 2 -> {
                    doMac(isOre);
                    doMac(isThermal, isOre, isCrushedOre, isCrushedPureOre);
                    doCentrifuge(isImpureDust, isPureDust);
                }
                case 3 -> {
                    doMac(isOre);
                    doWash(isCrushedOre);
                    doSift(isCrushedPureOre);
                }
                case 4 -> {
                    doMac(isOre);
                    doChemWash(isCrushedOre, isCrushedPureOre);
                    doMac(isCrushedOre, isCrushedPureOre);
                    doCentrifuge(isImpureDust, isPureDust);
                }
                default -> {

                }
            }
            if (itemOutputs == null) {
                itemOutputs = NonNullList.create();
            }
            progressTime = 1;
            maxProgressTime = overclockResults[0];
            recipeEUt = overclockResults[1];
            itemOutputs.addAll(Arrays.asList(midProduct));
        }
    }

    private int[] calculateOverclock(int parallelNumber) {
        long recipeVoltage = parallelNumber * 30L;
        int overclockNumber = (int) Math.floor(Math.log((double)(getMaxVoltage() / recipeVoltage)) / Math.log(4));
        int[] overclockResult = new int[2];
        overclockResult[0] = (int) (getTime(mode) / Math.pow(2, overclockNumber));
        overclockResult[1] = (int) (recipeVoltage * Math.pow(4, overclockNumber));
        return overclockResult;
    }

    private static int getTime(int mode) {
        return switch (mode) {
            case 0 -> 30 * 20;
            case 1 -> 15 * 20;
            case 2 -> 10 * 20;
            case 3 -> 20 * 20;
            case 4 -> 17 * 20;
            default -> 1000000000;
        };
    }

    protected long getEnergyInputPerSecond() {
        return getEnergyContainer().getInputPerSec();
    }

    protected long getEnergyStored() {
        return getEnergyContainer().getEnergyStored();
    }

    protected boolean drawEnergy(int recipeEUt, boolean simulate) {
        long resultEnergy = getEnergyStored() - recipeEUt;
        if (resultEnergy >= 0L && resultEnergy <= getEnergyCapacity()) {
            if (!simulate) getEnergyContainer().changeEnergy(-recipeEUt);
            return true;
        } else return false;
    }

    protected long getMaxVoltage() {
        IEnergyContainer energyContainer = getEnergyContainer();
        if (energyContainer instanceof EnergyContainerList) {
            long voltage;
            long amperage;
            if (energyContainer.getInputVoltage() > energyContainer.getOutputVoltage()) {
                voltage = energyContainer.getInputVoltage();
                amperage = energyContainer.getInputAmperage();
            } else {
                voltage = energyContainer.getOutputVoltage();
                amperage = energyContainer.getOutputAmperage();
            }

            if (amperage == 1) {
                // amperage is 1 when the energy is not exactly on a tier

                // the voltage for recipe search is always on tier, so take the closest lower tier
                return GTValues.V[GTUtility.getFloorTierByVoltage(voltage)];
            } else {
                // amperage != 1 means the voltage is exactly on a tier
                // ignore amperage, since only the voltage is relevant for recipe search
                // amps are never > 3 in an EnergyContainerList
                return voltage;
            }
        }
        return Math.max(energyContainer.getInputVoltage(), energyContainer.getOutputVoltage());
    }

    public void update() {
        World world = getMetaTileEntity().getWorld();
        if (world != null && !world.isRemote) {
            if (workingEnabled) {
                if (progressTime > 0) {
                    setActive(true);
                    updateRecipeProgress();
                }
                //check everything that would make a recipe never start here.
                if (progressTime == 0 && shouldProcessRecipe()) {
                    recipeProcessing();
                }
            }
            if (wasActiveAndNeedsUpdate) {
                this.wasActiveAndNeedsUpdate = false;
                setActive(false);
            }
        }
    }

    protected void updateRecipeProgress() {
        if (canRecipeProgress && drawEnergy(recipeEUt, true)) {
            drawEnergy(recipeEUt, false);
            //as recipe starts with progress on 1 this has to be > only not => to compensate for it
            if (++progressTime > maxProgressTime) {
                completeRecipe();
            }
            if (this.hasNotEnoughEnergy && getEnergyInputPerSecond() > 19L * recipeEUt) {
                this.hasNotEnoughEnergy = false;
            }
        } else if (recipeEUt > 0) {
            //only set hasNotEnoughEnergy if this recipe is consuming recipe
            //generators always have enough energy
            this.hasNotEnoughEnergy = true;
            decreaseProgress();
        }
    }

    protected void decreaseProgress() {
        //if current progress value is greater than 2, decrement it by 2
        if (progressTime >= 2) {
            if (ConfigHolder.machines.recipeProgressLowEnergy) {
                this.progressTime = 1;
            } else {
                this.progressTime = Math.max(1, progressTime - 2);
            }
        }
    }

    protected void completeRecipe() {
        outputRecipeOutputs();
        this.progressTime = 0;
        setMaxProgress(0);
        this.recipeEUt = 0;
        this.itemOutputs = null;
        this.overclockResults = new int[]{0, 0};
        this.hasNotEnoughEnergy = false;
        this.wasActiveAndNeedsUpdate = true;
    }

    protected void outputRecipeOutputs() {
        isOutputsFull = !GTTransferUtils.addItemsToItemHandler(getOutputInventory(), true, itemOutputs);
        GTTransferUtils.addItemsToItemHandler(getOutputInventory(), false, itemOutputs);
    }

    private boolean shouldProcessRecipe() {
        return true;
    }

    //  检测物品是否有对应矿辞
    @SafeVarargs
    private boolean checkTypes(int id, HashSet<Integer>... tables) {
        for (HashSet<Integer> set : tables) {
            if (set.contains(id)) {
                return true;
            }
        }
        return false;
    }

    //  计算配方产物带概率输出
    private List<ItemStack> getOutputStack(Recipe recipe, int time) {
        List<ItemStack> t_output = new ArrayList<>();
        for (ItemStack item : recipe.getOutputs()) {
            t_output.add(EPUniverUtil.copyAmountUnsafe((long) time * item.getCount(), item));
        }
        //  计算产出概率
        for (int i = 0; i < recipe.getChancedOutputs().size(); i++) {
            int tChance = recipe.getChancedOutputs().get(i).getChance();
            // Use Normal Distribution 正态分布
            double u = time * (tChance / 10000D);
            double e = time * (tChance / 10000D) * (1 - (tChance / 10000D));
            Random random = new Random();
            int tAmount = (int) Math.ceil(Math.sqrt(e) * random.nextGaussian() + u);
            t_output.add(
                    EPUniverUtil.copyAmountUnsafe((long) tAmount * recipe.getChancedOutputs().get(i).getItemStack().getCount(), recipe.getChancedOutputs().get(i).getItemStack()));
        }
        return t_output.stream()
                .filter(i -> (i != null && i.getCount() > 0))
                .collect(Collectors.toList());
    }

    //  用t_product中的物品更新midProduct
    private void doCompress(List<ItemStack> list) {
        HashMap<Integer, Integer> r_product = new HashMap<>();
        for (ItemStack stack : list) {
            int t_id = EPUniverUtil.stackToInt(stack);
            //  开启石粉销毁，则跳过加入石粉的循环
            if (isVoidStone) {
                if (stack.isItemEqual(OreDictUnifier.get(OrePrefix.dust, Materials.Stone,  1))) {
                    continue;
                }
            }
            if (t_id != 0) {
                //  重复物品
                if (r_product.containsKey(t_id)) {
                    r_product.put(t_id, r_product.get(t_id) + stack.getCount());
                } else {
                    r_product.put(t_id, stack.getCount());
                }
            }
        }
        //  更新midProduct
        midProduct = new ItemStack[r_product.size()];
        int cnt = 0;
        for (Integer id : r_product.keySet()) {
            ItemStack stack = EPUniverUtil.intToStack(id);
            midProduct[cnt] = EPUniverUtil.copyAmountUnsafe(r_product.get(id), stack);
            cnt++;
        }
    }


    public void invalidate() {
        this.progressTime = 0;
        this.maxProgressTime = 0;
        recipeEUt = 0;
        isOutputsFull = false;
        setActive(false);
    }

    public boolean isVoidStone() {
        return isVoidStone;
    }

    public void setVoidStone(boolean voidStone) {
        isVoidStone = voidStone;
        metaTileEntity.markDirty();
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
        metaTileEntity.markDirty();
    }

    @Nonnull
    public MetaTileEntity getMetaTileEntity() {
        return metaTileEntity;
    }

    @Override
    public boolean isWorkingEnabled() {
        return workingEnabled;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        this.workingEnabled = workingEnabled;
        metaTileEntity.markDirty();
        World world = metaTileEntity.getWorld();
        if (world != null && !world.isRemote) {
            metaTileEntity.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(workingEnabled));
        }
    }

    @Override
    public int getProgress() {
        return this.progressTime;
    }

    @Override
    public int getMaxProgress() {
        return this.maxProgressTime;
    }

    public void setMaxProgress(int maxProgress) {
        this.maxProgressTime = maxProgress;
        metaTileEntity.markDirty();
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            if (metaTileEntity.getWorld() != null && !metaTileEntity.getWorld().isRemote) {
                this.metaTileEntity.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
                this.metaTileEntity.markDirty();
            }
        }
    }

    public double getProgressPercent() {
        return getMaxProgress() == 0 ? 0.0 : getProgress() / (getMaxProgress() * 1.0);
    }
    public int getParallelLimit() { return MAX_PARA; }

    public int getRecipeEUt() {
        return recipeEUt;
    }

    public void receiveCustomData(int dataId, @Nonnull PacketBuffer buf) {
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            getMetaTileEntity().scheduleRenderUpdate();
        }
        if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.workingEnabled = buf.readBoolean();
            getMetaTileEntity().scheduleRenderUpdate();
        }
    }

    public void writeInitialData(@Nonnull PacketBuffer buf) {
        buf.writeBoolean(isActive);
        buf.writeBoolean(workingEnabled);
        buf.writeBoolean(isVoidStone);
    }

    public void receiveInitialData(@Nonnull PacketBuffer buf) {
        this.isActive = buf.readBoolean();
        this.workingEnabled = buf.readBoolean();
        this.isVoidStone = buf.readBoolean();
    }

    @Nonnull
    public NBTTagCompound serializeNBT(NBTTagCompound compound) {
        compound.setBoolean("WorkEnabled", workingEnabled);
        compound.setBoolean("CanRecipeProgress", canRecipeProgress);
        compound.setBoolean("isVoidStone", isVoidStone);
        compound.setInteger("mode", mode);
        if (progressTime > 0) {
            compound.setInteger("Progress", progressTime);
            compound.setInteger("MaxProgress", maxProgressTime);
            compound.setInteger("RecipeEUt", this.recipeEUt);
            NBTTagList itemOutputsList = new NBTTagList();
            for (ItemStack itemOutput : itemOutputs) {
                itemOutputsList.appendTag(itemOutput.writeToNBT(new NBTTagCompound()));
            }
            compound.setTag("ItemOutputs", itemOutputsList);
        }
        return compound;
    }

    public void deserializeNBT(@Nonnull NBTTagCompound compound) {
        this.workingEnabled = compound.getBoolean("WorkEnabled");
        this.canRecipeProgress = compound.getBoolean("CanRecipeProgress");
        this.isVoidStone = compound.getBoolean("isVoidStone");
        this.progressTime = compound.getInteger("Progress");
        this.mode = compound.getInteger("mode");
        if (progressTime > 0) {
            this.isActive = true;
            this.maxProgressTime = compound.getInteger("MaxProgress");
            this.recipeEUt = compound.getInteger("RecipeEUt");
            NBTTagList itemOutputsList = compound.getTagList("ItemOutputs", Constants.NBT.TAG_COMPOUND);
            this.itemOutputs = NonNullList.create();
            for (int i = 0; i < itemOutputsList.tagCount(); i++) {
                this.itemOutputs.add(new ItemStack(itemOutputsList.getCompoundTagAt(i)));
            }
        }
    }
}
