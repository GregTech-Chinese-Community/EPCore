package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.chains.BZMediumChain;
import cn.gtcommunity.epimorphism.loaders.recipe.chains.EDOTChain;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.WetwareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.GoowareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        GTOverrideRecipes.init();
        EPRecipeHandlerList.register();
        initChains();
        initCircuits();
    }

    public static void initChains() {
        BZMediumChain.init();
        EDOTChain.init();
    }

    public static void initCircuits() {
        WetwareCircuits.init();
        GoowareCircuits.init();
    }
}
