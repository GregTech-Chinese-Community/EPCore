package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PoloniumChain {
    public static void init() {

        //  Pitchblende + Nitric Acid -> Uranite + Polonium Nitrate
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .input(dust, Pitchblende, 5)
                .fluidInputs(NitricAcid.getFluid(4000))
                .output(dust, Uraninite, 3)
                .fluidOutputs(PoloniumNitrate.getFluid(1000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Polonium Nitrate + Chlorine -> Polonium Chloride + Oxygen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PoloniumNitrate.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, PoloniumChloride, 2)
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(VA[HV])
                .duration(200)
                .temperature(2866)
                .buildAndRegister();

        //  Polonium Chloride + Hydrogen -> Polonium + Diluted Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PoloniumChloride)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, Polonium)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();
    }
}
