package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags;
import gregtech.api.unification.material.Materials;

public class EPMaterialFlagAddition {

    public static void init() {
        //  Coils for Motor wires
        Materials.Copper.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Cupronickel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Electrum.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Kanthal.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Graphene.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Ruridit.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Europium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Americium.addFlags(EPMaterialFlags.GENERATE_COIL);
        //  Coils for CEu Vanilla coils
        Materials.Lead.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Steel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Aluminium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.BlackSteel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.TungstenSteel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Iridium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Osmiridium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Tritanium.addFlags(EPMaterialFlags.GENERATE_COIL);
    }

}
