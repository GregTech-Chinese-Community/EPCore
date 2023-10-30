package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
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
                .iconSet(METALLIC)
                .flags(GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR)
                .blastTemp(4850, BlastProperty.GasTier.HIGHEST, VA[IV], 1000)
                .components(Nickel, 8, Chrome, 6, Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .build();
        //  24502 Hastelloy-N
        HastelloyN = new Material.Builder(24502, gregtechId("hastelloy_n"))
                .ingot()
                .fluid()
                .fluidTemp(3980)
                .color(0x939554)
                .iconSet(DULL)
                .flags(GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME)
                .blastTemp(4550, BlastProperty.GasTier.HIGHER, VA[EV], 800)
                .components(Nickel, 15, Molybdenum, 4, Chrome, 2, Titanium, 2, Yttrium, 2)
                .build();
        //  24503 Stellite
        Stellite = new Material.Builder(24503, gregtechId("stellite"))
                .ingot()
                .fluid()
                .fluidTemp(4110)
                .color(0x9991A5)
                .iconSet(METALLIC)
                .blastTemp(4310, BlastProperty.GasTier.HIGHER, VA[IV], 1200)
                .components(Chrome, 9, Cobalt, 9, Manganese, 5, Titanium, 2)
                .build();
        //  24504 Quantum Alloy
        QuantumAlloy = new Material.Builder(24504, gregtechId("quantum_alloy"))
                .ingot()
                .fluid()
                .color(0x0F0F0F)
                .iconSet(SHINY)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UHV], 1600)
                .components(Stellite, 15, Emerald, 5, Gallium, 5, Americium, 5, Germanium, 5, TitaniumTungstenCarbide, 5)
                .cableProperties(V[UHV], 24, 0, true)
                .build();
        //  24505 Grisium
        Grisium = new Material.Builder(24505, gregtechId("grisium"))
                .ingot()
                .fluid()
                .color(0x355D6A)
                .iconSet(METALLIC)
                //  TODO UEV stage coil?
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UEV], 2000)
                .components(BETSPerrhenate, 1, Trinaquadalloy, 4, Vibranium, 2, Taranium, 1, TitaniumCarbide, 9, Potassium, 9, Lithium, 9, Sulfur, 6)
                .cableProperties(V[UEV], 48, 0, true)
                .build();
        //  24506 HDCS (High Durability Compound Steel)
        Hdcs = new Material.Builder(24506, gregtechId("hdcs"))
                .ingot()
                .fluid()
                .color(0x334433)
                .iconSet(SHINY)
                .toolStats(new ToolProperty(20.0F, 10.0F, 18000, 18))
                //  TODO UHV stage Coil?
                .blastTemp(9900, BlastProperty.GasTier.HIGHEST, VA[UEV], 2400)
                .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, Plutonium241, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME)
                .build();
        //  24507 Abyssalloy
        Abyssalloy = new Material.Builder(24507, gregtechId("abyssalloy"))
                .ingot()
                .fluid()
                .color(0x9E706A)
                .iconSet(METALLIC)
                .blastTemp(9625, BlastProperty.GasTier.HIGHEST, VA[UEV], 2250)
                .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, IncoloyMA956, 5, Germanium, 1, Iodine, 1, Radon, 1)
                .cableProperties(V[UEV], 64, 64, false)
                .flags(GENERATE_FINE_WIRE)
                .build();
    }
}
