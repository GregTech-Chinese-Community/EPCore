package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BismuthVanadiumChain {
    public static void init() {
        //  Vanadium Magnetite + Carbon dust -> Iron + Vanadium Slag
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, VanadiumMagnetite, 4)
                .input(dust, Carbon)
                .output(ingot, Iron, 3)
                .output(dust, VanadiumSlag, 4)
                .temperature(1500)
                .duration(220)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Vanadium Slag + Soda Ash -> Sodium Vanadate + Carbon Monoxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 18)
                .input(dust, VanadiumSlag, 4)
                .output(dust, SodiumVanadate, 16)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .temperature(700)
                .duration(140)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Bismuth + Nitric Acid -> Bismuth Nitrate Solution + Nitrogen Dioxide + Water
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .fluidInputs(NitricAcid.getFluid(6000))
                .circuitMeta(1)
                .fluidOutputs(BismuthNitrateSolution.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(3000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[LV])
                .duration(300)
                .buildAndRegister();

        //  Ammonium Vanadate + Bismuth Nitrate Solution + Ammonia + Water -> Bismuth Vanadate Solution + Ammonium Nitrate
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumVanadate, 9)
                .fluidInputs(BismuthNitrateSolution.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(BismuthVanadateSolution.getFluid(1000))
                .fluidOutputs(AmmoniumNitrate.getFluid(3000))
                .EUt(640)
                .duration(220)
                .buildAndRegister();

        //  Bismuth Vanadate Solution -> Bismuth Vanadate
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(BismuthVanadateSolution.getFluid(1000))
                .output(dust, BismuthVanadate, 6)
                .fluidOutputs(Water.getFluid(200))
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();

        //  Sodium Vanadate + Ammonium Chloride + Sulfuric Acid -> Ammonium Vanadate + Vanadium Waste Solution
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumVanadate, 8)
                .fluidInputs(AmmoniumChloride.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .circuitMeta(1)
                .output(dust, AmmoniumVanadate, 9)
                .fluidOutputs(VanadiumWasteSolution.getFluid(1000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  TODO Vanadium Waste Solution Cycle
    }
}
