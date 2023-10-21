package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPOrganicChemistryMaterials {

    //  Range 25000-25200
    public static void register() {
        //  25000 Kapton-K
        KaptonK = new Material.Builder(25000, gregtechId("kapton_k"))
                .ingot()
                .fluid()
                .color(16764498)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);
        //  25001 Kapton-E
        KaptonE = new Material.Builder(25001, gregtechId("kapton_e"))
                .ingot()
                .fluid()
                .color(16768908)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        Edot = new Material.Builder(25002, gregtechId("edot"))
                .fluid()
                .color(11665367)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .build();
        //  25003 Polystyrene
        Polystyrene = new Material.Builder(25003, gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .build();
        //  25004 PolystyreneSulfonate
        PolystyreneSulfonate = new Material.Builder(25004, gregtechId("polystyrene_sulfonate"))
                .ingot()
                .fluid()
                .color(14777458)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .build();
        //  25005  PEDOT-PSS
        PedotPSS = new Material.Builder(25005, gregtechId("pedot_pss"))
                .ingot()
                .fluid()
                .color(14771623)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(V[UHV], 24, 0, true)
                .build();
        //  25006  PMMA
        PMMA = new Material.Builder(25006, gregtechId("polymethylmethacrylate"))
                .ingot()
                .fluid()
                .color(9554657)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .build();
        //  25007  PEDOT:TMA
        PedotTMA = new Material.Builder(25007, gregtechId("pedot_tma"))
                .ingot()
                .fluid()
                .color(6201057)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING, GENERATE_LONG_ROD)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(V[UEV], 8, 6)
                .build();
        //  25008 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = new Material.Builder(25008, gregtechId("tetramethylammonium_hydroxide"))
                .fluid()
                .color(4259798)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("N(CH3)4OH", true);
        //  25009 Potassium Hydroxide
        PotassiumHydroxide = new Material.Builder(25009, gregtechId("potassium_hydroxide"))
                .dust()
                .fluid()
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .fluidTemp(633)
                .build();
        //  25010 Potassium Bromate
        PotassiumBromate = new Material.Builder(25010, gregtechId("potassium_bromate"))
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();
        //  25011 Malonic Acid
        MalonicAcid = new Material.Builder(25011, gregtechId("malonic_acid"))
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .build();
        //  25012 Chloroacetic Acid
        ChloroaceticAcid = new Material.Builder(25012, gregtechId("chloroacetic_acid"))
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .build();
        //  25013 Trichloroethylene
        Trichloroethylene = new Material.Builder(25013, gregtechId("trichloroethylene"))
                .fluid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .build();
        //  25014 Dichloroethane
        Dichloroethane = new Material.Builder(25014, gregtechId("dichloroethane"))
                .fluid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();
        //  25015 Hydrobromic Acid
        HydrobromicAcid = new Material.Builder(25015, gregtechId("hydrobromic_acid"))
                .fluid(FluidTypes.ACID)
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .build();
        //  25016 Butanediol
        Butanediol = new Material.Builder(25016, gregtechId("butanediol"))
                .fluid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build()
                .setFormula("C4H8(OH)2", true);
        //  25017 Diacetyl
        Diacetyl = new Material.Builder(25017,  gregtechId("diacetyl"))
                .fluid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25018 Ethylene Glycol
        EthyleneGlycol = new Material.Builder(25018, gregtechId("ethylene_glycol"))
                .fluid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C2H4(OH)2", true);
        //  25019 Sulfur Dichloride
        SulfurDichloride = new Material.Builder(25019, gregtechId("sulfur_dichloride"))
                .fluid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();
        //  25020 Acetone Cyanohydrin
        AcetoneCyanohydrin = new Material.Builder(25020, gregtechId("acetone_cyanohydrin"))
                .fluid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build();
        //  25021 Para Xylene
        ParaXylene = new Material.Builder(25021, gregtechId("para_xylene"))
                .fluid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);
        //  25022 Cycloparaphenylene
        Cycloparaphenylene = new Material.Builder(25022, gregtechId("cycloparaphenylene"))
                .fluid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .build();
        //  25023 Dichlorocyclooctadieneplatinium
        Dichlorocyclooctadieneplatinium = new Material.Builder(25023, gregtechId("dichlorocyclooctadieneplatinium"))
                .dust()
                .color(0xD4E982)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 12, Chlorine, 2, Platinum, 1)
                .build()
                .setFormula("C8H12Cl2Pt", true);
        //  25024 Diiodobiphenyl
        Diiodobiphenyl = new Material.Builder(25024, gregtechId("diiodobiphenyl"))
                .dust()
                .color(0x000C52)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 8, Iodine, 2)
                .build()
                .setFormula("C12H8I2", true);
        //  25025 Bipyridine
        Bipyridine = new Material.Builder(25025, gregtechId("bipyridine"))
                .dust()
                .color(0x716449)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C10H8N2", true);
        //  25026 Palladium Bisdibenzylidieneacetone
        PalladiumBisdibenzylidieneacetone = new Material.Builder(25026, gregtechId("palladium_bisdibenzylidieneacetone"))
                .dust()
                .color(0x996881)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 51, Hydrogen, 42, Oxygen, 3, Palladium, 2)
                .build()
                .setFormula("C51H42O3Pd2", true);
        //  25027 1-Octene
        Octene = new Material.Builder(25027, gregtechId("1_octene"))
                .fluid()
                .color(0x818022)
                .components(Carbon, 8, Hydrogen, 16)
                .build();
        //  25028 Acetylene
        Acetylene = new Material.Builder(25028, gregtechId("acetylene"))
                .fluid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();
        //  25029 Cyclooctadiene
        Cyclooctadiene = new Material.Builder(25029, gregtechId("cyclooctadiene"))
                .fluid()
                .color(0x40AC40)
                .components(Carbon, 8, Hydrogen, 12)
                .build();
        //  25030 Pyridine
        Pyridine = new Material.Builder(25030, gregtechId("pyridine"))
                .fluid()
                .color(0x716449)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .build();
        //  25031 Formaldehyde
        Formaldehyde = new Material.Builder(25031, gregtechId("formaldehyde"))
                .fluid()
                .color(0x858F40)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();
        //  25032 Dibenzylideneacetone
        Dibenzylideneacetone = new Material.Builder(25032, gregtechId("dibenzylideneacetone"))
                .fluid()
                .color(0xA44545)
                .components(Carbon, 17, Hydrogen, 14, Oxygen, 1)
                .build();
        //  25033 Benzaldehyde
        Benzaldehyde = new Material.Builder(25033, gregtechId("benzaldehyde"))
                .fluid()
                .color(0x957D53)
                .components(Carbon, 7, Hydrogen, 6, Oxygen, 1)
                .build();
        //  25034 Benzoyl Chloride
        BenzoylChloride = new Material.Builder(25034, gregtechId("benzoyl_chloride"))
                .fluid()
                .color(0xABE1FF)
                .components(Carbon, 7, Hydrogen, 5, Chlorine, 1, Oxygen, 1)
                .build();
        //  25035 Thionyl Chloride
        ThionylChloride = new Material.Builder(25035, gregtechId("thionyl_chloride"))
                .fluid()
                .color(0xDBC2C2)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build()
                .setFormula("SOCl2", true);
        //  25036 Polyetheretherketone (PEEK)
        Polyetheretherketone = new Material.Builder(25036, gregtechId("polyetheretherketone"))
                .polymer()
                .color(0x45433D)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
                .build();
        //  25037 Difluorobenzophenone
        Difluorobenzophenone = new Material.Builder(25037, gregtechId("difluorobenzophenone"))
                .dust()
                .color(0xC44DA5)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 13, Hydrogen, 8, Oxygen, 1, Fluorine, 2)
                .build()
                .setFormula("(FC6H4)2CO", true);
        //  25038 Hydroquinone
        Hydroquinone = new Material.Builder(25038, gregtechId("hydroquinone"))
                .fluid()
                .color(0x83251A)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C6H4(OH)2", true);
        //  25039 Resorcinol
        Resorcinol = new Material.Builder(25039, gregtechId("resorcinol"))
                .fluid()
                .color(0x9DA38D)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25040 Fluorobenzene
        Fluorobenzene = new Material.Builder(25040, gregtechId("fluorobenzene"))
                .fluid()
                .color(0x7CCA88)
                .components(Carbon, 6, Hydrogen, 5, Fluorine, 1)
                .build();
        //  25041 Fluorotoluene
        Fluorotoluene = new Material.Builder(25041, gregtechId("fluorotoluene"))
                .fluid()
                .color(0x6EC5B8)
                .components(Carbon, 7, Hydrogen, 7, Fluorine, 1)
                .build();
        //  25042 Kevlar
        Kevlar = new Material.Builder(25042, gregtechId("kevlar"))
                .polymer()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);
        //  25043 Para Phenylenediamine
        ParaPhenylenediamine = new Material.Builder(25043, gregtechId("para_phenylenediamine"))
                .dust()
                .color(0x4A8E7B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);
        //  25044 Terephthaloyl Chloride
        TerephthaloylChloride = new Material.Builder(25044, gregtechId("terephthaloyl_chloride"))
                .dust()
                .color(0xFAC4DA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);
        //  25045 N-Methyl Pyrrolidone
        NMethylPyrrolidone = new Material.Builder(25045, gregtechId("n_methyl_pyrrolidone"))
                .fluid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();
        //  25046 Nitroaniline
        Nitroaniline = new Material.Builder(25046, gregtechId("nitroaniline"))
                .fluid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);
        //  25047 Durene
        Durene = new Material.Builder(25047, gregtechId("durene"))
                .dust()
                .color(0x336040)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);
        //  25048 Pyromellitic Dianhydride
        PyromelliticDianhydride = new Material.Builder(25048, gregtechId("pyromellitic_dianhydride"))
                .dust()
                .color(0xF0EAD6)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);
        //  25049 Aminophenol
        Aminophenol = new Material.Builder(25049, gregtechId("aminophenol"))
                .fluid()
                .color(0xFF7F50)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("HOC6H4NH2", true);
        //  25050 Aniline
        Aniline = new Material.Builder(25050, gregtechId("aniline"))
                .fluid()
                .color(0x4C911D)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1)
                .build()
                .setFormula("C6H5NH2", true);
        //  25051 Oxydianiline
        Oxydianiline = new Material.Builder(25051, gregtechId("oxydianiline"))
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25052 Dimethylformamide
        Dimethylformamide = new Material.Builder(25052, gregtechId("dimethylformamide"))
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);
        //  25053 Phthalic Anhydride
        PhthalicAnhydride = new Material.Builder(25053, gregtechId("phthalic_anhydride"))
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);
        //  25054 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(25054, gregtechId("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);
        //  25055 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = new Material.Builder(25055, gregtechId("bistrichloromethylbenzene"))
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);
        //  25056 Tetrabromoethane
        Tetrabromoethane = new Material.Builder(25056, gregtechId("tetrabromoethane"))
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();
        //  25057 Terephthalic Acid
        TerephthalicAcid = new Material.Builder(25057, gregtechId("terephthalic_acid"))
                .dust()
                .color(0x5ACCDA)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);
        //  25058 γ-Butyrolactone
        GammaButyrolactone = new Material.Builder(25058, gregtechId("gamma_butyrolactone"))
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25059 Methylamine
        Methylamine = new Material.Builder(25059, gregtechId("methylamine"))
                .fluid(FluidTypes.GAS)
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);
        //  25060 Trimethylaluminium
        Trimethylaluminium = new Material.Builder(25060, gregtechId("trimethylaluminium"))
                .fluid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);
        //  25061 Trimethylgallium
        Trimethylgallium = new Material.Builder(25061, gregtechId("trimethylgallium"))
                .fluid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);
        //  25062 Benzophenanthrenylacetonitrile
        Benzophenanthrenylacetonitrile = new Material.Builder(25062, gregtechId("benzophenanthrenylacetonitrile"))
                .dust()
                .color(0xBB58E9)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 20, Hydrogen, 13, Nitrogen, 1)
                .build();
        //  25063 Methylbenzophenanthrene
        Methylbenzophenanthrene = new Material.Builder(25063, gregtechId("methylbenzophenanthrene"))
                .dust()
                .color(0xEA236B)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 19, Hydrogen, 14)
                .build();
        //  25064 Bromo Succinimide
        BromoSuccinimide = new Material.Builder(25064, gregtechId("bromo_succinimide"))
                .dust()
                .color(0x00BF8C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 4, Hydrogen, 4, Bromine, 1, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25065 Succinimide
        Succinimide = new Material.Builder(25065, gregtechId("succinimide"))
                .dust()
                .color(0x1774B6)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25066 Succinic Acid
        SuccinicAcid = new Material.Builder(25066, gregtechId("succinic_acid"))
                .dust()
                .color(0x0C3A5B)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .build();
        //  25067 Maleic Anhydride
        MaleicAnhydride = new Material.Builder(25067, gregtechId("maleic_anhydride"))
                .fluid()
                .color(0x610C2F)
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .build();
        //  25068 Naphthaldehyde
        Naphthaldehyde = new Material.Builder(25068, gregtechId("naphthaldehyde"))
                .fluid()
                .color(0x00FFED)
                .components(Carbon, 11, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("C10H7CHO", true);
        //  25069 Butanol
        Butanol = new Material.Builder(25069, gregtechId("butanol"))
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);
        //  25070 Bromobutane
        Bromobutane = new Material.Builder(25070, gregtechId("bromobutane"))
                .fluid()
                .color(0xAE0E39)
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .build()
                .setFormula("CH3(CH2)3Br", true);
        //  25071 Cyanonaphthalene
        Cyanonaphthalene = new Material.Builder(25071, gregtechId("cyanonaphthalene"))
                .dust()
                .color(0xDE992D)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 11, Hydrogen, 7, Nitrogen, 1)
                .build();
        //  25072 Triphenylphosphine
        Triphenylphosphine = new Material.Builder(25072, gregtechId("triphenylphosphine"))
                .dust()
                .color(0x8F2C6B)
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .build()
                .setFormula("(C6H5)3P", true);
    }
}
