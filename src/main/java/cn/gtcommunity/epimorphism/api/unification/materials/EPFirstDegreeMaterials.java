package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
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
                .fluid()
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
        //  24029 Ammonium Sulfate
        AmmoniumSulfate = new Material.Builder(24029, gregtechId("ammonium_sulfate"))
                .fluid()
                .color(0x5858F4)
                .build()
                .setFormula("(NH2)4SO4", true);
        //  24030 Ammonium Persulfate
        AmmoniumPersulfate = new Material.Builder(24030, gregtechId("ammonium_persulfate"))
                .fluid()
                .color(0x4242B7)
                .build()
                .setFormula("(NH4)2S2O8", true);
        //  24031 Hydroxylamine Disulfate
        HydroxylamineDisulfate = new Material.Builder(24031, gregtechId("hydroxylamine_disulfate"))
                .fluid()
                .color(0x91A6D2)
                .build()
                .setFormula("(NH3OH)2(NH4)2(SO4)2", true);
        //  24032 Hydroxylamine
        Hydroxylamine = new Material.Builder(24032, gregtechId("hydroxylamine"))
                .fluid()
                .color(0x91C791)
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("H3NO", true);
        //  24033 Ammonium Nitrate
        AmmoniumNitrate = new Material.Builder(24033, gregtechId("ammonium_nitrate"))
                .fluid()
                .color(0x454066)
                .components(Nitrogen, 2, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("NH4NO3", true);
        //  24034 Thallium Sulfate
        ThalliumSulfate = new Material.Builder(24034, gregtechId("thallium_sulfate"))
                .dust()
                .color(0x9C222C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .build();
        //  24035 Thallium Chloride
        ThalliumChloride = new Material.Builder(24035, gregtechId("thallium_chloride"))
                .dust()
                .color(0xCC5350)
                .iconSet(MaterialIconSet.SHINY)
                .components(Thallium, 1, Chlorine, 1)
                .build();
        //  24036 Iodized Brine
        IodizedBrine = new Material.Builder(24036, gregtechId("iodized_brine"))
                .fluid()
                .color(0x525246)
                .build()
                .setFormula("I?", false);
        //  24037 Iodine Brine Mixture
        IodineBrineMixture = new Material.Builder(24037, gregtechId("iodine_brine_mixture"))
                .fluid()
                .color(0x525234)
                .build()
                .setFormula("I?Cl", false);
        //  24038 Brominated Brine
        BrominatedBrine = new Material.Builder(24038, gregtechId("brominated_brine"))
                .fluid()
                .color(0xA9A990)
                .build()
                .setFormula("Br?", false);
        //  24039 Iodine Slurry
        IodineSlurry = new Material.Builder(24039, gregtechId("iodine_slurry"))
                .fluid()
                .color(0x292923)
                .build()
                .setFormula("I?", false);
        //  24040 Sodium Iodate
        SodiumIodate = new Material.Builder(24040, gregtechId("sodium_iodate"))
                .dust()
                .color(0x0B0B47)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Iodine, 1, Oxygen, 3)
                .build();
        //  24041 Sodium Iodide
        SodiumIodide = new Material.Builder(24041, gregtechId("sodium_iodide"))
                .dust()
                .color(0x1919A3)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Iodine, 1)
                .build();
        //  24042 Sodium Hypochlorite
        SodiumHypochlorite = new Material.Builder(24042, gregtechId("sodium_hypochlorite"))
                .dust()
                .color(0x2828FF)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                .build();
        //  24043 Sodium Periodate
        SodiumPeriodate = new Material.Builder(24043, gregtechId("sodium_periodate"))
                .dust()
                .color(0x050547)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Sodium, 1, Iodine, 1, Oxygen, 4)
                .build();
        //  24044 Acidic Brominated Brine
        AcidicBrominatedBrine = new Material.Builder(24044, gregtechId("acidic_brominated_brine"))
                .fluid(FluidTypes.ACID)
                .color(0xC6A76F)
                .build()
                .setFormula("Br?(H2SO4)Cl", true);
        //  24045 Bromine Sulfate Solution
        BromineSulfateSolution = new Material.Builder(24045, gregtechId("bromine_sulfate_solution"))
                .fluid()
                .color(0xCC9966)
                .build()
                .setFormula("H2SO4Br(H2O)Cl2", true);
        //  24046 Overheated Bromine Sulfate Solution
        OverheatedBromineSulfateSolution = new Material.Builder(24046, gregtechId("overheated_bromine_sulfate_solution"))
                .fluid()
                .color(0xC69337)
                .iconSet(MaterialIconSet.DULL)
                .build()
                .setFormula("H2SO4Br(H2O)2Cl2", true);
        //  24047 Wet Bromine
        WetBromine = new Material.Builder(24047, gregtechId("wet_bromine"))
                .fluid()
                .color(0xDB5C5C)
                .iconSet(MaterialIconSet.DULL)
                .build()
                .setFormula("Br(H2O)", true);
        //  24048 Debrominated Water
        DebrominatedWater = new Material.Builder(24048, gregtechId("debrominated_water"))
                .fluid()
                .color(0x24A3A3)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();
        //  24049 Palladium Chloride
        PalladiumChloride = new Material.Builder(24049, gregtechId("palladium_chloride"))
                .dust()
                .color(0xAFB5BC)
                .iconSet(MaterialIconSet.SHINY)
                .components(Palladium, 1, Chlorine, 2)
                .build();
        //  24050 Palladium on Carbon
        PalladiumOnCarbon = new Material.Builder(24050, gregtechId("palladium_on_carbon"))
                .dust()
                .color(0x480104)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, Carbon, 1)
                .build();
        //  24051 Potassium Permanganate
        PotassiumPermanganate = new Material.Builder(24051, gregtechId("potassium_permanganate"))
                .dust()
                .color(0x871D82)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 1, Manganese, 1, Oxygen, 4)
                .build();
        //  24052 Potassium Manganate
        PotassiumManganate = new Material.Builder(24052, gregtechId("potassium_manganate"))
                .dust()
                .color(0x873883)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Potassium, 2, Manganese, 1, Oxygen, 4)
                .build();
        //  24053 Tin Chloride
        TinChloride = new Material.Builder(24053, gregtechId("tin_chloride"))
                .dust()
                .fluid()
                .color(0xDBDBDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Tin, 1, Chlorine, 2)
                .build();
        //  24054 Silver Oxide
        SilverOxide = new Material.Builder(24054, gregtechId("silver_oxide"))
                .dust()
                .color(0xA4A4A4)
                .components(Silver, 2, Oxygen, 1)
                .build();
        //  24055 Sodium Fluoride
        SodiumFluoride = new Material.Builder(24055, gregtechId("sodium_fluoride"))
                .dust()
                .color(0x460012)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Fluorine, 1)
                .build();
        //  24056 Zn-Fe-Al-Cl Catalyst
        ZnFeAlClCatalyst = new Material.Builder(24056, gregtechId("zn_fe_al_cl_catalyst"))
                .dust()
                .color(0xC522A9)
                .iconSet(MaterialIconSet.DULL)
                .components(Zinc, 1, Iron, 1, Aluminium, 1, Chlorine, 1)
                .build();
        //  24057 Sodium Nitrite
        SodiumNitrite = new Material.Builder(24057, gregtechId("sodium_nitrite"))
                .dust()
                .color(0x205CA4)
                .iconSet(MaterialIconSet.DULL)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 2)
                .build();
        //  24058 Sodium Nitrate
        SodiumNitrate = new Material.Builder(24058, gregtechId("sodium_nitrate"))
                .dust()
                .fluid()
                .color(0xEB9E3F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .build();
        //  24059 Fluoroboric Acid
        FluoroboricAcid = new Material.Builder(24059, gregtechId("fluoroboric_acid"))
                .fluid(FluidTypes.ACID)
                .color(0xD5811B)
                .components(Hydrogen, 1, Boron, 1, Fluorine, 4)
                .build();
        //  24060 Benzenediazonium Tetrafluoroborate
        BenzenediazoniumTetrafluoroborate = new Material.Builder(24060, gregtechId("benzenediazonium_tetrafluoroborate"))
                .fluid()
                .color(0xD5C5B2)
                .components(Carbon, 6, Hydrogen, 5, Boron, 1, Fluorine, 4, Nitrogen, 2)
                .build();
        //  24061 Gallium Trichloride
        GalliumTrichloride = new Material.Builder(24061, gregtechId("gallium_trichloride"))
                .dust()
                .color(0x6EB4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .build();
        //  24062 Aluminium Trichloride
        AluminiumTrichloride = new Material.Builder(24062, gregtechId("aluminium_trichloride"))
                .dust()
                .color(0x78C3EB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .build();
        //  24063 Aluminium Hydroxide
        AluminiumHydroxide = new Material.Builder(24063, gregtechId("aluminium_hydroxide"))
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .build()
                .setFormula("Al(OH)3", true);
        //  24064 Alumina
        Alumina = new Material.Builder(24064, gregtechId("alumina"))
                .dust()
                .color(0x78c3eb)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Aluminium, 2, Oxygen, 3)
                .build();
        //  24065 Gallium Trioxide
        GalliumTrioxide = new Material.Builder(24065, gregtechId("gallium_trioxide"))
                .dust()
                .fluid()
                .fluidTemp(2170)
                .color(0xE4CDFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .build();
        //  24066 Gallium Nitride
        GalliumNitride = new Material.Builder(24066, gregtechId("gallium_nitride"))
                .ingot()
                .color(0xFFF458)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .build();
        //  24067 Fullerene
        Fullerene = new Material.Builder(24067, gregtechId("fullerene"))
                .ingot()
                .color(0x72556A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING, GENERATE_FRAME)
                .components(Carbon, 60)
                .build();
        //  24068 Geodesic Polyarene
        GeodesicPolyarene = new Material.Builder(24068, gregtechId("geodesic_polyarene"))
                .dust()
                .color(0x9E81A8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .build();
        //  24069 Ti-Al Catalyst
        TiAlCatalyst = new Material.Builder(24069, gregtechId("ti_al_catalyst"))
                .dust()
                .color(0x6600CC)
                .iconSet(MaterialIconSet.DULL)
                .components(Titanium, 1, Aluminium, 1)
                .build();
        //  24070 Potassium Cyanide
        PotassiumCyanide = new Material.Builder(24070, gregtechId("potassium_cyanide"))
                .dust()
                .color(0x9EF3D0)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Carbon, 1, Nitrogen, 1)
                .build();
        //  24071 Potassium Bromide
        PotassiumBromide = new Material.Builder(24071, gregtechId("potassium_bromide"))
                .dust()
                .color(0x615057)
                .iconSet(MaterialIconSet.DULL)
                .components(Potassium, 1, Bromine, 1)
                .build();
        //  24072 Bismuth Vanadate
        BismuthVanadate = new Material.Builder(24072, gregtechId("bismuth_vanadate"))
                .dust()
                .color(0xFFAF33)
                .iconSet(MaterialIconSet.SHINY)
                .components(Bismuth, 1, Vanadium, 1, Oxygen, 4)
                .build();
        //  24073 Bismuth Vanadate Solution
        BismuthVanadateSolution = new Material.Builder(24073, gregtechId("bismuth_vanadate_solution"))
                .fluid()
                .color(0xFFAF33)
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth, 1, Vanadium, 1, Hydrogen, 2, Oxygen, 5)
                .build()
                .setFormula("BiVO4(H2O)", true);
        //  24074 Ammonium Vanadate
        AmmoniumVanadate = new Material.Builder(24074, gregtechId("ammonium_vanadate"))
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Vanadium, 1, Oxygen, 3)
                .build();
        //  24075 Vanadium Slag
        VanadiumSlag = new Material.Builder(24075, gregtechId("vanadium_slag"))
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vanadium, 1, Oxygen, 1)
                .build();
        //  24076 Bismuth Nitrate Solution
        BismuthNitrateSolution = new Material.Builder(24076, gregtechId("bismuth_nitrate_solution"))
                .fluid()
                .color(0x3ABF50)
                .components(Bismuth, 1, Nitrogen, 3, Oxygen, 10, Hydrogen, 2)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Bi(NO3)3(H2O)");
        //  24077 Sodium Vanadate
        SodiumVanadate = new Material.Builder(24077, gregtechId("sodium_vanadate"))
                .dust()
                .color(0xCC9933)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 3, Vanadium, 1, Oxygen, 4)
                .build();
        //  24078 Vanadium Waste Solution
        VanadiumWasteSolution = new Material.Builder(24078, gregtechId("vanadium_waste_solution"))
                .fluid()
                .color(0xA28097)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("NaCl(Na2SO4)(SiO2)(Al(OH)3)");
        //  24079 Sodium Bromide
        SodiumBromide = new Material.Builder(24079, gregtechId("sodium_bromide"))
                .dust()
                .color(0x830B2B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 1, Bromine, 1)
                .build();
        //  24080 White Phosphorus
        WhitePhosphorus = new Material.Builder(24080, gregtechId("white_phosphorus"))
                .gem()
                .color(0xECEADD)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();
        //  24081 Red Phosphorus
        RedPhosphorus = new Material.Builder(24081, gregtechId("red_phosphorus"))
                .gem()
                .color(0x77040E)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();
        //  24082 Violet Phosphorus
        VioletPhosphorus = new Material.Builder(24082, gregtechId("violet_phosphorus"))
                .gem()
                .color(0x8000FF)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();
        //  24083 Black Phosphorus
        BlackPhosphorus = new Material.Builder(24083, gregtechId("black_phosphorus"))
                .gem()
                .color(0x36454F)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();
        //  24084 Blue Phosphorus
        BluePhosphorus = new Material.Builder(24084, gregtechId("blue_phosphorus"))
                .gem()
                .color(0x9BE3E4)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();
        //  24085 Wollastonite
        Wollastonite = new Material.Builder(24085, gregtechId("wollastonite"))
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);
        //  24086 Phosphorene
        Phosphorene = new Material.Builder(24086, gregtechId("phosphorene"))
                .ingot()
                .color(0x273239)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .build();
        //  24087 Phosphoryl Chloride
        PhosphorylChloride = new Material.Builder(24087, gregtechId("phosphoryl_chloride"))
                .fluid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .build();
        //  24088 Phosphine
        Phosphine = new Material.Builder(24088, gregtechId("phosphine"))
                .fluid(FluidTypes.GAS)
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .build();
        //  24089 Copper Chloride
        CopperChloride = new Material.Builder(24089, gregtechId("copper_chloride"))
                .dust()
                .color(0x3FB3B8)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Copper, 1, Chlorine, 2)
                .build();
        //  24090 Lithium Hydroxide
        LithiumHydroxide = new Material.Builder(24090, gregtechId("lithium_hydroxide"))
                .dust()
                .color(0xDECAFA)
                .iconSet(MaterialIconSet.FINE)
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .build();

        //  24091 Lithiuim Amalgam
        LithiumAmalgam = new Material.Builder(24091, gregtechId("lithium_amalgam"))
                .fluid()
                .color(0xAEA7D4)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Mercury, 1, Lithium, 1)
                .build();
        //  24092 Hexafluoride Enriched Naquadah Solution
        HexafluorideEnrichedNaquadahSolution = new Material.Builder(24092, gregtechId("hexafluoride_enriched_naquadah_solution"))
                .fluid()
                .color(0x868D7F)
                .components(NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24093 Xenon Hexafluoro Enriched Naquadate
        XenonHexafluoroEnrichedNaquadate = new Material.Builder(24093, gregtechId("xenon_hexafluoro_enriched_naquadate"))
                .fluid()
                .color(0x255A55)
                .components(Xenon, 1, NaquadahEnriched, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24094 Enriched Naquadah Residue Solution
        EnrichedNaquadahResidueSolution = new Material.Builder(24094, gregtechId("enriched_naquadah_residue_solution"))
                .fluid()
                .color(0x868D7F)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("XeAuSbKeF6S2?");
        //  24095 Xenoauric Fluoroantimonic Acid
        XenoauricFluoroantimonicAcid = new Material.Builder(24095, gregtechId("xenoauric_fluoroantimonic_acid"))
                .fluid(FluidTypes.ACID)
                .color(0xE0BD74)
                .components(Xenon, 1, Gold, 1, Antimony, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24096 Gold Chloride
        GoldChloride = new Material.Builder(24096, gregtechId("gold_chloride"))
                .fluid()
                .color(0xCCCC66)
                .components(Gold, 2, Chlorine, 6)
                .build();
        //  24097 Bromine Trifluoride
        BromineTrifluoride = new Material.Builder(24097, gregtechId("bromine_trifluoride"))
                .fluid()
                .color(0xA88E57)
                .components(Bromine, 1, Fluorine, 3)
                .build();
        //  24098 Gold Trifluoride
        GoldTrifluoride = new Material.Builder(24098, gregtechId("gold_trifluoride"))
                .dust()
                .color(0xE8C478)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Gold, 1, Fluorine, 3)
                .build();
        //  24099 Naquadria Caesiumfluoride
        NaquadriaCaesiumfluoride = new Material.Builder(24099, gregtechId("naquadria_caesiumfluoride"))
                .fluid()
                .color(0xAAEB69)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("*Nq*F2CsF", true);
        //  24100 Acidic Naquadria Caesiumfluoride
        AcidicNaquadriaCaesiumfluoride = new Material.Builder(24100, gregtechId("acidic_naquadria_caesiumfluoride"))
                .fluid()
                .color(0x75EB00)
                .components(Naquadria, 1, Fluorine, 3, Caesium, 1, Sulfur, 2, Oxygen, 8)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("*Nq*F2CsF(SO4)2", true);
        //  24101 Nitrosonium Octafluoroxenate
        NitrosoniumOctafluoroxenate = new Material.Builder(24101, gregtechId("nitrosonium_octafluoroxenate"))
                .fluid()
                .color(0x953D9F)
                .components(NitrogenDioxide, 2, Xenon, 1, Fluorine, 8)
                .build()
                .setFormula("(NO2)2XeF8", true);
        //  24102 Naquadria Caesium Xenonnonfluoride
        NaquadriaCaesiumXenonnonfluoride = new Material.Builder(24102, gregtechId("naquadria_caesium_xenonnonfluoride"))
                .fluid()
                .color(0x54C248)
                .components(Naquadria, 1, Caesium, 1, Xenon, 1, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24103 Radon Naquadria Octafluoride
        RadonNaquadriaOctafluoride = new Material.Builder(24103, gregtechId("radon_naquadria_octafluoride"))
                .fluid()
                .color(0x85F378)
                .components(Radon, 1, Naquadria, 1, Fluorine, 8)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24104 Caesium Xenontrioxide Fluoride
        CaesiumXenontrioxideFluoride = new Material.Builder(24104, gregtechId("caesium_xenontrioxide_fluoride"))
                .fluid()
                .color(0x5067D7)
                .flags(DISABLE_DECOMPOSITION)
                .components(Caesium, 1, Xenon, 1, Oxygen, 3, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24105 Radon Trioxide
        RadonTrioxide = new Material.Builder(24105, gregtechId("radon_trioxide"))
                .fluid()
                .color(0x9A6DD7)
                .components(Radon, 1, Oxygen, 3)
                .build();
        //  24106 Cesium Fluoride
        CaesiumFluoride = new Material.Builder(24106, gregtechId("caesium_fluoride"))
                .fluid()
                .color(0xFF7A5F)
                .components(Caesium, 1, Fluorine, 1)
                .build();
        //  24107 Xenon Trioxide
        XenonTrioxide = new Material.Builder(24107, gregtechId("xenon_trioxide"))
                .fluid()
                .color(0x359FC3)
                .components(Xenon, 1, Oxygen, 3)
                .build();
        //  24108 Hexafluoride Naquadria Solution
        HexafluorideNaquadriaSolution = new Material.Builder(24108, gregtechId("hexafluoride_naquadria_solution"))
                .fluid()
                .color(0x25C213)
                .components(Naquadria, 1, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  24109 Naquadria Residue Solution
        NaquadriaResidueSolution = new Material.Builder(24109, gregtechId("naquadria_residue_solution"))
                .fluid()
                .color(0x25C213)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("InPS6?", true);
        //  24110 Radon Difluoride
        RadonDifluoride = new Material.Builder(24110, gregtechId("radon_difluoride"))
                .fluid()
                .color(0x8B7EFF)
                .components(Radon, 1, Fluorine, 2)
                .build();
        //  24111 Heavy Alkali Chloride Solution
        HeavyAlkaliChlorideSolution = new Material.Builder(24111, gregtechId("heavy_alkali_chloride_solution"))
                .fluid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .build()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);
        //  24112 Stannic Chloride
        StannicChloride = new Material.Builder(24112, gregtechId("stannic_chloride"))
                .fluid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .build();
        //  24113 Rubidium Chlorostannate
        RubidiumChlorostannate = new Material.Builder(24113, gregtechId("rubidium_chlorostannate"))
                .dust()
                .color(0xBD888A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .build();
        //  24114 Caesium Chlorostannate
        CaesiumChlorostannate = new Material.Builder(24114, gregtechId("caesium_chlorostannate"))
                .dust()
                .color(0xBDAD88)
                .iconSet(MaterialIconSet.SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .build();
        //  24115 Germanium Dioxide
        GermaniumDioxide = new Material.Builder(24115, gregtechId("germanium_dioxide"))
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .build();
        //  24116 Roasted Sphalerite
        RoastedSphalerite = new Material.Builder(24116, gregtechId("roasted_sphalerite"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .build();
        //  24117 Zinc Rich Sphalerite
        ZincRichSphalerite = new Material.Builder(24117, gregtechId("zinc_rich_sphalerite"))
                .dust()
                .color(0xC3AC8F)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .build()
                .setFormula("Zn2(GaGeO2)", true);
        //  24118 Zinc Oxide
        ZincOxide = new Material.Builder(24118, gregtechId("zinc_oxide"))
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .build();
        //  24119 Waelz Oxide
        WaelzOxide = new Material.Builder(24119, gregtechId("waelz_oxide"))
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .build();
        //  24120 Waelz Slag
        WaelzSlag = new Material.Builder(24120, gregtechId("waelz_slag"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();
        //  24121 Impure Germanium Dioxide
        ImpureGermaniumDioxide = new Material.Builder(24121, gregtechId("impure_germanium_dioxide"))
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);
        //  24122 Germanium Tetrachloride
        GermaniumTetrachloride = new Material.Builder(24122, gregtechId("germanium_tetrachloride"))
                .fluid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .build();
        //  24123 Molybdenum Trioxide
        MolybdenumTrioxide = new Material.Builder(24123, gregtechId("molybdenum_trioxide"))
                .dust()
                .color(0xCBCFDA)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .build();
        //  24124 Lead Chloride
        LeadChloride = new Material.Builder(24124, gregtechId("lead_chloride"))
                .dust()
                .color(0xF3F3F3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .build();
        //  24125 Perrhenic Acid
        PerrhenicAcid = new Material.Builder(24125, gregtechId("perrhenic_acid"))
                .dust()
                .color(0xE6DC70)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .build();
        //  24126 Ammonium Perrhenate
        AmmoniumPerrhenate = new Material.Builder(24126, gregtechId("ammonium_perrhenate"))
                .dust()
                .color(0xA69970)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .build();
        //  24127 Niobium Pentoxide
        NiobiumPentoxide = new Material.Builder(24127, gregtechId("niobium_pentoxide"))
                .dust()
                .color(0xBAB0C3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .build();
        //  24128 Tantalum Pentoxide
        TantalumPentoxide = new Material.Builder(24128, gregtechId("tantalum_pentoxide"))
                .dust()
                .color(0x72728A)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .build();
        //  24129 Calcium Difluoride
        CalciumDifluoride = new Material.Builder(24129, gregtechId("calcium_difluoride"))
                .dust()
                .color(0xFFFC9E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .build();
        //  24130 Manganese Difluoride
        ManganeseDifluoride = new Material.Builder(24130, gregtechId("manganese_difluoride"))
                .dust()
                .color(0xEF4B3D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .build();
        //  24131 Calcium Carbide
        CalciumCarbide = new Material.Builder(24131, gregtechId("calcium_carbide"))
                .dust()
                .color(0x807B70)
                .iconSet(MaterialIconSet.DULL)
                .components(Calcium, 1, Carbon, 2)
                .build();
        //  24132 Calcium Hydroxide
        CalciumHydroxide = new Material.Builder(24132, gregtechId("calcium_hydroxide"))
                .dust()
                .color(0x5F8764)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .build()
                .setFormula("Ca(OH)2", true);
        //  24133 Sodium Tellurite
        SodiumTellurite = new Material.Builder(24133, gregtechId("sodium_tellurite"))
                .dust()
                .color(0xC6C9BE)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .build();
        //  24134 Selenium Dioxide
        SeleniumDioxide = new Material.Builder(24134, gregtechId("selenium_dioxide"))
                .dust()
                .color(0xE0DDD8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .build();
        //  24135 Tellurium Dioxide
        TelluriumDioxide = new Material.Builder(24135, gregtechId("tellurium_dioxide"))
                .dust()
                .color(0xE3DDB8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .build();
        //  24136 Selenous Acid
        SelenousAcid = new Material.Builder(24136, gregtechId("selenous_acid"))
                .dust()
                .color(0xE0E083)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .build();
        //  24137 GST Glass
        GSTGlass = new Material.Builder(24137, gregtechId("gst_glass"))
                .ingot()
                .fluid()
                .color(0xCFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .build();
        //  24138 ZBLAN Glass
        ZBLANGlass = new Material.Builder(24138, gregtechId("zblan_glass"))
                .ingot()
                .fluid()
                .color(0xACB4BC)
                .iconSet(MaterialIconSet.SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);
        //  24139 Erbium-doped ZBLAN Glass
        ErbiumDopedZBLANGlass = new Material.Builder(24139, gregtechId("erbium_doped_zblan_glass"))
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);
        //  24140 PraseodymiumDopedZBLANGlass
        PraseodymiumDopedZBLANGlass = new Material.Builder(24140, gregtechId("praseodymium_doped_zblan_glass"))
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);
        //  24141 Silicon Tetrachloride
        SiliconTetrachloride = new Material.Builder(24141, gregtechId("silicon_tetrachloride"))
                .fluid()
                .color(0x5B5B7A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Chlorine, 4)
                .build();
        //  24142 Cadmium Sulfide
        CadmiumSulfide = new Material.Builder(24142, gregtechId("cadmium_sulfide"))
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .build();
        //  24143 Silicon Carbide
        SiliconCarbide = new Material.Builder(24143, gregtechId("silicon_carbide"))
                .dust()
                .color(0x4D4D4D)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, VA[UV])
                .cableProperties(V[UHV], 6, 8)
                .build();

        //  24144 Chromium Germanium Telluride
        ChromiumGermaniumTelluride = new Material.Builder(24144, gregtechId("chromium_germanium_telluride"))
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chrome, 1, Germanium, 1, Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .build();

        //  24145 Magnetic Chromium Germanium Telluride
        ChromiumGermaniumTellurideMagnetic = new Material.Builder(24145, gregtechId("magnetic_chromium_germanium_telluride"))
                .ingot()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .build();
        
        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);
    }
}
