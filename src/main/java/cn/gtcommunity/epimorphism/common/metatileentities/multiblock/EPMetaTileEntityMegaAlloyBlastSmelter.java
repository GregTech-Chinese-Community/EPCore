package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EPMetaTileEntityMegaAlloyBlastSmelter extends GlassTierMultiblockController implements IHeatingCoil {

    private int blastFurnaceTemperature;
    protected int heatingCoilLevel;
    protected int heatingCoilDiscount;
    protected int coilTier;

    private int count = 0;
    List<IBlockState> listCoil = GregTechAPI.HEATING_COILS.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    List<IBlockState> listGlass = EPAPI.MAP_GLASS_SHAPE_INFO.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> (int) entry.getValue().getTier()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    int maxLeng = EPUniverUtil.maxLength(new ArrayList<List<IBlockState>>() {{
        add(listCoil);
        add(listGlass);
    }});
    List<IBlockState> finalListCoil = EPUniverUtil.consistentList(listCoil, maxLeng);
    List<IBlockState> finalListGlass = EPUniverUtil.consistentList(listGlass, maxLeng);

    public EPMetaTileEntityMegaAlloyBlastSmelter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYMRecipeMaps.ALLOY_BLAST_RECIPES);
        this.recipeMapWorkable = new MegaAlloyBlastSmelterRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityMegaAlloyBlastSmelter(metaTileEntityId);
    }

    //  CoilType Context
    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        Object coilType = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.blastFurnaceTemperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
            this.heatingCoilDiscount = ((IHeatingCoilBlockStats) coilType).getEnergyDiscount();
            this.coilTier = ((IHeatingCoilBlockStats) coilType).getTier();
        } else {
            this.blastFurnaceTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
            this.heatingCoilLevel = BlockWireCoil.CoilType.CUPRONICKEL.getLevel();
            this.heatingCoilDiscount = BlockWireCoil.CoilType.CUPRONICKEL.getEnergyDiscount();
            this.coilTier = BlockWireCoil.CoilType.CUPRONICKEL.getTier();
        }

        this.blastFurnaceTemperature += 100 * Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        blastFurnaceTemperature = 0;
        heatingCoilLevel = 0;
        heatingCoilDiscount = 0;
    }

    //  Check recipe
    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return this.blastFurnaceTemperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   BBBBB   ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                .aisle("BDHDDDDDHDB", "C  W V W  C", "C  B V B  C", "C  B V B  C", "BDHDDVDDHDB", " DVVVVVVVD ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDMDDD  ")
                .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                .aisle("   BBBBB   ", "   CCCCC   ", "   CCSCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                .where('S', selfPredicate())
                .where('B', states(getVentState()))
                .where('D', states(getCasingState()))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('H', states(getVentState()))
                .where('V', states(getBoilerState()))
                .where('W', TraceabilityPredicate.HEATING_COILS.get())
                .where('C', states(getCasingState()).setMinGlobalLimited(15).or(autoAbilities(true, true, true, false, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where(' ', any())
                .build();
    }
     private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING);
     }

     private static IBlockState getVentState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
     }

     private static IBlockState getBoilerState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.ALLOY_SMELTING_PIPE_CASING);
     }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.BLAST_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.ALLOY_BLAST_SMELTER_OVERLAY;
    }

    //  Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.1"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.2"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.3"));
        tooltip.add(I18n.format("epimorphism.machine.mega_alloy_blast_smelter.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.mega_alloy_blast_smelter.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.mega_alloy_blast_smelter.tooltip.3"));
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            IEnergyContainer energyContainer = this.recipeMapWorkable.getEnergyContainer();
            if (energyContainer != null && energyContainer.getEnergyCapacity() > 0L) {
                long maxVoltage = Math.max(energyContainer.getInputVoltage(), energyContainer.getOutputVoltage());
                int voltage = Math.min(GTUtility.getFloorTierByVoltage(maxVoltage), getGlassTier());
                String voltageName = GTValues.VNF[voltage];
                textList.add(2, new TextComponentTranslation("epimorphism.machine.multiblock.max_parallel", getMaxParallel(heatingCoilLevel)));
                textList.add(2, new TextComponentTranslation("epimorphism.machine.multiblock.max_voltage", voltageName));
                textList.add(2, new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature", blastFurnaceTemperature)
                        .setStyle(new Style().setColor(TextFormatting.RED)));
            }
        }
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("   BBBBB   ", "   CCENC   ", "   CCCCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W V W  C", "C  B V B  C", "C  B V B  C", "BDHDDVDDHDB", " DVVVVVVVD ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " GW  V  WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDMDDD  ")
                    .aisle("BDHDDDDDHDB", "C  W   W  C", "C  B   B  C", "C  B   B  C", "BDHDDDDDHDB", " DVVVVVVVD ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " GW     WG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle("BDDDDDDDDDB", "C  VWWWV  C", "C  VBBBV  C", "C  VBBBV  C", "BDDDDDDDDDB", " DVVVVVVVD ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " GWW   WWG ", " DDDDDDDDD ", " DDDDDDDDD ", "  DDDDDDD  ")
                    .aisle(" BDDHHHDDB ", " G       G ", " G       G ", " G       G ", " BDDHHHDDB ", "  DVVVVVD  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  GWWWWWG  ", "  DDDDDDD  ", "  DDDDDDD  ", "   DDDDD   ")
                    .aisle("  BDDDDDB  ", "  G     G  ", "  G     G  ", "  G     G  ", "  BDDDDDB  ", "   DDDDD   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   DDDDD   ", "   DDDDD   ", "           ")
                    .aisle("   BBBBB   ", "   ICXCJ   ", "   CCSCC   ", "   CCCCC   ", "   BBBBB   ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ", "           ")
                    .where('S', EPMetaTileEntities.MEGA_ALLOY_BLAST_SMELTER, EnumFacing.SOUTH)
                    .where('B', getVentState())
                    .where('D', getCasingState())
                    .where('H', getVentState())
                    .where('V', getBoilerState())
                    .where('C', getCasingState())
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[5], EnumFacing.NORTH)
                    .where('N', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH)
                    .where('I', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.SOUTH)
                    .where('X', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.SOUTH)
                    .where('J', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.SOUTH)
                    .where('M', MetaTileEntities.MUFFLER_HATCH[1], EnumFacing.UP)
                    .where(' ', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;

        finalListCoil.stream()
                .map(b -> {
                    MultiblockShapeInfo.Builder midFinalBuilder = finalBuilder;
                    if (midFinalBuilder != null) {
                        midFinalBuilder.where('W', b);
                        midFinalBuilder.where('G', finalListGlass.get(count));
                        count++;
                    }
                    return midFinalBuilder;
                }).forEach(b -> shapeInfo.add(b.build()));
        count = 0;
        return shapeInfo;
    }

    @Override
    public int getCurrentTemperature() {
        return this.blastFurnaceTemperature;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    /**  getMaxParallel(int heatingCoilLevel)
     *     @param heatingCoilLevel the level to get the parallel for
     *     @return the max parallel for the heating coil level
     */
    public static int getMaxParallel(int heatingCoilLevel) {
        return heatingCoilLevel * 4;
    }

    protected class MegaAlloyBlastSmelterRecipeLogic extends HeatingCoilRecipeLogic {
        public MegaAlloyBlastSmelterRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
            super(metaTileEntity);
        }

        @Override
        public int getParallelLimit() {
            return getMaxParallel(heatingCoilLevel);
        }

        @Override
        protected long getMaxVoltage() {
            return Math.min(GTValues.V[((GlassTierMultiblockController)this.metaTileEntity).getGlassTier()], super.getMaxVoltage());
        }

        @Override
        protected long getMaxParallelVoltage() {
            return super.getMaxVoltage();
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            int cut_maxProgress = (int) Math.floor(maxProgress * Math.pow(0.8, coilTier));
            EPLog.logger.info("check");
            super.setMaxProgress(cut_maxProgress);
        }
    }
}
