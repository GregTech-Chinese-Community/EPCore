package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.recipe.properties.NoCoilHigherTemperatureProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.RecipePropertyStorage;
import gregtech.api.util.TextFormattingUtil;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;
import java.math.BigInteger;

public class NoCoilHigherTemperatureRecipeBuilder extends RecipeBuilder<NoCoilHigherTemperatureRecipeBuilder> {
    public NoCoilHigherTemperatureRecipeBuilder() {/**/}

    public NoCoilHigherTemperatureRecipeBuilder(Recipe recipe, RecipeMap<NoCoilHigherTemperatureRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public NoCoilHigherTemperatureRecipeBuilder(NoCoilHigherTemperatureRecipeBuilder builder) {
        super(builder);
    }

    public NoCoilHigherTemperatureRecipeBuilder copy() {
        return new NoCoilHigherTemperatureRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals("temperature_higher")) {
            temperature((BigInteger) value);
            return true;
        }
        return super.applyProperty(key, value);
    }

    public NoCoilHigherTemperatureRecipeBuilder temperature(BigInteger temperature) {
        applyProperty(NoCoilHigherTemperatureProperty.getInstance(), temperature);
        return this;
    }

    public ValidationResult<Recipe> build() {
        if (this.recipePropertyStorage == null)
            this.recipePropertyStorage = new RecipePropertyStorage();
        if (this.recipePropertyStorage.hasRecipeProperty(NoCoilHigherTemperatureProperty.getInstance())) {
            if ((this.recipePropertyStorage.getRecipePropertyValue(NoCoilHigherTemperatureProperty.getInstance(), BigInteger.valueOf(-1))).intValue() <= 0)
                this.recipePropertyStorage.store(NoCoilHigherTemperatureProperty.getInstance(), BigInteger.valueOf(298));
        } else {
            this.recipePropertyStorage.store(NoCoilHigherTemperatureProperty.getInstance(), BigInteger.valueOf(298));
        }
        return super.build();
    }

    public BigInteger getTemperature() {
        return (this.recipePropertyStorage == null) ? BigInteger.valueOf(0) : (this.recipePropertyStorage
                .getRecipePropertyValue(NoCoilHigherTemperatureProperty.getInstance(), BigInteger.valueOf(0)));
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(NoCoilHigherTemperatureProperty.getInstance().getKey(), TextFormattingUtil.formatNumbers(getTemperature()))
                .toString();
    }
}