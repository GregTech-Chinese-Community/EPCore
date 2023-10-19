package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.MaterialFluidBlock;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPFirstDegreeMaterials {
    //  Range 24000-24500
    public static void register() {
        //  24001 GrapheneOxide
        GrapheneOxide = new Material.Builder(24001, gregtechId("graphene_oxide"))
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();
        //  24002 Hydrazine
        Hydrazine = new Material.Builder(24002, gregtechId("hydrazine"))
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        //  24003 BerylliumOxide
        BerylliumOxide = new Material.Builder(24003, gregtechId("beryllium_oxide"))
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        //  24004 Hydrogen Peroxide
        HydrogenPeroxide = new Material.Builder(24004, gregtechId("hydrogen_peroxide"))
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();

        //  24005 Tungsten Trioxide
        TungstenTrioxide = new Material.Builder(24005, gregtechId("tungsten_trioxide"))
                .dust()
                .color(0xC7D300)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .build();
        //  24006 Hexagonal Boron Nitride
        HexagonalBoronNitride = new Material.Builder(24006, gregtechId("hexagonal_boron_nitride"))
                .gem()
                .color(0x6A6A72)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("h-BN", true);

        //  24007  Cubic Boron Nitride
        CubicBoronNitride = new Material.Builder(24007, gregtechId("cubic_boron_nitride"))
                .gem()
                .color(0x545572)
                .iconSet(MaterialIconSet.DIAMOND)
                //  TODO DISABLE_CRYSTALLIZATION
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, CRYSTALLIZABLE, FLAMMABLE, EXPLOSIVE)
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 15))
                .build()
                .setFormula("c-BN", true);
        //  24008 Boric Acid
        BoricAcid = new Material.Builder(24008, gregtechId("boric_acid"))
                .dust()
                .color(0xFAFAFA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build();
        //  24009 Boron Trioxide
        BoronTrioxide = new Material.Builder(24009, gregtechId("boron_trioxide"))
                .dust()
                .color(0xE9FAC0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .build();
        //  24010 Boron Trifluoride
        BoronTrifluoride = new Material.Builder(24010, gregtechId("boron_trifluoride"))
                .fluid(FluidTypes.GAS)
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .build();
        //  24011 Lithium Hydride
        LithiumHydride = new Material.Builder(24011, gregtechId("lithium_hydride"))
                .ingot()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .build();
        //  24012 Lithium Tetrafluoroborate
        LithiumTetrafluoroborate = new Material.Builder(24012, gregtechId("lithium_tetrafluoroborate"))
                .dust()
                .color(0x90FAF6)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .build();
        //  24013 Diborane
        Diborane = new Material.Builder(24013, gregtechId("diborane"))
                .fluid(FluidTypes.GAS)
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .build();
        //  24014 Borazine
        Borazine = new Material.Builder(24014, gregtechId("borazine"))
                .fluid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .build();
        //  24015 Boron Trichloride
        BoronTrichloride = new Material.Builder(24015, gregtechId("boron_trichloride"))
                .fluid(FluidTypes.GAS)
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .build();
        //  24016 Trichloroborazine
        Trichloroborazine = new Material.Builder(24016, gregtechId("trichloroborazine"))
                .fluid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .build();
        //  24017 Amorphous Boron Nitride
        AmorphousBoronNitride = new Material.Builder(24017, gregtechId("amorphous_boron_nitride"))
                .ingot()
                .color(0x9193C5)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("a-BN", true);
        //  24018 Heterodiamond
        Heterodiamond = new Material.Builder(24018, gregtechId("heterodiamond"))
                .gem()
                .color(0x512A72)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .build();
        //  24019 Cubic Heterodiamond
        CubicHeterodiamond = new Material.Builder(24019, gregtechId("cubic_heterodiamond"))
                .gem()
                .color(0x753DA6)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .build()
                .setFormula("c-BC2N", true);
        //  24020 Carbon Nanotube
        CarbonNanotube = new Material.Builder(24020, gregtechId("carbon_nanotube"))
                .ingot()
                .fluid()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(V[UEV], 8, 6)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);
        //  24021 Silver Tetrafluoroborate
        SilverTetrafluoroborate = new Material.Builder(24021, gregtechId("silver_tetrafluoroborate"))
                .fluid()
                .color(0x818024)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silver, 1, Boron, 1, Fluorine, 4)
                .build()
                .setFormula("AgBF4", true);
        //  24022 Trimethyltin Chloride
        TrimethyltinChloride = new Material.Builder(24022, gregtechId("trimethyltin_chloride"))
                .fluid()
                .color(0x7F776F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 6, Tin, 1, Chlorine, 1)
                .build()
                .setFormula("(CH3)3SnCl", true);
        //  24023 Silver Chloride
        SilverChloride = new Material.Builder(24023, gregtechId("silver_chloride"))
                .dust()
                .color(0x8D8D8D)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Silver, 1, Chlorine, 1)
                .build();
        //  24024 Chloroplatinic Acid
        ChloroplatinicAcid = new Material.Builder(24024, gregtechId("chloroplatinic_acid"))
                .fluid(FluidTypes.ACID)
                .color(0xFFB546)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24025 Potassium Tetrachloroplatinate
        PotassiumTetrachloroplatinate = new Material.Builder(24025, gregtechId("potassium_tetrachloroplatinate"))
                .dust()
                .color(0xF1B04F)
                .iconSet(MaterialIconSet.SHINY)
                .components(Potassium, 2, Platinum, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("K2PtCl4", true);
        //  24026 Nickel Triphenylphosphite
        NickelTriphenylphosphite = new Material.Builder(24026, gregtechId("nickel_triphenylphosphite"))
                .dust()
                .color(0xCCCC66)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 2, Nickel, 1, Phosphorus, 2)
                .build()
                .setFormula("C36H30Cl2NiP2", true);
        //  24027 Nickel Chloride
        NickelChloride = new Material.Builder(24027, gregtechId("nickel_chloride"))
                .dust()
                .color(0x898A07)
                .iconSet(MaterialIconSet.DULL)
                .components(Nickel, 1, Chlorine, 2)
                .build();
        //  24028 Phosphorus Trichloride
        PhosphorusTrichloride = new Material.Builder(24028, gregtechId("phosphorus_trichloride"))
                .fluid()
                .color(0xD8D85B)
                .components(Phosphorus, 1, Chlorine, 3)
                .build();
    }
}
