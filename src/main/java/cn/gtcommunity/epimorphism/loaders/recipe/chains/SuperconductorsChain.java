package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SuperconductorsChain {
    public static void init() {
        UEVSuperconductorChain();
        UIVSuperconductorChain();
    }

    private static void UEVSuperconductorChain() {
        BETSPerrhenateChain();
    }

    private static void UIVSuperconductorChain() {
        LanthanumFullereneNanotubeChain();
        ActiniumSuperhydrideChain();
        BoronFranciumMixtureChain();
    }

    private static void BETSPerrhenateChain() {
        //  Barium Sulfide + Carbon Dioxide + Water -> Barium Carbonate + Hydrogen Sulfide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BariumSulfide, 2)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .circuitMeta(2)
                .output(dust, BariumCarbonate, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .EUt(30)
                .duration(280)
                .buildAndRegister();

        //  Carbon + Sulfur -> Carbon Disulfide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Carbon)
                .input(dust, Sulfur, 2)
                .fluidOutputs(CarbonDisulfide.getFluid(1000))
                .EUt(VA[MV])
                .duration(350)
                .temperature(1200)
                .buildAndRegister();

        //  Iodine + Carbon Disulfide + Fluorine -> Sulfur + Biperfluoromethanedisulfide
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Iodine)
                .fluidInputs(CarbonDisulfide.getFluid(2000))
                .fluidInputs(Fluorine.getFluid(6000))
                .output(dust, Sulfur, 2)
                .fluidOutputs(Biperfluoromethanedisulfide.getFluid(1000))
                .EUt(VA[MV])
                .duration(160)
                .buildAndRegister();

        //  Barium Carbonate + Biperfluoromethanedisulfide + Water + Mercury -> Barium Triflate Solution
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, BariumCarbonate, 5)
                .notConsumable(BLACKLIGHT)
                .fluidInputs(Biperfluoromethanedisulfide.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .fluidInputs(Mercury.getFluid(1000))
                .fluidOutputs(BariumTriflateSolution.getFluid(3000))
                .EUt(VA[IV])
                .duration(240)
                .CasingTier(5)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Barium Triflate Solution -> Barium Triflate + Mercury + Water
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BariumTriflateSolution.getFluid(3000))
                .output(dust, BariumTriflate, 17)
                .fluidOutputs(Mercury.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[EV])
                .duration(320)
                .buildAndRegister();

        //  Barium Triflate + Scandium + Sulfuric Acid -> Scandium Triflate + Barite + Hydrogen
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BariumTriflate, 51)
                .input(dust, Scandium, 2)
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .output(dust, ScandiumTriflate, 50)
                .output(dust, Barite, 21)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  Sterling Silver + Butane + Butene -> Propadiene + Butane
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, SterlingSilver)
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Butene.getFluid(1000))
                .fluidOutputs(Propadiene.getFluid(1000))
                .fluidOutputs(Butane.getFluid(1000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        //  Sodium Hydroxide + Sulfur -> Sodium Thiosulfate + Sodium Sulfide + Steam
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 18)
                .input(dust, Sulfur, 4)
                .output(dust, SodiumThiosulfate, 7)
                .output(dust, SodiumSulfide, 6)
                .fluidOutputs(Steam.getFluid(3000))
                .temperature(455)
                .EUt(VA[MV])
                .duration(210)
                .buildAndRegister();

        //  Ethane + Chlorine -> Dibromoacrolein + Hydrochloric Acid
        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(lens, MarkerMaterials.Color.Gray)
                .fluidInputs(Ethane.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .fluidOutputs(Chloroethane.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(3340)
                .duration(200)
                .buildAndRegister();

        //  Sodium Hydroxide + Carbon Dioxide -> Sodium Formate
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .circuitMeta(0)
                .fluidOutputs(SodiumFormate.getFluid(1000))
                .EUt(VA[LV])
                .duration(90)
                .temperature(288)
                .buildAndRegister();

        //  Sodium Formate + Sulfuric Acid -> Sodium Bisulfate + Formic Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SodiumFormate.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, SodiumBisulfate, 7)
                .fluidOutputs(FormicAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();

        //  Polydimethylsiloxane + Sodium + Formic Acid + Bromine + Water -> Sodium Hydroxide + Dibromoacrolein + Hydrogen
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, Polydimethylsiloxane)
                .input(dust, Sodium, 4)
                .fluidInputs(FormicAcid.getFluid(2000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, SodiumHydroxide, 12)
                .fluidOutputs(Dibromoacrolein.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[EV])
                .duration(360)
                .buildAndRegister();

        //  Sodium Thiosulfate + Dibromoacrolein + Chloroethane -> Salt + Sodium Bisulfate + Bromodihydrothiine
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumThiosulfate, 14)
                .fluidInputs(Dibromoacrolein.getFluid(1000))
                .fluidInputs(Chloroethane.getFluid(1000))
                .output(dust, Salt, 4)
                .output(dust, SodiumBisulfate, 14)
                .fluidOutputs(Bromodihydrothiine.getFluid(1000))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        //  Selenium + Buty Lithium -> Lithiumthiinediselenide + Bromobutane
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Selenium, 2)
                .fluidInputs(Bromodihydrothiine.getFluid(1000))
                .fluidInputs(ButylLithium.getFluid(2000))
                .output(dust, Lithiumthiinediselenide,14)
                .fluidOutputs(Bromobutane.getFluid(2000))
                .EUt(VA[LuV])
                .duration(340)
                .buildAndRegister();

        //  Scandium Triflate + Titanium Tetrachloride + Propadiene + Acetylene -> CTT + Hydrochloric Acid
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, ScandiumTriflate)
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(Propadiene.getFluid(2000))
                .fluidInputs(Acetylene.getFluid(2000))
                .output(dust, CyclopentadienylTitaniumTrichloride, 23)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[IV])
                .duration(260)
                .CasingTier(5)
                .buildAndRegister();

        //  CTT + Lithiumthiinediselenide + Tetrafluoroethylene -> BETS + LithiumFluoride
        ROASTER_RECIPES.recipeBuilder()
                .notConsumable(dust, CyclopentadienylTitaniumTrichloride, 1)
                .input(dust, Lithiumthiinediselenide, 28)
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .output(dust, Bisethylenedithiotetraselenafulvalene, 26)
                .output(dust, LithiumFluoride, 8)
                .EUt(VA[UHV])
                .duration(800)
                .temperature(2500)
                .buildAndRegister();

        //  BETS + Ammonium Perrhenate -> BETS Perrhenate
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Bisethylenedithiotetraselenafulvalene)
                .fluidInputs(AmmoniumPerrhenate.getFluid(1000))
                .output(dust, BETSPerrhenate)
                .blastFurnaceTemp(5000)
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  New Barium Sulfide recipe
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Sulfur)
                .input(dust, Barium)
                .output(dust, BariumSulfide)
                .EUt(VA[MV])
                .duration(160)
                .temperature(488)
                .buildAndRegister();
    }

    private static void LanthanumFullereneNanotubeChain() {

        //  Lanthanum-Fullerene Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Lanthanum, 2)
                .input(dust, GeodesicPolyarene, 2)
                .output(dust, LanthanumFullereneMixture, 4)
                .EUt(VA[LuV])
                .duration(140)
                .buildAndRegister();

        //  Lanthanum-Fullerene Mixture + Nitrogen -> Lanthanum Embedded Fullerene
        LASER_CVD_RECIPES.recipeBuilder()
                .notConsumable(plate, MagnetoResonatic)
                .input(dust, LanthanumFullereneMixture, 4)
                .fluidInputs(Nitrogen.getFluid(20000))
                .output(dust, LanthanumEmbeddedFullerene, 4)
                .fluidOutputs(Ammonia.getFluid(20000))
                .EUt(VA[UHV])
                .duration(320)
                .temperature(4982)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Lanthanum Embedded Fullerene -> Lanthanum Fullerene Nanotube
        PLASMA_CVD_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .input(dust, LanthanumEmbeddedFullerene)
                .fluidInputs(Acetylene.getFluid(3000))
                .fluidInputs(Cycloparaphenylene.getFluid(7000))
                .fluidInputs(Nitrogen.getPlasma(10000))
                .output(ingot, LanthanumFullereneNanotube)
                .fluidOutputs(Ammonia.getFluid(10000))
                .temperature(3496)
                .duration(1200)
                .EUt(VA[UEV])
                .buildAndRegister();
    }

    private static void ActiniumSuperhydrideChain() {

        //  Glucose and Fructos
        //  TODO Bio Reactor Recipe?
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Sugar, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Glucose, 24)
                .output(dust, Fructose, 24)
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();

        //  Glucose + Oxygen -> Oxalic Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Glucose, 24)
                .notConsumable(dust, Vanadium)
                .fluidInputs(Oxygen.getFluid(9000))
                .fluidOutputs(OxalicAcid.getFluid(3000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Oxalic Acid + Oxygen + Actinium -> Actinium Oxalate
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Actinium)
                .fluidInputs(OxalicAcid.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, ActiniumOxalate, 13)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[LuV])
                .duration(180)
                .buildAndRegister();

        //  Actinium Oxalate -> Actinium Hydride
        BLAST_RECIPES.recipeBuilder()
                .input(dust, ActiniumOxalate, 13)
                .input(dust, Lithium, 13)
                .input(dust, LithiumHydride, 6)
                .fluidInputs(CarbonTetrachloride.getFluid(4000))
                .output(dust, ActiniumHydride, 4)
                .output(dust, LithiumChloride, 32)
                .fluidOutputs(CarbonDioxide.getFluid(8000))
                .EUt(VA[MV])
                .duration(540)
                .blastFurnaceTemp(11700)
                .buildAndRegister();

        //  Back to Stellar Furnace and Plasma Condenser
    }

    private static void BoronFranciumMixtureChain() {
        //  Francium Carbide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Francium, 2)
                .fluidInputs(Acetylene.getFluid(1000))
                .output(dust, FranciumCarbide, 4)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[HV])
                .duration(260)
                .buildAndRegister();

        //  Boron-Francium Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, FranciumCarbide, 2)
                .input(dust, CubicBoronNitride)
                .input(dust, AmorphousBoronNitride)
                .output(dust, BoronFranciumMixture, 4)
                .EUt(VA[UHV])
                .duration(160)
                .buildAndRegister();
    }
}
