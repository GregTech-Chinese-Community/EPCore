package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class SeleniumTelluriumChain {
    public static void init() {
        //  Blue Vitriol + Water -> Copper + Chalcogen Anode Mud + Sulfuric Acid + Oxygen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BlueVitriol.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .circuitMeta(3)
                .output(dust, Copper)
                .chancedOutput(dust, ChalcogenAnodeMud, 1000, 500)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(100)
                .EUt(60)
                .temperature(588)
                .buildAndRegister();

        //  Chalcogen Anode Mud -> Silver + Copper + Gold
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, ChalcogenAnodeMud)
                .output(dust, Silver)
                .chancedOutput(dust, Copper, 1000, 1000)
                .chancedOutput(dust, Gold, 750, 750)
                .duration(300)
                .EUt(64)
                .buildAndRegister();

        //  Chalcogen Anode Mud + Soda Ash + Oxygen -> Sodium Tellurite + Selenium Dioxide + Silver + Carbon Dioxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ChalcogenAnodeMud)
                .input(dust, SodaAsh, 6)
                .fluidInputs(Oxygen.getFluid(4000))
                .output(dust, SodiumTellurite, 6)
                .output(dust, SeleniumDioxide, 3)
                .output(ingot, Silver, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(600)
                .temperature(1900)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Sodium Tellurite + Water -> Tellurium Dioxide + Sodium Hydroxide
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, SodiumTellurite, 6)
                .fluidInputs(Water.getFluid(1000))
                .circuitMeta(2)
                .output(dust, TelluriumDioxide, 3)
                .output(dust, SodiumHydroxide, 6)
                .duration(400)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Tellurium Dioxide + Sulfur Dioxide + Water -> Tellurium + Sulfuric Acid + Sulfur Trioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TelluriumDioxide, 3)
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Tellurium)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(300)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Selenium Dioxide + Water -> Selenous Acid
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SeleniumDioxide, 3)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SelenousAcid, 6)
                .duration(400)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Selenous Acid + Sulfur Dioxide -> Selenium + Sulfuric Acid + Sulfur Trioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SelenousAcid, 6)
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .output(dust, Selenium)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(300)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
