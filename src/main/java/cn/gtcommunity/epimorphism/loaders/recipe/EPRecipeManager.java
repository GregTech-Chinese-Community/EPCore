package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.chains.*;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.CatalyticReformationOilProcessing;
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
        initMultiblockRecipes();
    }

    public static void initChains() {
        BZMediumChain.init();
        PEDOTChain.init();
        PMMAChain.init();
        AmmoniaChain.init();
    }

    public static void initCircuits() {
        WetwareCircuits.init();
        GoowareCircuits.init();
    }

    public static void initMultiblockRecipes() {
        CatalyticReformationOilProcessing.init();
    }
}
