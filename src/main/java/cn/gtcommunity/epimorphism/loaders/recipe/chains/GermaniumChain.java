package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GermaniumChain {
    public static void init() {
        //  Sphalerite + Oxygen -> Roasted Sphalerite + Zinc Oxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Sphalerite, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .output(dust, RoastedSphalerite, 3)
                .output(dust, ZincOxide, 2)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .temperature(1773)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Roasted Sphalerite + Zinc -> Zinc Rich Sphalerite
        MIXER_RECIPES.recipeBuilder()
                .input(dust, RoastedSphalerite, 3)
                .input(dust, Zinc, 2)
                .output(dust, ZincRichSphalerite, 5)
                .duration(320)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Zinc Rich Sphalerite + Sulfuric Acid -> Waelz Oxide + Waelz Slag
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, ZincRichSphalerite, 5)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, WaelzOxide)
                .output(dust, WaelzSlag, 5)
                .duration(400)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Waelz Slag + Water -> Zinc Oxide + Gallium + Sulfuric Acid
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WaelzSlag, 5)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, ZincOxide, 2)
                .chancedOutput(dust, Gallium, 2000, 1000)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Waelz Oxide + Sulfuric Acid -> Impure Germanium Dioxide + Waelz Slag + Manganese
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WaelzOxide)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, ImpureGermaniumDioxide, 3)
                .output(dust, WaelzSlag, 5)
                .chancedOutput(dust, Manganese, 1000, 1000)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Impure Germanium Dioxide + Hydrochloric Acid -> Cadmium + Germanium Tetrachloride + Water
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ImpureGermaniumDioxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .chancedOutput(dust, Cadmium, 500, 1000)
                .fluidOutputs(GermaniumTetrachloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(300)
                .EUt(VA[HV])
                .temperature(244)
                .buildAndRegister();

        //  Germanium Tetrachloride + Water -> Germanium Dioxide + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, GermaniumDioxide, 3)
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Germanium Dioxide + Hydrochloric Acid -> Germanium Tetrachloride + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(GermaniumTetrachloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Germanium Dioxide + Hydrogen -> Germanium + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Germanium)
                .fluidOutputs(Water.getFluid(2000))
                .duration(240)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Germanium + Oxygen -> Germanium Dioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Germanium)
                .fluidInputs(Oxygen.getFluid(2000))
                .circuitMeta(2)
                .output(dust, GermaniumDioxide, 3)
                .duration(150)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
