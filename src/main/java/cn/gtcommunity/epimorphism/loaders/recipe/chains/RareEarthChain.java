package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class RareEarthChain {
    public static void init() {
        //  Remove centrifuge recipe of Rare earth.
        GTRecipeHandler.removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, RareEarth));

        //  Butyraldehyde + Hydrogen -> Ethylhexanol + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .circuitMeta(0)
                .fluidOutputs(Ethylhexanol.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Ethylhexanol + Phosphorus Pentoxide ->  Di-(2-ethylhexyl)phosphoric Acid + Butane
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylhexanol.getFluid(5000))
                .input(dust, PhosphorusPentoxide, 7)
                .fluidOutputs(DiethylhexylPhosphoricAcid.getFluid(2000))
                .fluidOutputs(Butane.getFluid(2000))
                .duration(600)
                .EUt(16)
                .buildAndRegister();

        //  Rare Earth -> Crude Rare Earth Turbid Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, RareEarth)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(CrudeRareEarthTurbidSolution.getFluid(2000))
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Crude Rare Earth Turbid Solution + Nitric Acid -> Nitrated Rare Earth Turbid Solution
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CrudeRareEarthTurbidSolution.getFluid(2000))
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidOutputs(NitratedRareEarthTurbidSolution.getFluid(2000))
                .EUt(VA[EV])
                .duration(350)
                .buildAndRegister();

        //  Sodium Hydroxide + Di-(2-ethylhexyl)phosphoric Acid + Nitrated Rare Earth Turbid Solution -> Sodium Nitrate + Rare Earth Hydroxides Solution
        DIGESTER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(DiethylhexylPhosphoricAcid.getFluid(1000))
                .fluidInputs(NitratedRareEarthTurbidSolution.getFluid(2000))
                .output(dust, SodiumNitrate, 3)
                .fluidOutputs(RareEarthHydroxidesSolution.getFluid(1000))
                .duration(240)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Rare Earth Hydroxides Solution + Hydrochloric Acid -> Rare Earth Chorides Slurry + Steam
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthHydroxidesSolution.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, RareEarthChloridesSlurry, 4)
                .fluidOutputs(Steam.getFluid(600))
                .temperature(1125)
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Rare Earth Chorides Slurry (MV)
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, RareEarthChloridesSlurry, 4)
                .input(dust, SodiumBicarbonate, 8)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, Sodium, 4)
                .fluidOutputs(LowPurityRareEarthChloridesSolution.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .temperature(980)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        //  Rare Earth Chorides Slurry (HV)
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, RareEarthChloridesSlurry, 2)
                .input(dust, BariumCarbonate, 4)
                .fluidInputs(DistilledWater.getFluid(500))
                .output(dust, Barium, 2)
                .fluidOutputs(LowPurityRareEarthChloridesSolution.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .temperature(980)
                .EUt(VA[HV])
                .duration(600)
                .buildAndRegister();

        //  Low Purity Rare Earth Chlorides Solution + AquaRegia -> Roughly Purified Rare Earth Chlorides Solution
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(LowPurityRareEarthChloridesSolution.getFluid(4000))
                .fluidInputs(AquaRegia.getFluid(2000))
                .fluidOutputs(RoughlyPurifiedRareEarthChloridesSolution.getFluid(6000))
                .EUt(VA[EV])
                .duration(1200)
                .buildAndRegister();

        //  Roughly Purified Rare Earth Chlorides Solution -> High Purity Rare Earth Chlorides Slurry + Diluted Hydrochloric Acid
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(RoughlyPurifiedRareEarthChloridesSolution.getFluid(6000))
                .output(dust, HighPurityRareEarthChloridesSlurry, 3)
                .output(dust, LowPurityRareEarthChloridesSlag, 2)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(300)
                .buildAndRegister();

        //  High Purity Rare Earth Chlorides Slurry + Hydrochloric Acid -> High Purity Rare Earth Chlorides Solution
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .input(dust, HighPurityRareEarthChloridesSlurry)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(HighPurityRareEarthChloridesSolution.getFluid(1000))
                .EUt(VA[EV])
                .duration(600)
                .buildAndRegister();

        //  High Purity Rare Earth Chlorides Solution -> Neodymium Oxide
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HighPurityRareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(1)
                .output(dust, NeodymiumOxide)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(500))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  High Purity Rare Earth Chlorides Solution -> Cerium Oxide
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HighPurityRareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(2)
                .output(dust, CeriumOxide)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(300))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  High Purity Rare Earth Chlorides Solution -> Samarium Oxide
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HighPurityRareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(3)
                .output(dust, SamariumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(800))
                .duration(200)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Low Purity Rare Earth Chlorides Slag + Cobaltite -> Yttrium Oxide, Lanthanum Oxide
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LowPurityRareEarthChloridesSlag, 4)
                .input(dust, Cobaltite, 2)
                .output(dust, YttriumOxide)
                .output(dust, Sulfur, 2)
                .EUt(3840)
                .duration(300)
                .temperature(450)
                .buildAndRegister();

        //  Low Purity Rare Earth Chlorides Slag + Ferric Oxide -> Lanthanum Oxide + Oxygen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LowPurityRareEarthChloridesSlag, 4)
                .input(dust, FerricOxide, 2)
                .output(dust, LanthanumOxide)
                .fluidOutputs(Oxygen.getFluid(3000))
                .duration(300)
                .EUt(15360)
                .temperature(860)
                .buildAndRegister();

        //  Rare Earth UV recipe
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthHydroxidesSolution.getFluid(1000))
                .output(dustSmall, Thorium)
                .fluidOutputs(LaPrNdCeOxidesSolution.getFluid(250))
                .fluidOutputs(ScEuGdSmOxidesSolution.getFluid(250))
                .fluidOutputs(YTbDyHoOxidesSolution.getFluid(250))
                .fluidOutputs(ErTmYbLuOxidesSolution.getFluid(250))
                .fluidOutputs(Water.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(200)
                .EUt(VA[UV])
                .buildAndRegister();
    }
}
