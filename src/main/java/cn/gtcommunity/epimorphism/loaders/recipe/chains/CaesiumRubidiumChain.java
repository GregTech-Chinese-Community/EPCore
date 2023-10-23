package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class CaesiumRubidiumChain {
    public static void init() {
        //  Pollucite + Hydrochloric Acid -> Alumina + Silicon Dioxide + Heavy Alkali Chloride Solution
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pollucite, 10)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .output(dust, Alumina)
                .output(dust, SiliconDioxide, 4)
                .fluidOutputs(HeavyAlkaliChlorideSolution.getFluid(1000))
                .duration(400)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Tin + Chlorine -> Tin Chloride
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Tin)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(1)
                .fluidOutputs(TinChloride.getFluid(1000))
                .temperature(294)
                .duration(100)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Tin + Chlorine -> Stannic Chloride
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Tin)
                .fluidInputs(Chlorine.getFluid(4000))
                .circuitMeta(2)
                .fluidOutputs(StannicChloride.getFluid(1000))
                .temperature(388)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Stannic Chloride -> Tin Chloride
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(StannicChloride.getFluid(1000))
                .circuitMeta(0)
                .fluidOutputs(TinChloride.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .duration(250)
                .EUt(VA[MV])
                .temperature(420)
                .buildAndRegister();

        //  Tin Chloride + Chloride -> Stannic Chloride
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TinChloride.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(0)
                .fluidOutputs(StannicChloride.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .temperature(860)
                .buildAndRegister();

        //  Heavy Alkali Chloride Solution + StannicChloride -> Rubidium Chlorostannate + Caesium Chlorostannate
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HeavyAlkaliChlorideSolution.getFluid(1000))
                .fluidInputs(StannicChloride.getFluid(1500))
                .output(dust, RubidiumChlorostannate, 4)
                .output(dust, CaesiumChlorostannate, 9)
                .fluidOutputs(Water.getFluid(2000))
                .duration(400)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
