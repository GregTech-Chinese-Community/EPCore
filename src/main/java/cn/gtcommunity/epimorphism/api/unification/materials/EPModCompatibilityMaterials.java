package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPModCompatibilityMaterials {
    //Range: 27001 - 27200
    private static int startId = 27001;
    private static final int END_ID = startId + 200;
    public static void init() {
        // 27000 Mana
        Mana = new Material.Builder(getMaterialsId(), gregtechId("mana"))
                .fluid(FluidTypes.GAS, false)
                .color(0x00BFFF).fluidTemp(0)
                .build();
        // 27001 Primal Mana
        PrimalMana = new Material.Builder(getMaterialsId(), gregtechId("primal_mana"))
                .fluid(FluidTypes.GAS, false)
                .color(0x0000FF).fluidTemp(0)
                .build();
        // 27002 Dawnstone
        Dawnstone = new Material.Builder(getMaterialsId(), gregtechId("dawnstone"))
                .ingot(3)
                .fluid(FluidTypes.LIQUID, true)
                .blastTemp(2300).components(Gold, 1, Copper, 1)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
