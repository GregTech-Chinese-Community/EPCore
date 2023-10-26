package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.blocks.*;
import cn.gtcommunity.epimorphism.loaders.recipe.chains.*;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.*;
import cn.gtcommunity.epimorphism.loaders.recipe.components.*;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.*;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.*;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        GTOverrideRecipes.init();
        EPRecipeHandlerList.register();
        RecipeConflicts.init();
        EPMaterialInfoLoader.init();
        initBlocks();
        initChains();
        initCircuits();
        initMultiblockRecipes();
        MachineComponents.init();
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
        CaesiumRubidiumChain.init();
        CalciumChain.init();
        CarbonNanotubeChain.init();
        CyanogenChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        FullereneChain.init();
        GalliumNitrideChain.init();
        GermaniumChain.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        IodineChain.init();
        KaptonChain.init();
        KevlarChain.init();
        LithiumChain.init();
        MolybdenumRheniumChain.init();
        NaquadahChain.init();
        NiobiumTantalumChain.init();
        PEDOTChain.init();
        PEEKChain.init();
        PhosphorusChain.init();
        PhotoresistivesChain.init();
        PMMAChain.init();
        SeleniumTelluriumChain.init();
        SuperconductorsChain.init();
        TaraniumChain.init();
        ThalliumChain.init();
        TungstenChain.init();
    }

    public static void initCircuits() {
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
        SpintronicCircuits.init();
    }

    public static void initMultiblockRecipes() {
        CatalyticReformationOilProcessing.init();
        MetaTileEntityRecipes.init();
    }
}
