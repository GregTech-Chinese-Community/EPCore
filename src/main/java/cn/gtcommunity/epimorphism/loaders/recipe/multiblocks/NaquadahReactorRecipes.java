package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class NaquadahReactorRecipes {
    public static void init() {
        //  Crude Naquadah Fuel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(1000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(3000))
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(6000))
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrudeNaquadahFuel.getFluid(9000))
                .chancedOutput(dust, Naquadah, 1000, 500)
                .fluidOutputs(HeavyNaquadahFuel.getFluid(1000))
                .fluidOutputs(MediumNaquadahFuel.getFluid(2000))
                .fluidOutputs(LightNaquadahFuel.getFluid(3000))
                .fluidOutputs(NaquadahGas.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(800))
                .fluidOutputs(Ammonia.getFluid(400))
                .fluidOutputs(EnrichedNaquadahWaste.getFluid(400))
                .fluidOutputs(NaquadriaWaste.getFluid(200))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Heavy Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyNaquadahFuel.getFluid(1))
                .EUt(-2048)
                .duration(180)
                .buildAndRegister();

        //  Medium Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumNaquadahFuel.getFluid(1))
                .EUt(-2048)
                .duration(120)
                .buildAndRegister();

        //  Light Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightNaquadahFuel.getFluid(1))
                .EUt(-2048)
                .duration(60)
                .buildAndRegister();

        //  Heavy Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyTaraniumFuel.getFluid(1))
                .EUt(-4096)
                .duration(360)
                .buildAndRegister();

        //  Medium Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumTaraniumFuel.getFluid(1))
                .EUt(-4096)
                .duration(240)
                .buildAndRegister();

        //  Light Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightTaraniumFuel.getFluid(1))
                .EUt(-4096)
                .duration(120)
                .buildAndRegister();

        //  Heavy Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(1))
                .EUt(-8192)
                .duration(720)
                .buildAndRegister();

        //  Medium Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(1))
                .EUt(-8192)
                .duration(480)
                .buildAndRegister();

        //  Light Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(1))
                .EUt(-8192)
                .duration(240)
                .buildAndRegister();

        //  Naquadah Gas
        GAS_TURBINE_FUELS.recipeBuilder()
                .fluidInputs(NaquadahGas.getFluid(1))
                .EUt(-32)
                .duration(240)
                .buildAndRegister();

    }
}
