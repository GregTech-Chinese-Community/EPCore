package cn.gtcommunity.epimorphism.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;

public class EPMaterialFlags {

    public static final MaterialFlag GENERATE_COIL = new MaterialFlag.Builder("generate_coil")
            .requireFlags(MaterialFlags.GENERATE_FINE_WIRE)
            .build();

}
