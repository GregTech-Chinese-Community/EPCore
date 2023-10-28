package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.util.GTUtility.gregtechId;

public class EPLiquidMaterials {
    // Range: 25401 - 25500
    public static void init() {
        //25401 Dragon Breath
        DragonBreath = new Material.Builder(25401, gregtechId("dragon_breath"))
                .fluid(FluidTypes.ACID, true)
                .color(0x9400D3)
                .build();
        //25402 Concentrate Dragon Breath
        ConcentrateDragonBreath = new Material.Builder(25402, gregtechId("concentrate_dragon_breath"))
                .fluid(FluidTypes.ACID, true)
                .color(0x9400D3)
                .build();
        //25403 Impurities Precious Metal Cold Solution
        ImpuritiesPreciousMetalColdSolution = new Material.Builder(25403, gregtechId("impuritie_precious_metal_cold_solution"))
                .fluid(FluidTypes.LIQUID, false)
                .color(0x6495ED)
                .build();
    }

}
