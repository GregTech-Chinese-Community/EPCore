package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class CyclotronRecipes {
    public static void init() {

        //  Cu + Cs -> Ac
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Copper.getFluid(L))
                .fluidInputs(Caesium.getFluid(L))
                .fluidOutputs(Actinium.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L))
                .EUt(VA[ZPM])
                .duration(300)
                .buildAndRegister();

        //  TODO C + At -> Ac

        //  C + Cs -> La
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Carbon.getFluid(L * 4))
                .fluidInputs(Caesium.getFluid(L))
                .fluidOutputs(Lanthanum.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  La + Li -> Ce
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Lanthanum.getFluid(L))
                .fluidInputs(Lithium.getFluid(L))
                .fluidOutputs(Cerium.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Cu + Sr -> Nb
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Copper.getFluid(L * 4))
                .fluidInputs(Strontium.getFluid(L))
                .fluidOutputs(Niobium.getFluid(L * 2))
                .fluidOutputs(FreeElectronGas.getFluid(L * 3))
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Be + Ce -> Nb
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(Beryllium.getFluid(L * 3))
                .fluidInputs(Cerium.getFluid(L * 2))
                .fluidOutputs(Niobium.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Free Electron Gas -> Quantum Anomaly
        CYCLOTRON_RECIPES.recipeBuilder()
                .fluidInputs(FreeElectronGas.getFluid(L * 10))
                .chancedOutput(QUANTUM_ANOMALY, 1000, 0)
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  TODO Quantum Anomaly Recipe in Quantum Force Transformer (at UEV stage)
    }
}
