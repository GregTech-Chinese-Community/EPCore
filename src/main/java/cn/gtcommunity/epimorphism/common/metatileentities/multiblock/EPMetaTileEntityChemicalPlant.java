package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTier;
import cn.gtcommunity.epimorphism.api.capability.EPDataCode;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.recipe.properties.CasingTierProperty;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.EPMultiblockAbility;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import cn.gtcommunity.epimorphism.loaders.formula.CatalystFormula;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.VA;

public class EPMetaTileEntityChemicalPlant extends RecipeMapMultiblockController {
    private int coilLevel;
    private int casingTier;
    private int tubeTier;
    private int voltageTier;
    private int tier;

    //TODO 生成预览使用 未来优化器其架构
    private int count = 0;
    List<IBlockState> listCoil = GregTechAPI.HEATING_COILS.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    List<IBlockState> listCasing = EPAPI.MAP_CP_CASING.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    List<IBlockState> listTube = EPAPI.MAP_CP_TUBE.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    List<IBlockState> listMachineCasing = EPAPI.MAP_MACHINE_CASING.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    int maxLeng = EPUniverUtil.maxLength(new ArrayList<List<IBlockState>>() {{
        add(listCoil);
        add(listCasing);
        add(listTube);
        add(listMachineCasing);
    }});
    List<IBlockState> finalListCoil = EPUniverUtil.consistentList(listCoil, maxLeng);
    List<IBlockState> finalListCasing = EPUniverUtil.consistentList(listCasing, maxLeng);
    List<IBlockState> finalListTube = EPUniverUtil.consistentList(listTube, maxLeng);
    List<IBlockState> finalListMachineCasing = EPUniverUtil.consistentList(listMachineCasing, maxLeng);

