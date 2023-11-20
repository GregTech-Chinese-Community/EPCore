package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class FluoinatedEthylenePropyleneChain {
    public static void init() {

        //  Tetrafluoroethylene -> Hexafluoropropylene
        PYROLYSE_RECIPES.recipeBuilder()
                .input(stick, Steel)
                .fluidInputs(Tetrafluoroethylene.getFluid(3000))
                .fluidOutputs(Hexafluoropropylene.getFluid(2000))
                .EUt(VA[HV])
                .duration(460)
                .buildAndRegister();

        //  Tetrafluoroethylene + Hexafluoropropylene -> Fluorinated Ethylene Propylene
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .fluidInputs(Hexafluoropropylene.getFluid(1000))
                .fluidOutputs(FluorinatedEthylenePropylene.getFluid(1000))
                .EUt(VA[EV])
                .duration(135)
                .buildAndRegister();
    }
}
