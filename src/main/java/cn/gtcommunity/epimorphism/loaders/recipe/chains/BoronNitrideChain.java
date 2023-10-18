package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class BoronNitrideChain {
    public static void init() {
        //  Borax + Hydrochloric Acid -> Boric Acid + Salt + Water
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Borax, 23)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, BoricAcid, 16)
                .output(dust, Salt, 4)
                .fluidOutputs(Water.getFluid(5000))
                .duration(300)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Boric Acid -> Boron Trioxide + Water
        DRYER_RECIPES.recipeBuilder()
                .input(dust, BoricAcid, 8)
                .output(dust, BoronTrioxide, 5)
                .fluidOutputs(Water.getFluid(3000))
                .duration(100)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Boric Acid + Hydrofluoric Acid -> Boron Trifluoride + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BoricAcid, 5)
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidOutputs(BoronTrifluoride.getFluid(2000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Lithium + Hydrogen -> Lithium Hydride
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Lithium)
                .fluidInputs(Hydrogen.getFluid(1000))
                .output(ingot, LithiumHydride)
                .temperature(873)
                .duration(300)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Lithium Hydride + Boron Trifluoride -> Lithium Tetrafluoroborate + Diborane
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 12)
                .fluidInputs(BoronTrifluoride.getFluid(8000))
                .output(dust, LithiumTetrafluoroborate, 36)
                .fluidOutputs(Diborane.getFluid(1000))
                .duration(640)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Lithium Tetrafluoroborate -> LithiumHydride + Boron Trifluoride
        DRYER_RECIPES.recipeBuilder()
                .input(dust, LithiumTetrafluoroborate, 6)
                .output(ingot, LithiumHydride, 2)
                .fluidOutputs(BoronTrifluoride.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Diborane + Ammonia -> Borazine + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Diborane.getFluid(3000))
                .fluidInputs(Ammonia.getFluid(6000))
                .fluidOutputs(Borazine.getFluid(2000))
                .fluidOutputs(Hydrogen.getFluid(24000))
                .duration(400)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Boron Trioxide + Carbon dust + Chlorine -> Boron Trichloride + Carbon Monoxide
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BoronTrioxide, 5)
                .input(dust, Carbon, 3)
                .fluidInputs(Chlorine.getFluid(6000))
                .fluidOutputs(BoronTrichloride.getFluid(2000))
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .temperature(774)
                .duration(90)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Ammonium Chloride + Boron Trichloride -> Trichloroborazine + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 6)
                .fluidInputs(BoronTrichloride.getFluid(3000))
                .fluidOutputs(Trichloroborazine.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(9000))
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        //  UV Hexagonal Boron Nitride: Borazine + Oxygen -> Hexagonal Boron Nitride + Water
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(Borazine.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .output(gem, HexagonalBoronNitride, 6)
                .fluidOutputs(Water.getFluid(3000))
                .duration(400)
                .EUt(VA[UV])
                .temperature(1300)
                .buildAndRegister();

        //  UEV Hexagonal Boron Nitride: Nickel + Boron + Nitrogen -> Hexagonal Boron Nitride
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(foil, Nickel, 8)
                .input(dust, Boron)
                .fluidInputs(Nitrogen.getFluid(1000))
                .output(gem, HexagonalBoronNitride, 2)
                .temperature(2900)
                .duration(80)
                .EUt(VA[UEV])
                .buildAndRegister();

        //  Hexagonal Boron Nitride -> Cubic Boron Nitride
        CVD_RECIPES.recipeBuilder()
                .input(dust, HexagonalBoronNitride)
                .output(gem, CubicBoronNitride)
                .duration(100)
                .EUt(VA[UV])
                .temperature(3501)
                .buildAndRegister();

        //  Caesium + Trichloroborazine -> Amorphous Boron Nitride + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .fluidInputs(Trichloroborazine.getFluid(1000))
                .output(dust, AmorphousBoronNitride, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .duration(200)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Cubic Boron Nitride + Carbon -> Heterodiamond
        IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, CubicBoronNitride)
                .input(dust, Carbon)
                .output(gem, Heterodiamond, 2)
                .explosivesAmount(32)
                .duration(20)
                .EUt(VA[LV])
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, CubicBoronNitride)
                .input(dust, Carbon)
                .output(gem, Heterodiamond, 2)
                .explosivesType(DYNAMITE.getStackForm(16))
                .duration(20)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Heterodiamond + Carbon -> Cubic Heterodiamond
        CVD_RECIPES.recipeBuilder()
                .input(dust, Heterodiamond)
                .input(dust, Carbon)
                .output(gem, CubicHeterodiamond)
                .duration(400)
                .EUt(VA[UHV])
                .temperature(2200)
                .buildAndRegister();
    }
}
