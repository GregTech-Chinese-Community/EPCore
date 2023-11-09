package cn.gtcommunity.epimorphism.api.recipe;

import cn.gtcommunity.epimorphism.api.recipe.builder.*;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapChemicalPlant;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapComponentAssemblyLine;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapGeneral;
import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapPreciseAssembler;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.*;
import gregtech.core.sound.GTSoundEvents;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.epimorphism.recipe.RecipeMaps")
@ZenRegister
public class EPRecipeMaps {

    //  Singleblock Machine Recipemap
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRYER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES;

    //  Multiblock Machine Recipemap
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES;
    @ZenProperty
    public static final RecipeMap<GlassTierNoCoilTemperatureRecipeBuilder> CVD_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES;
    @ZenProperty
    public static final RecipeMap<GlassTierRecipeBuilder> SONICATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<PHRecipeBuilder> FERMENTATION_TANK_RECIPES;
    @ZenProperty
    public static final RecipeMap<GrindBallTierRecipeBuilder> ISA_MILL_GRINDER;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_FACTORY_RECIPES;
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_FURNACE_RECIPES;
    @ZenProperty
    public static final RecipeMap<CasingTierRecipeBuilder> CHEMICAL_PLANT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> ROASTER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISSOLUTION_TANK_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES;
    @ZenProperty
    public static final RecipeMap<ComputationRecipeBuilder> COMPUTING_TERMINAL_RECIPES;
    @ZenProperty
    public static final RecipeMap<AltitudeRecipeBuilder> COSMIC_RAY_DETECTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DIGESTER_RECIPES;
    @ZenProperty
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_A;
    @ZenProperty
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_B;
    @ZenProperty
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_C;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES;
    @ZenProperty
    public static final RecipeMap<FlowRateRecipeBuilder> HEAT_EXCHANGE_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilHigherTemperatureRecipeBuilder> STELLAR_FURNACE_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DIMENSIONAL_OSCILLATOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<PACasingTierRecipeBuilder> PRECISE_ASSEMBLER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES;
    @ZenProperty
    public static final RecipeMap<CACasingTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES;

    //  Generator Recipemaps
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HIGH_PRESSURE_STEAM_TURBINE_FUELS;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> SUPERCRITICAL_STEAM_TURBINE_FUELS;

    public EPRecipeMaps() {}

    static {
        //  Chemical Dryer Recipemap
        DRYER_RECIPES = new RecipeMap<>("dryer_recipes", 0, 1, 0, 2, 0, 1, 0, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.FURNACE);

        //  Vacuum Chamber Recipemap
        VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber_recipes", 1, 4, 1, 1, 0, 2, 0, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Crystallization Crucible Recipemap
        CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallization_recipes", 0, 6, 1, 1, 0, 3, 0, 0, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);

        //  Catalytic Reformer Recipemap
        CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 1, 0, 0, 1, 1, 1, 4, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);

