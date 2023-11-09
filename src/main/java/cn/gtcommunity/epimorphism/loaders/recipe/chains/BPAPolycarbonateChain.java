package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class BPAPolycarbonateChain {
    public static void init() {
        //  Carbon Monoxide + Oxygen + Methanol - > Dimethyl Carbonate + Water
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(Methanol.getFluid(2000))
                .circuitMeta(1)
                .fluidOutputs(DimethylCarbonate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Dimethyl Carbonate + Phenol -> Diphenyl Carbonate + Methanol
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DimethylCarbonate.getFluid(1000))
                .fluidInputs(Phenol.getFluid(2000))
                .fluidOutputs(DiphenylCarbonate.getFluid(1000))
                .fluidOutputs(Methanol.getFluid(2000))
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        //  Diphenyl Carbonate + Bisphenol-A -> BPA Polycarbonate + Phenol
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DiphenylCarbonate.getFluid(1000))
                .fluidInputs(BisphenolA.getFluid(1000))
                .fluidOutputs(BPAPolycarbonate.getFluid(144))
                .fluidOutputs(Phenol.getFluid(2000))
                .EUt(VA[IV])
                .duration(160)
                .buildAndRegister();
    }
}
