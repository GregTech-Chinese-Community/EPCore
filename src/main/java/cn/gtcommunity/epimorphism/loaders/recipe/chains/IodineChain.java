package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class IodineChain {
    public static void init() {
        //  Saltpeter + Salt Water -> Potassium + Iodized Brine
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Saltpeter)
                .fluidInputs(SaltWater.getFluid(1000))
                .output(dust, Potassium)
                .fluidOutputs(IodizedBrine.getFluid(1000))
                .EUt(1280)
                .duration(240)
                .temperature(1128)
                .buildAndRegister();

        //  Iodized Brine + Chlorine -> Iodine Brine Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(IodizedBrine.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(300))
                .fluidOutputs(IodineBrineMixture.getFluid(1300))
                .EUt(480)
                .duration(240)
                .buildAndRegister();

        //  Iodine Brine Mixture -> Brominated Brine + Iodine Slurry
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(IodineBrineMixture.getFluid(1300))
                .fluidOutputs(BrominatedBrine.getFluid(1000))
                .fluidOutputs(IodineSlurry.getFluid(300))
                .EUt(980)
                .duration(120)
                .buildAndRegister();

        //  Iodine Slurry -> Iodine dust
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(IodineSlurry.getFluid(1200))
                .output(dust, Iodine)
                .EUt(1280)
                .duration(200)
                .buildAndRegister();

        //  SodiumIodate + Sodium Hypochlorite -> Sodium Periodate + Salt
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumIodate, 5)
                .input(dust, SodiumHypochlorite, 3)
                .output(dust, SodiumPeriodate, 6)
                .output(dust, Salt, 2)
                .temperature(1340)
                .EUt(1920)
                .duration(160)
                .buildAndRegister();

        //  Iodine dust + Sodium Hydroxide -> Sodium Iodate + Sodium Iodide + Water
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, Iodine, 6)
                .fluidInputs(SodiumHydroxide.getFluid(6000))
                .output(dust, SodiumIodate, 5)
                .output(dust, SodiumIodide, 10)
                .fluidOutputs(Water.getFluid(9000))
                .EUt(860)
                .duration(600)
                .buildAndRegister();
    }
}
