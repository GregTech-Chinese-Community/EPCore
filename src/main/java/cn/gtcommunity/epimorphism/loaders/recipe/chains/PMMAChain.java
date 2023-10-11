package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.AcetoneCyanohydrin;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.PMMA;
import static gregtech.api.GTValues.L;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;

public class PMMAChain {
    public static void init() {

        //  Acetone Cyanohydrin
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(AcetoneCyanohydrin.getFluid(2000))
                .duration(150).EUt(240).buildAndRegister();

        //  PMMA
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcetoneCyanohydrin.getFluid(2000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(PMMA.getFluid(L * 4))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(200).EUt(240).buildAndRegister();
    }
}
