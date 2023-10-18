package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class TungstenChain {
    public static void init() {

        //  Delete original recipes
        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES,
                OreDictUnifier.get(dust, TungsticAcid, 7));

        //  Tungstic Acid -> Tungsten Trioxide + Water
        EPRecipeMaps.DRYER_RECIPES.recipeBuilder()
                .input(dust, TungsticAcid, 7)
                .output(dust, TungstenTrioxide, 4)
                .fluidOutputs(Water.getFluid(1000))
                .duration(160)
                .EUt(16)
                .buildAndRegister();

        //  Tungsten Trioxide + Carbon dust -> Carbon Dioxide + Tungsten
        BLAST_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 8)
                .input(dust, Carbon, 3)
                .output(ingotHot, Tungsten, 2)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .blastFurnaceTemp(Tungsten.getBlastTemperature())
                .duration(2400)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Tungsten Trioxide + Hydrogen -> Tungsten + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Tungsten)
                .fluidOutputs(Water.getFluid(3000))
                .duration(210)
                .EUt(960)
                .buildAndRegister();

    }
}
