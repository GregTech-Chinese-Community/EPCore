package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.blocks.Crucibles;
import cn.gtcommunity.epimorphism.loaders.recipe.chains.*;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MachineComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MaterialComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.CatalyticReformationOilProcessing;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.WetwareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.GoowareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        GTOverrideRecipes.init();
        EPRecipeHandlerList.register();
        initBlocks();
        initChains();
        initCircuits();
        initComponents();
        initMultiblockRecipes();
    }

    public static void initBlocks() {
        Crucibles.init();
    }

    public static void initChains() {
        AmmoniaChain.init();
        BoronNitrideChain.init();
        BZMediumChain.init();
        CarbonNanotubeChain.init();
        GrapheneChain.init();
        PEDOTChain.init();
        PMMAChain.init();
        TungstenChain.init();
    }

    public static void initCircuits() {
        WetwareCircuits.init();
        GoowareCircuits.init();
    }

    public static void initComponents() {
        MachineComponents.init();
        MaterialComponents.init();
    }

    public static void initMultiblockRecipes() {
        CatalyticReformationOilProcessing.init();
    }
}
