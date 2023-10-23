package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class MolybdenumRheniumChain {
    public static void init() {

        //  Molybdenite + Oxygen -> Molybdenum Trioxide + Sulfur Dioxide + Molybdenum Flue
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Molybdenite, 3)
                .fluidInputs(Oxygen.getFluid(8000))
                .output(dust, MolybdenumTrioxide, 4)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .fluidOutputs(MolybdenumFlue.getFluid(1000))
                .temperature(1400)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Molybdenum Trioxide + Hydrogen -> Molybdenum + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Molybdenum)
                .fluidOutputs(Water.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Powellite + Hydrochloric Acid -> Molybdenum Trioxide + CalciumChloride + Water
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Powellite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Wulfenite + Hydrochloric Acid -> Molybdenum Trioxide + Lead Chloride + Water
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Wulfenite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, LeadChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  MolybdenumFlue -> MolybdenumTrioxide + TraceRheniumFlue
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MolybdenumFlue.getFluid(1000))
                .output(dust, MolybdenumTrioxide)
                .fluidOutputs(TraceRheniumFlue.getFluid(500))
                .duration(200)
                .EUt(60)
                .buildAndRegister();

        //  Soda Ash + Sodium Hydroxide + TraceRheniumFlue + Chlorine -> Perrhenic Acid + Salt + Carbon Dioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(TraceRheniumFlue.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, PerrhenicAcid, 6)
                .output(dust, Salt, 6)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Perrhenic Acid + Ammonia -> Ammonium Perrhenate
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PerrhenicAcid, 6)
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, AmmoniumPerrhenate, 10)
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Ammonium Perrhenate + Hydrogen Sulfide + Chlorine -> Rhenium + Ammonium Chloride + Sulfuric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumPerrhenate, 10)
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, Rhenium)
                .output(dust, AmmoniumChloride, 2)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
