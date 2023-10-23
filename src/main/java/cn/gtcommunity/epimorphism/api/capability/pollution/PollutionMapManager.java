package cn.gtcommunity.epimorphism.api.capability.pollution;

import gregtech.api.recipes.RecipeMap;

import java.util.HashMap;

public class PollutionMapManager {

    private static final HashMap<RecipeMap<?>, Integer> regMap = new HashMap<>();

    public static void addPollutionToRecipeMap(RecipeMap<?> recipeMap, int pollution) {
        regMap.put(recipeMap, pollution);
    }

    public static int getPollutionByMap(RecipeMap<?> recipeMap) {
        return regMap.get(recipeMap);
    }

}
