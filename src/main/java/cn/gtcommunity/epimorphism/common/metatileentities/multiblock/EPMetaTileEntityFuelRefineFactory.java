package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
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

import static gregtech.api.unification.material.Materials.*;

public class EPMetaTileEntityFuelRefineFactory extends RecipeMapMultiblockController {
    public EPMetaTileEntityFuelRefineFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.FUEL_REFINE_FACTORY_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityFuelRefineFactory(metaTileEntityId);
    }
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ")
                .aisle("      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ")
                .aisle("    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ")
                .aisle("   X       X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X       X   ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle(" X    XXX    X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X    XXX    X ")
                .aisle(" X    XXX    X ", "X XPUUP PUUPX X", " X           X ", "               ", "               ", "               ", " X           X ", "X XPUUP PUUPX X", " X           X ", "               ", "               ", "               ", " X           X ", "X XPUUP PUUPX X", " X    XMX    X ")
                .aisle(" X    XXX    X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X F  F F  F X ", "   F  F F  F   ", "   F  F F  F   ", "   F  F F  F   ", " X F  F F  F X ", "X XF  FPF  FX X", " X    XXX    X ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ", "               ", "               ", "               ", "  X         X  ", " X X   U   X X ", "  X         X  ")
                .aisle("   X       X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X  F F  X   ", "      F F      ", "      F F      ", "      F F      ", "   X  F F  X   ", "  XPXXFPFXXPX  ", "   X       X   ")
                .aisle("    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ", "               ", "               ", "               ", "    XX   XX    ", "   X  XXX  X   ", "    XX   XX    ")
                .aisle("      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ", "               ", "               ", "               ", "      XXX      ", "    XX   XX    ", "      XXX      ")
                .aisle("               ", "      XSX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ", "               ", "               ", "               ", "               ", "      XXX      ", "               ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(387)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('P', states(getPipeCasingState()))
                .where('U', states(getUniqueCasingState()))
                .where('F', states(getFrameState()))
                .where('M', states(getCasingState())
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH)
                                .setExactLimit(1)
                                .setPreviewCount(1)))
                .where(' ', any())
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.TALONITE_CASING);
    }

    private IBlockState getPipeCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    private IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(NaquadahAlloy).getBlock(NaquadahAlloy);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.TALONITE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return EPTextures.BURNER_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.perfect_oc"));
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
