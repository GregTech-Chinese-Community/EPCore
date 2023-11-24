package cn.gtcommunity.epimorphism.common.metatileentities.multiblock.generator;

import cn.gtcommunity.epimorphism.api.capability.EPDataCode;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.IMegaTurbine;
import cn.gtcommunity.epimorphism.api.capability.IReinforcedRotorHolder;
import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.EPMultiblockAbility;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import gregtech.api.GTValues;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.ImageCycleButtonWidget;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.api.util.LocalizationUtils;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.items.behaviors.TurbineRotorBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EPMetaTileEntityMegaTurbine extends FuelMultiblockController implements ITieredMetaTileEntity, IMegaTurbine {

    private int mode = 0;

    public final int tier;
    public final IBlockState casingState;
    public final IBlockState gearboxState;
    public final ICubeRenderer casingRenderer;
    public final boolean hasMufflerHatch;
    public final ICubeRenderer frontOverlay;
    private static final int MIN_DURABILITY_TO_WARN = 10;
    public IFluidHandler exportFluidHandler;


    public EPMetaTileEntityMegaTurbine(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, int tier, IBlockState casingState, IBlockState gearboxState, ICubeRenderer casingRenderer, boolean hasMufflerHatch, ICubeRenderer frontOverlay) {
        super(metaTileEntityId, recipeMap, tier);
        this.casingState = casingState;
        this.gearboxState = gearboxState;
        this.casingRenderer = casingRenderer;
        this.hasMufflerHatch = hasMufflerHatch;
        this.frontOverlay = frontOverlay;
        this.tier = tier;
        this.recipeMapWorkable = new MegaTurbineWorkableHandler(this, tier);
        this.recipeMapWorkable.setMaximumOverclockVoltage(GTValues.V[tier]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityMegaTurbine(metaTileEntityId, recipeMap, tier, casingState, gearboxState, casingRenderer, hasMufflerHatch, frontOverlay);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        this.exportFluidHandler = new FluidTankList(true, getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        ((MegaTurbineWorkableHandler) this.recipeMapWorkable).updateTanks();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.exportFluidHandler = null;
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess) && checkRotors() && checkRotorMaterial();
    }

    @Override
    protected long getMaxVoltage() {
        long maxProduction = ((MegaTurbineWorkableHandler) recipeMapWorkable).getMaxVoltage();
        long currentProduction = ((MegaTurbineWorkableHandler) recipeMapWorkable).boostProduction((int) maxProduction);
        if (isActive() && currentProduction < maxProduction) {
            return ((MegaTurbineWorkableHandler) recipeMapWorkable).getMaxVoltage();
        } else {
            return 0L;
        }
    }

    protected boolean isRotorFaceFree() {
        List<IReinforcedRotorHolder> rotorHolders = getRotorHolders();
        if (!isStructureFormed() || rotorHolders == null) return false;

        for (IReinforcedRotorHolder rotorHolder : rotorHolders) {
            if (!rotorHolder.isFrontFaceFree()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<IReinforcedRotorHolder> getRotorHolders() {
        List<IReinforcedRotorHolder> abilities = getAbilities(EPMultiblockAbility.REINFORCED_ROTOR_MULTIBLOCK_ABILITY);
        if (abilities.isEmpty())
            return null;
        return abilities;
    }

    //TODO 添加更智能的检测机制
    protected void setupRotors() {
        if (checkRotors()) return;
        for (int index = 0; index < inputInventory.getSlots(); index++) {
            ItemStack itemStack = inputInventory.getStackInSlot(index);
            if (itemStack.isEmpty()) continue;

            if (TurbineRotorBehavior.getInstanceFor(itemStack) == null) continue;

            for (IReinforcedRotorHolder holder : getRotorHolders()) {
                if (!holder.hasRotor()) {
                    inputInventory.extractItem(index, 1, false);
                    holder.setRotor(itemStack);
                    break;
                }
            }
        }
    }

    protected void setSpeed(int speed) {
        for (IReinforcedRotorHolder holder : getRotorHolders()) {
            if (holder.hasRotor()) {
                holder.setCurrentSpeed(speed);
            }
        }
    }

    protected boolean checkRotors() {
        for (IReinforcedRotorHolder holder : getRotorHolders()) {
            if (!holder.hasRotor()) {
                return false;
            }
        }
        return true;
    }

    protected boolean checkRotorMaterial() {
        return getRotorHolders().stream()
                .map(IReinforcedRotorHolder::getRotorMaterial)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet()).size() == 1;
    }

    @Override
    public void update() {
        super.update();
        if (getOffsetTimer() % 20 == 0) {
            if (!checkRotors()) {
                setSpeed(0);
            }
            if (!getWorld().isRemote && isStructureFormed()) {
                setupRotors();
            }
        }
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(
                        "CCCCCCC",
                        "CRCACRC",
                        "CCCACCC",
                        "CCCACCC",
                        "CRCACRC",
                        "CCCACCC",
                        "CCCACCC",
                        "CRCACRC",
                        "CCCCCCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCMMMCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCMSMCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCMMMCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC",
                        "CCCCCCC",
                        "CGCCCGC",
                        "CCCCCCC"
                )
                .aisle(
                        "CCCCCCC",
                        "CRCACRC",
                        "CCCACCC",
                        "CCCACCC",
                        "CRCACRC",
                        "CCCACCC",
                        "CCCACCC",
                        "CRCACRC",
                        "CCCCCCC"
                )
                .where('S', selfPredicate())
                .where('C', states(getCasingState()))
                .where('G', states(getGearBoxState()))
                .where('R', EPTraceabilityPredicate.ROTOR_HOLDER.get())
                .where('M', states(getCasingState()).or(abilities(MultiblockAbility.MUFFLER_HATCH)))
                .where('A', states(getCasingState())
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4))
                )
                .build();
    }

    public IBlockState getCasingState() {
        return casingState;
    }

    public IBlockState getGearBoxState() {
        return gearboxState;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return casingRenderer;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return frontOverlay;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            IReinforcedRotorHolder rotorHolder = getRotorHolders().get(0);

            if (checkRotors() && checkRotorMaterial() && rotorHolder.getRotorEfficiency() > 0) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.rotor_speed", TextFormattingUtil.formatNumbers(rotorHolder.getRotorSpeed()), TextFormattingUtil.formatNumbers(rotorHolder.getMaxRotorHolderSpeed())));
                textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.efficiency", rotorHolder.getTotalEfficiency()));

                long maxProduction = ((MegaTurbineWorkableHandler) recipeMapWorkable).getMaxVoltage();
                long currentProduction = isActive() ? ((MegaTurbineWorkableHandler) recipeMapWorkable).boostProduction((int) maxProduction) : 0;
                String voltageName = GTValues.VNF[GTUtility.getTierByVoltage(currentProduction)];

                if (isActive()) {
                    textList.add(3, new TextComponentTranslation("gregtech.multiblock.turbine.energy_per_tick", TextFormattingUtil.formatNumbers(currentProduction), voltageName));
                }

                int rotorDurability = rotorHolder.getRotorDurabilityPercent();
                if (rotorDurability > MIN_DURABILITY_TO_WARN) {
                    textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.rotor_durability", rotorDurability));
                } else {
                    textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.rotor_durability", rotorDurability).setStyle(new Style().setColor(TextFormatting.RED)));
                }
            }
        }
    }

    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        super.addWarningText(textList);
        if (isStructureFormed()) {
            if (!checkRotors()) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.no_rotor"));
            }
        }
    }

    @Override
    protected void addErrorText(List<ITextComponent> textList) {
        super.addErrorText(textList);
        if (isStructureFormed() && !isRotorFaceFree()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.turbine.obstructed").setStyle(new Style().setColor(TextFormatting.RED)));
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.base_production_eut", GTValues.V[tier] * 2 * 16));
        tooltip.add(I18n.format("gregtech.multiblock.turbine.efficiency_tooltip", GTValues.VNF[tier]));
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("epimorphism.multiblock.mega_turbine.description")};
    }

    @Nonnull
    @Override
    protected Widget getFlexButton(int x, int y, int width, int height) {
        return new ImageCycleButtonWidget(x, y, width, height, EPGuiTextures.BUTTON_STRUCTURE_SWITCHING,
                2, this::getMode, this::setMode)
                .shouldUseBaseBackground().singleTexture()
                .setTooltipHoverString(i -> LocalizationUtils.format("epimorphism.machine.mega_turbine.mode." + getMode()));
    }

    @Override
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
        if (!getWorld().isRemote) {
            writeCustomData(EPDataCode.EP_CHANNEL_6, buf -> buf.writeByte(mode));
            markDirty();
        }
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == EPDataCode.EP_CHANNEL_6) {
            this.mode = buf.readByte();
            scheduleRenderUpdate();
        }
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public boolean isStructureObstructed() {
        return super.isStructureObstructed() || !isRotorFaceFree();
    }

    @Override
    public boolean hasMufflerMechanics() {
        return hasMufflerHatch;
    }

    @Override
    public boolean canVoidRecipeItemOutputs() {
        return true;
    }

    @Override
    public boolean canVoidRecipeFluidOutputs() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeByte(mode);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.mode = buf.readByte();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setByte("mode", (byte) mode);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.mode = data.getByte("mode");
    }
}
