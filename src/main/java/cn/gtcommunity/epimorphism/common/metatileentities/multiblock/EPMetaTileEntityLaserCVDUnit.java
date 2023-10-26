package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import static gregtech.common.blocks.MetaBlocks.FRAMES;

public class EPMetaTileEntityLaserCVDUnit extends RecipeMapMultiblockController {
    public EPMetaTileEntityLaserCVDUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.LASER_CVD_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityLaserCVDUnit(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   XXXXX", "   XGGGX", "   XGGGX", "   XGGGX", "    XXX ")
                .aisle("XXXXXXXX", "XXXFCCCF", "XXXF   F", "XXXF   F", "    FFF ")
                .aisle("XXXXXXXX", "X XFCCCF", "X G    X", "XXXF   F", "    FFF ")
                .aisle("XXXXXXXX", "XXXFCCCF", "XSXF   F", "XXXF   F", "    FFF ")
                .aisle("   XXXXX", "   XGGGX", "   XGGGX", "   XGGGX", "    XXX ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(66)
                        .or(autoAbilities()))
                .where('G', states(getGlassState()))
                .where('C', states(getSubstrateState()))
                .where('F', states(getFrameState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.MIXER_CASING);
    }

    private static IBlockState getSubstrateState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.ADVANCED_SUBSTRATE_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    private static IBlockState getFrameState() {
        return FRAMES.get(GCYMMaterials.HastelloyX).getBlock(GCYMMaterials.HastelloyX);
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return EPTextures.CVD_UNIT_OVERLAY;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.MIXER_CASING;
    }
}

