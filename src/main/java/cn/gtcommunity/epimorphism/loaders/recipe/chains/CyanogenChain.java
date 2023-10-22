package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.BURNER_REACTOR_RECIPES;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class CyanogenChain {
    public static void init() {

        //  Hydrogen + Ammonia + Methane -> Hydrogen Cyanide + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(Methane.getFluid(1000))
                .circuitMeta(3)
                .fluidOutputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Methane + Ammonia + Oxygen + Platinum -> Hydrogen Cyanide + Steam
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .notConsumable(dust, Platinum)
                .fluidOutputs(HydrogenCyanide.getFluid(3000))
                .fluidOutputs(Steam.getFluid(3000))
                .temperature(1473)
                .duration(60)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Potassium Hydroxide + Hydrogen Cyanide -> Potassium Cyanide + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumHydroxide.getFluid(1000))
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .circuitMeta(0)
                .output(dust, PotassiumCyanide, 3)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();
    }
}