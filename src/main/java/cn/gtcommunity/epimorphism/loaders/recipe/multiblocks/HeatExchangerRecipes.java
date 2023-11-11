package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.material.Materials.*;

public class HeatExchangerRecipes {
    public static void init() {

        //  Exhaust gas heat exchange
        HEAT_EXCHANGE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(5))
                .fluidInputs(HighTemperatureExhaustGas.getFluid(1))
                .fluidOutputs(Steam.getFluid(160 * 5))
                .fluidOutputs(SuperheatedSteam.getFluid(80 * 5))
                .fluidOutputs(ExhaustGas.getFluid(1))
                .flowRate(500)
                .duration(20)
                .buildAndRegister();
    }
}
