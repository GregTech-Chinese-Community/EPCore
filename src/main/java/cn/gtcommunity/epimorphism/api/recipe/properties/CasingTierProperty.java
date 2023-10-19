package cn.gtcommunity.epimorphism.api.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class CasingTierProperty extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";

    private static final TreeMap<Integer, String> registeredCasingTiers = new TreeMap<>();

    private static CasingTierProperty INSTANCE;

    private CasingTierProperty() {
        super(KEY, Integer.class);
    }

    public static CasingTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CasingTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("epimorphism.recipe.casing_tier",
                castValue(value).toString()) + getCasingTier(castValue(value)), x, y, color);
    }

    private static String getCasingTier(Integer casing_tier) {
        Map.Entry<Integer, String> mapEntry = registeredCasingTiers.ceilingEntry(casing_tier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format(" - %s", mapEntry.getValue());
    }

    public static void registerCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredCasingTiers.put(tier, shortName);
    }
}
