package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class EPMetaTileEntityPlasmaCondenser extends RecipeMapMultiblockController {
    public EPMetaTileEntityPlasmaCondenser(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.PLASMA_CONDENSER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityPlasmaCondenser(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     ", " XXX ", " XXX ", " XXX ", "     ")
                .aisle(" XXX ", "XG GX", "X P X", "XG GX", " XXX ")
                .aisle(" XXX ", "X P X", "XPPPX", "X P X", " XOX ")
                .aisle(" XXX ", "XG GX", "X P X", "XG GX", " XXX ")
                .aisle("     ", " XXX ", " XSX ", " XXX ", "     ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('F', states(getCasingState())
                        .setMinGlobalLimited(25))
                .where('G', states(getGearboxCasingState()))
                .where('P', states(getPipeCasingState()))
                .where('O', states(getCasingState())
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH)
                                .setExactLimit(1)
                                .setPreviewCount(1)))
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.ZIRCONIUM_CARBIDE_CASING);
    }

    private IBlockState getGearboxCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX);
    }

    private IBlockState getPipeCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.ZIRCONIUM_CARBIDE_CASING;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.ARC_FURNACE_OVERLAY;
    }
}
