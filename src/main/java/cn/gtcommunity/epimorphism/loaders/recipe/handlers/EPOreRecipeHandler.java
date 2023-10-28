package cn.gtcommunity.epimorphism.loaders.recipe.handlers;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.*;

public class EPOreRecipeHandler {
    private EPOreRecipeHandler() {/**/}

    public static void register() {
        EPOrePrefix.milled.addProcessingHandler(PropertyKey.ORE, EPOreRecipeHandler::processMilled);
    }

    public static void processMilled(OrePrefix milledPrefix, Material material, OreProperty property) {
        EPRecipeMaps.ISA_MILL_GRINDER.recipeBuilder().EUt(GTValues.VA[ZPM]).duration(1500)
                .input(OrePrefix.crushed, material, 16)
                .output(milledPrefix, material, 16)
                .circuitMeta(11)
                .grindBallTier(1)
                .buildAndRegister();
        EPRecipeMaps.ISA_MILL_GRINDER.recipeBuilder().EUt(GTValues.VA[ZPM]).duration(1200)
                .input(OrePrefix.crushed, material, 16)
                .output(milledPrefix, material, 32)
                .circuitMeta(10)
                .grindBallTier(2)
                .buildAndRegister();
    }
}
