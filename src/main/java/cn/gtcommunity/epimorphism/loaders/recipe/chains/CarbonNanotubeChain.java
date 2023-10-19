package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class CarbonNanotubeChain {
    public static void init() {
        //  Carbon Nanotube ingot (UV)
        PLASMA_CVD_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .fluidInputs(Acetylene.getFluid(3000))
                .fluidInputs(Cycloparaphenylene.getFluid(7000))
                .fluidInputs(Nitrogen.getPlasma(10000))
                .output(ingot, CarbonNanotube)
                .fluidOutputs(Ammonia.getFluid(10000))
                .temperature(993)
                .duration(100)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Carbon Nanotube stick (UEV)
        PLASMA_CVD_RECIPES.recipeBuilder()
                .input(plateDouble, Rhenium)
                .fluidInputs(Acetylene.getFluid(24000))
                .fluidInputs(Cycloparaphenylene.getFluid(6000))
                .fluidInputs(Nitrogen.getPlasma(16000))
                .output(stickLong, CarbonNanotube)
                .fluidOutputs(Ammonia.getFluid(16000))
                .temperature(993)
                .duration(1200)
                .EUt(VA[UEV])
                .buildAndRegister();

        //  Cycloparaphenylene
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, Dichlorocyclooctadieneplatinium, 23)
                .input(dust, Diiodobiphenyl, 4)
                .notConsumable(dust, Bipyridine)
                .notConsumable(dust, PalladiumBisdibenzylidieneacetone)
                .fluidInputs(SilverTetrafluoroborate.getFluid(40000))
                .fluidInputs(TrimethyltinChloride.getFluid(40000))
                .output(dust, PlatinumRaw, 6)
                .output(dust, Iodine, 8)
                .output(dust, SilverChloride, 8)
                .output(dust, Tin, 4)
                .fluidOutputs(Cycloparaphenylene.getFluid(10000))
                .fluidOutputs(BoronTrifluoride.getFluid(4000))
                .fluidOutputs(Octene.getFluid(3000))
                .fluidOutputs(HydrofluoricAcid.getFluid(4000))
                .CasingTier(5)
                .EUt(491520)
                .duration(23)
                .buildAndRegister();

        //  Potassium Tetrachloroplatinate + Cyclooctadiene -> Dichlorocyclooctadieneplatinium + Potassium Chloride
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumTetrachloroplatinate, 7)
                .fluidInputs(Cyclooctadiene.getFluid(1000))
                .output(dust, Dichlorocyclooctadieneplatinium, 23)
                .output(dust, RockSalt, 4)
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Potassium dust + Chloroplatinic Acid -> Potassium Tetrachloroplatinate + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Potassium, 2)
                .fluidInputs(ChloroplatinicAcid.getFluid(1000))
                .output(dust, PotassiumTetrachloroplatinate, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(480)
                .duration(6)
                .buildAndRegister();

        //  Platinum dust + Hydrochloric Acid -> Raw Platinum dust + Chloroplatinic Acid
        DRYER_RECIPES.recipeBuilder()
                .input(dust, Platinum)
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, PlatinumRaw)
                .fluidOutputs(ChloroplatinicAcid.getFluid(1000))
                .EUt(1920)
                .duration(12)
                .buildAndRegister();

        //  Nickel Triphenylphosphite + Butadiene -> Cyclooctadiene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, NickelTriphenylphosphite)
                .fluidInputs(Butadiene.getFluid(2000))
                .fluidOutputs(Cyclooctadiene.getFluid(1000))
                .EUt(480)
                .duration(6)
                .buildAndRegister();

        //  Nickel Triphenylphosphite
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, NickelChloride)
                .fluidInputs(PhosphorusTrichloride.getFluid(2000))
                .fluidInputs(Phenol.getFluid(6000))
                .output(dust, NickelTriphenylphosphite, 16)
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .fluidOutputs(Oxygen.getFluid(6000))
                .EUt(1920)
                .duration(18)
                .buildAndRegister();

        //  Nickel Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Nickel)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, NickelChloride)
                .EUt(30)
                .duration(3)
                .buildAndRegister();

        //  Phosphorus dust + Chlorine -> Phosphorus Trichloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Phosphorus)
                .fluidInputs(Chlorine.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(PhosphorusTrichloride.getFluid(1000))
                .EUt(30)
                .duration(3)
                .buildAndRegister();
    }
}
