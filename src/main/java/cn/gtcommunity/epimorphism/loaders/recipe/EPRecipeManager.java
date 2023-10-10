package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.circuits.GoowareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        GTOverrideRecipes.init();
        EPRecipeHandlerList.register();
        initCircuits();
    }

    public static void initCircuits() {
        GoowareCircuits.init();
    }
}
