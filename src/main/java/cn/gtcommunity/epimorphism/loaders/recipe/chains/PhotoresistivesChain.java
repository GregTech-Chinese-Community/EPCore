package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhotoresistivesChain {
    public static void init() {
        //  Ethylene + Hydrogen Sulfide -> Diethyl Suflide
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(2000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(DiethylSuflide.getFluid(3000))
                .duration(150)
                .EUt(16)
                .buildAndRegister();

        //  Diethyl Suflide + Ethylene -> Hydrogen Sulfide
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(340)
                .EUt(16)
                .buildAndRegister();

        //  Dimethylcadmium + Diethyl Suflide -> Cadmium Sulfide + Ethane + Butane
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylcadmium.getFluid(1000))
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .output(dust, CadmiumSulfide, 2)
                .fluidOutputs(Ethane.getFluid(1000))
                .fluidOutputs(Butane.getFluid(1000))
                .duration(80)
                .EUt(VA[LuV])
                .temperature(588)
                .glassTier(6)
                .buildAndRegister();

        //  Butanediol + Sulfuric Acid -> Tetrahydrofuran + Diluted Sulfuric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1500))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Magnesium Chloride common recipe
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Magnesium)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, MagnesiumChloride, 3)
                .duration(50)
                .EUt(VA[LV])
                .buildAndRegister();

        //  HRA Magnesium
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChloride, 3)
                .fluidInputs(Potassium.getFluid(L * 2))
                .fluidInputs(Tetrahydrofuran.getFluid(10))
                .output(dust, HRAMagnesium)
                .output(dust, RockSalt, 4)
                .duration(140)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Ethylene + Bromine -> Ethylene Dibromide
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(EthyleneDibromide.getFluid(3000))
                .duration(100)
                .EUt(VA[MV])
                .buildAndRegister();

        //  HRA Magnesium + Ethylene Dibromide -> Grignard Reagent + Hydrobromic Acid
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .input(dust, HRAMagnesium)
                .fluidInputs(EthyleneDibromide.getFluid(3000))
                .fluidOutputs(GrignardReagent.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Cadmium + Bromine -> Cadmium Bromide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .fluidInputs(Bromine.getFluid(2000))
                .output(dust, CadmiumBromide, 3)
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        //  Cadmium Bromide + Grignard Reagent -> Magnesium Bromide + Dimethylcadmium
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CadmiumBromide, 3)
                .fluidInputs(GrignardReagent.getFluid(2000))
                .output(dust, MagnesiumBromide, 6)
                .fluidOutputs(Dimethylcadmium.getFluid(1000))
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();
    }
}
