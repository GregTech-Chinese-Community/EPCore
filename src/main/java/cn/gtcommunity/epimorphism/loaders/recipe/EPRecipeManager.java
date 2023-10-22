package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.blocks.Crucibles;
import cn.gtcommunity.epimorphism.loaders.recipe.chains.*;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.OpticalCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.SpintronicCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MachineComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MaterialComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.CatalyticReformationOilProcessing;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.WetwareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.GoowareCircuits;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.MetaTileEntityRecipes;

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
        BismuthVanadiumChain.init();
        BoronChain.init();
        BoronNitrideChain.init();
        BromineChain.init();
        BZMediumChain.init();
        CarbonNanotubeChain.init();
        CyanogenChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        FullereneChain.init();
        GalliumNitrideChain.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        IodineChain.init();
        KaptonChain.init();
        KevlarChain.init();
        LithiumChain.init();
        PEDOTChain.init();
        PEEKChain.init();
        PhosphorusChain.init();
        PMMAChain.init();
        ThalliumChain.init();
        TungstenChain.init();
    }

    public static void initCircuits() {
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
        SpintronicCircuits.init();
    }

    public static void initComponents() {
        MachineComponents.init();
        MaterialComponents.init();
    }

    public static void initMultiblockRecipes() {
        CatalyticReformationOilProcessing.init();
        MetaTileEntityRecipes.init();
    }
}
