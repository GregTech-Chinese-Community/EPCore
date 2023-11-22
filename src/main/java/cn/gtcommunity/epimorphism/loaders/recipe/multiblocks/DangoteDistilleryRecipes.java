package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.MOLECULAR_DISTILLATION_RECIPES;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.VA;
import static gregtech.api.GTValues.ZPM;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class DangoteDistilleryRecipes {

    public static void init() {

        //  Crude Naquadah Fuel -> Heavy/Medium/Light Naquadah Fuel + Naquadah Gas
        MOLECULAR_DISTILLATION_RECIPES.recipeBuilder()
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
                .temperature(9430)
                .buildAndRegister();

        //  TODO Rado-X
    }
}