package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPOrganicChemistryMaterials {
    //  Range 25001-25200
    private static int startId = 25001;
    private static final int END_ID = startId + 200;

    public static void register() {
        //  25000 Kapton-K
        KaptonK = new Material.Builder(getMaterialsId(), gregtechId("kapton_k"))
                .ingot()
                .fluid()
                .color(16764498)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);
        //  25001 Kapton-E
        KaptonE = new Material.Builder(getMaterialsId(), gregtechId("kapton_e"))
                .ingot()
                .fluid()
                .color(16768908)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        Edot = new Material.Builder(getMaterialsId(), gregtechId("edot"))
                .fluid()
                .color(11665367)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .build();
        //  25003 Polystyrene
        Polystyrene = new Material.Builder(getMaterialsId(), gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .build();
        //  25004 PolystyreneSulfonate
        PolystyreneSulfonate = new Material.Builder(getMaterialsId(), gregtechId("polystyrene_sulfonate"))
                .ingot()
                .fluid()
                .color(14777458)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .build();
        //  25005  PEDOT:PSS
        PedotPSS = new Material.Builder(getMaterialsId(), gregtechId("pedot_pss"))
                .ingot()
                .fluid()
                .color(14771623)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(V[UHV], 24, 6, false)
                .build();
        //  25006  PMMA
        PMMA = new Material.Builder(getMaterialsId(), gregtechId("polymethylmethacrylate"))
                .ingot()
                .fluid()
                .color(9554657)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .build();
        //  25007  PEDOT-TMA
        PedotTMA = new Material.Builder(getMaterialsId(), gregtechId("pedot_tma"))
                .ingot()
                .fluid()
                .color(6201057)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING, GENERATE_LONG_ROD)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(V[UEV], 8, 6)
                .build();
        //  25008 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = new Material.Builder(getMaterialsId(), gregtechId("tetramethylammonium_hydroxide"))
                .fluid()
                .color(4259798)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("N(CH3)4OH", true);
        //  25009 Potassium Hydroxide
        PotassiumHydroxide = new Material.Builder(getMaterialsId(), gregtechId("potassium_hydroxide"))
                .dust()
                .fluid()
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .fluidTemp(633)
                .build();
        //  25010 Potassium Bromate
        PotassiumBromate = new Material.Builder(getMaterialsId(), gregtechId("potassium_bromate"))
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();
        //  25011 Malonic Acid
        MalonicAcid = new Material.Builder(getMaterialsId(), gregtechId("malonic_acid"))
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .build();
        //  25012 Chloroacetic Acid
        ChloroaceticAcid = new Material.Builder(getMaterialsId(), gregtechId("chloroacetic_acid"))
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .build();
        //  25013 Trichloroethylene
        Trichloroethylene = new Material.Builder(getMaterialsId(), gregtechId("trichloroethylene"))
                .fluid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .build();
        //  25014 Dichloroethane
        Dichloroethane = new Material.Builder(getMaterialsId(), gregtechId("dichloroethane"))
                .fluid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();
        //  25015 Hydrobromic Acid
        HydrobromicAcid = new Material.Builder(getMaterialsId(), gregtechId("hydrobromic_acid"))
                .fluid(FluidTypes.ACID)
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .build();
        //  25016 Butanediol
        Butanediol = new Material.Builder(getMaterialsId(), gregtechId("butanediol"))
                .fluid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build()
                .setFormula("C4H8(OH)2", true);
        //  25017 Diacetyl
        Diacetyl = new Material.Builder(getMaterialsId(),  gregtechId("diacetyl"))
                .fluid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25018 Ethylene Glycol
        EthyleneGlycol = new Material.Builder(getMaterialsId(), gregtechId("ethylene_glycol"))
                .fluid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C2H4(OH)2", true);
        //  25019 Sulfur Dichloride
        SulfurDichloride = new Material.Builder(getMaterialsId(), gregtechId("sulfur_dichloride"))
                .fluid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();
        //  25020 Acetone Cyanohydrin
        AcetoneCyanohydrin = new Material.Builder(getMaterialsId(), gregtechId("acetone_cyanohydrin"))
                .fluid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build();
        //  25021 Para Xylene
        ParaXylene = new Material.Builder(getMaterialsId(), gregtechId("para_xylene"))
                .fluid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);
        //  25022 Cycloparaphenylene
        Cycloparaphenylene = new Material.Builder(getMaterialsId(), gregtechId("cycloparaphenylene"))
                .fluid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .build();
        //  25023 Dichlorocyclooctadieneplatinium
        Dichlorocyclooctadieneplatinium = new Material.Builder(getMaterialsId(), gregtechId("dichlorocyclooctadieneplatinium"))
                .dust()
                .color(0xD4E982)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 12, Chlorine, 2, Platinum, 1)
                .build()
                .setFormula("C8H12Cl2Pt", true);
        //  25024 Diiodobiphenyl
        Diiodobiphenyl = new Material.Builder(getMaterialsId(), gregtechId("diiodobiphenyl"))
                .dust()
                .color(0x000C52)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 8, Iodine, 2)
                .build()
                .setFormula("C12H8I2", true);
        //  25025 Bipyridine
        Bipyridine = new Material.Builder(getMaterialsId(), gregtechId("bipyridine"))
                .dust()
                .color(0x716449)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C10H8N2", true);
        //  25026 Palladium Bisdibenzylidieneacetone
        PalladiumBisdibenzylidieneacetone = new Material.Builder(getMaterialsId(), gregtechId("palladium_bisdibenzylidieneacetone"))
                .dust()
                .color(0x996881)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 51, Hydrogen, 42, Oxygen, 3, Palladium, 2)
                .build()
                .setFormula("C51H42O3Pd2", true);
        //  25027 1-Octene
        Octene = new Material.Builder(getMaterialsId(), gregtechId("1_octene"))
                .fluid()
                .color(0x818022)
                .components(Carbon, 8, Hydrogen, 16)
                .build();
        //  25028 Acetylene
        Acetylene = new Material.Builder(getMaterialsId(), gregtechId("acetylene"))
                .fluid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();
        //  25029 Cyclooctadiene
        Cyclooctadiene = new Material.Builder(getMaterialsId(), gregtechId("cyclooctadiene"))
                .fluid()
                .color(0x40AC40)
                .components(Carbon, 8, Hydrogen, 12)
                .build();
        //  25030 Pyridine
        Pyridine = new Material.Builder(getMaterialsId(), gregtechId("pyridine"))
                .fluid()
                .color(0x716449)
                .components(Carbon, 10, Hydrogen, 8, Nitrogen, 2)
                .build();
        //  25031 Formaldehyde
        Formaldehyde = new Material.Builder(getMaterialsId(), gregtechId("formaldehyde"))
                .fluid()
                .color(0x858F40)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();
        //  25032 Dibenzylideneacetone
        Dibenzylideneacetone = new Material.Builder(getMaterialsId(), gregtechId("dibenzylideneacetone"))
                .fluid()
                .color(0xA44545)
                .components(Carbon, 17, Hydrogen, 14, Oxygen, 1)
                .build();
        //  25033 Benzaldehyde
        Benzaldehyde = new Material.Builder(getMaterialsId(), gregtechId("benzaldehyde"))
                .fluid()
                .color(0x957D53)
                .components(Carbon, 7, Hydrogen, 6, Oxygen, 1)
                .build();
        //  25034 Benzoyl Chloride
        BenzoylChloride = new Material.Builder(getMaterialsId(), gregtechId("benzoyl_chloride"))
                .fluid()
                .color(0xABE1FF)
                .components(Carbon, 7, Hydrogen, 5, Chlorine, 1, Oxygen, 1)
                .build();
        //  25035 Thionyl Chloride
        ThionylChloride = new Material.Builder(getMaterialsId(), gregtechId("thionyl_chloride"))
                .fluid()
                .color(0xDBC2C2)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build()
                .setFormula("SOCl2", true);
        //  25036 Polyetheretherketone (PEEK)
        Polyetheretherketone = new Material.Builder(getMaterialsId(), gregtechId("polyetheretherketone"))
                .polymer()
                .color(0x45433D)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
                .build();
        //  25037 Difluorobenzophenone
        Difluorobenzophenone = new Material.Builder(getMaterialsId(), gregtechId("difluorobenzophenone"))
                .dust()
                .color(0xC44DA5)
                .iconSet(SHINY)
                .components(Carbon, 13, Hydrogen, 8, Oxygen, 1, Fluorine, 2)
                .build()
                .setFormula("(FC6H4)2CO", true);
        //  25038 Hydroquinone
        Hydroquinone = new Material.Builder(getMaterialsId(), gregtechId("hydroquinone"))
                .fluid()
                .color(0x83251A)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C6H4(OH)2", true);
        //  25039 Resorcinol
        Resorcinol = new Material.Builder(getMaterialsId(), gregtechId("resorcinol"))
                .fluid()
                .color(0x9DA38D)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25040 Fluorobenzene
        Fluorobenzene = new Material.Builder(getMaterialsId(), gregtechId("fluorobenzene"))
                .fluid()
                .color(0x7CCA88)
                .components(Carbon, 6, Hydrogen, 5, Fluorine, 1)
                .build();
        //  25041 Fluorotoluene
        Fluorotoluene = new Material.Builder(getMaterialsId(), gregtechId("fluorotoluene"))
                .fluid()
                .color(0x6EC5B8)
                .components(Carbon, 7, Hydrogen, 7, Fluorine, 1)
                .build();
        //  25042 Kevlar
        Kevlar = new Material.Builder(getMaterialsId(), gregtechId("kevlar"))
                .polymer()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);
        //  25043 Para Phenylenediamine
        ParaPhenylenediamine = new Material.Builder(getMaterialsId(), gregtechId("para_phenylenediamine"))
                .dust()
                .color(0x4A8E7B)
                .iconSet(ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);
        //  25044 Terephthaloyl Chloride
        TerephthaloylChloride = new Material.Builder(getMaterialsId(), gregtechId("terephthaloyl_chloride"))
                .dust()
                .color(0xFAC4DA)
                .iconSet(SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);
        //  25045 N-Methyl Pyrrolidone
        NMethylPyrrolidone = new Material.Builder(getMaterialsId(), gregtechId("n_methyl_pyrrolidone"))
                .fluid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();
        //  25046 Nitroaniline
        Nitroaniline = new Material.Builder(getMaterialsId(), gregtechId("nitroaniline"))
                .fluid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);
        //  25047 Durene
        Durene = new Material.Builder(getMaterialsId(), gregtechId("durene"))
                .dust()
                .color(0x336040)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);
        //  25048 Pyromellitic Dianhydride
        PyromelliticDianhydride = new Material.Builder(getMaterialsId(), gregtechId("pyromellitic_dianhydride"))
                .dust()
                .color(0xF0EAD6)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);
        //  25049 Aminophenol
        Aminophenol = new Material.Builder(getMaterialsId(), gregtechId("aminophenol"))
                .fluid()
                .color(0xFF7F50)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("HOC6H4NH2", true);
        //  25050 Aniline
        Aniline = new Material.Builder(getMaterialsId(), gregtechId("aniline"))
                .fluid()
                .color(0x4C911D)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1)
                .build()
                .setFormula("C6H5NH2", true);
        //  25051 Oxydianiline
        Oxydianiline = new Material.Builder(getMaterialsId(), gregtechId("oxydianiline"))
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25052 Dimethylformamide
        Dimethylformamide = new Material.Builder(getMaterialsId(), gregtechId("dimethylformamide"))
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);
        //  25053 Phthalic Anhydride
        PhthalicAnhydride = new Material.Builder(getMaterialsId(), gregtechId("phthalic_anhydride"))
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);
        //  25054 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(getMaterialsId(), gregtechId("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);
        //  25055 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = new Material.Builder(getMaterialsId(), gregtechId("bistrichloromethylbenzene"))
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);
        //  25056 Tetrabromoethane
        Tetrabromoethane = new Material.Builder(getMaterialsId(), gregtechId("tetrabromoethane"))
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();
        //  25057 Terephthalic Acid
        TerephthalicAcid = new Material.Builder(getMaterialsId(), gregtechId("terephthalic_acid"))
                .dust()
                .color(0x5ACCDA)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);
        //  25058 γ-Butyrolactone
        GammaButyrolactone = new Material.Builder(getMaterialsId(), gregtechId("gamma_butyrolactone"))
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25059 Methylamine
        Methylamine = new Material.Builder(getMaterialsId(), gregtechId("methylamine"))
                .fluid(FluidTypes.GAS)
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);
        //  25060 Trimethylaluminium
        Trimethylaluminium = new Material.Builder(getMaterialsId(), gregtechId("trimethylaluminium"))
                .fluid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);
        //  25061 Trimethylgallium
        Trimethylgallium = new Material.Builder(getMaterialsId(), gregtechId("trimethylgallium"))
                .fluid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);
        //  25062 Benzophenanthrenylacetonitrile
        Benzophenanthrenylacetonitrile = new Material.Builder(getMaterialsId(), gregtechId("benzophenanthrenylacetonitrile"))
                .dust()
                .color(0xBB58E9)
                .iconSet(ROUGH)
                .components(Carbon, 20, Hydrogen, 13, Nitrogen, 1)
                .build();
        //  25063 Methylbenzophenanthrene
        Methylbenzophenanthrene = new Material.Builder(getMaterialsId(), gregtechId("methylbenzophenanthrene"))
                .dust()
                .color(0xEA236B)
                .iconSet(DULL)
                .components(Carbon, 19, Hydrogen, 14)
                .build();
        //  25064 Bromo Succinimide
        BromoSuccinimide = new Material.Builder(getMaterialsId(), gregtechId("bromo_succinimide"))
                .dust()
                .color(0x00BF8C)
                .iconSet(ROUGH)
                .components(Carbon, 4, Hydrogen, 4, Bromine, 1, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25065 Succinimide
        Succinimide = new Material.Builder(getMaterialsId(), gregtechId("succinimide"))
                .dust()
                .color(0x1774B6)
                .iconSet(ROUGH)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25066 Succinic Acid
        SuccinicAcid = new Material.Builder(getMaterialsId(), gregtechId("succinic_acid"))
                .dust()
                .color(0x0C3A5B)
                .iconSet(DULL)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .build();
        //  25067 Maleic Anhydride
        MaleicAnhydride = new Material.Builder(getMaterialsId(), gregtechId("maleic_anhydride"))
                .fluid()
                .color(0x610C2F)
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .build();
        //  25068 Naphthaldehyde
        Naphthaldehyde = new Material.Builder(getMaterialsId(), gregtechId("naphthaldehyde"))
                .fluid()
                .color(0x00FFED)
                .components(Carbon, 11, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("C10H7CHO", true);
        //  25069 Butanol
        Butanol = new Material.Builder(getMaterialsId(), gregtechId("butanol"))
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);
        //  25070 Bromobutane
        Bromobutane = new Material.Builder(getMaterialsId(), gregtechId("bromobutane"))
                .fluid()
                .color(0xAE0E39)
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .build()
                .setFormula("CH3(CH2)3Br", true);
        //  25071 Cyanonaphthalene
        Cyanonaphthalene = new Material.Builder(getMaterialsId(), gregtechId("cyanonaphthalene"))
                .dust()
                .color(0xDE992D)
                .iconSet(DULL)
                .components(Carbon, 11, Hydrogen, 7, Nitrogen, 1)
                .build();
        //  25072 Triphenylphosphine
        Triphenylphosphine = new Material.Builder(getMaterialsId(), gregtechId("triphenylphosphine"))
                .dust()
                .color(0x8F2C6B)
                .iconSet(BRIGHT)
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .build()
                .setFormula("(C6H5)3P", true);
        //  25073 Ethylanthraquinone
        Ethylanthraquinone = new Material.Builder(getMaterialsId(), gregtechId("ethylanthraquinone"))
                .fluid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);
        //  25074 Ethylanthrahydroquinone
        Ethylanthrahydroquinone = new Material.Builder(getMaterialsId(), gregtechId("ethylanthrahydroquinone"))
                .fluid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);
        //  25075 Ethylenediamine
        Ethylenediamine = new Material.Builder(getMaterialsId(), gregtechId("ethylenediamine"))
                .fluid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);
        //  25076 Tetrasodium EDTA
        TetrasodiumEDTA = new Material.Builder(getMaterialsId(), gregtechId("tetrasodium_edta"))
                .dust()
                .color(0x8890E0)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .build();
        //  25077 EthylenediaminetetraaceticAcid
        EthylenediaminetetraaceticAcid = new Material.Builder(getMaterialsId(), gregtechId("ethylenediaminetetraacetic_acid"))
                .dust()
                .fluid()
                .color(0x87E6D9)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();
        //  25078 Tetramethylammonium Chloride
        TetramethylammoniumChloride = new Material.Builder(getMaterialsId(), gregtechId("tetramethylammonium_chloride"))
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .build()
                .setFormula("N(CH3)4Cl", true);
        //  25079 Trimethylamine
        Trimethylamine = new Material.Builder(getMaterialsId(), gregtechId("trimethylamine"))
                .fluid(FluidTypes.GAS)
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3N", true);
        //  25080 Pyrocatechol
        Pyrocatechol = new Material.Builder(getMaterialsId(), gregtechId("pyrocatechol"))
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25081 Nitryl Fluoride
        NitrylFluoride = new Material.Builder(getMaterialsId(), gregtechId("nitryl_fluoride"))
                .fluid()
                .color(0x8B7EFF)
                .components(Nitrogen, 1, Oxygen, 2, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25082 Dimethylamine Hydrochloride
        DimethylamineHydrochloride = new Material.Builder(getMaterialsId(), gregtechId("dimethylamine_hydrochloride"))
                .fluid()
                .color(0xE3EBDC)
                .components(Dimethylamine, 1, HydrochloricAcid, 1)
                .build()
                .setFormula("C2H8NCl", true);
        //  25083 Potassium Formate
        PotassiumFormate = new Material.Builder(getMaterialsId(), gregtechId("potassium_formate"))
                .dust()
                .color(0x74B5A9)
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Potassium, 1)
                .build();
        //  25084 Diethyl Suflide
        DiethylSuflide = new Material.Builder(getMaterialsId(), gregtechId("diethyl_sulfide"))
                .fluid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .build()
                .setFormula("(C2H5)2S", true);
        //  25085 Dimethylcadmium
        Dimethylcadmium = new Material.Builder(getMaterialsId(), gregtechId("dimethylcadmium"))
                .fluid()
                .color(0x5C037F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 6, Cadmium, 1)
                .build()
                .setFormula("(CH3)2Cd", true);
        //  25086 BETS Perrhenate
        BETSPerrhenate = new Material.Builder(getMaterialsId(), gregtechId("bets_perrhenate"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Rhenium, 1, Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4, Oxygen, 4)
                .build();
        //  25087 Bisethylenedithiotetraselenafulvalene
        Bisethylenedithiotetraselenafulvalene = new Material.Builder(getMaterialsId(), gregtechId("bisethylenedithiotetraselenafulvalene"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4)
                .build();
        //  25088 Lithiumthiinediselenide
        Lithiumthiinediselenide = new Material.Builder(getMaterialsId(), gregtechId("lithiumthiinediselenide"))
                .dust()
                .color(0x689E64)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Lithium, 2, Selenium, 2)
                .build();
        //  25089 Cyclopentadienyl Titanium Trichloride
        CyclopentadienylTitaniumTrichloride = new Material.Builder(getMaterialsId(), gregtechId("cyclopentadienyl_titanium_trichloride"))
                .dust()
                .color(0x752C7A)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 10, Chlorine, 2, Titanium, 1)
                .build()
                .setFormula("(C5H5)2Cl2Ti", true);
        //  25090 Propadiene
        Propadiene = new Material.Builder(getMaterialsId(), gregtechId("propadiene"))
                .fluid()
                .color(0xBD8F61)
                .components(Carbon, 3, Hydrogen, 4)
                .build();
        //  25091 Barium Triflate
        BariumTriflate = new Material.Builder(getMaterialsId(), gregtechId("barium_triflate"))
                .dust()
                .color(0xFFC183)
                .iconSet(BRIGHT)
                .components(Barium, 1, Oxygen, 6, Carbon, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ba(OSO2CF3)2", true);
        //  25092 Scandium Triflate
        ScandiumTriflate = new Material.Builder(getMaterialsId(), gregtechId("scandium_triflate"))
                .dust()
                .color(0xCC9999)
                .iconSet(BRIGHT)
                .components(Scandium, 1, Oxygen, 9, Carbon, 3, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Sc(OSO2CF3)3", true);
        //  25093 Barium Triflate Solution
        BariumTriflateSolution = new Material.Builder(getMaterialsId(), gregtechId("barium_triflate_solution"))
                .fluid()
                .color(0xFFC183)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C2BaF6O6S2Hg(H2O)3", true);
        //  25094 Biperfluoromethanedisulfide
        Biperfluoromethanedisulfide = new Material.Builder(getMaterialsId(), gregtechId("biperfluoromethanedisulfide"))
                .fluid()
                .color(0x849648)
                .components(Carbon, 2, Fluorine, 6, Sulfur, 2)
                .build();
        //  25095 Butyl Lithium
        ButylLithium = new Material.Builder(getMaterialsId(), gregtechId("butyl_lithium"))
                .fluid()
                .color(0x96F6DF)
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .build();
        //  25096 Bromodihydrothiine
        Bromodihydrothiine = new Material.Builder(getMaterialsId(), gregtechId("bromodihydrothiine"))
                .fluid()
                .color(0x66F36E)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Bromine, 2)
                .build();
        //  25097 Chloroethane
        Chloroethane = new Material.Builder(getMaterialsId(), gregtechId("chloroethane"))
                .fluid()
                .color(0xA55D80)
                .components(Carbon, 2, Hydrogen, 5, Chlorine, 1)
                .build();
        //  25098 Dibromoacrolein
        Dibromoacrolein = new Material.Builder(getMaterialsId(), gregtechId("dibromoacrolein"))
                .fluid()
                .color(0x7C4660)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 2, Oxygen, 2)
                .build();
        //  25099 Formic Acid
        FormicAcid = new Material.Builder(getMaterialsId(), gregtechId("formic_acid"))
                .fluid()
                .color(0xFFAA77)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 2)
                .build();
        //  25100 Sodium Formate
        SodiumFormate = new Material.Builder(getMaterialsId(), gregtechId("sodium_formate"))
                .fluid()
                .color(0x416CC0)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 1, Oxygen, 2, Sodium, 1)
                .build();
        //  25101 Ethylhexanol
        Ethylhexanol = new Material.Builder(getMaterialsId(), gregtechId("ethylhexanol"))
                .fluid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();
        //  25102 Diethylhexyl Phosphoric Acid
        DiethylhexylPhosphoricAcid = new Material.Builder(getMaterialsId(), gregtechId("diethylhexyl_phosphoric_acid"))
                .fluid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);
        //  25103 Dichloromethane
        Dichloromethane = new Material.Builder(getMaterialsId(), gregtechId("dichloromethane"))
                .fluid()
                .color(0xB87FC7)
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .build();
        //  25104 Tributylamine
        Tributylamine = new Material.Builder(getMaterialsId(), gregtechId("tributylamine"))
                .fluid()
                .color(0x801a80)
                .components(Carbon, 12, Hydrogen, 27, Nitrogen, 1)
                .build()
                .setFormula("(C4H9)3N", true);
        //  25105 Zylon
        Zylon = new Material.Builder(getMaterialsId(), gregtechId("zylon"))
                .polymer()
                .color(0xFFE000)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build();
        //  25106 Pre Zylon
        PreZylon = new Material.Builder(getMaterialsId(), gregtechId("pre_zylon"))
                .dust()
                .color(0x623250)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Carbon, 20, Hydrogen, 22, Nitrogen, 2, Oxygen, 2)
                .build();
        //  25107 Terephthalaldehyde
        Terephthalaldehyde = new Material.Builder(getMaterialsId(), gregtechId("terephthalaldehyde"))
                .dust()
                .color(0x567C2D)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25108 Dibromomethylbenzene
        Dibromomethylbenzene = new Material.Builder(getMaterialsId(), gregtechId("dibromomethylbenzene"))
                .fluid()
                .color(0x9F4839)
                .components(Carbon, 7, Hydrogen, 6, Bromine, 2)
                .build();
        //  25109 Isochloropropane
        Isochloropropane = new Material.Builder(getMaterialsId(), gregtechId("isochloropropane"))
                .fluid()
                .color(0xC3AC65)
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .build()
                .setFormula("CH3CHClCH3", true);
        //  25110 Dinitrodipropanyloxybenzene
        Dinitrodipropanyloxybenzene = new Material.Builder(getMaterialsId(), gregtechId("dinitrodipropanyloxybenzene"))
                .fluid()
                .color(0x9FAD1D)
                .components(Carbon, 12, Hydrogen, 16, Oxygen, 6, Nitrogen, 2)
                .build()
                .setFormula("C12H16O2(NO2)2", true);
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
