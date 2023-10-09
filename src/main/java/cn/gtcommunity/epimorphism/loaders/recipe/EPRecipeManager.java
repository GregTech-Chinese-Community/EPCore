package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        EPRecipeHandlerList.register();
    }
}
