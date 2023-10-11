package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;

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
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_PLATE,
                        MaterialFlags.GENERATE_FOIL })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(12),
                        Hydrogen, Integer.valueOf(12),
                        Materials.Nitrogen, Integer.valueOf(2),
                        Oxygen, Integer.valueOf(1) })
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);

        //  25001 Kapton-E
        KaptonE = new Material.Builder(25001, gregtechId("kapton_e"))
                .ingot()
                .fluid()
                .color(16768908)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_PLATE,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_FOIL })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(12),
                        Hydrogen, Integer.valueOf(12),
                        Materials.Nitrogen, Integer.valueOf(2),
                        Oxygen, Integer.valueOf(1) })
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        Edot = new Material.Builder(25002, gregtechId("edot"))
                .fluid()
                .color(11665367)
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(6),
                        Hydrogen, Integer.valueOf(6),
                        Oxygen, Integer.valueOf(2),
                        Materials.Sulfur, Integer.valueOf(1) })
                .build();

        //  25003 Polystyrene
        Polystyrene = new Material.Builder(25003, gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION
                })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(8),
                        Hydrogen, Integer.valueOf(8) })
                .build();

        //  25004 PolystyreneSulfonate
        PolystyreneSulfonate = new Material.Builder(25004, gregtechId("polystyrene_sulfonate"))
                .ingot()
                .fluid()
                .color(14777458)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_PLATE })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(8),
                        Hydrogen, Integer.valueOf(8),
                        Materials.Sulfur, Integer.valueOf(1),
                        Oxygen, Integer.valueOf(3) })
                .build();

        //  25005  PEDOT-PSS
        PedotPSS = new Material.Builder(25005, gregtechId("pedot_pss"))
                .ingot()
                .fluid()
                .color(14771623)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_FINE_WIRE })
                .components(new Object[] {
                        EPMaterials.Edot, Integer.valueOf(1),
                        EPMaterials.PolystyreneSulfonate, Integer.valueOf(1) })
                .cableProperties(GTValues.V[9], 24, 0, true)
                .build();

        //  25006  PMMA
        PMMA = new Material.Builder(25006, gregtechId("polymethylmethacrylate"))
                .ingot()
                .fluid()
                .color(9554657)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_PLATE })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(5),
                        Hydrogen, Integer.valueOf(8),
                        Oxygen, Integer.valueOf(2) })
                .build();

        //  25007  PEDOT-TMA
        PedotTMA = new Material.Builder(25007, gregtechId("pedot_tma"))
                .ingot()
                .fluid()
                .color(6201057)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_ROD,
                        MaterialFlags.GENERATE_SPRING })
                .components(new Object[] {
                        EPMaterials.Edot, Integer.valueOf(1),
                        EPMaterials.PMMA, Integer.valueOf(2) })
                .cableProperties(GTValues.V[10], 8, 6)
                .build();
        //  25008 Tetramethylammonium Hydroxide
        TetramethylammoniumHydroxide = new Material.Builder(25008, gregtechId("tetramethylammonium_hydroxide"))
                .fluid()
                .color(4259798)
                .flags(new MaterialFlag[] {
                        DISABLE_DECOMPOSITION
                })
                .components(new Object[] {
                        Materials.Nitrogen, Integer.valueOf(1),
                        Materials.Carbon, Integer.valueOf(4),
                        Hydrogen, Integer.valueOf(12),
                        Oxygen, Integer.valueOf(1),
                        Hydrogen, Integer.valueOf(1) })
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
    }
}
