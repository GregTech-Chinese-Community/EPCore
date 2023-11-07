package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;

import static cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPMachineCasingMaterials {
    //  Range 24501-25000
    private static int startId = 24501;
    private static final int END_ID = startId + 500;

    public static void register() {
        //  24501 Inconel-625
        Inconel625 = new Material.Builder(getMaterialsId(), gregtechId("inconel_625"))
                .ingot()
                .fluid()
                .fluidTemp(3700)
                .fluidPipeProperties(5500, 640, true, true, true, false)
                .color(0x3fcc60)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .blastTemp(4850, BlastProperty.GasTier.HIGHEST, VA[IV], 1000)
                .components(Nickel, 8, Chrome, 6, Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .build();
        //  24502 Hastelloy-N
        HastelloyN = new Material.Builder(getMaterialsId(), gregtechId("hastelloy_n"))
                .ingot()
                .fluid()
                .fluidTemp(3980)
                .color(0x939554)
                .iconSet(DULL)
                .flags(GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_CURVED_PLATE)
                .blastTemp(4550, BlastProperty.GasTier.HIGHER, VA[EV], 800)
                .components(Nickel, 15, Molybdenum, 4, Chrome, 2, Titanium, 2, Yttrium, 2)
                .build();
        //  24503 Stellite
        Stellite = new Material.Builder(getMaterialsId(), gregtechId("stellite"))
                .ingot()
                .fluid()
                .fluidTemp(4110)
                .color(0x9991A5)
                .iconSet(METALLIC)
                .blastTemp(4310, BlastProperty.GasTier.HIGHER, VA[EV], 1200)
                .components(Chrome, 9, Cobalt, 9, Manganese, 5, Titanium, 2)
                .flags(GENERATE_ROD, GENERATE_FRAME)
                .build();
        //  24504 Quantum Alloy
        QuantumAlloy = new Material.Builder(getMaterialsId(), gregtechId("quantum_alloy"))
                .ingot()
                .fluid()
                .color(0x0F0F0F)
                .iconSet(SHINY)
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UHV], 1600)
                .components(Stellite, 15, Emerald, 5, Gallium, 5, Americium, 5, Germanium, 5, TitaniumTungstenCarbide, 5)
                .cableProperties(V[UHV], 24, 0, true)
                .flags(GENERATE_PLATE)
                .build();
        //  24505 Grisium
        Grisium = new Material.Builder(getMaterialsId(), gregtechId("grisium"))
                .ingot()
                .fluid()
                .color(0x355D6A)
                .iconSet(METALLIC)
                .blastTemp(11800, BlastProperty.GasTier.HIGHEST, VA[UEV], 2000)
                .components(BETSPerrhenate, 1, Trinaquadalloy, 4, Vibranium, 2, Taranium, 1, TitaniumCarbide, 9, Potassium, 9, Lithium, 9, Sulfur, 6)
                .cableProperties(V[UEV], 48, 0, true)
                .build();
        //  24506 HDCS (High Durability Compound Steel)
        Hdcs = new Material.Builder(getMaterialsId(), gregtechId("hdcs"))
                .ingot()
                .fluid()
                .color(0x334433)
                .iconSet(SHINY)
                .toolStats(new ToolProperty(20.0F, 10.0F, 18000, 18))
                .blastTemp(11900, BlastProperty.GasTier.HIGHEST, VA[UEV], 2400)
                .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, Plutonium241, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_BOLT_SCREW, GENERATE_FRAME)
                .build();
        //  24507 Abyssalloy
        Abyssalloy = new Material.Builder(getMaterialsId(), gregtechId("abyssalloy"))
                .ingot()
                .fluid()
                .color(0x9E706A)
                .iconSet(METALLIC)
                .blastTemp(9625, BlastProperty.GasTier.HIGHEST, VA[UEV], 2250)
                .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, IncoloyMA956, 5, Germanium, 1, Rutherfordium, 1, Radon, 1)
                .cableProperties(V[UEV], 64, 64, false)
                .flags(GENERATE_FINE_WIRE)
                .build();
        //  24508 Lafium
        Lafium = new Material.Builder(getMaterialsId(), gregtechId("lafium"))
                .ingot()
                .fluid()
                .color(0x0D0D60)
                .iconSet(SHINY)
                .blastTemp(9865, BlastProperty.GasTier.HIGHEST, VA[UEV], 1860)
                .components(HastelloyN, 8, Naquadria, 4, Samarium, 2, Tungsten, 4, Aluminium, 6, Nickel, 8, Titanium, 4, Carbon, 2, Argon, 2)
                .fluidPipeProperties(23000, 8000, true, true, true, true)
                .build();
        //  24509 Black Titanium
        BlackTitanium = new Material.Builder(getMaterialsId(), gregtechId("black_titanium"))
                .ingot()
                .fluid()
                .color(0x6C003B)
                .iconSet(SHINY)
                .blastTemp(11500, BlastProperty.GasTier.HIGHEST, VA[UEV], 4580)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Titanium, 26, Lanthanum, 6, TungstenSteel, 4, Cobalt, 3, Manganese, 2, Phosphorus, 2, Palladium, 2, Niobium, 1, Argon, 5)
                .toolStats(new ToolProperty(9.0F, 30.0F, 32000, 20))
                .build();
        //  24510 Talonite
        Talonite = new Material.Builder(getMaterialsId(), gregtechId("talonite"))
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(SHINY)
                .blastTemp(3454)
                .flags(GENERATE_PLATE)
                .components(Cobalt, 4, Chrome, 3, Phosphorus, 2, Molybdenum, 1)
                .build();
        //  24511 Black Plutonium
        BlackPlutonium = new Material.Builder(getMaterialsId(), gregtechId("black_plutonium"))
                .ingot()
                .fluid()
                .color(0x060606)
                .iconSet(BRIGHT)
                .blastTemp(12960, BlastProperty.GasTier.HIGHEST, VA[UHV], 3600)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Plutonium244, 18, Cerium, 9, Gadolinium, 3, Dysprosium, 3, Thulium, 2, TungstenCarbide, 6, RedSteel, 6, Duranium, 2, Radon, 2)
                .build();
        //  24512 Maraging Steel-250
        MaragingSteel250 = new Material.Builder(getMaterialsId(), gregtechId("maraging_steel_250"))
                .ingot()
                .fluid()
                .color(0xA5ADB2)
                .iconSet(SHINY)
                .blastTemp(2413, BlastProperty.GasTier.MID, VA[EV], 680)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Steel, 16, Molybdenum, 1, Titanium, 1, Nickel, 4, Cobalt, 2)
                .build();
        //  24513 Staballoy
        Staballoy = new Material.Builder(getMaterialsId(), gregtechId("staballoy"))
                .ingot()
                .fluid()
                .color(0x444B42)
                .iconSet(SHINY)
                .blastTemp(3450, BlastProperty.GasTier.HIGH, VA[EV], 462)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .components(Uranium238, 9, Titanium, 1)
                .build();
        //  24514 Babbitt Alloy
        BabbittAlloy = new Material.Builder(getMaterialsId(), gregtechId("babbitt_alloy"))
                .ingot()
                .fluid()
                .color(0xA19CA4)
                .iconSet(SHINY)
                .components(Tin, 5, Lead, 36, Antimony, 8, Astatine, 1)
                .blastTemp(737, BlastProperty.GasTier.MID, VA[MV], 214)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();
        //  24515 Zirconium Carbide
        ZirconiumCarbide = new Material.Builder(getMaterialsId(), gregtechId("zirconium_carbide"))
                .ingot()
                .fluid()
                .color(0xFFDACD)
                .iconSet(SHINY)
                .components(Zirconium, 1, Carbon, 1)
                .blastTemp(1200, BlastProperty.GasTier.MID, VA[HV], 344)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();
        //  24516 Inconel-792
        Inconel792 = new Material.Builder(getMaterialsId(), gregtechId("inconel_792"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(Nickel, 2, Niobium, 1, Aluminium, 2, Nichrome, 1)
                .blastTemp(6200, BlastProperty.GasTier.HIGHER, VA[IV], 1266)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_CURVED_PLATE, GENERATE_ROTOR)
                .fluidPipeProperties(4900, 220, true, true, true, false)
                .build();
        //  24517 Incoloy-MA813
        IncoloyMA813 = new Material.Builder(getMaterialsId(), gregtechId("incoloy_ma_813"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(VanadiumSteel, 4, Osmiridium, 2, HSSS, 3, Germanium, 4, Duranium, 5, Dubnium, 1)
                .blastTemp(9900, BlastProperty.GasTier.HIGHEST, VA[ZPM], 4277)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW)
                .build();
        //  24518 Hastelloy-X78
        HastelloyX78 = new Material.Builder(getMaterialsId(), gregtechId("hastelloy_x_78"))
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(SHINY)
                .blastTemp(12800, BlastProperty.GasTier.HIGHEST, VA[UHV], 4997)
                .components(NaquadahAlloy, 10, Rhenium, 5, Naquadria, 4, Gadolinium, 3, Strontium, 2, Polonium, 3, Rutherfordium, 2, Fermium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();
        //  24519 Hastelloy-K243
        HastelloyK243 = new Material.Builder(getMaterialsId(), gregtechId("hastelloy_k_243"))
                .ingot()
                .fluid()
                .color(0xa4ff70)
                .iconSet(BRIGHT)
                .blastTemp(12400, BlastProperty.GasTier.HIGHEST, VA[UEV], 5032)
                .components(HastelloyX78, 5, NiobiumNitride, 2, Tritanium, 4, TungstenCarbide, 4, Promethium, 4, Mendelevium, 1)
                .build();
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
