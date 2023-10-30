package cn.gtcommunity.epimorphism.api.recipe.machines;

import cn.gtcommunity.epimorphism.api.recipe.properties.CasingTierProperty;
import cn.gtcommunity.epimorphism.api.recipe.properties.CatalystAProperty;
import cn.gtcommunity.epimorphism.api.recipe.properties.CatalystBProperty;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import gregtech.api.GTValues;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class RecipeMapChemicalPlant<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public RecipeMapChemicalPlant(@Nonnull String unlocalizedName, int maxInputs, int maxOutputs, int maxFluidInputs, int maxFluidOutputs, @Nonnull R defaultRecipeBuilder, boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
    }

    @Override
    public ModularUI.Builder createJeiUITemplate(IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids, int yOffset) {
        int newYOffset = yOffset + 18;
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 166)
                .widget(new RecipeProgressWidget(200, 78 , 23 + newYOffset - 6, 20, 20, progressBarTexture, moveType, this));
        this.addInventorySlotGroup(builder, importItems, importFluids, false, newYOffset);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true, newYOffset);
        return builder;
    }

    @Override
    protected void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs, int yOffset) {
        int startInputsX = 78 - 4 - 4 * 18;
        int startInputsY = 37 - 2 * 18 + yOffset;
        if (!isOutputs) {
            for (int i = 0; i < 4; i++) {
                addSlot(builder, startInputsX + 18 * i, startInputsY, i, itemHandler, fluidHandler, false, false);
                addSlot(builder, startInputsX + 18 * i, startInputsY + 18 + 15, i, itemHandler, fluidHandler, true, false);
            }
        }else {
            for (int i = 0; i < 4; i++) {
                addSlot(builder, 78 + 20 + 5 + 18 * i, startInputsY + 9, i, itemHandler, fluidHandler, false, true);
                addSlot(builder, 78 + 20 + 5 + 18 * i, startInputsY + 18 + 9, i, itemHandler, fluidHandler, true, true);
            }
        }
    }
}
