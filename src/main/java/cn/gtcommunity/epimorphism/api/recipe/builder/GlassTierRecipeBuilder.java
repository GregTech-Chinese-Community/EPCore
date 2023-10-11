package cn.gtcommunity.epimorphism.api.recipe.builder;

import cn.gtcommunity.epimorphism.api.recipe.properties.GlassTierProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

    public class GlassTierRecipeBuilder extends RecipeBuilder<GlassTierRecipeBuilder> {
        public GlassTierRecipeBuilder() {/**/}

        public GlassTierRecipeBuilder(Recipe recipe, RecipeMap<GlassTierRecipeBuilder> recipeMap) {
            super(recipe, recipeMap);
        }

        public GlassTierRecipeBuilder(GlassTierRecipeBuilder builder) {
            super(builder);
        }

        public GlassTierRecipeBuilder copy() {
            return new GlassTierRecipeBuilder(this);
        }

        public boolean applyProperty(@Nonnull String key, Object value) {
            if (key.equals("glass_tier")) {
                glassTier(((Number)value).intValue());
                return true;
            }
            return super.applyProperty(key, value);
        }

        public GlassTierRecipeBuilder glassTier(int glass_tier) {
            if (glass_tier <= 0) {
                EPLog.logger.error("Glass Tier cannot be less than or equal to 0", new IllegalArgumentException());
                this.recipeStatus = EnumValidationResult.INVALID;
            }
            applyProperty(GlassTierProperty.getInstance(), glass_tier);
            return this;
        }

        public int getGlassTier() {
            return this.recipePropertyStorage == null ? 0 : this.recipePropertyStorage
                    .getRecipePropertyValue(GlassTierProperty.getInstance(), 0);
        }

        public String toString() {
            return (new ToStringBuilder(this))
                    .appendSuper(super.toString())
                    .append(GlassTierProperty.getInstance().getKey(), getGlassTier())
                    .toString();
        }
    }

