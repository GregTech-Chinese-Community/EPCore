package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockBoilerCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class EPMetaTileEntityIonImplantater extends RecipeMapMultiblockController {
    public EPMetaTileEntityIonImplantater(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.ION_IMPLANTATER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityIonImplantater(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  CCC        ", "  CCC        ", "  CUC        ", "  CCC        ", "  CCC        ", "  CUC        ", "  CCC        ", "             ", "             ", "             ", "             ", "             ")
                .aisle(" CCCCC       ", " F   F       ", " F   F   ccc ", " F   F   cgc ", " F   F   cgc ", " F   F   ccc ", " F   F       ", " CCCCC       ", "             ", "             ", "             ", "             ")
                .aisle("CCCCCCC      ", "C fsf C  ccc ", "C     C c   c", "C     C c   c", "C     C c   c", "C     C c   c", "C     C  ccc ", " CCPCC       ", "  FPF        ", "  FPF        ", "  FPF        ", "  CCC        ")
                .aisle("CCCCCCC   c  ", "C sGs C  c c ", "U     U c   c", "C     PPP   c", "C     PPP   c", "U     U c   c", "C     C  c c ", " CP PC    c  ", "  P P        ", "  P P        ", "  P P        ", "  CCC        ")
                .aisle("CCCCCCC      ", "C fsf C  ccc ", "C     C c   c", "C     C c   c", "C     C c   c", "C     C c   c", "C     C  ccc ", " CCPCC       ", "  FPF        ", "  FPF        ", "  FPF        ", "  CCC        ")
                .aisle(" CCCCC       ", " F   F       ", " F   F   ccc ", " F   F   cgc ", " F   F   cgc ", " F   F   ccc ", " F   F       ", " CCCCC       ", "             ", "             ", "             ", "             ")
                .aisle("  CCC        ", "  CCC        ", "  CCC        ", "  CSC        ", "  CCC        ", "  CCC        ", "  CCC        ", "             ", "             ", "             ", "             ", "             ")
                .where('S', selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(110)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('c', states(getSecondCasingState()))
                .where('f', states(getThirdCasingState()))
                .where('s', states(getSubstrateState()))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where('U', states(getUniqueCasingState()))
                .where('P', states(getPipeCasingState()))
                .where('g', states(getSecondGlassState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL);
    }

    private static IBlockState getSubstrateState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.SUBSTRATE_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    private static IBlockState getSecondGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.NaquadahAlloy).getBlock(Materials.NaquadahAlloy);
    }

    private IBlockState getPipeCasingState() {
        return EPMetablocks.EP_BOILER_CASING.getState(EPBlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.ENGRAVER_CASING;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.LASER_ENGRAVER_OVERLAY;
    }
}
