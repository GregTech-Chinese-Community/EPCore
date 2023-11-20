package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.loaders.recipe.blocks.*;
import cn.gtcommunity.epimorphism.loaders.recipe.chains.*;
import cn.gtcommunity.epimorphism.loaders.recipe.circuits.*;
import cn.gtcommunity.epimorphism.loaders.recipe.components.*;
import cn.gtcommunity.epimorphism.loaders.recipe.multiblocks.*;

public class EPRecipeManager {

    private EPRecipeManager() {}

    public static void init() {
        RecipeConflicts.init();
        EPMaterialInfoLoader.init();
        EPFusionLoader.init();
        EPOverrideRecipes.init();
        initBlocks();
        initChains();
        initCircuits();
        initMultiblockRecipes();
        MachineComponents.init();
    }

    public static void initBlocks() {
        Coils.init();
        Crucibles.init();
        Explosives.init();
        Pipes.init();
    }

    public static void initChains() {
        AmmoniaChain.init();
        BismuthVanadiumChain.init();
        BoronChain.init();
        BoronNitrideChain.init();
        BPAPolycarbonateChain.init();
        BromineChain.init();
        BZMediumChain.init();
        CaesiumRubidiumChain.init();
        CalciumChain.init();
        CaliforniumChain.init();
        ChlorineChain.init();
        CarbonNanotubeChain.init();
        CBDOPolycarbonateChain.init();
        CyanogenChain.init();
        DragonChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        FluoinatedEthylenePropyleneChain.init();
        FullereneChain.init();
        GalliumNitrideChain.init();
        GermaniumChain.init();
        GrapheneChain.init();
        HexanitrohexaaxaisowurtzitaneChain.init();
        HydrogenPeroxideChain.init();
        IodineChain.init();
        KaptonChain.init();
        KevlarChain.init();
        LithiumChain.init();
        MagneticsChain.init();
        MagnetoResonaticChain.init();
        MolybdenumRheniumChain.init();
        NaquadahChain.init();
        NdYAGChain.init();
        NiobiumTantalumChain.init();
        PEDOTChain.init();
        PEEKChain.init();
        PhosphorusChain.init();
        PhotoresistivesChain.init();
        PMMAChain.init();
        PoloniumChain.init();
        PowerIntCircuitChain.init();
        PreciousMetalChain.init();
        RareEarthChain.init();
        RubbersChain.init();
        SeleniumTelluriumChain.init();
        SodiumChain.init();
        StrontiumRadiumChain.init();
        SuperconductorsChain.init();
        TaraniumChain.init();
        ThalliumChain.init();
        TungstenChain.init();
        ZylonChain.init();
    }

    public static void initCircuits() {
        PrimitiveCircuit.init();
        CrystalCircuits.init();
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
        SpintronicCircuits.init();
        WrapCircuits.init();
    }

    public static void initMultiblockRecipes() {
        MetaTileEntityRecipes.init();
        CatalyticReformerRecipes.init();
        ComponentAssemblerRecipes.init();
        DimensionalOscillatorRecipes.init();
        FrackerRecipes.init();
        IndustrialDrillRecipes.init();
        NaquadahReactorRecipes.init();
        FuelRefineFactoryRecipes.init();
        HyperReactorRecipes.init();
        PlasmaCondenserRecipes.init();
        StellarFurnaceRecipes.init();
        HeatExchangerRecipes.init();
        PreciseAssemblerRecipes.init();
        ComponentAssemblyLineRecipes.init();
//        LargeCircuitAssemblyLineRecipes.init();
        CyclotronRecipes.init();
        DecayChamberRecipes.init();
        DragonFusionUnitRecipes.init();
        CrystallizerRecipes.init();
        RocketEngineRecipes.init();
    }
}
