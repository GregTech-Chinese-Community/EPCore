package cn.gtcommunity.epimorphism.common.metatileentities;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.utils.EPUtils;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.*;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityCatalystHatch;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityMillBallHatch;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.util.GTUtility;
import gregtech.common.metatileentities.MetaTileEntities;

import static cn.gtcommunity.epimorphism.api.utils.EPUtils.epId;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class EPMetaTileEntities {

    //  SingleBlock---MultiblockHatches Range:1-300
    public static EPMetaTileEntityBufferHatch MULTIPART_BUFFER_HATCH;
    public static EPMetaTileEntityMillBallHatch MULTIPART_BALL_HATCH;
    public static EPMetaTileEntityCatalystHatch MULTIPART_CATALYST_HATCH;

    //  SingleBlock---SimpleMachines Range:301-600
    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

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

    //  16-29

    public static EPMetaTileEntityIonImplantater ION_IMPLANTATER;
    public static EPMetaTileEntityPlasmaCVDUnit PLASMA_CVD;

    //  Range: 12301-13300
    private static <F extends MetaTileEntity> F registerSingleMetaTileEntity(int id, F mte) {
        if (id > 1000) return null;
        return MetaTileEntities.registerMetaTileEntity(id + 12300, mte);
    }

    //  Range: 13301-14300
    private static <T extends MultiblockControllerBase> T registerMultiMetaTileEntity(int id, T mte) {
        return MetaTileEntities.registerMetaTileEntity(id + 13300, mte);
    }

    public static void init() {

        //SingleBlocks: Id 12301-13300

        //  MultiblockHatches Id 12301_12600
        MULTIPART_BUFFER_HATCH = registerSingleMetaTileEntity(1, new EPMetaTileEntityBufferHatch(epId("buffer_hatch")));
        MULTIPART_BALL_HATCH = registerSingleMetaTileEntity(2, new EPMetaTileEntityMillBallHatch(epId("mill_ball_hatch")));
        MULTIPART_CATALYST_HATCH = registerSingleMetaTileEntity(3, new EPMetaTileEntityCatalystHatch(epId("catalyst_hatch")));

        //  SimpleMachines: Id 12601_12900   15 ids for each machine
        registerSimpleMetaTileEntity(DRYER, 12601, "dryer", EPRecipeMaps.DRYER_RECIPES, EPTextures.DRYER_OVERLAY, true, EPUtils::epId, GTUtility.hvCappedTankSizeFunction);


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
        // 16-30
        ION_IMPLANTATER = registerMultiMetaTileEntity(31, new EPMetaTileEntityIonImplantater(epId("ion_implantater")));
        PLASMA_CVD = registerMultiMetaTileEntity(32, new EPMetaTileEntityPlasmaCVDUnit(epId("plasma_cvd_unit")));
    }
}
