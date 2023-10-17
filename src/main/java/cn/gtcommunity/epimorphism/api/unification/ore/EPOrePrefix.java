package cn.gtcommunity.epimorphism.api.unification.ore;

import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags;
import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialIconType;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraft.client.resources.I18n;

import java.util.Collections;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class EPOrePrefix {

    public static final OrePrefix coil = new OrePrefix("coil", 453600L * 4, null, EPMaterialIconType.coil, 1L,
            (material -> material.hasFlag(MaterialFlags.GENERATE_FINE_WIRE) && material.hasFlag(EPMaterialFlags.GENERATE_COIL)));
    public static final OrePrefix plateCurved = new OrePrefix("plateCurved", M, null, EPMaterialIconType.plateCurved, ENABLE_UNIFICATION,
            (material -> material.hasFlag(MaterialFlags.GENERATE_PLATE) && material.hasFlag(EPMaterialFlags.GENERATE_CURVED_PLATE)));
    public static final OrePrefix milled = new OrePrefix("milled", -1, null, EPMaterialIconType.milled, ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty, mat -> Collections.singletonList(I18n.format("metaitem.milled.tooltip.flotation")));

    public static void init() {
        milled.addSecondaryMaterial(new MaterialStack(Materials.Stone, OrePrefix.stone.getMaterialAmount(Materials.Stone)));
    }
}
