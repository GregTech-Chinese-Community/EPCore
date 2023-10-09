package cn.gtcommunity.epimorphism.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;

public class EPMaterialFlags {

    public static final MaterialFlag GENERATE_COIL = new MaterialFlag.Builder("generate_coil")
            .requireFlags(MaterialFlags.GENERATE_FINE_WIRE)
            .build();
    public static final MaterialFlag GENERATE_CURVED_PLATE = new MaterialFlag.Builder("generate_curved_plate")
            .requireFlags(MaterialFlags.GENERATE_PLATE)
            .build();
}
