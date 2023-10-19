package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.api.recipe.properties.CasingTierProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class CasingTierRecipeBuilder extends RecipeBuilder<CasingTierRecipeBuilder> {
    public CasingTierRecipeBuilder() {

    }

    public CasingTierRecipeBuilder(Recipe recipe, RecipeMap<CasingTierRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public CasingTierRecipeBuilder(RecipeBuilder<CasingTierRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public CasingTierRecipeBuilder copy() {
        return new CasingTierRecipeBuilder(this);
    }

    public int getTier() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(CasingTierProperty.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(CasingTierProperty.KEY)) {
            this.CasingTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public CasingTierRecipeBuilder CasingTier(int level) {
        if (level <= 0) {
            EPLog.logger.error("Casing Tier cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(CasingTierProperty.getInstance(), level);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(CasingTierProperty.getInstance().getKey(), getTier())
                .toString();
    }
}
