package cn.gtcommunity.epimorphism.api.recipe.machines;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeMapGeneral<R extends RecipeBuilder<R>> extends RecipeMap<R> {
    private final RecipeMap<R> recipe_1;
    private final RecipeMap<R> recipe_2;
    private final RecipeMap<R> recipe_3;

    public RecipeMapGeneral(@Nonnull String unlocalizedName, int maxInputs, int maxOutputs, int maxFluidInputs, int maxFluidOutputs, @Nonnull R defaultRecipeBuilder, RecipeMap<R> recipe_1, RecipeMap<R> recipe_2, RecipeMap<R> recipe_3, boolean isHidden) {
        super(unlocalizedName, maxInputs, maxOutputs, maxFluidInputs, maxFluidOutputs, defaultRecipeBuilder, isHidden);
        this.recipe_1 = recipe_1;
        this.recipe_2 = recipe_2;
        this.recipe_3 = recipe_3;
    }

    @Override
    @Nullable
    public Recipe findRecipe(long voltage, List<ItemStack> inputs, List<FluidStack> fluidInputs, boolean exactVoltage) {
        final List<ItemStack> items = inputs.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        final List<FluidStack> fluids = fluidInputs.stream().filter(f -> f != null && f.amount != 0).collect(Collectors.toList());
        return switch (checkCircuit(inputs)){

            case 20 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipe_1);

            case 21 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipe_2);

            case 22 -> getRecipe(voltage, inputs, fluidInputs, exactVoltage, items, fluids, recipe_3);

            default -> null;
        };

    }

    private Recipe getRecipe(long voltage, List<ItemStack> inputs, List<FluidStack> fluidInputs, boolean exactVoltage, List<ItemStack> items, List<FluidStack> fluids, @Nonnull RecipeMap<R> recipemap) {
        return recipemap.find(items, fluids, recipe -> {
            if (exactVoltage && recipe.getEUt() != voltage) {
                // if exact voltage is required, the recipe is not considered valid
                return false;
            }
            if (recipe.getEUt() > voltage) {
                // there is not enough voltage to consider the recipe valid
                return false;
            }
            return recipe.matches(false, inputs, fluidInputs);
        });
    }

    private int checkCircuit(@Nonnull List<ItemStack> inputs) {
        for (ItemStack stack : inputs) {
            if (MetaItems.INTEGRATED_CIRCUIT.isItemEqual(stack)) {
                return IntCircuitIngredient.getCircuitConfiguration(stack);
            }
        }
        return 0;
    }
}
