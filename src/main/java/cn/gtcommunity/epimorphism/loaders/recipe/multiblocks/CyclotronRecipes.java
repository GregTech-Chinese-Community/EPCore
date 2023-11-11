package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class CyclotronRecipes {
    public static void init() {

        //  Test
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getPlasma(2000))
                .chancedOutput(QUANTUM_ANOMALY, 1000, 500)
                .fluidOutputs(FreeElectronGas.getFluid(1000))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();
    }
}
