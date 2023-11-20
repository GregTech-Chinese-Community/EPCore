package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class EPMetaTileEntityLargeVacuumChamber extends GCYMRecipeMapMultiblockController {
    public EPMetaTileEntityLargeVacuumChamber(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                EPRecipeMaps.VACUUM_CHAMBER_RECIPES,
                EPRecipeMaps.ULTRAVIOLET_LAMP_CHAMBER_RECIPES});
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new EPMetaTileEntityLargeVacuumChamber(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCCCC ", " CUUUC ", " CCCCC ")
                .aisle("CCCCCCC", "C     C", "CCCCCCC")
                .aisle("CCCCCCC", "G     G", "CCCOCCC")
                .aisle("CCCCCCC", "C     C", "CCCCCCC")
                .aisle(" CCCCC ", " CCSCC ", " CCCCC ")
                .where('S', selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(this.autoAbilities(true, true, true, true, true, true, false)))
                .where('G', states(getGlassState()))
                .where('U', states(getUniqueCasingState()))
                .where('O', states(getCasingState())
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH)
                                .setExactLimit(1)
                                .setPreviewCount(1)))
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.BABBITT_ALLOY_CASING);
    }

    private IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    public boolean hasMufflerMechanics() {
        return true;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return Textures.GAS_COLLECTOR_OVERLAY;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.BABBITT_ALLOY_CASING;
    }
}
