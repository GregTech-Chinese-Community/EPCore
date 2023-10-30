package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.recipe.properties.AltitudeProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class AltitudeRecipeBuilder extends RecipeBuilder<AltitudeRecipeBuilder> {
    public AltitudeRecipeBuilder() {/**/}

    public AltitudeRecipeBuilder(Recipe recipe, RecipeMap<AltitudeRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public AltitudeRecipeBuilder(AltitudeRecipeBuilder builder) {
        super(builder);
    }

    public AltitudeRecipeBuilder copy() {
        return new AltitudeRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals("altitude")) {
            Altitude(((Number)value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public AltitudeRecipeBuilder Altitude(int altitude) {
        if (altitude <= -64 || altitude >= 256) {
            EPLog.logger.error("Altitude cannot be less than -64 or greater than 256", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty(AltitudeProperty.getInstance(), altitude);
        return this;
    }

    public int getAltitude() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(AltitudeProperty.getInstance(), 0);
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(AltitudeProperty.getInstance().getKey(), getAltitude())
                .toString();
    }
}
