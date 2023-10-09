package cn.gtcommunity.epimorphism.loaders.recipe.handlers;

import cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix;
import cn.gtcommunity.epimorphism.common.items.EPToolItems;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

public class EPPartsRecipeHandler {

    private EPPartsRecipeHandler() {}
    public static void register() {
        EPOrePrefix.plateCurved.addProcessingHandler(PropertyKey.INGOT,EPPartsRecipeHandler::processPlateCurved);
        OrePrefix.ring.addProcessingHandler(PropertyKey.INGOT,EPPartsRecipeHandler::processRing);
        OrePrefix.spring.addProcessingHandler(PropertyKey.INGOT,EPPartsRecipeHandler::processSpring);
        OrePrefix.springSmall.addProcessingHandler(PropertyKey.INGOT,EPPartsRecipeHandler::processSpringSmall);
        OrePrefix.foil.addProcessingHandler(PropertyKey.INGOT,EPPartsRecipeHandler::processFoil);

    }

    public static void processPlateCurved(OrePrefix curvedPrefix, Material material, IngotProperty property) {
        if (material.hasFlag(MaterialFlags.GENERATE_PLATE)) {
            if (!material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.addShapedRecipe(String.format("plate_curved_%s", material),
                        OreDictUnifier.get(EPOrePrefix.plateCurved, material),
                        "h", "P", "B", 'P', new UnificationEntry(OrePrefix.plate,material), 'B', EPToolItems.BENDING_CYLINDER);
                RecipeMaps.BENDER_RECIPES.recipeBuilder().EUt(32).duration(40)
                        .input(OrePrefix.plate, material, 1)
                        .output(curvedPrefix, material)
                        .circuitMeta(5)
                        .buildAndRegister();
            }
        }
    }
    public static void processRing(OrePrefix ringPrefix, Material material, IngotProperty property) {
        if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {
            if (!material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.addShapedRecipe(String.format("bending_ring_%s", material),
                        OreDictUnifier.get(OrePrefix.ring, material),
                        "h", "S", "B", 'S', new UnificationEntry(OrePrefix.stick, material), 'B', EPToolItems.SMALL_BENDING_CYLINDER);
            }
        }
    }
    public static void processSpring(OrePrefix springPrefix, Material material, IngotProperty property) {
        if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {
            if (!material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.addShapedRecipe(String.format("bending_spring_%s", material),
                        OreDictUnifier.get(OrePrefix.spring, material),
                        "hSB", 'S', new UnificationEntry(OrePrefix.stick, material), 'B', EPToolItems.BENDING_CYLINDER);
            }
        }
    }
    public static void processSpringSmall(OrePrefix springSmallPrefix, Material material, IngotProperty property) {
        if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {
            if (!material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.addShapedRecipe(String.format("bending_small_spring_%s", material),
                        OreDictUnifier.get(OrePrefix.springSmall, material),
                        "hSB", 'S', new UnificationEntry(OrePrefix.stick, material), 'B', EPToolItems.SMALL_BENDING_CYLINDER);
            }
        }
    }
    public static void processFoil(OrePrefix foilPrefix, Material material, IngotProperty property) {
        if (material.hasFlag(MaterialFlags.GENERATE_PLATE)) {
            if (!material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.addShapedRecipe(String.format("bending_foil_%s", material),
                        OreDictUnifier.get(OrePrefix.foil, material),
                        "hPB", 'P', new UnificationEntry(OrePrefix.plate,material), 'B', EPToolItems.SMALL_BENDING_CYLINDER);
            }
        }
    }
}
