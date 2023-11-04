package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class PlasmaCondenserRecipes {
    public static void init() {

        //  Adamantium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Adamantium.getPlasma(144))
                .fluidInputs(LiquidHelium.getFluid(1440))
                .fluidOutputs(Adamantium.getFluid(144))
                .EUt(VA[ZPM])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(144))
                .fluidInputs(LiquidHelium.getFluid(1440))
                .output(ingot, Adamantium)
                .EUt(VA[ZPM])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(AdamantiumUnstable.getFluid(144))
                .fluidInputs(GelidCryotheum.getFluid(1440))
                .fluidOutputs(Adamantium.getFluid(144))
                .EUt(VA[UHV])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(AdamantiumUnstable.getFluid(144))
                .fluidInputs(GelidCryotheum.getFluid(1440))
                .output(ingot, Adamantium)
                .EUt(VA[UHV])
                .duration(120)
                .buildAndRegister();

        //  Vibranium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(144))
                .fluidInputs(LiquidHelium.getFluid(1440))
                .fluidOutputs(Vibranium.getFluid(144))
                .EUt(VA[UHV])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(144))
                .fluidInputs(LiquidHelium.getFluid(1440))
                .output(ingot, Vibranium)
                .EUt(VA[UHV])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(VibraniumUnstable.getFluid(144))
                .fluidInputs(GelidCryotheum.getFluid(1440))
                .fluidOutputs(Vibranium.getFluid(144))
                .EUt(VA[UIV])
                .duration(120)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(VibraniumUnstable.getFluid(144))
                .fluidInputs(GelidCryotheum.getFluid(1440))
                .output(ingot, Vibranium)
                .EUt(VA[UIV])
                .duration(120)
                .buildAndRegister();
    }
}
