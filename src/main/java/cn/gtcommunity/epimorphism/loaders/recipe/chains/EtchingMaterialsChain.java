package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class EtchingMaterialsChain {
    public static void init() {

        //  Kyanite + Methanol + Ammonia -> Methylamine Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Kyanite)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .duration(1000)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Alumina + Silicon Dioxide + Methanol + Ammonia -> MethylamineMixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina)
                .input(dust, SiliconDioxide)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .duration(1000)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Methylamine Mixture -> Methylamine + Dimethylamine + Trimethylamine + Water
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylamineMixture.getFluid(9000))
                .fluidOutputs(Methylamine.getFluid(1000))
                .fluidOutputs(Dimethylamine.getFluid(1000))
                .fluidOutputs(Trimethylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(1000)
                .EUt(VA[LuV])
                .disableDistilleryRecipes()
                .buildAndRegister();

        //  Trimethylamine + Chloromethane + Ethanol -> TetramethylammoniumChloride
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylamine.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(1000))
                .notConsumable(Ethanol.getFluid(4000))
                .output(dust, TetramethylammoniumChloride, 6)
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  TetramethylammoniumChloride + Potassium Hydroxide + Water -> Rock Salt + TetramethylammoniumHydroxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetramethylammoniumChloride, 6)
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(Water.getFluid(5000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(TetramethylammoniumHydroxide.getFluid(5000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Phenol + Hydrogen Peroxide -> Pyrocatechol + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, Pyrocatechol, 12)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Pyrocatechol + Distilled Water + Ethylenediamine -> EDP
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Pyrocatechol, 3)
                .fluidInputs(DistilledWater.getFluid(500))
                .fluidInputs(Ethylenediamine.getFluid(500))
                .fluidOutputs(EDP.getFluid(1000))
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
