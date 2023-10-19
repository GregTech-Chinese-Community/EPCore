package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.GTValues;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EPMetaTileEntityMegaAlloyBlastSmelter extends GlassTierMultiblockController implements IHeatingCoil {

    private int blastFurnaceTemperature;
    protected static int heatingCoilLevel;
    protected int heatingCoilDiscount;
    protected int coilTier;

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
                .aisle(
                        "   BBBBB   ",
                        "   CCCCC   ",
                        "   CCCCC   ",
                        "   CCCCC   ",
                        "   BBBBB   ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ")
                .aisle(
                        "  BDDDDDB  ",
                        "  G     G  ",
                        "  G     G  ",
                        "  G     G  ",
                        "  BDDDDDB  ",
                        "   DDDDD   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   DDDDD   ",
                        "   DDDDD   ",
                        "           ")
                .aisle(
                        " BDDHHHDDB ",
                        " G       G ",
                        " G       G ",
                        " G       G ",
                        " BDDHHHDDB ",
                        "  DVVVVVD  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  DDDDDDD  ",
                        "  DDDDDDD  ",
                        "   DDDDD   ")
                .aisle(
                        "BDDDDDDDDDB",
                        "C  AWWWA  C",
                        "C  ABBBA  C",
                        "C  ABBBA  C",
                        "BDDDDDDDDDB",
                        " DVVVVVVVD ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " DDDDDDDDD ",
                        " DDDDDDDDD ",
                        "  DDDDDDD  ")
                .aisle(
                        "BDHDDDDDHDB",
                        "C  W   W  C",
                        "C  B   B  C",
                        "C  B   B  C",
                        "BDHDDDDDHDB",
                        " DVVVVVVVD ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " DDDDDDDDD ",
                        " DDDDDDDDD ",
                        "  DDDDDDD  ")
                .aisle(
                        "BDHDDDDDHDB",
                        "C  W A W  C",
                        "C  B A B  C",
                        "C  B A B  C",
                        "BDHDDADDHDB",
                        " DVVVAVVVD ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " GW  A  WG ",
                        " DDDDDDDDD ",
                        " DDDDDDDDD ",
                        "  DDDDDDD  ")
                .aisle(
                        "BDHDDDDDHDB",
                        "C  W   W  C",
                        "C  B   B  C",
                        "C  B   B  C",
                        "BDHDDDDDHDB",
                        " DVVVVVVVD ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " GW     WG ",
                        " DDDDDDDDD ",
                        " DDDDDDDDD ",
                        "  DDDDDDD  ")
                .aisle(
                        "BDDDDDDDDDB",
                        "C  AWWWA  C",
                        "C  ABBBA  C",
                        "C  ABBBA  C",
                        "BDDDDDDDDDB",
                        " DVVVVVVVD ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " GWW   WWG ",
                        " DDDDDDDDD ",
                        " DDDDDDDDD ",
                        "  DDDDDDD  ")
                .aisle(
                        " BDDHHHDDB ",
                        " G       G ",
                        " G       G ",
                        " G       G ",
                        " BDDHHHDDB ",
                        "  DVVVVVD  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  GWWWWWG  ",
                        "  DDDDDDD  ",
                        "  DDDDDDD  ",
                        "   DDDDD   ")
                .aisle(
                        "  BDDDDDB  ",
                        "  G     G  ",
                        "  G     G  ",
                        "  G     G  ",
                        "  BDDDDDB  ",
                        "   DDDDD   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   GGGGG   ",
                        "   DDDDD   ",
                        "   DDDDD   ",
                        "           ")
                .aisle(
                        "   BBBBB   ",
                        "   CCCCC   ",
                        "   CCSCC   ",
                        "   CCCCC   ",
                        "   BBBBB   ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ",
                        "           ")
                .where('S', selfPredicate())
                .where('A', states(getUnknowState()))
                .where('B', states(getVentState()))
                .where('D', states(getCasingState()))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('H', states(getVentState()))
                .where('V', states(getPipeState()))
                .where('W', TraceabilityPredicate.HEATING_COILS.get())
                .where('C', states(getCasingState()).or(autoAbilities()))
                .where(' ', any())
                .build();
    }
     private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING);
     }

     private static IBlockState getVentState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
     }

     private static IBlockState getPipeState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
     }

     private static IBlockState getUnknowState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE);
     }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.BLAST_CASING;
    }

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
                textList.remove(1);
                textList.add(1, new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature", blastFurnaceTemperature)
                        .setStyle(new Style().setColor(TextFormatting.RED)));
                textList.add(2, new TextComponentTranslation("epimorphism.machine.mega_alloy_blast_smelter.max_parallel", getMaxParallel(heatingCoilLevel)));
                textList.add(2, new TextComponentTranslation("gregtech.multiblock.max_energy_per_tick", new Object[]{TextFormattingUtil.formatNumbers(GTValues.V[voltage]), voltageName}));
            }
        }
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
            return GTValues.V[((GlassTierMultiblockController)this.metaTileEntity).getGlassTier()];
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            int cut_maxProgress = (int) Math.floor(maxProgress * Math.pow(0.8, coilTier));
            EPLog.logger.info("check");
            super.setMaxProgress(cut_maxProgress);
        }
    }
}
