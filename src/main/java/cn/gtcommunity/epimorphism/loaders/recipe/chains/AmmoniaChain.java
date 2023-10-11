package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class AmmoniaChain {
    public static void init() {

        //  Delete original recipes
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
        );

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
        );

        //  Rich Nitrogen Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Air.getFluid(1500))
                .fluidOutputs(RichNitrogenMixture.getFluid(2500))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Rich Ammonia Mixture
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Chrome)
                .fluidInputs(RichNitrogenMixture.getFluid(2500))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Methane.getFluid(1000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Ruthenium)
                .fluidInputs(RichNitrogenMixture.getFluid(2500))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(RichAmmoniaMixture.getFluid(3000))
                .fluidOutputs(Methane.getFluid(1000))
                .duration(80)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Ammonia
        BREWING_RECIPES.recipeBuilder()
                .notConsumable(dust, Magnetite)
                .fluidInputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();

        BREWING_RECIPES.recipeBuilder()
                .notConsumable(dust, Chromite)
                .fluidInputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(3000))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
