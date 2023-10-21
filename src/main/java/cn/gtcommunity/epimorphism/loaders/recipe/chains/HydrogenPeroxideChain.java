package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class HydrogenPeroxideChain {
    public static void init() {
        //  Phthalic Acid -> Phthalic Anhydride + Water
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(PhthalicAcid.getFluid(1000))
                .output(dust, PhthalicAnhydride, 13)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Phthalic Anhydride + Ethylbenzene -> Ethylanthraquinone + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .fluidOutputs(Ethylanthraquinone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(1000)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Palladium + Ethylanthraquinon + Hydrogen -> Ethylanthrahydroquinone
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dustTiny, Palladium)
                .fluidInputs(Ethylanthraquinone.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidOutputs(Ethylanthrahydroquinone.getFluid(1000))
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Hydrogen Peroxide (EV): Ethylanthrahydroquinone + Oxygen -> Ethylanthraquinone + Hydrogen Peroxide
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylanthrahydroquinone.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(6000))
                .fluidOutputs(HydrogenPeroxide.getFluid(3000))
                .fluidOutputs(Ethylanthraquinone.getFluid(1000))
                .duration(40)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Hydrogen Peroxide (LuV): Platinum + Palladium on Carbon + Hydrogen + Oxygen -> Hydrogen Peroxide
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, Platinum)
                .notConsumable(dust, PalladiumOnCarbon)
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(HydrogenPeroxide.getFluid(1000))
                .CasingTier(5)
                .EUt(VA[LuV])
                .duration(400)
                .buildAndRegister();

        //  Hydrogen Peroxide (UV): Carbon Nanotube + Water -> Hydrogen Peroxide + Hydrogen
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .notConsumable(dust, CarbonNanotube)
                .fluidInputs(Water.getFluid(12000))
                .fluidOutputs(HydrogenPeroxide.getFluid(6000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .CasingTier(5)
                .EUt(VA[UV])
                .duration(240)
                .buildAndRegister();
    }
}
