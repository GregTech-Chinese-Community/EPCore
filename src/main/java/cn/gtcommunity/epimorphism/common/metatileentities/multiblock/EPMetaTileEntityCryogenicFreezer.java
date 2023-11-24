package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;

public class EPMetaTileEntityCryogenicFreezer extends RecipeMapMultiblockController {
    public EPMetaTileEntityCryogenicFreezer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, VACUUM_RECIPES);
        this.recipeMapWorkable = new EPMetaTileEntityCryogenicFreezer.CryogenicFreezerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new EPMetaTileEntityCryogenicFreezer(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "X#X", "XXX")
                .aisle("XXX", "XSX", "XXX")
                .where('S', this.selfPredicate())
                .where('X', states(new IBlockState[]{this.getCasingState()})
                        .setMinGlobalLimited(14)
                        .or(this.autoAbilities()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.ADVANCED_ALUMINIUM_CASING);
    }

    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @SideOnly(Side.CLIENT)
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return EPTextures.ADVANCED_ALUMINIUM_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    protected ICubeRenderer getFrontOverlay() {
        return Textures.VACUUM_FREEZER_OVERLAY;
    }

    //  Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.cryogenic_freezer.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.cryogenic_freezer.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.cryogenic_freezer.tooltip.3"));
        tooltip.add(I18n.format("epimorphism.machine.cryogenic_freezer.tooltip.4"));
    }

    //  Display Texts
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {

            if (getInputFluidInventory() != null) {
                FluidStack LubricantStack = getInputFluidInventory().drain(GelidCryotheum.getFluid(Integer.MAX_VALUE), false);
                int liquidOxygenAmount = LubricantStack == null ? 0 : LubricantStack.amount;
                textList.add(new TextComponentTranslation("epimorphism.machine.cryogenic_freezer.amount", TextFormattingUtil.formatNumbers((liquidOxygenAmount))));
                textList.add(new TextComponentTranslation("epimorphism.machine.cryogenic_freezer.subcooled"));
            }
        }
        super.addDisplayText(textList);
    }

    //  Warning
    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        super.addWarningText(textList);
        if (isStructureFormed()) {
            FluidStack lubricantStack = getInputFluidInventory().drain(GelidCryotheum.getFluid(Integer.MAX_VALUE), false);
            if (lubricantStack == null || lubricantStack.amount == 0) {
                textList.add(new TextComponentTranslation("epimorphism.machine.cryogenic_freezer.warning"));
            }
        }
    }

    private final FluidStack GELID_STACK = GelidCryotheum.getFluid(2);

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
    }

    protected class CryogenicFreezerRecipeLogic extends MultiblockRecipeLogic {
        private final EPMetaTileEntityCryogenicFreezer combustionEngine;

        public CryogenicFreezerRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.combustionEngine = (EPMetaTileEntityCryogenicFreezer) tileEntity;
        }

        protected void updateRecipeProgress() {
            if (canRecipeProgress && drawEnergy(recipeEUt, true)) {
                IMultipleTankHandler inputTank = combustionEngine.getInputFluidInventory();
                if (GELID_STACK.isFluidStackIdentical(inputTank.drain(GELID_STACK, false))) {
                    inputTank.drain(GELID_STACK, true);
                    if (++progressTime > maxProgressTime) {
                        completeRecipe();
                    }
                }
                else return;
                drawEnergy(recipeEUt, false);
            }
        }

        /**
         * @param maxProgress Reduce duration to 0.8 original duration.
         */
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = (int) (0.8 * maxProgress);
        }

        @Override
        public int getParallelLimit() {
            return 4;
        }
    }
}