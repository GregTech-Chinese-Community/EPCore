package cn.gtcommunity.epimorphism.client.renderer.texture;

import cn.gtcommunity.epimorphism.api.utils.EPUtils;
import cn.gtcommunity.epimorphism.client.renderer.texture.custom.IsaMillRenderer;
import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

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
    public static OrientedOverlayRenderer MEGA_TURBINE_OVERLAY = new OrientedOverlayRenderer("multiblock/mega_turbine");
    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer");
    public static OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");
    public static OrientedOverlayRenderer STELLAR_FURNACE_OVERLAY = new OrientedOverlayRenderer("multiblock/stellar_furnace");
    public static OrientedOverlayRenderer CYCLOTRON_OVERLAY = new OrientedOverlayRenderer("multiblock/cyclotron");
    public static OrientedOverlayRenderer DRAGON_FUSION_OVERLAY = new OrientedOverlayRenderer("multiblock/dragon_fusion");
    public static OrientedOverlayRenderer ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("machines/rocket_engine");

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
    public static EPOverlayRenderer ZIRCONIUM_CARBIDE_CASING = new EPOverlayRenderer("casings/solid/zirconium_carbide_casing");
    public static EPOverlayRenderer SUPERCRITICAL_FLUID_TURBINE_CASING = new EPOverlayRenderer("casings/ep_multiblock_casing_b/supercritical_fluid_turbine_casing");
    public static EPOverlayRenderer CORROSION_CASING = new EPOverlayRenderer("casings/ep_multiblock_casing_b/corrosion_casing");
    public static EPOverlayRenderer TRITANIUM_CASING = new EPOverlayRenderer("casings/solid/tritanium_casing");
    public static EPOverlayRenderer PRECISE_ASSEMBLER_CASING_MK1 = new EPOverlayRenderer("casings/solid/precise_assembler_casing_mk1");
    public static EPOverlayRenderer PRECISE_ASSEMBLER_CASING_MK2 = new EPOverlayRenderer("casings/solid/precise_assembler_casing_mk2");
    public static EPOverlayRenderer PRECISE_ASSEMBLER_CASING_MK3 = new EPOverlayRenderer("casings/solid/precise_assembler_casing_mk3");
    public static EPOverlayRenderer HASTELLOY_X78_CASING = new EPOverlayRenderer("casings/solid/hastelloy_x78_casing");
    public static EPOverlayRenderer CYCLOTRON_CASING = new EPOverlayRenderer("casings/solid/cyclotron_casing");
    public static EPOverlayRenderer DRACONIUM_CASING = new EPOverlayRenderer("casings/solid/draconium_casing");
    public static EPOverlayRenderer HG_1223_CASING = new EPOverlayRenderer("casings/solid/hg_1223_casing");
    public static EPOverlayRenderer QUANTUM_CONSTRAINT_CASING = new EPOverlayRenderer("casings/ep_quantum_force_transformer_casing/quantum_constraint_casing");
    public static EPOverlayRenderer MULTIPART_BUFFER_HATCH = new EPOverlayRenderer("multiparts/overlay_buffer_hatch");
    public static EPOverlayRenderer MULTIPART_BALL_HATCH = new EPOverlayRenderer("multiparts/overlay_ball_hatch");
    public static EPOverlayRenderer MULTIPART_CATALYST_HATCH = new EPOverlayRenderer("multiparts/overlay_catalyst_hatch");

    // EPMultiRenderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();

    public static TextureAtlasSprite HALO;
    public static TextureAtlasSprite HALO_NOISE;

    public static TextureAtlasSprite MASK_INGOT;

    public static TextureAtlasSprite[] COSMIC;
    public static TextureAtlasSprite COSMIC_0;
    public static TextureAtlasSprite COSMIC_1;
    public static TextureAtlasSprite COSMIC_2;
    public static TextureAtlasSprite COSMIC_3;
    public static TextureAtlasSprite COSMIC_4;
    public static TextureAtlasSprite COSMIC_5;
    public static TextureAtlasSprite COSMIC_6;
    public static TextureAtlasSprite COSMIC_7;
    public static TextureAtlasSprite COSMIC_8;
    public static TextureAtlasSprite COSMIC_9;

    public EPTextures() {}

    public static void register(TextureMap textureMap) {

        HALO = textureMap.registerSprite(EPUtils.epId("items/halo"));
        HALO_NOISE = textureMap.registerSprite(EPUtils.epId("items/halo_noise"));

        MASK_INGOT = textureMap.registerSprite(EPUtils.epId( "items/mask_ingot"));

        COSMIC_0 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_0"));
        COSMIC_1 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_1"));
        COSMIC_2 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_2"));
        COSMIC_3 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_3"));
        COSMIC_4 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_4"));
        COSMIC_5 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_5"));
        COSMIC_6 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_6"));
        COSMIC_7 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_7"));
        COSMIC_8 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_8"));
        COSMIC_9 = textureMap.registerSprite(EPUtils.epId("shader/cosmic_9"));

        COSMIC = new TextureAtlasSprite[] {
                COSMIC_0,
                COSMIC_1,
                COSMIC_2,
                COSMIC_3,
                COSMIC_4,
                COSMIC_5,
                COSMIC_6,
                COSMIC_7,
                COSMIC_8,
                COSMIC_9
        };
    }

    public static void preInit() {
        TextureUtils.addIconRegister(EPTextures::register);
    }

}
