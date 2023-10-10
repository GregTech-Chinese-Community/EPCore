package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;

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
                        MaterialFlags.DISABLE_DECOMPOSITION,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_PLATE,
                        MaterialFlags.GENERATE_FOIL })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(12),
                        Materials.Hydrogen, Integer.valueOf(12),
                        Materials.Nitrogen, Integer.valueOf(2),
                        Materials.Oxygen, Integer.valueOf(1) })
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);

        //  25001 Kapton-E
        KaptonE = new Material.Builder(25001, gregtechId("kapton_e"))
                .ingot()
                .fluid()
                .color(16768908)
                .flags(new MaterialFlag[] {
                        MaterialFlags.DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_PLATE,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_FOIL })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(12),
                        Materials.Hydrogen, Integer.valueOf(12),
                        Materials.Nitrogen, Integer.valueOf(2),
                        Materials.Oxygen, Integer.valueOf(1) })
                .build()
                .setFormula("O(C6H4NH2)2", true);
        //  25002  EDOT
        Edot = new Material.Builder(25002, gregtechId("edot"))
                .fluid()
                .color(11665367)
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(6),
                        Materials.Hydrogen, Integer.valueOf(6),
                        Materials.Oxygen, Integer.valueOf(2),
                        Materials.Sulfur, Integer.valueOf(1) })
                .build();

        //  25003 Polystyrene
        Polystyrene = new Material.Builder(25003, gregtechId("polystyrene"))
                .fluid()
                .color(14795458)
                .flags(new MaterialFlag[] {
                        MaterialFlags.DISABLE_DECOMPOSITION
                })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(8),
                        Materials.Hydrogen, Integer.valueOf(8) })
                .build();

        //  25004 PolystyreneSulfonate
        PolystyreneSulfonate = new Material.Builder(25004, gregtechId("polystyrene_sulfonate"))
                .ingot()
                .fluid()
                .color(14777458)
                .flags(new MaterialFlag[] {
                        MaterialFlags.DISABLE_DECOMPOSITION,
                        MaterialFlags.GENERATE_PLATE })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(8),
                        Materials.Hydrogen, Integer.valueOf(8),
                        Materials.Sulfur, Integer.valueOf(1),
                        Materials.Oxygen, Integer.valueOf(3) })
                .build();

        //  25005  PEDOT-PSS
        PedotPSS = new Material.Builder(25005, gregtechId("pedot_pss"))
                .ingot()
                .fluid()
                .color(14771623)
                .flags(new MaterialFlag[] {
                        MaterialFlags.DISABLE_DECOMPOSITION,
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
                        MaterialFlags.DISABLE_DECOMPOSITION,
                        MaterialFlags.NO_SMASHING,
                        MaterialFlags.NO_SMELTING,
                        MaterialFlags.GENERATE_PLATE })
                .components(new Object[] {
                        Materials.Carbon, Integer.valueOf(5),
                        Materials.Hydrogen, Integer.valueOf(8),
                        Materials.Oxygen, Integer.valueOf(2) })
                .build();

        //  25007  PEDOT-TMA
        PedotTMA = new Material.Builder(25007, gregtechId("pedot_tma"))
                .ingot()
                .fluid()
                .color(6201057)
                .flags(new MaterialFlag[] {
                        MaterialFlags.DISABLE_DECOMPOSITION,
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
                        MaterialFlags.DISABLE_DECOMPOSITION
                })
                .components(new Object[] {
                        Materials.Nitrogen, Integer.valueOf(1),
                        Materials.Carbon, Integer.valueOf(4),
                        Materials.Hydrogen, Integer.valueOf(12),
                        Materials.Oxygen, Integer.valueOf(1),
                        Materials.Hydrogen, Integer.valueOf(1) })
                .build()
                .setFormula("N(CH3)4OH", true);
    }
}
