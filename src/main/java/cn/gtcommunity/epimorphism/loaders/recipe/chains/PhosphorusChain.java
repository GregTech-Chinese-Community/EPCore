package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhosphorusChain {
    public static void init() {
        //  Triphenylphosphine
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 6)
                .fluidInputs(PhosphorusTrichloride.getFluid(3000))
                .fluidInputs(Chlorobenzene.getFluid(1000))
                .output(dust, Triphenylphosphine, 34)
                .output(dust, Salt, 12)
                .EUt(7680)
                .duration(250)
                .buildAndRegister();
    }
}
