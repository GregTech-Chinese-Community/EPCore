package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class EPMetaTileEntityDigester extends RecipeMapMultiblockController {
    public EPMetaTileEntityDigester(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.DIGESTER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityDigester(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCCCC ", " COOOC ", "  CCC  ", "       ")
                .aisle("CHHHHHC", "COAAAOC", " CAAAC ", " CCCCC ")
                .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                .aisle("CHHHHHC", "COAAAOC", " CAAAC ", " CCCCC ")
                .aisle(" CCSCC ", " COOOC ", "  CCC  ", "       ")
                .where('S', selfPredicate())
                .where('C', states(getCasingAState()))
                .where('H', states(getHeatState()))
                .where('O', states(getCoilState()))
                .where('L', states(getCasingBState()))
                .where('A', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingAState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST);
    }
    private static IBlockState getCasingBState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }
    private static IBlockState getHeatState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.HSSE_STURDY);
    }
    private static IBlockState getCoilState() {
        return MetaBlocks.WIRE_COIL.getState(BlockWireCoil.CoilType.CUPRONICKEL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.ROBUST_TUNGSTENSTEEL_CASING;
    }
}
