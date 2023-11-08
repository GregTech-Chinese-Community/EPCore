package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;


import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class PreciseAssemblerRecipes {
    public static void init() {
        //  Intravital SoC
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CRYSTAL_SYSTEM_ON_CHIP)
                .inputs(UHASOC_CHIP.getStackForm(2))
                .input(wireFine, Adamantium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(2000))
                .outputs(INTRAVITAL_SOC.getStackForm(4))
                .EUt(VA[UHV])
                .duration(480)
                .CasingTier(3)
                .buildAndRegister();
    }
}