package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.recipe.properties.NoCoilTemperatureProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.recipeproperties.RecipePropertyStorage;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTUtility;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class NoCoilTemperatureRecipeBuilder extends RecipeBuilder<NoCoilTemperatureRecipeBuilder> {
    public NoCoilTemperatureRecipeBuilder() {}

    public NoCoilTemperatureRecipeBuilder(Recipe recipe, RecipeMap<NoCoilTemperatureRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public NoCoilTemperatureRecipeBuilder(NoCoilTemperatureRecipeBuilder builder) {
        super(builder);
    }

    public NoCoilTemperatureRecipeBuilder copy() {
        return new NoCoilTemperatureRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals("temperature")) {
            temperature(((Number)value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public NoCoilTemperatureRecipeBuilder temperature(int temperature) {
        if (temperature <= 0) {
            EPLog.logger.error("Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty((RecipeProperty) NoCoilTemperatureProperty.getInstance(), Integer.valueOf(temperature));
        return this;
    }

    public ValidationResult<Recipe> build() {
        if (this.recipePropertyStorage == null)
            this.recipePropertyStorage = (IRecipePropertyStorage)new RecipePropertyStorage();
        if (this.recipePropertyStorage.hasRecipeProperty((RecipeProperty)NoCoilTemperatureProperty.getInstance())) {
            if (((Integer)this.recipePropertyStorage.getRecipePropertyValue((RecipeProperty)NoCoilTemperatureProperty.getInstance(), Integer.valueOf(-1))).intValue() <= 0)
                this.recipePropertyStorage.store((RecipeProperty)NoCoilTemperatureProperty.getInstance(), Integer.valueOf(298));
        } else {
            this.recipePropertyStorage.store((RecipeProperty)NoCoilTemperatureProperty.getInstance(), Integer.valueOf(298));
        }
        return super.build();
    }

    public int getTemperature() {
        return (this.recipePropertyStorage == null) ? 0 : ((Integer)this.recipePropertyStorage
                .getRecipePropertyValue((RecipeProperty)NoCoilTemperatureProperty.getInstance(), Integer.valueOf(0))).intValue();
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(NoCoilTemperatureProperty.getInstance().getKey(), GTUtility.formatNumbers(getTemperature()))
                .toString();
    }
}
