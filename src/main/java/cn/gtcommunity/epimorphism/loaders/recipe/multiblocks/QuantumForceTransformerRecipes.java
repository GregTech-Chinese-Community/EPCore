package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class QuantumForceTransformerRecipes {
    public static void init() {

        //  Test

        QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
                .input(dust, Carbon, 21)
                .fluidInputs(Hydrogen.getFluid(25000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(5000))
                .fluidOutputs(Epoxy.getFluid(60000))
                .EUt(VA[UHV])
                .duration(100)
                .CasingTier(2)
                .buildAndRegister();
    }
}
