package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class HeatExchangerRecipes {
    public static void init() {

        //  Exhaust gas heat exchange
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(1 * 450))
                .fluidInputs(HighTemperatureExhaustGas.getFluid(1))
                .fluidOutputs(Steam.getFluid(160 * 450))
                .fluidOutputs(SuperheatedSteam.getFluid(80 * 450))
                .fluidOutputs(ExhaustGas.getFluid(1))
                .flowRate(500)
                .duration(20)
                .buildAndRegister();
    }
}
