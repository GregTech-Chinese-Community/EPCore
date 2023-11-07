package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.recipe.properties.GlassTierProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import gregtech.api.util.TextFormattingUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class GlassTierBlastRecipeBuilder extends RecipeBuilder<GlassTierBlastRecipeBuilder> {
    public GlassTierBlastRecipeBuilder() {/**/}

    public GlassTierBlastRecipeBuilder(Recipe recipe, RecipeMap<GlassTierBlastRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public GlassTierBlastRecipeBuilder(GlassTierBlastRecipeBuilder builder) {
        super(builder);
    }

    public GlassTierBlastRecipeBuilder copy() {
        return new GlassTierBlastRecipeBuilder(this);
    }

    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals("glass_tier")) {
            glassTier(((Number)value).intValue());
            return true;
        }
        if (key.equals(TemperatureProperty.KEY)) {
            this.blastFurnaceTemp(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public GlassTierBlastRecipeBuilder glassTier(int glass_tier) {
        if (glass_tier <= 0) {
            EPLog.logger.error("Glass Tier cannot be less than or equal to 0", new IllegalArgumentException());
            this.recipeStatus = EnumValidationResult.INVALID;
        }
        applyProperty(GlassTierProperty.getInstance(), glass_tier);
        return this;
    }

    public GlassTierBlastRecipeBuilder blastFurnaceTemp(int blastFurnaceTemp) {
        if (blastFurnaceTemp <= 0) {
            GTLog.logger.error("Blast Furnace Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(TemperatureProperty.getInstance(), blastFurnaceTemp);
        return this;
    }

    public int getGlassTier() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(GlassTierProperty.getInstance(), 0);
    }

    public int getBlastFurnaceTemp() {
        return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                .getRecipePropertyValue(TemperatureProperty.getInstance(), 0);
    }

    public String toString() {
        return (new ToStringBuilder(this))
                .appendSuper(super.toString())
                .append(GlassTierProperty.getInstance().getKey(), getGlassTier())
                .append(TemperatureProperty.getInstance().getKey(), TextFormattingUtil.formatNumbers(getBlastFurnaceTemp()))
                .toString();
    }
}
