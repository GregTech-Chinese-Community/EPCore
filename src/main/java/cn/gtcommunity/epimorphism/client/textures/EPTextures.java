package cn.gtcommunity.epimorphism.client.textures;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.FRONT;

public class EPTextures {

    //  OrientedOverlayRenderer
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblock/catalytic_reformer");
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible");
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit");
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator");
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/sonicator");

    //  EPOverlayRenderer
    public static EPOverlayRenderer ADVANCED_INVAR_CASING = new EPOverlayRenderer("casings/solid/advanced_invar_casing");

    public EPTextures() {
    }

    public static void preInit() {}

}
