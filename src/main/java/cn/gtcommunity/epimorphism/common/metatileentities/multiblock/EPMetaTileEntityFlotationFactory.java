package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockActiveMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockGlassCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class EPMetaTileEntityFlotationFactory extends RecipeMapMultiblockController {

    public EPMetaTileEntityFlotationFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.FLOTATION_FACTORY);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityFlotationFactory(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  CCC  ", "  IBI  ", "  GGG  ", "  GGG  ", "  GGG  ", "  IBI  ", "  CCC  ")
                .aisle(" CCCCC ", " PAAAP ", " PAAAP ", " PAAAP ", " PAAAP ", " PAAAP ", " CCCCC ")
                .aisle("CCCCCCC", "IAAAAAI", "GAAAAAG", "GAAAAAG", "GAAAAAG", "IAAAAAI", "CCCCCCC")
                .aisle("CCCCCCC", "BAAPAAB", "GAAPAAG", "GAAPAAG", "GAAPAAG", "BAAPAAB", "CCCCCCC")
                .aisle("CCCCCCC", "IAAAAAI", "GAAAAAG", "GAAAAAG", "GAAAAAG", "IAAAAAI", "CCCCCCC")
                .aisle(" CCCCC ", " PAAAP ", " PAAAP ", " PAAAP ", " PAAAP ", " PAAAP ", " CCCCC ")
                .aisle("  CCC  ", "  ISI  ", "  GGG  ", "  GGG  ", "  GGG  ", "  IBI  ", "  CCC  ")
                .where('S', selfPredicate())
                .where('I', states(getIntakeState()))
                .where('B', states(getGearBoxState()))
                .where('G', states(getGlassState()))
                .where('C', states(getCasingState()).setMinGlobalLimited(57).or(autoAbilities()))
                .where('P', states(getPipeState()))
                .where(' ', any())
                .where('A', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.FLOTATION_CASING);
    }
    private static IBlockState getGlassState() {
        return EPMetablocks.EP_GLASS_CASING.getState(EPBlockGlassCasing.CasingType.SILICATE_GLASS);
    }
    private static IBlockState getPipeState() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.FLOTATION_CASING_PIPE);
    }
    private static IBlockState getIntakeState() {
        return EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getState(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.FLOTATION_INTAKE_CASING);
    }
    private static IBlockState getGearBoxState() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.FLOTATION_CASING_GEARBOX);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.FLOTATION_CASING;
    }

}
