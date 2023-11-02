package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhosphorusChain {
    public static void init() {
        //  TricalciumPhosphate + Silicon Dioxide + Carbon -> White Phosphorus + Wollastonite + Carbon Dioxide
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TricalciumPhosphate, 10)
                .input(dust, SiliconDioxide, 18)
                .input(dust, Carbon, 5)
                .output(gem, WhitePhosphorus)
                .output(dust, Wollastonite, 30)
                .fluidOutputs(CarbonDioxide.getFluid(5000))
                .temperature(1073)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  White Phosphorus + Argon -> Red Phosphorus
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Argon.getFluid(50))
                .output(gem, RedPhosphorus)
                .temperature(573)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  White Phosphorus + Lead -> Violet Phosphorus
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Lead.getFluid(L * 2))
                .output(gem, VioletPhosphorus)
                .duration(400)
                .EUt(VA[HV])
                .buildAndRegister();

        //  White Phosphorus -> Black Phosphorus
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(gem, WhitePhosphorus)
                .output(gem, BlackPhosphorus)
                .temperature(524)
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Black Phosphorus -> Blue Phosphorus
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .notConsumable(foil, Gold)
                .input(gem, BlackPhosphorus)
                .output(dust, BluePhosphorus)
                .duration(100)
                .EUt(VA[ZPM])
                .temperature(3188)
                .buildAndRegister();

        //  Sodium Hydroxide + Black Phosphorus + Distilled Water + N-Methyl Pyrrolidone -> Phosphorene Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 6)
                .input(gem, BlackPhosphorus, 8)
                .fluidInputs(DistilledWater.getFluid(200))
                .fluidInputs(NMethylPyrrolidone.getFluid(800))
                .fluidOutputs(PhosphoreneSolution.getFluid(1000))
                .duration(600)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Sodium Hydroxide + Blue Phosphorus + Distilled Water + N-Methyl Pyrrolidone -> Phosphorene Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 6)
                .input(gem, BluePhosphorus, 8)
                .fluidInputs(DistilledWater.getFluid(200))
                .fluidInputs(NMethylPyrrolidone.getFluid(800))
                .fluidOutputs(PhosphoreneSolution.getFluid(3000))
                .duration(600)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Phosphorene Solution + Argon -> Phosphorene + N-Methyl Pyrrolidone
        SONICATION_RECIPES.recipeBuilder()
                .fluidInputs(PhosphoreneSolution.getFluid(125))
                .fluidInputs(Argon.getFluid(100))
                .output(foil, Phosphorene, 4)
                .fluidOutputs(NMethylPyrrolidone.getFluid(100))
                .duration(100)
                .EUt(VA[LuV])
                .glassTier(8)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  White Phosphorus + Chlorine -> Phosphorus Trichloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Chlorine.getFluid(12000))
                .fluidOutputs(PhosphorusTrichloride.getFluid(4000))
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Sodium + Phosphorus Trichloride + Chlorobenzene -> Triphenylphosphine + Salt
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 6)
                .fluidInputs(PhosphorusTrichloride.getFluid(3000))
                .fluidInputs(Chlorobenzene.getFluid(1000))
                .output(dust, Triphenylphosphine, 34)
                .output(dust, Salt, 12)
                .EUt(7680)
                .duration(250)
                .buildAndRegister();

        //  Phosphorus Trichloride + Oxygen -> Phosphoryl Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(PhosphorylChloride.getFluid(1000))
                .duration(120)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Phosphine
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Water.getFluid(6000))
                .fluidOutputs(Phosphine.getFluid(4000))
                .duration(200)
                .EUt(16)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, VioletPhosphorus)
                .fluidInputs(DistilledWater.getFluid(6000))
                .fluidOutputs(Phosphine.getFluid(8000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();
    }
}
