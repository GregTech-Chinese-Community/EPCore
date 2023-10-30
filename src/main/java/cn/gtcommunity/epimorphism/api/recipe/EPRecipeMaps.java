package cn.gtcommunity.epimorphism.api.recipe;

import cn.gtcommunity.epimorphism.api.recipe.builder.*;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapChemicalPlant;
import cn.gtcommunity.epimorphism.api.recipe.machines.RecipeMapGeneral;
import cn.gtcommunity.epimorphism.client.textures.EPGuiTextures;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.ComputationRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class EPRecipeMaps {

    //  SimpleMachines
    public static final RecipeMap<SimpleRecipeBuilder> DRYER_RECIPES = new RecipeMap<>("dryer_recipes", 0, 1, 0, 2, 0, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.FURNACE);

    //  Multiblocks
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallization_recipes", 0, 6, 1, 1, 0, 3, 0, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 1, 0, 0, 1, 1, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<GlassTierNoCoilTemperatureRecipeBuilder> CVD_RECIPES = new RecipeMap<>("cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new GlassTierNoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_RECIPES = new RecipeMap<>("plasma_cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_RECIPES = new RecipeMap<>("laser_cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 1, 5, 1, 1, 0, 2, 0, 1, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<GlassTierRecipeBuilder> SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 0, 0, 1, 2, 2, 1, 1, new GlassTierRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, EPGuiTextures.FOIL_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CENTRIFUGE);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 0, 3, 0, 2, 0, 2, 0, 2, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 0, 3, 0, 2, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<PHRecipeBuilder> FERMENTATION_TANK_RECIPES = new RecipeMap<>("fermentation_tank_recipes", 0, 3, 0, 3, 1, 3, 1, 3, new PHRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<GrindBallTierRecipeBuilder> ISA_MILL_GRINDER = new RecipeMap<>("isa_mill_recipes", 3, 3, 0, 0, new GrindBallTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_FACTORY_RECIPES = new RecipeMap<>("flotation_factory_recipes", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.CIRCULAR)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_FURNACE_RECIPES = new RecipeMap<>("vacuum_drying_furnace_recipes", 1, 9, 2, 3, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<CasingTierRecipeBuilder> CHEMICAL_PLANT_RECIPES = new RecipeMapChemicalPlant<>("chemical_plant_recipes", 4, 4, 4, 4, new CasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSlotOverlay(false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> ROASTER_RECIPES = new RecipeMap<>("roaster_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATER_RECIPES = new RecipeMap<>("ion_implanter_recipes", 1, 3, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> DISSOLUTION_TANK_RECIPES = new RecipeMap<>("dissolution_tank_recipes", 2, 2, 4, 4, new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, 0, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<ComputationRecipeBuilder> COMPUTING_TERMINAL_RECIPES = new RecipeMap<>("computing_terminal_recipes", 1, 4, 1, 4, 0, 0, 0, 0, new ComputationRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.DATA_ORB_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.DATA_ORB_OVERLAY)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.COMPUTATION);

    public static final RecipeMap<AltitudeRecipeBuilder> COSMIC_RAY_DETECTOR_RECIPES = new RecipeMap<>("cosmic_ray_detector_recipes", 1, 2, 1, 3, 0, 2, 0, 3,new AltitudeRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> DIGESTER_RECIPES = new RecipeMap<>("digester_recipes", 2, 2, 2, 2, new SimpleRecipeBuilder(), false);

    //  Pseudo RecipeMap used in General Processing Plant
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_A = new RecipeMapGeneral<>("general_recipes_a", 1, 2, 1, 1, new SimpleRecipeBuilder(),  RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_B = new RecipeMapGeneral<>("general_recipes_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);
    public static final RecipeMapGeneral<SimpleRecipeBuilder> GENERAL_RECIPES_C = new RecipeMapGeneral<>("general_recipes_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

    //  Generators
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor_recipes", 0, 0, 0, 0, 0, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMBUSTION);
}
