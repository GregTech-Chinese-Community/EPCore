package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.BURNER_REACTOR_RECIPES;
import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.CRYOGENIC_REACTOR_RECIPES;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class BZMediumChain {
    public static void init() {
        //  BZ Medium
        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotassiumBromate, 4)
                .input(dust, MalonicAcid, 3)
                .input(dust, Cerium)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(BZMedium.getFluid(1000))
                .duration(100)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Potassium Bromate
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(3000))
                .fluidInputs(PotassiumHydroxide.getFluid(L * 9))
                .output(dust, PotassiumBromate, 5)
                .fluidOutputs(Ice.getFluid(3000))
                .temperature(273)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Potassium Hydroxide
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .notConsumable(new IntCircuitIngredient(2))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, PotassiumHydroxide, 3)
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .duration(720)
                .EUt(VA[LV])
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(2000))
                .duration(400)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Malonic Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, ChloroaceticAcid, 8)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, SodiumHydroxide, 6)
                .output(dust, MalonicAcid, 11)
                .fluidOutputs(HypochlorousAcid.getFluid(1000))
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trichloroethylene.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .notConsumable(SulfuricAcid.getFluid(250))
                .output(dust, ChloroaceticAcid, 8)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100).EUt(VA[EV]).buildAndRegister();

        //  Trichloroethylene
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(Trichloroethylene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(3000))
                .temperature(400)
                .duration(100).EUt(VA[EV]).buildAndRegister();
    }
}
