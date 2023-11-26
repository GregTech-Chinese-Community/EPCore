package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

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
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING, GENERATE_LONG_ROD, GENERATE_FINE_WIRE)
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
        //  25049 Oxydianiline
        Oxydianiline = new Material.Builder(getMaterialsId(), gregtechId("oxydianiline"))
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25050 Dimethylformamide
        Dimethylformamide = new Material.Builder(getMaterialsId(), gregtechId("dimethylformamide"))
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);
        //  25051 Phthalic Anhydride
        PhthalicAnhydride = new Material.Builder(getMaterialsId(), gregtechId("phthalic_anhydride"))
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);
        //  25052 Biphenyl Tetracarboxylic Acid Dianhydride
        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(getMaterialsId(), gregtechId("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);
        //  25053 Bistrichloromethylbenzene
        Bistrichloromethylbenzene = new Material.Builder(getMaterialsId(), gregtechId("bistrichloromethylbenzene"))
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);
        //  25054 Tetrabromoethane
        Tetrabromoethane = new Material.Builder(getMaterialsId(), gregtechId("tetrabromoethane"))
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();
        //  25055 Terephthalic Acid
        TerephthalicAcid = new Material.Builder(getMaterialsId(), gregtechId("terephthalic_acid"))
                .dust()
                .color(0x5ACCDA)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);
        //  25056 γ-Butyrolactone
        GammaButyrolactone = new Material.Builder(getMaterialsId(), gregtechId("gamma_butyrolactone"))
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25057 Methylamine
        Methylamine = new Material.Builder(getMaterialsId(), gregtechId("methylamine"))
                .fluid(FluidTypes.GAS)
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);
        //  25058 Trimethylaluminium
        Trimethylaluminium = new Material.Builder(getMaterialsId(), gregtechId("trimethylaluminium"))
                .fluid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);
        //  25059 Trimethylgallium
        Trimethylgallium = new Material.Builder(getMaterialsId(), gregtechId("trimethylgallium"))
                .fluid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);
        //  25060 Benzophenanthrenylacetonitrile
        Benzophenanthrenylacetonitrile = new Material.Builder(getMaterialsId(), gregtechId("benzophenanthrenylacetonitrile"))
                .dust()
                .color(0xBB58E9)
                .iconSet(ROUGH)
                .components(Carbon, 20, Hydrogen, 13, Nitrogen, 1)
                .build();
        //  25061 Methylbenzophenanthrene
        Methylbenzophenanthrene = new Material.Builder(getMaterialsId(), gregtechId("methylbenzophenanthrene"))
                .dust()
                .color(0xEA236B)
                .iconSet(DULL)
                .components(Carbon, 19, Hydrogen, 14)
                .build();
        //  25062 Bromo Succinimide
        BromoSuccinimide = new Material.Builder(getMaterialsId(), gregtechId("bromo_succinimide"))
                .dust()
                .color(0x00BF8C)
                .iconSet(ROUGH)
                .components(Carbon, 4, Hydrogen, 4, Bromine, 1, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25063 Succinimide
        Succinimide = new Material.Builder(getMaterialsId(), gregtechId("succinimide"))
                .dust()
                .color(0x1774B6)
                .iconSet(ROUGH)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 2)
                .build();
        //  25064 Succinic Acid
        SuccinicAcid = new Material.Builder(getMaterialsId(), gregtechId("succinic_acid"))
                .dust()
                .color(0x0C3A5B)
                .iconSet(DULL)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .build();
        //  25065 Maleic Anhydride
        MaleicAnhydride = new Material.Builder(getMaterialsId(), gregtechId("maleic_anhydride"))
                .fluid()
                .color(0x610C2F)
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .build();
        //  25066 Naphthaldehyde
        Naphthaldehyde = new Material.Builder(getMaterialsId(), gregtechId("naphthaldehyde"))
                .fluid()
                .color(0x00FFED)
                .components(Carbon, 11, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("C10H7CHO", true);
        //  25067 Butanol
        Butanol = new Material.Builder(getMaterialsId(), gregtechId("butanol"))
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);
        //  25068 Bromobutane
        Bromobutane = new Material.Builder(getMaterialsId(), gregtechId("bromobutane"))
                .fluid()
                .color(0xAE0E39)
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .build()
                .setFormula("CH3(CH2)3Br", true);
        //  25069 Cyanonaphthalene
        Cyanonaphthalene = new Material.Builder(getMaterialsId(), gregtechId("cyanonaphthalene"))
                .dust()
                .color(0xDE992D)
                .iconSet(DULL)
                .components(Carbon, 11, Hydrogen, 7, Nitrogen, 1)
                .build();
        //  25070 Triphenylphosphine
        Triphenylphosphine = new Material.Builder(getMaterialsId(), gregtechId("triphenylphosphine"))
                .dust()
                .color(0x8F2C6B)
                .iconSet(BRIGHT)
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .build()
                .setFormula("(C6H5)3P", true);
        //  25071 Ethylanthraquinone
        Ethylanthraquinone = new Material.Builder(getMaterialsId(), gregtechId("ethylanthraquinone"))
                .fluid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);
        //  25072 Ethylanthrahydroquinone
        Ethylanthrahydroquinone = new Material.Builder(getMaterialsId(), gregtechId("ethylanthrahydroquinone"))
                .fluid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);
        //  25073 Ethylenediamine
        Ethylenediamine = new Material.Builder(getMaterialsId(), gregtechId("ethylenediamine"))
                .fluid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);
        //  25074 Tetrasodium EDTA
        TetrasodiumEDTA = new Material.Builder(getMaterialsId(), gregtechId("tetrasodium_edta"))
                .dust()
                .color(0x8890E0)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .build();
        //  25075 EthylenediaminetetraaceticAcid
        EthylenediaminetetraaceticAcid = new Material.Builder(getMaterialsId(), gregtechId("ethylenediaminetetraacetic_acid"))
                .dust()
                .fluid()
                .color(0x87E6D9)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();
        //  25076 Tetramethylammonium Chloride
        TetramethylammoniumChloride = new Material.Builder(getMaterialsId(), gregtechId("tetramethylammonium_chloride"))
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .build()
                .setFormula("N(CH3)4Cl", true);
        //  25077 Trimethylamine
        Trimethylamine = new Material.Builder(getMaterialsId(), gregtechId("trimethylamine"))
                .fluid(FluidTypes.GAS)
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3N", true);
        //  25078 Pyrocatechol
        Pyrocatechol = new Material.Builder(getMaterialsId(), gregtechId("pyrocatechol"))
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25079 Nitryl Fluoride
        NitrylFluoride = new Material.Builder(getMaterialsId(), gregtechId("nitryl_fluoride"))
                .fluid()
                .color(0x8B7EFF)
                .components(Nitrogen, 1, Oxygen, 2, Fluorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25080 Dimethylamine Hydrochloride
        DimethylamineHydrochloride = new Material.Builder(getMaterialsId(), gregtechId("dimethylamine_hydrochloride"))
                .fluid()
                .color(0xE3EBDC)
                .components(Dimethylamine, 1, HydrochloricAcid, 1)
                .build()
                .setFormula("C2H8NCl", true);
        //  25081 Potassium Formate
        PotassiumFormate = new Material.Builder(getMaterialsId(), gregtechId("potassium_formate"))
                .dust()
                .color(0x74B5A9)
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Potassium, 1)
                .build();
        //  25082 Diethyl Suflide
        DiethylSuflide = new Material.Builder(getMaterialsId(), gregtechId("diethyl_sulfide"))
                .fluid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .build()
                .setFormula("(C2H5)2S", true);
        //  25083 Dimethylcadmium
        Dimethylcadmium = new Material.Builder(getMaterialsId(), gregtechId("dimethylcadmium"))
                .fluid()
                .color(0x5C037F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 6, Cadmium, 1)
                .build()
                .setFormula("(CH3)2Cd", true);
        //  25084 BETS Perrhenate
        BETSPerrhenate = new Material.Builder(getMaterialsId(), gregtechId("bets_perrhenate"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SHINY)
                .components(Rhenium, 1, Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4, Oxygen, 4)
                .build();
        //  25085 Bisethylenedithiotetraselenafulvalene
        Bisethylenedithiotetraselenafulvalene = new Material.Builder(getMaterialsId(), gregtechId("bisethylenedithiotetraselenafulvalene"))
                .dust()
                .color(0x98E993)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Carbon, 10, Hydrogen, 8, Sulfur, 4, Selenium, 4)
                .build();
        //  25086 Lithiumthiinediselenide
        Lithiumthiinediselenide = new Material.Builder(getMaterialsId(), gregtechId("lithiumthiinediselenide"))
                .dust()
                .color(0x689E64)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Lithium, 2, Selenium, 2)
                .build();
        //  25087 Cyclopentadienyl Titanium Trichloride
        CyclopentadienylTitaniumTrichloride = new Material.Builder(getMaterialsId(), gregtechId("cyclopentadienyl_titanium_trichloride"))
                .dust()
                .color(0x752C7A)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 10, Chlorine, 2, Titanium, 1)
                .build()
                .setFormula("(C5H5)2Cl2Ti", true);
        //  25088 Propadiene
        Propadiene = new Material.Builder(getMaterialsId(), gregtechId("propadiene"))
                .fluid()
                .color(0xBD8F61)
                .components(Carbon, 3, Hydrogen, 4)
                .build();
        //  25089 Barium Triflate
        BariumTriflate = new Material.Builder(getMaterialsId(), gregtechId("barium_triflate"))
                .dust()
                .color(0xFFC183)
                .iconSet(BRIGHT)
                .components(Barium, 1, Oxygen, 6, Carbon, 2, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ba(OSO2CF3)2", true);
        //  25090 Scandium Triflate
        ScandiumTriflate = new Material.Builder(getMaterialsId(), gregtechId("scandium_triflate"))
                .dust()
                .color(0xCC9999)
                .iconSet(BRIGHT)
                .components(Scandium, 1, Oxygen, 9, Carbon, 3, Fluorine, 9)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Sc(OSO2CF3)3", true);
        //  25091 Barium Triflate Solution
        BariumTriflateSolution = new Material.Builder(getMaterialsId(), gregtechId("barium_triflate_solution"))
                .fluid()
                .color(0xFFC183)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C2BaF6O6S2Hg(H2O)3", true);
        //  25092 Biperfluoromethanedisulfide
        Biperfluoromethanedisulfide = new Material.Builder(getMaterialsId(), gregtechId("biperfluoromethanedisulfide"))
                .fluid()
                .color(0x849648)
                .components(Carbon, 2, Fluorine, 6, Sulfur, 2)
                .build();
        //  25093 Butyl Lithium
        ButylLithium = new Material.Builder(getMaterialsId(), gregtechId("butyl_lithium"))
                .fluid()
                .color(0x96F6DF)
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .build();
        //  25094 Bromodihydrothiine
        Bromodihydrothiine = new Material.Builder(getMaterialsId(), gregtechId("bromodihydrothiine"))
                .fluid()
                .color(0x66F36E)
                .components(Carbon, 4, Hydrogen, 4, Sulfur, 2, Bromine, 2)
                .build();
        //  25095 Chloroethane
        Chloroethane = new Material.Builder(getMaterialsId(), gregtechId("chloroethane"))
                .fluid()
                .color(0xA55D80)
                .components(Carbon, 2, Hydrogen, 5, Chlorine, 1)
                .build();
        //  25096 Dibromoacrolein
        Dibromoacrolein = new Material.Builder(getMaterialsId(), gregtechId("dibromoacrolein"))
                .fluid()
                .color(0x7C4660)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 2, Oxygen, 2)
                .build();
        //  25097 Formic Acid
        FormicAcid = new Material.Builder(getMaterialsId(), gregtechId("formic_acid"))
                .fluid()
                .color(0xFFAA77)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 2)
                .build();
        //  25098 Sodium Formate
        SodiumFormate = new Material.Builder(getMaterialsId(), gregtechId("sodium_formate"))
                .fluid()
                .color(0x416CC0)
                .iconSet(ROUGH)
                .components(Carbon, 1, Hydrogen, 1, Oxygen, 2, Sodium, 1)
                .build();
        //  25099 Ethylhexanol
        Ethylhexanol = new Material.Builder(getMaterialsId(), gregtechId("ethylhexanol"))
                .fluid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();
        //  25100 Diethylhexyl Phosphoric Acid
        DiethylhexylPhosphoricAcid = new Material.Builder(getMaterialsId(), gregtechId("diethylhexyl_phosphoric_acid"))
                .fluid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);
        //  25101 Dichloromethane
        Dichloromethane = new Material.Builder(getMaterialsId(), gregtechId("dichloromethane"))
                .fluid()
                .color(0xB87FC7)
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .build();
        //  25102 Tributylamine
        Tributylamine = new Material.Builder(getMaterialsId(), gregtechId("tributylamine"))
                .fluid()
                .color(0x801a80)
                .components(Carbon, 12, Hydrogen, 27, Nitrogen, 1)
                .build()
                .setFormula("(C4H9)3N", true);
        //  25103 Zylon
        Zylon = new Material.Builder(getMaterialsId(), gregtechId("zylon"))
                .polymer()
                .color(0xFFE000)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build();
        //  25104 Pre Zylon
        PreZylon = new Material.Builder(getMaterialsId(), gregtechId("pre_zylon"))
                .dust()
                .color(0x623250)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Carbon, 20, Hydrogen, 22, Nitrogen, 2, Oxygen, 2)
                .build();
        //  25105 Terephthalaldehyde
        Terephthalaldehyde = new Material.Builder(getMaterialsId(), gregtechId("terephthalaldehyde"))
                .dust()
                .color(0x567C2D)
                .iconSet(ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25106 Dibromomethylbenzene
        Dibromomethylbenzene = new Material.Builder(getMaterialsId(), gregtechId("dibromomethylbenzene"))
                .fluid()
                .color(0x9F4839)
                .components(Carbon, 7, Hydrogen, 6, Bromine, 2)
                .build();
        //  25107 Isochloropropane
        Isochloropropane = new Material.Builder(getMaterialsId(), gregtechId("isochloropropane"))
                .fluid()
                .color(0xC3AC65)
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .build()
                .setFormula("CH3CHClCH3", true);
        //  25108 Dinitrodipropanyloxybenzene
        Dinitrodipropanyloxybenzene = new Material.Builder(getMaterialsId(), gregtechId("dinitrodipropanyloxybenzene"))
                .fluid()
                .color(0x9FAD1D)
                .components(Carbon, 12, Hydrogen, 16, Oxygen, 6, Nitrogen, 2)
                .build()
                .setFormula("C12H16O2(NO2)2", true);
        //  25109 Hexanitrohexaaxaisowurtzitane
        Hexanitrohexaaxaisowurtzitane = new Material.Builder(getMaterialsId(), gregtechId("hexanitrohexaaxaisowurtzitane"))
                .dust()
                .color(0x0B7222)
                .iconSet(BRIGHT)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .build();
        //  25110 Crude Hexanitrohexaaxaisowurtzitane
        CrudeHexanitrohexaaxaisowurtzitane = new Material.Builder(getMaterialsId(), gregtechId("crude_hexanitrohexaaxaisowurtzitane"))
                .dust()
                .color(0x5799EC)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 12, Oxygen, 12)
                .build();
        //  25111 Tetraacetyldinitrosohexaazaisowurtzitane
        Tetraacetyldinitrosohexaazaisowurtzitane = new Material.Builder(getMaterialsId(), gregtechId("tetraacetyldinitrosohexaazaisowurtzitane"))
                .dust()
                .color(0xEA7584)
                .iconSet(ROUGH)
                .components(Carbon, 14, Hydrogen, 18, Nitrogen, 8, Oxygen, 6)
                .build();
        //  25112 Dibenzyltetraacetylhexaazaisowurtzitane
        Dibenzyltetraacetylhexaazaisowurtzitane = new Material.Builder(getMaterialsId(), gregtechId("dibenzyltetraacetylhexaazaisowurtzitane"))
                .dust()
                .color(0xB7E8EE)
                .iconSet(DULL)
                .components(Carbon, 28, Hydrogen, 32, Nitrogen, 6, Oxygen, 4)
                .build();
        //  25113 Succinimidyl Acetate
        SuccinimidylAcetate = new Material.Builder(getMaterialsId(), gregtechId("succinimidyl_acetate"))
                .dust()
                .color(0x1D3605)
                .iconSet(ROUGH)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 4)
                .build();
        //  25114 N-Hydroxysuccinimide
        NHydroxysuccinimide = new Material.Builder(getMaterialsId(), gregtechId("n_hydroxysuccinimide"))
                .dust()
                .color(0x33BAFB)
                .iconSet(DULL)
                .components(Carbon, 4, Hydrogen, 5, Nitrogen, 1, Oxygen, 3)
                .build()
                .setFormula("(CH2CO)2NOH", true);
        //  25115 Tetrahydrofuran
        Tetrahydrofuran = new Material.Builder(getMaterialsId(), gregtechId("tetrahydrofuran"))
                .fluid()
                .color(0x0BCF52)
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("(CH2)4O", true);
        //  25116 Succinic Anhydride
        SuccinicAnhydride = new Material.Builder(getMaterialsId(), gregtechId("succinic_anhydride"))
                .dust()
                .color(0xA2569D)
                .components(Carbon, 4, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("(CH2CO)2O");
        //  25117 Hexabenzylhexaazaisowurtzitane
        Hexabenzylhexaazaisowurtzitane = new Material.Builder(getMaterialsId(), gregtechId("hexabenzylhexaazaisowurtzitane"))
                .dust()
                .color(0x48561E)
                .iconSet(DULL)
                .components(Carbon, 48, Hydrogen, 48 ,Nitrogen, 6)
                .build();
        //  25118 Acetonitrile
        Acetonitrile = new Material.Builder(getMaterialsId(), gregtechId("acetonitrile"))
                .dust()
                .color(0x7D82A3)
                .iconSet(ROUGH)
                .components(Carbon, 2, Hydrogen, 3, Nitrogen, 1)
                .build()
                .setFormula("CH3CN");
        //  25119 Acetamide
        Acetamide = new Material.Builder(getMaterialsId(), gregtechId("acetamide"))
                .dust()
                .color(0x7D82A3)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("CH3CONH2", true);
        //  25120 Benzylamine
        Benzylamine = new Material.Builder(getMaterialsId(), gregtechId("benzylamine"))
                .fluid()
                .color(0x527A92)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .build();
        //  25121 Benzyl Chloride
        BenzylChloride = new Material.Builder(getMaterialsId(), gregtechId("benzyl_chloride"))
                .fluid()
                .color(0x6699CC)
                .components(Carbon, 7, Hydrogen, 7, Chlorine, 1)
                .build();
        //  25122 Hexamethylenetetramine
        Hexamethylenetetramine = new Material.Builder(getMaterialsId(), gregtechId("hexamethylenetetramine"))
                .dust()
                .color(0x53576D)
                .iconSet(DULL)
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 4)
                .build()
                .setFormula("(CH2)6N4", true);
        //  25123 Dimethyl Carbonate
        DimethylCarbonate = new Material.Builder(getMaterialsId(), gregtechId("dimethyl_carbonate"))
                .fluid()
                .color(0xC5EB9E)
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3O)2CO", true);
        //  25124 Diphenyl Carbonate
        DiphenylCarbonate = new Material.Builder(getMaterialsId(), gregtechId("diphenyl_carbonate"))
                .fluid()
                .color(DimethylCarbonate.getMaterialRGB() + Benzene.getMaterialRGB())
                .components(Carbon, 13, Hydrogen, 10, Oxygen, 3)
                .build();
        //  25125 BPA Polycarbonate
        BPAPolycarbonate = new Material.Builder(getMaterialsId(), gregtechId("bpa_polycarbonate"))
                .ingot()
                .fluid()
                .color(0xE3EBDA)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .build();
        //  25126 Isobutyric Acid
        IsobutyricAcid = new Material.Builder(getMaterialsId(), gregtechId("isobutyric_acid"))
                .fluid()
                .color(Propene.getMaterialRGB() + Propadiene.getMaterialRGB())
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .build();
        //  25127 Isobutyric Anhydride
        IsobutyricAnhydride = new Material.Builder(getMaterialsId(), gregtechId("isobutyric_anhydride"))
                .fluid()
                .color(IsobutyricAcid.getMaterialRGB() - AceticAnhydride.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 3)
                .build();
        //  25128 Dimethylketene
        Dimethylketene = new Material.Builder(getMaterialsId(), gregtechId("dimethylketene"))
                .fluid()
                .color(0x0925BE)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();
        //  25129 Tetramethylcyclobutanediol
        Tetramethylcyclobutanediol = new Material.Builder(getMaterialsId(), gregtechId("tetramethylcyclobutanediol"))
                .fluid()
                .color(Dimethylketene.getMaterialRGB() + Hydrogen.getMaterialRGB())
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .build();
        //  25130 CBDO Polycarbonate
        CBDOPolycarbonate = new Material.Builder(getMaterialsId(), gregtechId("cbdo_polycarbonate"))
                .ingot()
                .fluid()
                .color(0xDFDFDF)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 9, Hydrogen, 14, Oxygen, 3)
                .build();
        //  25131 Nitrile Butadiene Rubber
        NitrileButadieneRubber = new Material.Builder(getMaterialsId(), gregtechId("nitrile_butadiene_rubber"))
                .polymer()
                .color(0x211A18)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1)
                .fluidTemp(433)
                .build();
        //  25132 Poly (Phosphonitrile Fluoro) Rubber
        PolyPhosphonitrileFluoroRubber = new Material.Builder(getMaterialsId(), gregtechId("poly_phosphonitrile_fluoro_rubber"))
                .polymer()
                .color(0x372B28)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_RING)
                .components(Carbon, 24, Hydrogen, 16, Oxygen, 8, Nitrogen, 4, Phosphorus, 4, Fluorine, 40)
                .build();
        //  25133 Acrylonitrile
        Acrylonitrile = new Material.Builder(getMaterialsId(), gregtechId("acrylonitrile"))
                .fluid()
                .color(Propene.getMaterialRGB())
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .build();
        //  25134 Phosphonitrilic Chloride Trimer
        PhosphonitrilicChlorideTrimer = new Material.Builder(getMaterialsId(), gregtechId("phosphonitrilic_chloride_trimer"))
                .fluid()
                .color(0x082C38)
                .components(Chlorine, 6, Nitrogen, 3, Phosphorus, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25135 Sodium Trifluoroethanolate
        SodiumTrifluoroethanolate = new Material.Builder(getMaterialsId(), gregtechId("sodium_trifluoroethanolate"))
                .dust()
                .color(0x50083E)
                .iconSet(ROUGH)
                .components(Carbon, 2, Hydrogen, 4, Fluorine, 3, Sodium, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25136 Octafluoro Pentanol
        OctafluoroPentanol = new Material.Builder(getMaterialsId(), gregtechId("octafluoro_pentanol"))
                .fluid()
                .color(0xE5EBDE)
                .components(Carbon, 5, Hydrogen, 4, Fluorine, 8, Oxygen, 1)
                .build();
        //  25137 Tributyl Phosphate
        TributylPhosphate = new Material.Builder(getMaterialsId(), gregtechId("tributyl_phosphate"))
                .fluid()
                .color(0xBED323)
                .components(Carbon, 12, Hydrogen, 27, Phosphorus, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C4H9)3PO4", true);
        //  25138 Methyl Isobutyl Ketone
        MethylIsobutylKetone = new Material.Builder(getMaterialsId(), gregtechId("methyl_isobutyl_ketone"))
                .fluid()
                .color(0x2F5687)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 1)
                .build();
        //  25139 tbp_mibk_solution
        TBPMIBKSolution = new Material.Builder(getMaterialsId(), gregtechId("tbp_mibk_solution"))
                .fluid()
                .color(TributylPhosphate.getMaterialRGB() + MethylIsobutylKetone.getMaterialRGB())
                .components(TributylPhosphate, 1, MethylIsobutylKetone, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25140 Mesityl Oxide
        MesitylOxide = new Material.Builder(getMaterialsId(), gregtechId("mesityl_oxide"))
                .fluid()
                .color(0x783E50)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 1)
                .build();
        //  25141 Electrolyte Reflector Mixture
        ElectrolyteReflectorMixture = new Material.Builder(getMaterialsId(), gregtechId("electrolyte_reflector_mixture"))
                .fluid()
                .fluidTemp(209)
                .color(0xE62A35)
                .components(ManganeseDifluoride, 1, ZincSulfide, 1, TantalumPentoxide, 1, Rutile, 1, Ethanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25142 Ethylene Dibromide
        EthyleneDibromide = new Material.Builder(getMaterialsId(), gregtechId("ethylene_dibromide"))
                .fluid()
                .color(0x4F1743)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Bromine, 2)
                .build();
        //  25143 Grignard Reagent
        GrignardReagent = new Material.Builder(getMaterialsId(), gregtechId("grignard_reagent"))
                .fluid()
                .color(0xA12AA1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 3, Magnesium, 1, Bromine, 1)
                .build();
        //  25144 Fluorocarborane
        Fluorocarborane = new Material.Builder(getMaterialsId(), gregtechId("fluorocarborane"))
                .dust()
                .color(0x59B35C)
                .iconSet(BRIGHT)
                .components(Carbon, 1, Hydrogen, 2, Boron, 11, Fluorine, 11)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("HCHB11F11", true);
        //  25145 Perfluorobenzene
        Perfluorobenzene = new Material.Builder(getMaterialsId(), gregtechId("perfluorobenzene"))
                .fluid()
                .color(0x39733B)
                .components(Carbon, 6, Fluorine, 6)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25146 Trimethylsilane
        Trimethylsilane = new Material.Builder(getMaterialsId(), gregtechId("trimethylsilane"))
                .fluid()
                .color(0xB366B0)
                .components(Carbon, 3, Hydrogen, 10, Silicon, 1)
                .build();
        //  25147 Trimethylchlorosilane
        Trimethylchlorosilane = new Material.Builder(getMaterialsId(), gregtechId("trimethylchlorosilane"))
                .fluid()
                .color(0x864D84)
                .components(Carbon, 9, Hydrogen, 9, Silicon, 1, Chlorine, 1)
                .build()
                .setFormula("(CH3)3SiCl", true);
        //  25148 Caesium Carborane Precursor
        CaesiumCarboranePrecursor = new Material.Builder(getMaterialsId(), gregtechId("caesium_carborane_precursor"))
                .dust()
                .color(CaesiumCarborane.getMaterialRGB())
                .iconSet(SAND)
                .components(Caesium, 1, Boron, 10, Hydrogen, 21, Carbon, 4, Nitrogen, 1, Chlorine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("CsB10H12CN(CH3)3Cl", true);
        //  25149 Borane Dimethylsulfide
        BoraneDimethylsulfide = new Material.Builder(getMaterialsId(), gregtechId("borane_dimethylsulfide"))
                .fluid()
                .color(Lead.getMaterialRGB() + Boron.getMaterialRGB())
                .components(Caesium, 1, Carbon, 1, Boron, 11, Hydrogen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25150 Decaborane
        Decaborane = new Material.Builder(getMaterialsId(), gregtechId("decaborane"))
                .dust()
                .color(0x4C994F)
                .iconSet(ROUGH)
                .components(Boron, 10, Hydrogen, 14)
                .flags(DISABLE_DECOMPOSITION)
                .build();
        //  25151 Diethyl Ether
        DiethylEther = new Material.Builder(getMaterialsId(), gregtechId("diethyl_ether"))
                .fluid()
                .color(0xFFA4A3)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(C2H5)2O", true);
        //  25152 Boron Trifluoride Etherate
        BoronTrifluorideEtherate = new Material.Builder(getMaterialsId(), gregtechId("boron_trifluoride_etherate"))
                .fluid()
                .color(0xBF6E6E)
                .components(Boron, 1, Fluorine, 3, Carbon, 4, Hydrogen, 7, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(BF3)(C2H5)2O", true);
        //  25153 Dimethyl Sulfide
        DimethylSulfide = new Material.Builder(getMaterialsId(), gregtechId("dimethyl_sulfide"))
                .fluid()
                .color(SulfuricAcid.getMaterialRGB() + Methanol.getMaterialRGB())
                .components(Carbon, 2, Hydrogen, 6, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(CH3)2S", true);
        //  25154 Oxalic Acid
        OxalicAcid = new Material.Builder(getMaterialsId(), gregtechId("oxalic_acid"))
                .fluid()
                .color(0xC5EB9E)
                .components(Carbon, 2, Hydrogen, 2, Oxygen, 4)
                .build()
                .setFormula("HOOCCOOH", false);
        //  25155 Glucose
        Glucose = new Material.Builder(getMaterialsId(), gregtechId("glucose"))
                .dust()
                .color(0xE3E3E3)
                .iconSet(SAND)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 6)
                .build();
        //  25156 Fructose
        Fructose = new Material.Builder(getMaterialsId(), gregtechId("fructose"))
                .dust()
                .color(0xE3E3E3)
                .iconSet(SAND)
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 6)
                .build();
        //  25157 Hexafluoropropylene
        Hexafluoropropylene = new Material.Builder(getMaterialsId(), gregtechId("hexafluoropropylene"))
                .fluid()
                .color(0x141D6F)
                .components(Carbon, 3, Fluorine, 6)
                .build();
        //  25158 Fluorinated Ethylene Propylene
        FluorinatedEthylenePropylene = new Material.Builder(getMaterialsId(), gregtechId("fluorinated_ethylene_propylene"))
                .polymer()
                .color(0xC8C8C8)
                .iconSet(DULL)
                .components(Carbon, 5, Fluorine, 10)
                .build();
        //  25159 Polycyclic Aromatic Mixture
        PolycyclicAromaticMixture = new Material.Builder(getMaterialsId(), gregtechId("polycyclic_aromatic_mixture"))
                .dust()
                .color(0x95A36C)
                .iconSet(ROUGH)
                .components(Carbon, 18, Hydrogen, 12)
                .build();
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
