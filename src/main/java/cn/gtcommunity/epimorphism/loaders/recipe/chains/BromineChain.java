package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class BromineChain {
    public static void init() {
        //  Brominated Brine + Sulfuric Acid -> Acidic Brominated Brine
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BrominatedBrine.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(AcidicBrominatedBrine.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        //  Acidic Brominated Brine + Sulfur Dioxide + Water -> Bromine Sulfate Solution + Salt Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcidicBrominatedBrine.getFluid(1000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .circuitMeta(3)
                .fluidOutputs(BromineSulfateSolution.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        //  Bromine Sulfate Solution + Steam -> Overheated Bromine Sulfate Solution
        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(BromineSulfateSolution.getFluid(2000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(OverheatedBromineSulfateSolution.getFluid(3000))
                .temperature(2250)
                .EUt(VA[HV])
                .duration(400)
                .buildAndRegister();

        //  Overheated Bromine Sulfate Solution
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(OverheatedBromineSulfateSolution.getFluid(3000))
                .fluidOutputs(WetBromine.getFluid(1000))
                .fluidOutputs(DebrominatedWater.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(280)
                .buildAndRegister();

        //  Wet Bromine -> Bromine
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(WetBromine.getFluid(1000))
                .fluidOutputs(Bromine.getFluid(1000))
                .EUt(360)
                .duration(80)
                .buildAndRegister();

        //  Debrominated Water -> Salt Water
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(DebrominatedWater.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(100))
                .EUt(360)
                .duration(80)
                .buildAndRegister();
    }
}
