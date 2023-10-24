package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class CalciumChain {
    public static void init() {
        //  Quicklime + Carbon -> Calcium Carbide + Carbon Monoxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .input(dust, Carbon, 3)
                .output(dust, CalciumCarbide, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .temperature(2473)
                .duration(500)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Quicklime + Coke -> Calcium Carbide + Carbon Monoxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .input(gem, Coke)
                .output(dust, CalciumCarbide, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .temperature(2473)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Calcium Carbide + Water -> Calcium Hydroxide + Acetylene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumCarbide, 3)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CalciumHydroxide, 5)
                .fluidOutputs(Acetylene.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        //  Calcium Hydroxide + Carbon Dioxide -> Calcite + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(Water.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();
    }
}
