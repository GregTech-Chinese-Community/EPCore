package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class ThalliumChain {
    public static void init() {
        //  Pyrite + Oxygen -> Iron + Thallium Sulfate + Sulfur Dioxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Pyrite, 3)
                .fluidInputs(Oxygen.getFluid(6000))
                .output(ingot, Iron)
                .output(dust, ThalliumSulfate, 7)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .temperature(1704)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Galena + Oxygen -> Lead + Thallium Sulfate + Sulfur Dioxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Galena, 4)
                .fluidInputs(Oxygen.getFluid(6000))
                .output(ingot, Lead, 2)
                .output(dust, ThalliumSulfate, 7)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .temperature(1802)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Thallium Sulfate + Water + Platinum Plate -> Thallium + Sulfuric Acid + Oxygen
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, ThalliumSulfate, 7)
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(plate, Platinum)
                .output(dust, Thallium, 2)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(200)
                .EUt(60)
                .buildAndRegister();

        //  Thallium Sulfate + Hydrochloric Acid -> Thallium Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ThalliumSulfate)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .circuitMeta(1)
                .output(dust, ThalliumChloride, 4)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(30)
                .buildAndRegister();

    }
}
