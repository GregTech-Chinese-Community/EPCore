package cn.gtcommunity.epimorphism.common.metatileentities;

import cn.gtcommunity.epimorphism.api.metatileentity.single.SimpleSteamMetaTileEntity;
import cn.gtcommunity.epimorphism.api.metatileentity.single.SteamProgressIndicator;
import cn.gtcommunity.epimorphism.api.metatileentity.single.SteamProgressIndicators;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.utils.EPUtils;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.*;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityCatalystHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityIndustrialMaintenanceHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityMillBallHatch;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;

import static cn.gtcommunity.epimorphism.api.utils.EPUtils.epId;
import static gregtech.api.util.GTUtility.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class EPMetaTileEntities {

    //  SingleBlock---MultiblockHatches Range:1-300
    public static EPMetaTileEntityBufferHatch MULTIPART_BUFFER_HATCH;
    public static EPMetaTileEntityMillBallHatch MULTIPART_BALL_HATCH;
    public static EPMetaTileEntityCatalystHatch MULTIPART_CATALYST_HATCH;
    public static EPMetaTileEntityIndustrialMaintenanceHatch INDUSTRIAL_MAINTENANCE_HATCH;

    //  SingleBlock---SimpleMachines Range:301-600
    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];
    public static final SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[3];
    public static SimpleSteamMetaTileEntity[] STEAM_VACUUM_CHAMBER = new SimpleSteamMetaTileEntity[2];
    public static SimpleMachineMetaTileEntity[] VACUUM_CHAMBER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    //  Multiblocks
    public static EPMetaTileEntitySonicator SONICATOR;
    public static EPMetaTileEntityCVDUnit CVD_UNIT;
    public static EPMetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static EPMetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static EPMetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static EPMetaTileEntityFermentationTank FERMENTATION_TANK;
    public static EPMetaTileEntityBlazingBlastFurnace BLAZING_BLAST_FURNACE;
    public static EPMetaTileEntityCryogenicFreezer CRYOGENIC_FREEZER;
    public static EPMetaTileEntityIsaMill ISA_MILL;
    public static EPMetaTileEntityFlotationFactory FLOTATION_FACTORY;
    public static EPMetaTileEntityVacuumDryingFurnace VACUUM_DRYING_FURNACE;
    public static EPMetaTileEntityBurnerReactor BURNER_REACTOR;
    public static EPMetaTileEntityCryogenicReactor CRYOGENIC_REACTOR;
    public static EPMetaTileEntityMegaAlloyBlastSmelter MEGA_ALLOY_BLAST_SMELTER;
    public static EPMetaTileEntityChemicalPlant CHEMICAL_PLANT;
    public static EPMetaTileEntityMegaOilCrackingUnit MEGA_OIL_CRACKING_UNIT;
    public static EPMetaTileEntityMegaChemicalReactor MEGA_CHEMICAL_REACTOR;
//    public static EPMetaTileEntityAlgaeFarm ALGAE_FARM;
    public static EPMetaTileEntityIndustrialFishingPond INDUSTRIAL_FISHING_POND;
    public static EPMetaTileEntityRoaster ROASTER;
    public static EPMetaTileEntityIndustrialDrill INDUSTRIAL_DRILL;
    public static EPMetaTileEntityFracker FRACKER;
    public static EPMetaTileEntityGeneralProcessingPlant GENERAL_PROCESSING_PLANT;
    public static EPMetaTileEntityIntegratedOreFactory INTEGRATED_ORE_FACTORY;
    public static EPMetaTileEntityDissolutionTank DISSOLUTION_TANK;
    public static EPMetaTileEntityDigester DIGESTER;
