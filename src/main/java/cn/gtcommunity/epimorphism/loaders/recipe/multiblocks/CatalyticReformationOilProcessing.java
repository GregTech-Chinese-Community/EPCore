package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.CATALYTIC_REFORMER_RECIPES;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.ParaXylene;
import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class CatalyticReformationOilProcessing {
    public static void init() {
        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Platinum)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(60))
                .fluidOutputs(Benzene.getFluid(200))
                .fluidOutputs(ParaXylene.getFluid(350))
                .fluidOutputs(Ethylbenzene.getFluid(200))
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();

        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(120))
                .fluidOutputs(Benzene.getFluid(400))
                .fluidOutputs(ParaXylene.getFluid(700))
                .fluidOutputs(Ethylbenzene.getFluid(400))
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();
    }
}
