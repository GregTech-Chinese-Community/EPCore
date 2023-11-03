package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.util.GTUtility.gregtechId;

public class EPSecondDegreeMaterials {
    // Range: 25401 - 25500
    private static int startId = 25401;
    private static final int END_ID = startId + 100;

    public static void init() {
        //25401 Dragon Breath
        DragonBreath = new Material.Builder(getMaterialsId(), gregtechId("dragon_breath"))
                .fluid(FluidTypes.ACID, true)
                .color(0x9400D3)
                .build();
        //25402 Concentrate Dragon Breath
        ConcentrateDragonBreath = new Material.Builder(getMaterialsId(), gregtechId("concentrate_dragon_breath"))
                .fluid(FluidTypes.ACID, true)
                .color(0x9400D3)
                .build();
        //25403 Impurities Precious Metal Cold Solution
        ImpuritiesPreciousMetalColdSolution = new Material.Builder(getMaterialsId(), gregtechId("impuritie_precious_metal_cold_solution"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0x6495ED)
                .build();
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
