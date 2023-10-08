package cn.gtcommunity.epimorphism.api.unification.ore;

import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags;
import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialIconType;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;

public class EPOrePrefix {

    public static final OrePrefix coil = new OrePrefix("coil", 453600L * 4, null, EPMaterialIconType.coil, 1L,
            (material -> material.hasFlag(MaterialFlags.GENERATE_FINE_WIRE) && material.hasFlag(EPMaterialFlags.GENERATE_COIL)));

}
