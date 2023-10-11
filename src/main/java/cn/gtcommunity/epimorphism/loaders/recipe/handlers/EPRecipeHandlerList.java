package cn.gtcommunity.epimorphism.loaders.recipe.handlers;

public class EPRecipeHandlerList {

    public static void register() {
        EPPartsRecipeHandler.register();
        EPToolRecipeHandler.register();
    }
}
