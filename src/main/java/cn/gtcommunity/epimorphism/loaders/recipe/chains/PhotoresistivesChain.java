package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhotoresistivesChain {
    public static void init() {
        //  Ethylene + Hydrogen Sulfide -> Diethyl Suflide
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(2000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(DiethylSuflide.getFluid(3000))
                .duration(150)
                .EUt(16)
                .buildAndRegister();

        //  Diethyl Suflide + Ethylene -> Hydrogen Sulfide
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(340)
                .EUt(16)
                .buildAndRegister();

        //  Dimethylcadmium + Diethyl Suflide -> Cadmium Sulfide + Ethane + Butane
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylcadmium.getFluid(1000))
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .output(dust, CadmiumSulfide, 2)
                .fluidOutputs(Ethane.getFluid(1000))
                .fluidOutputs(Butane.getFluid(1000))
                .duration(80)
                .EUt(VA[LuV])
                .temperature(588)
                .glassTier(6)
                .buildAndRegister();
    }
}