    public EPMetaTileEntityChemicalPlant(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.CHEMICAL_PLANT_RECIPES);
        this.recipeMapWorkable = new ChemicalPlantLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityChemicalPlant(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        Object casingTier = context.get("ChemicalPlantCasingTieredStats");
        Object tubeTier = context.get("ChemicalPlantTubeTieredStats");
        Object voltageTier = context.get("MachineCasingTypeTieredStats");
        this.coilLevel = EPUniverUtil.getOrDefault(() -> coilType instanceof IHeatingCoilBlockStats,
                () ->  ((IHeatingCoilBlockStats) coilType).getLevel(),
                BlockWireCoil.CoilType.CUPRONICKEL.getLevel());
        this.casingTier = EPUniverUtil.getOrDefault(() -> casingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier)casingTier).getIntTier(),
                0);
        this.tubeTier = EPUniverUtil.getOrDefault(() -> tubeTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier)tubeTier).getIntTier(),
                0);
        this.voltageTier = EPUniverUtil.getOrDefault(() -> voltageTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier)voltageTier).getIntTier(),
                0);

        this.tier = Math.min(this.casingTier,this.tubeTier);

        this.writeCustomData(EPDataCode.EP_CHANNEL_3, buf -> buf.writeInt(this.casingTier));
    }

    @Override
    protected void initializeAbilities() {
        List<IItemHandlerModifiable> inputItem = new ArrayList<>(this.getAbilities(MultiblockAbility.IMPORT_ITEMS));
        inputItem.addAll(this.getAbilities(EPMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY));
        this.inputInventory = new ItemHandlerList(inputItem);
        this.inputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.outputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        this.energyContainer = new EnergyContainerList(this.getAbilities(MultiblockAbility.INPUT_ENERGY));
    }

    @Override
    public void update() {
        super.update();

        if(this.getWorld().isRemote && this.casingTier == 0){
            this.writeCustomData(EPDataCode.EP_CHANNEL_2, buf -> {});
        }
    }



    @SuppressWarnings("SpellCheckingInspection")
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEEEEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXAXM#", "##TAT##", "##XAX##", "##TAT##", "#MXAXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EEESEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .where('S', selfPredicate())
                .where('E', EPTraceabilityPredicate.EP_CP_CASING.get()
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(EPMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY).setMaxGlobalLimited(2).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('C', EPTraceabilityPredicate.EP_CP_CASING.get())
                .where('X', heatingCoils())
                .where('M', EPTraceabilityPredicate.EP_MACHINE_CASINGS.get())
                .where('T', EPTraceabilityPredicate.EP_CP_TUBE.get())
                .where('#', any())
                .where('A',air())
                .build();
    }
    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return EPTextures.CHEMICAL_PLANT_OVERLAY;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return switch (this.casingTier) {
            case (2) -> Textures.SOLID_STEEL_CASING;
            case (3) -> Textures.FROST_PROOF_CASING;
            case (4) -> Textures.CLEAN_STAINLESS_STEEL_CASING;
            case (5) -> Textures.STABLE_TITANIUM_CASING;
            case (6) -> Textures.ROBUST_TUNGSTENSTEEL_CASING;
            default -> Textures.BRONZE_PLATED_BRICKS;
        };
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("CCCHJCC", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .aisle("CMMMMMC", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("CMMMMMC", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("CMMMMMC", "#MX#XM#", "##T#T##", "##X#X##", "##T#T##", "#MX#XM#", "CCCCCCC")
                    .aisle("CMMMMMC", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("CMMMMMC", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("CVNSKLZ", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .where('S', EPMetaTileEntities.CHEMICAL_PLANT, EnumFacing.SOUTH)
                    .where('V', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.SOUTH)
                    .where('N', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.SOUTH)
                    .where('K', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.SOUTH)
                    .where('L', MetaTileEntities.ITEM_EXPORT_BUS[4], EnumFacing.SOUTH)
                    .where('Z', EPMetaTileEntities.MULTIPART_CATALYST_HATCH, EnumFacing.SOUTH)
                    .where('H', MetaTileEntities.ENERGY_INPUT_HATCH[5], EnumFacing.NORTH)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('J', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF), EnumFacing.NORTH);
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;

        finalListCoil.stream()
                .map(b -> {
                    MultiblockShapeInfo.Builder midFinalBuilder = finalBuilder;
                    if (midFinalBuilder != null) {
                        midFinalBuilder.where('X', b);
                        midFinalBuilder.where('C', finalListCasing.get(count));
                        midFinalBuilder.where('T', finalListTube.get(count));
                        midFinalBuilder.where('M', finalListMachineCasing.get(count));
                        count++;
                    }
                    return midFinalBuilder;
                }).forEach(b -> shapeInfo.add(b.build()));
        count = 0;
        return shapeInfo;
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if(dataId == EPDataCode.EP_CHANNEL_3){
            this.casingTier = buf.readInt();
        }
        if(dataId == EPDataCode.EP_CHANNEL_2){
            this.writeCustomData(EPDataCode.EP_CHANNEL_3, buf1 -> buf1.writeInt(this.casingTier));
        }
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        textList.add(new TextComponentString(I18n.format("epimorphism.machine.chemical_plant.coil_tier", coilLevel)));
        textList.add(new TextComponentString(I18n.format("epimorphism.machine.chemical_plant.casing_tier", casingTier)));
        textList.add(new TextComponentString(I18n.format("epimorphism.machine.chemical_plant.tube_tier", tubeTier)));
        textList.add(new TextComponentString(I18n.format("epimorphism.machine.chemical_plant.tier", tier)));
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.casingTier);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.casingTier = buf.readInt();
    }

    protected class ChemicalPlantLogic extends MultiblockRecipeLogic {

        public ChemicalPlantLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / (2 * coilLevel);
            this.metaTileEntity.markDirty();
        }

        protected long getMaxVoltage() {
            return Math.min(super.getMaxVoltage(), VA[voltageTier]);
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (super.checkRecipe(recipe) && (recipe.getProperty(CasingTierProperty.getInstance(), 0) <= tier)) {
                List<ItemStack> list = getAbilities(EPMultiblockAbility.CATALYST_MULTIBLOCK_ABILITY).stream().map(c -> c.getStackInSlot(0)).filter(c -> !c.isEmpty()).collect(Collectors.toList());
                List<GTRecipeInput> list_r = recipe.getInputs().stream().filter(GTRecipeInput::isNonConsumable).filter(r -> !CatalystFormula.checkCatalyst(Arrays.stream(r.getInputStacks()).collect(Collectors.toList()))).collect(Collectors.toList());
                int count = 0;
                for (GTRecipeInput input_r : list_r) {
                    for (ItemStack input : list) {
                        if (input_r.acceptsStack(input)) {
                            count++;
                            break;
                        }
                    }
                }
                return count == list_r.size() && list_r.size() == list.size();
            }else {
                return false;
            }
        }

        @Override
        public int getParallelLimit() {
            return 2 * tubeTier;
        }
    }
}
