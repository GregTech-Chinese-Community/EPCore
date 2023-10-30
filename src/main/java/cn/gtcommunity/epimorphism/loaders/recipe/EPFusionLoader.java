package cn.gtcommunity.epimorphism.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class EPFusionLoader {
    public static void init() {
        //  Americium + Neon -> Dubnium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Dubnium.getFluid(125))
                .EUt(VA[UV])
                .duration(160)
                .EUToStart(380000000L)
                .buildAndRegister();
    }
}
