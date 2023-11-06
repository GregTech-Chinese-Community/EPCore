package cn.gtcommunity.epimorphism.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nonnull;
import java.math.BigInteger;

public class NoCoilHigherTemperatureProperty extends RecipeProperty<BigInteger> {
    public static final String KEY = "temperature";

    private static NoCoilHigherTemperatureProperty INSTANCE;

    private NoCoilHigherTemperatureProperty() {
        super("temperature", BigInteger.class);
    }

    public static NoCoilHigherTemperatureProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoCoilHigherTemperatureProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("epimorphism.recipe.temperature", castValue(value)), x, y, color);
    }
}
