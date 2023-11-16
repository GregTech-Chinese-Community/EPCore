package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import gregtech.api.recipes.GTRecipeHandler;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class RocketEngineRecipes {
    public static void init() {

        //  Remove rocket fuel Combustion generator recipe
        GTRecipeHandler.removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS,
                new FluidStack[]{RocketFuel.getFluid(16)});

        //  Buff Rocket Fuel heat value
        ROCKET_ENGINE_RECIPES.recipeBuilder()
                .fluidInputs(RocketFuel.getFluid(16))
                .EUt(-2048)
                .duration(20)
                .buildAndRegister();

        //  TODO Other rocket fuels
    }
}
