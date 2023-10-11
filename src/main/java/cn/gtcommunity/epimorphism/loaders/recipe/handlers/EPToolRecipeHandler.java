package cn.gtcommunity.epimorphism.loaders.recipe.handlers;

import cn.gtcommunity.epimorphism.common.items.EPToolItems;
import gregtech.api.items.toolitem.IGTTool;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

import javax.annotation.Nonnull;

import static gregtech.api.unification.material.properties.PropertyKey.*;

public class EPToolRecipeHandler {

    public static void register() {
        OrePrefix.plate.addProcessingHandler(TOOL, EPToolRecipeHandler::processTool);

    }

    private static void processTool(OrePrefix prefix, Material material, ToolProperty property) {
        UnificationEntry stick = new UnificationEntry(OrePrefix.stick, Materials.Wood);
        UnificationEntry rod = new UnificationEntry(OrePrefix.stick, material);
        UnificationEntry plate = new UnificationEntry(OrePrefix.plate, material);
        UnificationEntry ingot = new UnificationEntry(material.hasProperty(GEM) ? OrePrefix.gem : OrePrefix.ingot, material);

        addToolRecipe(material, EPToolItems.BENDING_CYLINDER, true,
                "shf", "III", "III",
                'I', ingot);
        addToolRecipe(material, EPToolItems.SMALL_BENDING_CYLINDER, true,
                "shf", "III",
                'I', ingot);
        if (material.hasFlag(MaterialFlags.GENERATE_PLATE) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
            addToolRecipe(material, EPToolItems.COMBINATION_WRENCH, true,
                    "PhP", "IPI", "fP ",
                    'I', ingot,
                    'P', plate);
            if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {
                addToolRecipe(material, EPToolItems.UNIVERSAL_SPADE, true,
                        "hPP", "DRP", "RDf",
                        'P', plate,
                        'D', new UnificationEntry(OrePrefix.dye, MarkerMaterials.Color.Blue),
                        'R', rod);
            }
        }
    }

    public static void addToolRecipe(@Nonnull Material material, @Nonnull IGTTool tool, boolean mirrored, Object... recipe) {
        if (mirrored) {
            ModHandler.addMirroredShapedRecipe(String.format("%s_%s", tool.getId(), material),
                    tool.get(material), recipe);
        } else {
            ModHandler.addShapedRecipe(String.format("%s_%s", tool.getId(), material),
                    tool.get(material), recipe);
        }
    }
}
