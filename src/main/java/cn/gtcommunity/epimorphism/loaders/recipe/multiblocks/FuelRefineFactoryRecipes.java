package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class FuelRefineFactoryRecipes {
    public static void init() {

        //  Cetane Boosted Diesel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(Diesel.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidOutputs(CetaneBoostedDiesel.getFluid(6000))
                .EUt(VA[EV])
                .duration(20)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(BioDiesel.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidOutputs(CetaneBoostedDiesel.getFluid(6000))
                .EUt(VA[EV])
                .duration(20)
                .buildAndRegister();

        //  High Octane Gasoline
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(Gasoline.getFluid(1000))
                .fluidInputs(Octane.getFluid(1000))
                .fluidOutputs(HighOctaneGasoline.getFluid(6000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();

        //  Light Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .fluidInputs(Uranium235.getFluid(500))
                .fluidInputs(Nitrogen.getFluid(500))
                .fluidOutputs(LightNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, GalliumSulfide)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidOutputs(LightNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Medium Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(Uranium235.getFluid(500))
                .fluidInputs(Plutonium241.getFluid(500))
                .output(dust, Plutonium244)
                .fluidOutputs(MediumNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, IndiumPhosphide)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidOutputs(MediumNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Heavy Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .input(dust, Plutonium239)
                .fluidInputs(Nitrogen.getPlasma(500))
                .output(dust, Naquadah)
                .fluidOutputs(HeavyNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Trinium)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidOutputs(HeavyNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Light Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Gallium)
                .fluidInputs(LightNaquadahFuel.getFluid(12000))
                .fluidInputs(Krypton.getFluid(6000))
                .fluidOutputs(LightTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Medium Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Duranium)
                .fluidInputs(MediumNaquadahFuel.getFluid(12000))
                .fluidInputs(Xenon.getFluid(6000))
                .fluidOutputs(MediumTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Heavy Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Tritanium)
                .fluidInputs(HeavyNaquadahFuel.getFluid(12000))
                .fluidInputs(Radon.getFluid(6000))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Energetic Naquadria
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(NitrogenDioxide.getFluid(500))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Lutetium)
                .output(dust, Uranium238)
                .output(dust, Plutonium241)
                .output(dust, NaquadahEnriched)
                .fluidOutputs(EnergeticNaquadria.getFluid(1000))
                .duration(300)
                .EUt(65536)
                .buildAndRegister();

        //  Light Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Europium)
                .fluidInputs(LightTaraniumFuel.getFluid(500))
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(300))
                .fluidInputs(EnergeticNaquadria.getFluid(200))
                .fluidInputs(Uranium238.getFluid(L))
                .output(dust, Naquadah)
                .fluidOutputs(LightHyperFuel.getFluid(2000))
                .duration(460)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Medium Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Americium)
                .fluidInputs(MediumTaraniumFuel.getFluid(400))
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(350))
                .fluidInputs(EnergeticNaquadria.getFluid(250))
                .fluidInputs(Uranium235.getFluid(L))
                .output(dust, NaquadahEnriched)
                .fluidOutputs(MediumHyperFuel.getFluid(2000))
                .duration(520)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Heavy Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(HeavyTaraniumFuel.getFluid(300))
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidInputs(EnergeticNaquadria.getFluid(300))
                .fluidInputs(Plutonium239.getFluid(L))
                .output(dust, NaquadahEnriched)
                .fluidOutputs(HeavyHyperFuel.getFluid(2000))
                .duration(580)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Adamantium + Bedrock Gas + Sulfuric Acid -> Adamantium Enriched + Deep Iron + Naquadah + Osmium + Diluted Sulfuric Acid
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Adamantium, 10)
                .fluidInputs(BedrockGas.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(dust, AdamantiumEnriched)
                .output(dust, DeepIron, 5)
                .output(dust, Naquadah, 2)
                .output(dust, Osmium, 2)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(900))
                .duration(200)
                .EUt(VA[UHV])
                .buildAndRegister();
    }
}
