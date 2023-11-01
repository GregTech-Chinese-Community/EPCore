package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockActiveMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;

public class EPMetaTileEntityHyperReactorMk2 extends FuelMultiblockController {

    public EPMetaTileEntityHyperReactorMk2(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.HYPER_REACTOR_MK2_RECIPES, UEV);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[UEV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new EPMetaTileEntityHyperReactorMk2(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("   CCCCC   ", "   CCCCC   ", "   CCCCC   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ")
                .aisle("  CCCCCCC  ", "  VOOOOOV  ", "  COOOOOC  ", "  FUUUUUF  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  FUUUUUF  ", "  CCCCCCC  ", "  VCCCCCV  ", "  CCCCCCC  ")
                .aisle(" CCCCCCCCC ", " VOoooooOV ", " COoooooOC ", " FUoooooUF ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " FUoooooUF ", " CCCCCCCCC ", " VCCCCCCCV ", " CCCCCCCCC ")
                .aisle("CCCCCCCCCCC", "COoooooooOC", "COoooooooOC", "GUoooooooUG", "G         G", "G         G", "G         G", "G         G", "G         G", "G         G", "G         G", "GUoooooooUG", "CCCCCCCCCCC", "CCCCCCCCCCC", "CCCCCCCCCCC")
                .aisle("CCCCCCCCCCC", "COoooooooOC", "COoooooooOC", "GUOOOoOOOUG", "G         G", "G         G", "G         G", "G OOO OOO G", "G         G", "G         G", "G         G", "GUOOOoOOOUG", "CCCCCCCCCCC", "CCCCCCCCCCC", "CCCCCCCCCCC")
                .aisle("CCCCCCCCCCC", "COoooooooOC", "COoooooooOC", "GUOOOoOOOUG", "G  H   H  G", "G  H   H  G", "G  H   H  G", "G OOO OOO G", "G  H   H  G", "G  H   H  G", "G  H   H  G", "GUOOOoOOOUG", "CCCCCCCCCCC", "CCCCCCCCCCC", "CCCCCCCCCCC")
                .aisle("CCCCCCCCCCC", "COoooooooOC", "COoooooooOC", "GUOOOoOOOUG", "G         G", "G         G", "G         G", "G OOO OOO G", "G         G", "G         G", "G         G", "GUOOOoOOOUG", "CCCCCCCCCCC", "CCCCCCCCCCC", "CCCCCCCCCCC")
                .aisle("CCCCCCCCCCC", "COoooooooOC", "COoooooooOC", "GUoooooooUG", "G         G", "G         G", "G         G", "G         G", "G         G", "G         G", "G         G", "GUoooooooUG", "CCCCCCCCCCC", "CCCCCCCCCCC", "CCCCCCCCCCC")
                .aisle(" CCCCCCCCC ", " VOoooooOV ", " COoooooOC ", " FUoooooUF ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " F       F ", " FUoooooUF ", " CCCCCCCCC ", " VCCCCCCCV ", " CCCCCCCCC ")
                .aisle("  CCCCCCC  ", "  VOOOOOV  ", "  COOOOOC  ", "  FUUUUUF  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  F     F  ", "  FUUUUUF  ", "  CCCCCCC  ", "  VCCCCCV  ", "  CCCCCCC  ")
                .aisle("   CCCCC   ", "   CCSCC   ", "   CCCCC   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   GGGGG   ", "   CCCCC   ", "   CCCCC   ", "   CCCCC   ")
                .where('S', selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(420)
                        .or(autoAbilities(false, true, false, false, true, false, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getOutputVoltage() == GTValues.V[UEV]
                                            && container.getOutputAmperage() == 2;
                                })
                                .toArray(MetaTileEntity[]::new)).setExactLimit(1).setPreviewCount(1)))
                .where('V', states(getUniqueCasingState()))
                .where('O', states(getSecondCasingState()))
                .where('o', states(getThirdCasingState()))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where('U', states(getSecondUniqueCasingState()))
                .where('H', states(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getState(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.HYPER_CORE_MK2)))
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.HYPER_CASING);
    }

    private IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private IBlockState getSecondCasingState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_COIL);
    }

    private IBlockState getThirdCasingState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL);
    }

    private IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    private IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(BlackPlutonium).getBlock(BlackPlutonium);
    }

    private IBlockState getSecondUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.ELECTROLYTIC_CELL);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return Textures.POWER_SUBSTATION_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.HYPER_CASING;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.hyper_reactor_mk2.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.hyper_reactor_mk2.tooltip.2"));
    }
}
