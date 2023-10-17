package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPMachineCasingMaterials {
    //  Range 24501-24999
    public static void register() {
        //  24501 Inconel-625
        Inconel625 = new Material.Builder(24501, gregtechId("inconel_625"))
                .ingot()
                .fluid()
                .fluidTemp(3700)
                .fluidPipeProperties(5500, 640, true, true, true, true)
                .color(0x3fcc60)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR)
                .blastTemp(4850, BlastProperty.GasTier.HIGHEST, VA[5], 1000)
                .components(Nickel, 8, Chrome, 6, Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .build();

        //  24502 Hastelloy-N
        HastelloyN = new Material.Builder(24502, gregtechId("hastelloy_n"))
                .ingot()
                .fluid()
                .fluidTemp(3980)
                .color(0x939554)
                .iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME)
                .blastTemp(4550, BlastProperty.GasTier.HIGHER, VA[4], 800)
                .components(Nickel, 15, Molybdenum, 4, Chrome, 2, Titanium, 2, Yttrium, 2)
                .build();
    }
}
