package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import gregtech.api.unification.material.MarkerMaterials;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PreciseAssemblerRecipes {
    public static void init() {

        //  Test
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.OpV)
                .input(circuit, MarkerMaterials.Tier.UXV)
                .output(circuit, MarkerMaterials.Tier.UEV)
                .EUt(VA[UXV])
                .duration(1200)
                .CasingTier(3)
                .buildAndRegister();
    }
}