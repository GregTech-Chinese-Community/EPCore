package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import gregtech.api.GTValues;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EPMetaTileEntityMegaOilCrackingUnit extends GlassTierMultiblockController {

    private int coilTier;
    protected int heatingCoilLevel;

    public EPMetaTileEntityMegaOilCrackingUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.CRACKING_RECIPES);
        this.recipeMapWorkable = new MegaCrackingUnitWorkableHandler(this);
    }
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityMegaOilCrackingUnit(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.coilTier = ((IHeatingCoilBlockStats) type).getTier();
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) type).getLevel();
        } else {
            this.coilTier = 0;
            this.heatingCoilLevel = 1;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.coilTier = -1;
        this.heatingCoilLevel = 0;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(
                        "CCCCCCCCCCCCC",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC"
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " CGGGGGGGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " GALALALALAG ",
                        " CGGGCCCGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " GALALALALAG ",
                        " CGGGCCCGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " GALALALALAG ",
                        " CGGGCCCGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " CGGGGGGGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC"
                )
                .aisle(
                        "CCCCCCSCCCCCC",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C "
                )
                .where('S', selfPredicate())
                .where('C', states(getCasingState()).or(autoAbilities()))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('L', TraceabilityPredicate.HEATING_COILS.get())
                .where('D', states(getCasingState()))
                .where('E', states(getCasingState()))
                .where(' ', any())
                .where('A', air())
                .build();
    }

    //TODO 预览

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.CRACKING_UNIT_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.3"));
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
                textList.add(new TextComponentTranslation("gregtech.multiblock.cracking_unit.energy", 100 - 10 * coilTier));
            }
        }
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    protected int getCoilTier() {
        return this.coilTier;
    }

    /**  getMaxParallel(int heatingCoilLevel)
     *     @param heatingCoilLevel the level to get the parallel for
     *     @return the max parallel for the heating coil level
     */
    public static int getMaxParallel(int heatingCoilLevel) {
        return heatingCoilLevel * 4;
    }

    private class MegaCrackingUnitWorkableHandler extends MultiblockRecipeLogic {

        public MegaCrackingUnitWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
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
        protected void modifyOverclockPost(int[] resultOverclock, @Nonnull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);

            int coilTier = ((EPMetaTileEntityMegaOilCrackingUnit) metaTileEntity).getCoilTier();
            if (coilTier <= 0)
                return;

            resultOverclock[0] *= 1.0f - coilTier * 0.1; // each coil above cupronickel (coilTier = 0) uses 10% less energy
            resultOverclock[0] = Math.max(1, resultOverclock[0]);
        }
    }
}
