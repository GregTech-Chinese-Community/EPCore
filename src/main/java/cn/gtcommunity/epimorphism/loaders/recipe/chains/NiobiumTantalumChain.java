package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class NiobiumTantalumChain {
    public static void init() {
        //  Pyrochlore + Hydrofluoric Acid -> Niobium Pentoxide + Tantalum Pentoxide + Calcium Difluoride + Water
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pyrochlore, 11)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .output(dust, NiobiumPentoxide, 7)
                .output(dust, TantalumPentoxide)
                .output(dust, CalciumDifluoride, 6)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Tantalite + Hydrofluoric Acid -> Tantalum Pentoxide + Niobium Pentoxide + Manganese Difluoride
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Tantalite, 9)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .output(dust, TantalumPentoxide, 7)
                .output(dust, NiobiumPentoxide)
                .output(dust, ManganeseDifluoride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
