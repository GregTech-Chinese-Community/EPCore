package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class EDOTChain {
    public static void init() {

        //  Diacetyl
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidOutputs(Diacetyl.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  EDOT
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Diacetyl.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(SulfurDichloride.getFluid(1000))
                .fluidOutputs(Edot.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Styrene
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Styrene.getFluid(L))
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(Polystyrene.getFluid(L))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Styrene.getFluid(L))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(Polystyrene.getFluid(216))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(2))
                .fluidInputs(Styrene.getFluid(2160))
                .fluidInputs(Air.getFluid(7500))
                .fluidInputs(TitaniumTetrachloride.getFluid(100))
                .fluidOutputs(Polystyrene.getFluid(3240))
                .duration(800)
                .EUt(VA[LV])
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(2))
                .fluidInputs(Styrene.getFluid(2160))
                .fluidInputs(Oxygen.getFluid(7500))
                .fluidInputs(TitaniumTetrachloride.getFluid(100))
                .fluidOutputs(Polystyrene.getFluid(4320))
                .duration(800)
                .EUt(VA[LV])
                .buildAndRegister();

        //  PolystyreneSulfonate
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Polystyrene.getFluid(L))
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(PolystyreneSulfonate.getFluid(L))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        //  PEDOT:PSS
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Edot.getFluid(1000))
                .fluidInputs(PolystyreneSulfonate.getFluid(L))
                .fluidOutputs(PedotPSS.getFluid(L * 9))
                .duration(400)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  PEDOT-TMA
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Edot.getFluid(1000))
                .fluidInputs(PMMA.getFluid(L))
                .fluidOutputs(PedotTMA.getFluid(L * 9))
                .duration(400)
                .EUt(VA[ZPM])
                .buildAndRegister();
    }
}
