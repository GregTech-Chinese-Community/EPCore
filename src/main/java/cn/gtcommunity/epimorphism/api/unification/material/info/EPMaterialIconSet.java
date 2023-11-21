package cn.gtcommunity.epimorphism.api.unification.material.info;

import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.items.behaviors.renderer.HaloRenderItemBehavior;
import gregtech.api.unification.material.info.MaterialIconSet;

public class EPMaterialIconSet {
    public static final MaterialIconSet CUSTOM_MHCSM = new MaterialIconSet("mhcsm", null, true);
    public static final MaterialIconSet CUSTOM_DEGENERATE_RHENIUM = new MaterialIconSet("degenerate_rhenium", null, true);
    public static final MaterialIconSet CUSTOM_HYPOGEN = new MaterialIconSet("hypogen", null, true);
    public static final MaterialIconSet CUSTOM_LEGENDARIUM = new MaterialIconSet("legendarium", null, true);
    public static final MaterialIconSetWithRenderer CUSTOM_INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> EPTextures.HALO, true));
}