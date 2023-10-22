package cn.gtcommunity.epimorphism.api.unification.materials;

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
    }
}
