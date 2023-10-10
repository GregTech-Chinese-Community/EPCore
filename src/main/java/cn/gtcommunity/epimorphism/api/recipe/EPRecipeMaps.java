package cn.gtcommunity.epimorphism.api.recipe;

import cn.gtcommunity.epimorphism.api.recipe.builder.NoCoilTemperatureRecipeBuilder;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.core.sound.GTSoundEvents;

public class EPRecipeMaps {
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CVD_RECIPES = new RecipeMap<>("cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);
}