//    public static EPMetaTileEntityBiologicalReactionChamber BIOLOGICAL_REACTION_CHAMBER;
//    public static EPMetaTileEntityComputingTerminal COMPUTING_TERMINAL;
//    public static EPMetaTileEntityElectronCryomicroscopy ELECTRON_CRYOMICROSCOPY;
//    public static EPMetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static EPMetaTileEntityPCBFactory PCB_FACTORY;

    public static EPMetaTileEntityIonImplantater ION_IMPLANTATER;
    public static EPMetaTileEntityPlasmaCVDUnit PLASMA_CVD;
    public static EPMetaTileEntityLaserCVDUnit LASER_CVD;
    public static EPMetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static EPMetaTileEntityFuelRefineFactory FUEL_REFINE_FACTORY;
    public static EPMetaTileEntityHyperReactorMk1 HYPER_REACTOR_MK1;
    public static EPMetaTileEntityHyperReactorMk2 HYPER_REACTOR_MK2;
    public static EPMetaTileEntityHyperReactorMk3 HYPER_REACTOR_MK3;

    //  Range: 12301-13300
    private static void registerSimpleSteamMetaTileEntity(SimpleSteamMetaTileEntity[] machines, int startId, String name, RecipeMap<?> recipeMap, SteamProgressIndicator progressIndicator, ICubeRenderer texture, boolean isBricked) {
        machines[0] = registerMetaTileEntity(startId, new SimpleSteamMetaTileEntity(epId(String.format("%s.bronze", name)), recipeMap, progressIndicator, texture, isBricked, false));
        machines[1] = registerMetaTileEntity(startId + 1, new SimpleSteamMetaTileEntity(epId(String.format("%s.steel", name)), recipeMap, progressIndicator, texture, isBricked, true));
    }

    private static <F extends MetaTileEntity> F registerSingleMetaTileEntity(int id, F mte) {
        if (id > 1000) return null;
        return registerMetaTileEntity(id + 12300, mte);
    }

    //  Range: 13301-14300
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 13300, mte);
    }

    public static void init() {

        //SingleBlocks: Id 12301-13300

        //  MultiblockHatches Id 12301_12600
        MULTIPART_BUFFER_HATCH = registerSingleMetaTileEntity(1, new EPMetaTileEntityBufferHatch(epId("buffer_hatch")));
        MULTIPART_BALL_HATCH = registerSingleMetaTileEntity(2, new EPMetaTileEntityMillBallHatch(epId("mill_ball_hatch")));
        MULTIPART_CATALYST_HATCH = registerSingleMetaTileEntity(3, new EPMetaTileEntityCatalystHatch(epId("catalyst_hatch")));
        INDUSTRIAL_MAINTENANCE_HATCH = registerSingleMetaTileEntity(4, new EPMetaTileEntityIndustrialMaintenanceHatch(epId("industrial_maintenance_hatch")));

        //  SimpleMachines: Id 12601_12900   15 ids for each machine
        registerSimpleMetaTileEntity(DRYER, 12601, "dryer", EPRecipeMaps.DRYER_RECIPES, EPTextures.DRYER_OVERLAY, true, EPUtils::epId, GTUtility.hvCappedTankSizeFunction);
        NAQUADAH_REACTOR[0] = registerMetaTileEntity(12614, new SimpleGeneratorMetaTileEntity(epId("naquadah_reactor.iv"), EPRecipeMaps.NAQUADAH_REACTOR_RECIPES, EPTextures.NAQUADAH_REACTOR_OVERLAY, 5, genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[1] = registerMetaTileEntity(12615, new SimpleGeneratorMetaTileEntity(epId("naquadah_reactor.luv"), EPRecipeMaps.NAQUADAH_REACTOR_RECIPES, EPTextures.NAQUADAH_REACTOR_OVERLAY, 6, genericGeneratorTankSizeFunction));
        NAQUADAH_REACTOR[2] = registerMetaTileEntity(12616, new SimpleGeneratorMetaTileEntity(epId("naquadah_reactor.zpm"),  EPRecipeMaps.NAQUADAH_REACTOR_RECIPES, EPTextures.NAQUADAH_REACTOR_OVERLAY, 7, genericGeneratorTankSizeFunction));
        registerSimpleSteamMetaTileEntity(STEAM_VACUUM_CHAMBER, 12617, "vacuum_chamber", EPRecipeMaps.VACUUM_CHAMBER_RECIPES, SteamProgressIndicators.COMPRESS, Textures.GAS_COLLECTOR_OVERLAY, false);
        registerSimpleMetaTileEntity(VACUUM_CHAMBER, 12619, "vacuum_chamber", EPRecipeMaps.VACUUM_CHAMBER_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, true, EPUtils::epId, GTUtility.hvCappedTankSizeFunction);

        //Multiblocks: Id 13301-14300
        SONICATOR = registerMultiMetaTileEntity(1, new EPMetaTileEntitySonicator(epId("sonicator")));
        CVD_UNIT = registerMultiMetaTileEntity(2, new EPMetaTileEntityCVDUnit(epId("cvd_unit")));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(3, new EPMetaTileEntityNanoscaleFabricator(epId("nanoscale_fabricator")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(4, new EPMetaTileEntityCrystallizationCrucible(epId("crystallization_crucible")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(5, new EPMetaTileEntityCatalyticReformer(epId("catalytic_reformer")));
        FERMENTATION_TANK= registerMultiMetaTileEntity(6, new EPMetaTileEntityFermentationTank(epId("fermentation_tank")));
        BLAZING_BLAST_FURNACE = registerMultiMetaTileEntity(7, new EPMetaTileEntityBlazingBlastFurnace(epId("blazing_blast_furnace")));
        CRYOGENIC_FREEZER = registerMultiMetaTileEntity(8, new EPMetaTileEntityCryogenicFreezer(epId("cryogenic_freezer")));
        ISA_MILL = registerMultiMetaTileEntity(9, new EPMetaTileEntityIsaMill(epId("isa_mill")));
        FLOTATION_FACTORY = registerMultiMetaTileEntity(10, new EPMetaTileEntityFlotationFactory(epId("flotation_factory")));
        VACUUM_DRYING_FURNACE = registerMultiMetaTileEntity(11, new EPMetaTileEntityVacuumDryingFurnace(epId("vacuum_drying_furnace")));
        BURNER_REACTOR = registerMultiMetaTileEntity(12, new EPMetaTileEntityBurnerReactor(epId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMultiMetaTileEntity(13, new EPMetaTileEntityCryogenicReactor(epId("cryogenic_reactor")));
        MEGA_ALLOY_BLAST_SMELTER = registerMultiMetaTileEntity(14, new EPMetaTileEntityMegaAlloyBlastSmelter(epId("mega_alloy_blast_smelter")));
        CHEMICAL_PLANT = registerMultiMetaTileEntity(15, new EPMetaTileEntityChemicalPlant(epId("chemical_plant")));
        MEGA_OIL_CRACKING_UNIT = registerMultiMetaTileEntity(16, new EPMetaTileEntityMegaOilCrackingUnit(epId("mega_oil_cracking_unit")));
        MEGA_CHEMICAL_REACTOR = registerMultiMetaTileEntity(17, new EPMetaTileEntityMegaChemicalReactor(epId("mega_chemical_reactor")));
//        ALGAE_FARM = registerMultiMetaTileEntity(18, new EPMetaTileEntityAlgaeFarm(epId("algae_farm")));
        INDUSTRIAL_FISHING_POND = registerMultiMetaTileEntity(19, new EPMetaTileEntityIndustrialFishingPond(epId("industrial_fishing_pond")));
        ROASTER = registerMultiMetaTileEntity(20, new EPMetaTileEntityRoaster(epId("roaster")));
        INDUSTRIAL_DRILL = registerMultiMetaTileEntity(21, new EPMetaTileEntityIndustrialDrill(epId("industrial_drill")));
        FRACKER = registerMultiMetaTileEntity(22, new EPMetaTileEntityFracker(epId("fracker"), GTValues.ZPM));
        GENERAL_PROCESSING_PLANT = registerMultiMetaTileEntity(23, new EPMetaTileEntityGeneralProcessingPlant(epId("general_processing_plant")));
        INTEGRATED_ORE_FACTORY = registerMultiMetaTileEntity(24, new EPMetaTileEntityIntegratedOreFactory(epId("integrated_ore_factory")));
        DISSOLUTION_TANK = registerMultiMetaTileEntity(25, new EPMetaTileEntityDissolutionTank(epId("dissolution_tank")));
        DIGESTER = registerMultiMetaTileEntity(26, new EPMetaTileEntityDigester(epId("digester")));
//        BIOLOGICAL_REACTION_CHAMBER = registerMultiMetaTileEntity(27, new EPMetaTileEntityBiologicalReactionChamber(epId()));
//        COMPUTING_TERMINAL = registerMultiMetaTileEntity(28, new EPMetaTileEntityComputingTerminal(epId("computing_terminal")));
//        ELECTRON_CRYOMICROSCOPY = registerMultiMetaTileEntity(29, new EPMetaTileEntityElectronCryomicroscopy(epId()));
//        COSMIC_RAY_DETECTOR = registerMultiMetaTileEntity(30, new EPMetaTileEntityCosmicRayDetector(epId("cosmic_ray_detector")));
        ION_IMPLANTATER = registerMultiMetaTileEntity(31, new EPMetaTileEntityIonImplantater(epId("ion_implantater")));
        PLASMA_CVD = registerMultiMetaTileEntity(32, new EPMetaTileEntityPlasmaCVDUnit(epId("plasma_cvd_unit")));
        LASER_CVD = registerMultiMetaTileEntity(33, new EPMetaTileEntityLaserCVDUnit(epId("laser_cvd_unit")));
        LARGE_NAQUADAH_REACTOR = registerMultiMetaTileEntity(34, new EPMetaTileEntityLargeNaquadahReactor(epId("large_naquadah_reactor")));
//        PCB_FACTORY = registerMultiMetaTileEntity(35, new EPMetaTileEntityPCBFactory(epId("pcb_factory")));
        FUEL_REFINE_FACTORY = registerMultiMetaTileEntity(36, new EPMetaTileEntityFuelRefineFactory(epId("fuel_refine_factory")));
        HYPER_REACTOR_MK1 = registerMultiMetaTileEntity(37, new EPMetaTileEntityHyperReactorMk1(epId("hyper_reactor_mk1")));
        HYPER_REACTOR_MK2 = registerMultiMetaTileEntity(38, new EPMetaTileEntityHyperReactorMk2(epId("hyper_reactor_mk2")));
        HYPER_REACTOR_MK3 = registerMultiMetaTileEntity(39, new EPMetaTileEntityHyperReactorMk3(epId("hyper_reactor_mk3")));
    }
}