        //  CVD Unit Recipemap
        CVD_RECIPES = new RecipeMap<>("cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new GlassTierNoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);

        //  Plasma CVD Unit Recipemap
        PLASMA_CVD_RECIPES = new RecipeMap<>("plasma_cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);

        //  Laser CVD Unit Recipemap
        LASER_CVD_RECIPES = new RecipeMap<>("laser_cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);

        //  Nanoscale Fabricator Recipemap
        MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 1, 5, 1, 1, 0, 2, 0, 1, new NoCoilTemperatureRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, EPGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, true, false, EPGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(false, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(true, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(true, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
                .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);

        //  Sonicator Recipemap
        SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 0, 0, 1, 2, 2, 1, 1, new GlassTierRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, EPGuiTextures.FOIL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CENTRIFUGE);

        //  Cryogenic Reactor Recipemap
        CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 0, 3, 0, 2, 0, 2, 0, 2, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);

        //  Burner Reactor Recipemap
        BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Fermentation Tank Recipemap
        FERMENTATION_TANK_RECIPES = new RecipeMap<>("fermentation_tank_recipes", 0, 3, 0, 3, 1, 3, 1, 3, new PHRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CHEMICAL_REACTOR);

        //  Isa Mill Recipemap
        ISA_MILL_GRINDER = new RecipeMap<>("isa_mill_recipes", 3, 3, 0, 0, new GrindBallTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.MACERATOR);

        //  Flotation Factory Recipemap
        FLOTATION_FACTORY_RECIPES = new RecipeMap<>("flotation_factory_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.CIRCULAR)
                .setSound(GTSoundEvents.BATH);

        //  Vacuum Drying Furnace Recipemap
        VACUUM_DRYING_FURNACE_RECIPES = new RecipeMap<>("vacuum_drying_furnace_recipes", 1, 9, 2, 3, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.FURNACE);

        //  Chemical Plant Recipemap
        CHEMICAL_PLANT_RECIPES = new RecipeMapChemicalPlant<>("chemical_plant_recipes", 4, 4, 4, 4, new CasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
                .setSlotOverlay(false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setSound(GTSoundEvents.CHEMICAL_REACTOR);

        //  Industrial Roaster Recipemap
        ROASTER_RECIPES = new RecipeMap<>("roaster_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);

        //  Ion Implantater Recipemap
        ION_IMPLANTATER_RECIPES = new RecipeMap<>("ion_implanter_recipes", 1, 3, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);

        //  Dissolution Tank Recipemap
        DISSOLUTION_TANK_RECIPES = new RecipeMap<>("dissolution_tank_recipes", 2, 2, 4, 4, new SimpleRecipeBuilder(), false);

        //  Industrial Drilling Rig Recipemap
        DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, 0, 0, 0, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.MACERATOR);

        //  Computing Terminal Recipemap
        COMPUTING_TERMINAL_RECIPES = new RecipeMap<>("computing_terminal_recipes", 1, 4, 1, 4, 0, 0, 0, 0, new ComputationRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.DATA_ORB_OVERLAY)
                .setSlotOverlay(true, false, GuiTextures.DATA_ORB_OVERLAY)
                .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.COMPUTATION);

        //  Cosmic Ray Detector Recipemap
        COSMIC_RAY_DETECTOR_RECIPES = new RecipeMap<>("cosmic_ray_detector_recipes", 2, 3, 2, 3, new AltitudeRecipeBuilder(), false);

        //  Digester Recipemap
        DIGESTER_RECIPES = new RecipeMap<>("digester_recipes", 2, 2, 2, 2, new SimpleRecipeBuilder(), false);

        //  Universal Processing Plant Recipemaps (Pseudo Recipemap)
        GENERAL_RECIPES_A = new RecipeMapGeneral<>("general_recipes_a", 1, 2, 1, 1, new SimpleRecipeBuilder(),  RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);
        GENERAL_RECIPES_B = new RecipeMapGeneral<>("general_recipes_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);
        GENERAL_RECIPES_C = new RecipeMapGeneral<>("general_recipes_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

        //  Fuel Refine Factory Recipemap
        FUEL_REFINE_FACTORY_RECIPES = new RecipeMap<>("fuel_refine_factory_recipes", 0, 3, 0, 4, 0, 4, 0, 2, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);

        //  Plasma Condenser Recipemap
        PLASMA_CONDENSER_RECIPES = new RecipeMap<>("plasma_condenser_recipes", 0, 2, 0, 2, 0, 2, 0, 2, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Large Heat Exchanger Recipemap
        HEAT_EXCHANGE_RECIPES = new RecipeMap<>("heat_exchanger_recipes", 0, 0, 2, 3, new FlowRateRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL);

        //  Stellar Furnace Recipemap
        STELLAR_FURNACE_RECIPES = new RecipeMap<>("stellar_furnace_recipes", 0, 6, 0, 6, 0, 6, 0, 6, new NoCoilHigherTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.ARC);

        //  Dimensional Oscillator Recipemap
        DIMENSIONAL_OSCILLATOR_RECIPES = new RecipeMap<>("dimensional_oscillator_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSound(GTSoundEvents.SCIENCE);

        //  Precise Assembler Recipemap
        PRECISE_ASSEMBLER_RECIPES = new RecipeMapPreciseAssembler<>("precise_assembler_recipes", 4, 1, 4, 0, new PACasingTierRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Component Assembler Recipemap
        COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler_recipes", 0, 6, 0, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Component Assembly Line Recipemap
        COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapComponentAssemblyLine<>("component_assembly_line_recipes", 12, 1,  12, 0, new CACasingTierRecipeBuilder(), false)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Naquadah Reactor Recipemap
        NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor_recipes", 0, 0, 0, 0, 0, 1, 0, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COMBUSTION);

        //  Hyper Reactor Mk I Recipemap
        HYPER_REACTOR_MK1_RECIPES = new RecipeMap<>("hyper_reactor_mk1_recipes", 0, 0, 0, 0, 0, 1, 0, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Hyper Reactor Mk II Recipemap
        HYPER_REACTOR_MK2_RECIPES = new RecipeMap<>("hyper_reactor_mk2_recipes", 0, 0, 0, 0, 0, 1, 0, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  Hyper Reactor Mk III Recipemap
        HYPER_REACTOR_MK3_RECIPES = new RecipeMap<>("hyper_reactor_mk3_recipes", 0, 0, 0, 0, 0, 1, 0, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);

        //  High Pressure Steam Turbine Recipemap
        HIGH_PRESSURE_STEAM_TURBINE_FUELS = new RecipeMap<>("high_pressure_steam_turbine_fuels", 0, 0, 1, 1, new FuelRecipeBuilder(), false);

        //  Supercritical Steam Turbine Recipemap
        SUPERCRITICAL_STEAM_TURBINE_FUELS = new RecipeMap<>("supercritical_steam_turbine_fuels",  0, 0, 1, 1, new FuelRecipeBuilder(), false);
    }
}