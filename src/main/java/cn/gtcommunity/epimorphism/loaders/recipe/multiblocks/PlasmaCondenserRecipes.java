package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class PlasmaCondenserRecipes {
    public static void init() {

        //  Degenerated Rhenium
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .inputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(16000))
                .output(plate, DegenerateRhenium)
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Helium.getFluid(16000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .inputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(GelidCryotheum.getFluid(8000))
                .output(plate, DegenerateRhenium)
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Ice.getFluid(8000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  Neutron
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(NEUTRON_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(32000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Neutronium.getFluid(1000))
                .fluidOutputs(Helium.getFluid(32000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(NEUTRON_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(GelidCryotheum.getFluid(16000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Neutronium.getFluid(1000))
                .fluidOutputs(Ice.getFluid(16000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  Hypogen
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(HYPOGEN_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(64000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Hypogen.getFluid(1000))
                .fluidOutputs(Helium.getFluid(64000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(HYPOGEN_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(GelidCryotheum.getFluid(32000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Hypogen.getFluid(1000))
                .fluidOutputs(Ice.getFluid(32000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  Actinium Superhydride
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(24000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .output(dust, ActiniumSuperhydride, 13)
                .fluidOutputs(Helium.getFluid(24000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(GelidCryotheum.getFluid(12000))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .output(dust, ActiniumSuperhydride, 13)
                .fluidOutputs(Ice.getFluid(12000))
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        /*
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
                .buildAndRegister();*/

    }
}
