package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags;
import gregtech.api.unification.material.Materials;

public class EPMaterialFlagAddition {

    public static void init() {
        Materials.Copper.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.AnnealedCopper.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Electrum.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Kanthal.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Graphene.addFlags(EPMaterialFlags.GENERATE_COIL);
    }

}
