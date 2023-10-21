package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GalliumNitrideChain {
    public static void init() {
        //  Aluminium + Sodium + Chloromethane -> Trimethylaluminium + Salt
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Aluminium)
                .input(dust, Sodium, 3)
                .fluidInputs(Chloromethane.getFluid(3000))
                .fluidOutputs(Trimethylaluminium.getFluid(500))
                .output(dust, Salt, 6)
                .duration(150)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Gallium + Chlorine -> Gallium Trichloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Gallium)
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, GalliumTrichloride, 4)
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Gallium Trichloride + Trimethylaluminium -> Aluminium Trichloride + Trimethylgallium
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GalliumTrichloride, 4)
                .fluidInputs(Trimethylaluminium.getFluid(500))
                .output(dust, AluminiumTrichloride, 4)
                .fluidOutputs(Trimethylgallium.getFluid(1000))
                .duration(300)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Aluminium Trichloride + Water -> Aluminium Hydroxide + Hydrochloric Acid
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AluminiumTrichloride, 4)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .duration(60)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Aluminium Hydroxide -> Alumina + Water
        DRYER_RECIPES.recipeBuilder()
                .input(dust, AluminiumHydroxide, 14)
                .output(dust, Alumina, 5)
                .fluidOutputs(Water.getFluid(3000))
                .duration(60)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Sapphire + Trimethylgallium + Water -> Gallium Trioxide + Methane
        CVD_RECIPES.recipeBuilder()
                .input(plate, Sapphire)
                .fluidInputs(Trimethylgallium.getFluid(2000))
                .fluidInputs(Water.getFluid(3000))
                .output(dust, GalliumTrioxide, 5)
                .fluidOutputs(Methane.getFluid(3000))
                .temperature(923)
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Gallium Trioxide + Ammonia -> Gallium Nitride (plate) + Steam
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(GalliumTrioxide.getFluid(L * 5))
                .fluidInputs(Ammonia.getFluid(2000))
                .output(plate, GalliumNitride, 2)
                .fluidOutputs(Steam.getFluid(3000))
                .temperature(1023)
                .duration(250)
                .EUt(VA[UHV])
                .buildAndRegister();
    }
}
