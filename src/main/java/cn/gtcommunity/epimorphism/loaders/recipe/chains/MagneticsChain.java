package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class MagneticsChain {
    public static void init() {

        //  Tallium + Copper + Chlorine -> Thallium Copper Chloride
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(ThalliumCopperChloride.getFluid(L * 5))
                .blastFurnaceTemp(1570)
                .duration(700)
                .EUt(VA[EV])
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .circuitMeta(5)
                .output(dust, ThalliumCopperChloride, 5)
                .duration(350)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Plutonium-239 + Hydrogen -> Plutonium Trihydride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Plutonium239)
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, PlutoniumTrihydride, 4)
                .duration(60)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Plutonium Trihydride + Phosphine -> Plutonium Phosphide + Hydrogen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PlutoniumTrihydride, 4)
                .fluidInputs(Phosphine.getFluid(1000))
                .output(ingot, PlutoniumPhosphide, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(160)
                .EUt(VA[IV])
                .temperature(890)
                .buildAndRegister();

        //  Neptunium + Aluminium -> Neptunium Aluminide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Neptunium)
                .input(dust, Aluminium, 3)
                .output(dust, NeptuniumAluminide, 4)
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 3)
                .fluidInputs(Neptunium.getFluid(L))
                .circuitMeta(2)
                .fluidOutputs(NeptuniumAluminide.getFluid(L * 4))
                .EUt(VA[IV])
                .duration(3669)
                .blastFurnaceTemp(1568)
                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 3)
                .fluidInputs(Neptunium.getFluid(L))
                .fluidInputs(Neon.getFluid(100))
                .circuitMeta(12)
                .fluidOutputs(NeptuniumAluminide.getFluid(L * 4))
                .EUt(VA[IV])
                .duration(2458)
                .blastFurnaceTemp(1568)
                .buildAndRegister();

        //  Bismuth + Water -> Bismuth Trioxide + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 2)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, BismuthTrioxide, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(50)
                .EUt(60)
                .buildAndRegister();

        //  Ferric Oxide: Iron + Oxygen -> Ferric Oxide
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, FerricOxide)
                .duration(200)
                .EUt(8)
                .temperature(450)
                .buildAndRegister();

        //  Ferric Oxide (MV): Iron + Oxygen -> Ferric Oxide
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, FerricOxide, 5)
                .temperature(473)
                .duration(50)
                .EUt(120)
                .buildAndRegister();

        //  Bismuth Trioxide + Boron Trioxide + Distilled Water -> Bismuth Ferrite seed crystal
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, BismuthTrioxide, 20)
                .input(dust, BoronTrioxide, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, BismuthFerrite)
                .duration(1000)
                .EUt(VA[LuV])
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, BismuthFerrite)
                .output(plate, BismuthFerrite)
                .duration(400)
                .EUt(2)
                .buildAndRegister();
    }
}
