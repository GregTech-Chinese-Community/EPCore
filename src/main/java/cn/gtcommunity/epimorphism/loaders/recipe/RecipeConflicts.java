package cn.gtcommunity.epimorphism.loaders.recipe;

import gregtech.api.recipes.GTRecipeHandler;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class RecipeConflicts {
    public static void init() {
        //  Dichloroethane and Vinyl Chloride
        //  Solution: Add circuit.
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(1)
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(160).EUt(VA[LV]).buildAndRegister();

        //  2-Ethylanthraquinone and Styrene
        //  Solution: Add catalytic dust.
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .notConsumable(dust, Pyrite)
                .fluidOutputs(Styrene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(30)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Potassium Hydroxide and Rock Salt Electrolysis
        //  Solution: Delete recipes by EPMaterialPropertyAddition, add circuit.
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .circuitMeta(1)
                .output(dust, Potassium)
                .fluidOutputs(Chlorine.getFluid(1000))
                .duration(72)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Salt Electrolysis and Sodium Chlorate
        //  Solution: Delete recipes by EPMaterialPropertyAddition, add circuit.
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, Salt, 2)
                .circuitMeta(1)
                .output(dust, Sodium)
                .fluidOutputs(Chlorine.getFluid(1000))
                .duration(56)
                .EUt(VA[LV])
                .buildAndRegister();
    }
}
