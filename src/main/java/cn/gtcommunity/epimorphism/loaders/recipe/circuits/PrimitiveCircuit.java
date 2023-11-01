package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class PrimitiveCircuit {
    public static void init() {
        //  test
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Coal)
                .input(wireFine, Copper, 4)
                .output(VACUUM_TUBE)
                .EUt(4)
                .duration(120)
                .buildAndRegister();
    }
}
