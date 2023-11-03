package cn.gtcommunity.epimorphism.client.renderer.texture;

import cn.gtcommunity.epimorphism.client.renderer.texture.custom.IsaMillRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;

public class EPTextures {

    //  OrientedOverlayRenderer
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblock/catalytic_reformer");
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible");
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit");
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator");
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/sonicator");
    public static OrientedOverlayRenderer ISA_MILL_OVERLAY = new OrientedOverlayRenderer("multiblock/isa_mill");
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/burner_reactor");
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/cryogenic_reactor");
    public static OrientedOverlayRenderer VACUUM_DRYING_FURNACE_OVERLAY = new OrientedOverlayRenderer("multiblock/vacuum_drying_furnace");
    public static OrientedOverlayRenderer CHEMICAL_PLANT_OVERLAY = new OrientedOverlayRenderer("multiblock/ep_chemical_plant");
    public static OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblock/industrial_drill");
    public static OrientedOverlayRenderer FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblock/fracker");
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster");
    public static OrientedOverlayRenderer ALGAE_FARM_OVERLAY = new OrientedOverlayRenderer("multiblock/algae_farm");
    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer");
    public static OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");

    //  EPOverlayRenderer
    public static EPOverlayRenderer ADVANCED_INVAR_CASING = new EPOverlayRenderer("casings/solid/advanced_invar_casing");
    public static EPOverlayRenderer ADVANCED_ALUMINIUM_CASING = new EPOverlayRenderer("casings/solid/advanced_aluminium_casing");
    public static EPOverlayRenderer ISA_MILL_CASING = new EPOverlayRenderer("casings/ep_mill_casing/isa_mill_casing");
    public static EPOverlayRenderer FLOTATION_CASING = new EPOverlayRenderer("casings/ep_mill_casing/flotation_casing");
    public static EPOverlayRenderer VACUUM_CASING = new EPOverlayRenderer("casings/solid/vacuum_casing");
    public static EPOverlayRenderer NAQUADRIA_CASING = new EPOverlayRenderer("casings/solid/naquadria_casing");
    public static EPOverlayRenderer HYPER_CASING = new EPOverlayRenderer("casings/solid/hyper_casing");
    public static EPOverlayRenderer TALONITE_CASING = new EPOverlayRenderer("casings/solid/talonite_casing");
    public static EPOverlayRenderer BREEDING_CASING = new EPOverlayRenderer("casings/solid/breeding_casing");
    public static EPOverlayRenderer FARM_CASING = new EPOverlayRenderer("casings/solid/farm_casing");
    public static EPOverlayRenderer QUANTUM_CASING = new EPOverlayRenderer("casings/solid/quantum_casing");
    public static EPOverlayRenderer IRIDIUM_CASING = new EPOverlayRenderer("casings/solid/iridium_casing");
    public static EPOverlayRenderer MARAGING_STEEL_CASING = new EPOverlayRenderer("casings/ep_multiblock_casing_b/maraging_steel_250_casing");
    public static EPOverlayRenderer BABBITT_ALLOY_CASING = new EPOverlayRenderer("casings/solid/babbitt_alloy_casing");

    public static EPOverlayRenderer MULTIPART_BUFFER_HATCH = new EPOverlayRenderer("multiparts/overlay_buffer_hatch");
    public static EPOverlayRenderer MULTIPART_BALL_HATCH = new EPOverlayRenderer("multiparts/overlay_ball_hatch");
    public static EPOverlayRenderer MULTIPART_CATALYST_HATCH = new EPOverlayRenderer("multiparts/overlay_catalyst_hatch");

    // EPMultiRenderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();

    public EPTextures() {}

    public static void preInit() {}

}
