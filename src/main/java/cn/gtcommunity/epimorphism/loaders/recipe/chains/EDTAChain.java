package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class EDTAChain {
    public static void init() {

        //  Ethylene + Chlorine + Iron (III) Chloride -> Dichloroethane
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .notConsumable(Iron3Chloride.getFluid(1))
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Copper Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, CopperChloride, 3)
                .EUt(VA[LV])
                .duration(40)
                .buildAndRegister();

        //  Ethylene + Hydrochloric Acid + Copper -> Dichloroethane + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .notConsumable(dust, CopperChloride)
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Dichloroethane -> Vinyl Chloride + Hydrochloric Acid
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .temperature(773)
                .duration(40)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Dichloroethane + Chlorine -> Trichloroethylene + Hydrogen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .circuitMeta(0)
                .fluidOutputs(Trichloroethylene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(3000))
                .temperature(400)
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Dichloroethane + Ammonia -> Ethylenediamine + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Ethylenediamine.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(80)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Silver + Methanol -> Formaldehyde + Hydrogen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, Silver)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .temperature(923)
                .duration(180)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Sodium + Ethylenediamine + Formaldehyde + Hydrogen Cyanide + Water -> TetrasodiumEDTA + Ammonia + Oxygen
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 4)
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(4000))
                .fluidInputs(HydrogenCyanide.getFluid(4000))
                .fluidInputs(Water.getFluid(4000))
                .circuitMeta(8)
                .output(dust, TetrasodiumEDTA)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .duration(120)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Tetrasodium EDTA + Hydrochloric Acid -> Ethylenediaminetetraacetic Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetrasodiumEDTA)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .output(dust, EthylenediaminetetraaceticAcid, 32)
                .output(dust, Salt, 8)
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();
    }
}
