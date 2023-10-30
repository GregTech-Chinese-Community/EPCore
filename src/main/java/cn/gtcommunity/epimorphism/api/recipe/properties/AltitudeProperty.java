package cn.gtcommunity.epimorphism.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class AltitudeProperty extends RecipeProperty<Integer> {
    public static final String KEY = "altitude";
    private static AltitudeProperty INSTANCE;
    private AltitudeProperty() {
        super(KEY, Integer.class);
    }

    public static AltitudeProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AltitudeProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("epimorphism.recipe.altitude", castValue(value)), x, y, color);
    }
}
