package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class LithiumChain {
    public static void init() {

        //  Lithium Hydride + Water -> Lithium Hydroxide + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, LithiumHydroxide, 3)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(50)
                .EUt(8)
                .buildAndRegister();

        //  Lithium + Lithium Hydroxide + Mercury -> Lithium Amalgam
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Lithium)
                .input(dust, LithiumHydroxide, 3)
                .fluidInputs(Mercury.getFluid(1000))
                .fluidOutputs(LithiumAmalgam.getFluid(1000))
                .duration(80)
                .EUt(240)
                .buildAndRegister();
    }
}
