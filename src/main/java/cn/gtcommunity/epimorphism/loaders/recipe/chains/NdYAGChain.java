package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class NdYAGChain {
    public static void init() {
        //  Potassium Permanganate + Ammonia + Hydrogen Cyanide + Sulfuric Acid -> Manganese Sulfate + Potassium Sulfate + Ammonium Cyanate
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, PotassiumPermanganate, 12)
                .fluidInputs(Ammonia.getFluid(5000))
                .fluidInputs(HydrogenCyanide.getFluid(5000))
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .output(dust, ManganeseSulfate, 12)
                .output(dust, PotassiumSulfate, 7)
                .fluidOutputs(AmmoniumCyanate.getFluid(5000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[EV])
                .duration(800)
                .CasingTier(4)
                .buildAndRegister();

        //  Carbamide (HV): Ammonium Cyanate -> Carbamide
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumCyanate.getFluid(1000))
                .output(dust, Carbamide, 8)
                .EUt(VA[HV])
                .duration(320)
                .buildAndRegister();

        //  TODO Carbamide (IV): Carbon Dioxide + Ammonia --Chemical Reactor--> Ammonium Carbamate --Electric Blast Furnace--> Carbamide

        //  Yttrium Oxide + Neodymium Oxide -> Nd:Y
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, YttriumOxide, 45)
                .input(dust, NeodymiumOxide, 5)
                .output(dust, NeodymiumDopedYttriumOxide, 5)
                .EUt(VA[IV])
                .duration(220)
                .temperature(1880)
                .buildAndRegister();

        //  Zeolite + Butanol + Ammonia -> Tributylamine + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Zeolite)
                .fluidInputs(Butanol.getFluid(3000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(Tributylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[HV])
                .duration(140)
                .buildAndRegister();

        //  Alumina + Nitric Acid -> Aluminium Nitrate + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .fluidInputs(NitricAcid.getFluid(6000))
                .output(dust, AluminiumNitrate, 26)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[LV])
                .duration(190)
                .buildAndRegister();

        //  Aluminiuim Nitrate + Dichloromethane + Tributylamine -> Crude Alumina Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, AluminiumNitrate, 26)
                .fluidInputs(Dichloromethane.getFluid(1000))
                .fluidInputs(Tributylamine.getFluid(1000))
                .fluidOutputs(CrudeAluminaSolution.getFluid(1000))
                .EUt(VA[MV])
                .duration(280)
                .buildAndRegister();

        //  Crude Alumina Solution + Tributylamine + Hydrogen Peroxide -> Alumina Solution + Nitric Acid + Nitrogen Dioxide
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .fluidInputs(CrudeAluminaSolution.getFluid(1000))
                .fluidInputs(Tributylamine.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(AluminaSolution.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(2000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .EUt(VA[HV])
                .duration(210)
                .CasingTier(3)
                .buildAndRegister();

        //  Unprocessed Nd:YAG Solution
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Carbamide, 8)
                .input(dust, NeodymiumDopedYttriumOxide)
                .fluidInputs(AluminaSolution.getFluid(1000))
                .fluidOutputs(UnprocessedNdYAGSolution.getFluid(2000))
                .fluidOutputs(Tributylamine.getFluid(2000))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        //  Nd:YAG
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(UnprocessedNdYAGSolution.getFluid(1000))
                .output(gem, NdYAG)
                .fluidOutputs(Dichloromethane.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(550)
                .temperature(1884)
                .glassTier(9)
                .buildAndRegister();
    }
}
