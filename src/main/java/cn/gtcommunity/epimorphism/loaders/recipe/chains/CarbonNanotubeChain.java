package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

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
                .duration(1200)
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
                .duration(460)
                .buildAndRegister();

        //  Cycloparaphenylene Cycle

        //  Potassium Tetrachloroplatinate + Cyclooctadiene -> Dichlorocyclooctadieneplatinium + Potassium Chloride
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumTetrachloroplatinate, 7)
                .fluidInputs(Cyclooctadiene.getFluid(1000))
                .output(dust, Dichlorocyclooctadieneplatinium, 23)
                .output(dust, RockSalt, 4)
                .EUt(VA[HV])
                .duration(360)
                .buildAndRegister();

        //  Potassium dust + Chloroplatinic Acid -> Potassium Tetrachloroplatinate + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Potassium, 2)
                .fluidInputs(ChloroplatinicAcid.getFluid(1000))
                .output(dust, PotassiumTetrachloroplatinate, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(480)
                .duration(300)
                .buildAndRegister();

        //  Platinum dust + Hydrochloric Acid -> Raw Platinum dust + Chloroplatinic Acid
        DRYER_RECIPES.recipeBuilder()
                .input(dust, Platinum)
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, PlatinumRaw)
                .fluidOutputs(ChloroplatinicAcid.getFluid(1000))
                .EUt(1920)
                .duration(120)
                .buildAndRegister();

        //  Nickel Triphenylphosphite + Butadiene -> Cyclooctadiene
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, NickelTriphenylphosphite)
                .fluidInputs(Butadiene.getFluid(2000))
                .fluidOutputs(Cyclooctadiene.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        //  Nickel Chloride + Phosphorus Trichloride + Phenol -> Nickel Triphenylphosphite + Hydrochloric Acid + Oxygen
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, NickelChloride)
                .fluidInputs(PhosphorusTrichloride.getFluid(2000))
                .fluidInputs(Phenol.getFluid(6000))
                .output(dust, NickelTriphenylphosphite, 16)
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .fluidOutputs(Oxygen.getFluid(6000))
                .EUt(1920)
                .duration(180)
                .buildAndRegister();

        //  Nickel Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Nickel)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, NickelChloride)
                .EUt(30)
                .duration(60)
                .buildAndRegister();

        //  Phosphorus dust + Chlorine -> Phosphorus Trichloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Phosphorus)
                .fluidInputs(Chlorine.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(PhosphorusTrichloride.getFluid(1000))
                .EUt(30)
                .duration(60)
                .buildAndRegister();

        //  Diiodobiphenyl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Biphenyl, 22)
                .input(dust, Iodine, 2)
                .fluidInputs(AmmoniumSulfate.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Diiodobiphenyl, 22)
                .fluidOutputs(AmmoniumPersulfate.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .EUt(480)
                .duration(260)
                .buildAndRegister();

        //  Another Ammonium Persulfate recipe
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumSulfate.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .circuitMeta(0)
                .fluidOutputs(AmmoniumPersulfate.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(120)
                .duration(220)
                .buildAndRegister();

        //  Hydroxylamine Disulfate + Ammonia -> Hydroxylamine + Ammonium Sulfate
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HydroxylamineDisulfate.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(2000))
                .circuitMeta(2)
                .fluidOutputs(Hydroxylamine.getFluid(2000))
                .fluidOutputs(AmmoniumSulfate.getFluid(2000))
                .EUt(120)
                .duration(180)
                .buildAndRegister();

        //  Ammonium Nitrate + Sulfur Dioxide + Ammonia + Water -> Hydroxylamine Disulfate
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Water.getFluid(3000))
                .circuitMeta(22)
                .fluidOutputs(HydroxylamineDisulfate.getFluid(2000))
                .EUt(120)
                .duration(360)
                .buildAndRegister();

        //  Nitric Acid + Ammonia -> Ammonium Nitrate
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NitricAcid.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(AmmoniumNitrate.getFluid(1000))
                .EUt(480)
                .duration(120)
                .buildAndRegister();

        //  Nickel dust + Aluminium dust + Pyridine -> Bipyridine + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Nickel)
                .notConsumable(dust, Aluminium)
                .fluidInputs(Pyridine.getFluid(2000))
                .output(dust, Bipyridine, 20)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

        //  Thallium Chloride + Formaldehyde + Acetaldehyde -> Pyridine + Hydrogen + Water
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, ThalliumChloride)
                .fluidInputs(Formaldehyde.getFluid(1000))
                .fluidInputs(Acetaldehyde.getFluid(2000))
                .circuitMeta(21)
                .fluidOutputs(Pyridine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(1920)
                .duration(240)
                .buildAndRegister();

        //  Formaldehyde (IV)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumPeriodate, 6)
                .notConsumable(dust, OsmiumTetroxide)
                .fluidInputs(Acetone.getFluid(1000))
                .output(dust, SodiumIodate, 5)
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Acetaldehyde.getFluid(1000))
                .EUt(7680)
                .duration(220)
                .buildAndRegister();

        //  Formaldehyde (LuV)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Silver)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .buildAndRegister();
    }
}
