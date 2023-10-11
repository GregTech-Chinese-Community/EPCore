package cn.gtcommunity.epimorphism.api.recipe.properties;

import gregtech.api.GTValues;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nonnull;

public class GlassTierProperty extends RecipeProperty<Integer> {
    public static final String KEY = "glass_tier";

    private static GlassTierProperty INSTANCE;

    private GlassTierProperty() {
        super("glass_tier", Integer.class);
    }

    public static GlassTierProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GlassTierProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("epimorphism.recipe.glass_tier", String.format("%s (%s)", castValue(value), GTValues.VN[castValue(value)])), x, y, color);
    }
}
