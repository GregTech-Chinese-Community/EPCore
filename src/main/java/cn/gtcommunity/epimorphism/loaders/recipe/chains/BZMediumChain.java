package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BZMediumChain {
    public static void init() {
        //  Potassium Bromate + Malonic Acid + Cerium + Distilled Water -> BZ Medium
        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotassiumBromate, 4)
                .input(dust, MalonicAcid, 3)
                .input(dust, Cerium)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(BZMedium.getFluid(1000))
                .duration(100)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Bromine + Potassium Hydroxide -> Potassium Bromate + Ice
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(3000))
                .fluidInputs(PotassiumHydroxide.getFluid(L * 9))
                .output(dust, PotassiumBromate, 5)
                .fluidOutputs(Ice.getFluid(3000))
                .temperature(273)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Rock Salt + Water -> Potassium Hydroxide + Chlorine + Hydrogen
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, PotassiumHydroxide, 3)
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .duration(720)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Bromine + Sulfur Dioxide + Water -> Sulfuric Acid + Hydrobromic Acid
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(2000))
                .duration(400)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Soda Ash + Chloroacetic Acid + Water -> Malonic Acid + Sodium Hydroxide + Hypochlorous Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, ChloroaceticAcid, 8)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, MalonicAcid, 11)
                .output(dust, SodiumHydroxide, 6)
                .fluidOutputs(HypochlorousAcid.getFluid(1000))
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Trichloroethylene + Water + Sulfuric Acid -> Chloroacetic Acid + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trichloroethylene.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .notConsumable(SulfuricAcid.getFluid(250))
                .output(dust, ChloroaceticAcid, 8)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
