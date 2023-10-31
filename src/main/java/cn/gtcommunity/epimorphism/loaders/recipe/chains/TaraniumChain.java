package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class TaraniumChain {
    public static void init() {
        //  Bedrock Smoke + Water -> Bedrock Soot Solution
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BedrockSmoke.getFluid(1000))
                .fluidInputs(CrudeNaquadahFuel.getFluid(1000))
                .fluidOutputs(BedrockSootSolution.getFluid(2000))
                .duration(600)
                .EUt(1024)
                .buildAndRegister();

        //  Bedrock Soot Solution + -> Platinum + Iridium + Naquadah + Clean Bedrock Solution
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockSootSolution.getFluid(4000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Iridium, 3, 1000, 0)
                .chancedOutput(dust, Naquadah, 1000, 0)
                .fluidOutputs(CleanBedrockSolution.getFluid(1000))
                .duration(600)
                .EUt(4096)
                .buildAndRegister();

        //  Clean Bedrock Solution -> Bedrock + Heavy Bedrock Smoke + Medium Bedrock Smoke + Light Bedrock Smoke + Ultralight Bedrock Smoke
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumBedrockSmoke.getFluid(320))
                .fluidOutputs(LightBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(90)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Heavy Bedrock Smoke -> Iridium + Bedrock + Heavy Taranium Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyTaraniumGas.getFluid(1000))
                .duration(200)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Medium Bedrock Smmoke -> Iridium + Bedrock + Medium Taranium Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 2)
                .fluidOutputs(MediumTaraniumGas.getFluid(1000))
                .duration(140)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Light Bedrock Smoke -> Iridium + Bedrock + Light Taranium Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock)
                .fluidOutputs(LightTaraniumGas.getFluid(1000))
                .duration(90)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ultralight Bedrock Smoke -> Iridium + Bedrock + Bedrock Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UltralightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .chancedOutput(dust, Bedrock, 3000, 0)
                .fluidOutputs(BedrockGas.getFluid(1000))
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fluorine + Heavy Taranium Gas -> Cracked Heavy Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(6000))
                .fluidInputs(HeavyTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyTaranium.getFluid(2000))
                .duration(300)
                .EUt(9216)
                .buildAndRegister();

        //  Fluorine + Medium Taranium Gas -> Cracked Medium Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(4000))
                .fluidInputs(MediumTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumTaranium.getFluid(1600))
                .duration(250)
                .EUt(9216)
                .buildAndRegister();

        //  Fluorine + Light Taranium Gas -> Cracked Light Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidInputs(LightTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightTaranium.getFluid(1200))
                .duration(200)
                .EUt(9216)
                .buildAndRegister();

        //  Cracked Heavy Taranium -> Taranium + Fluorine + Heavy Taranium Fuel + Medium Taranium Fuel + Light Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(250))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumTaraniumFuel.getFluid(200))
                .fluidOutputs(LightTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(600)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Cracked Medium Taranium -> Taranium + Fluorine + Heavy Taranium Fuel + Medium Taranium Fuel + Light Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(150))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumTaraniumFuel.getFluid(400))
                .fluidOutputs(LightTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(600)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Cracked Light Taranium -> Taranium + Fluorine + Heavy Taranium Fuel + Medium Taranium Fuel + Light Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(50))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumTaraniumFuel.getFluid(150))
                .fluidOutputs(LightTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(600)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Enriched Naquadah + Sulfuric Acid + Bedrock Soot Solution -> Enriched Bedrock Soot Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(AquaRegia.getFluid(900))
                .fluidInputs(BedrockSootSolution.getFluid(100))
                .fluidOutputs(EnrichedBedrockSootSolution.getFluid(1000))
                .duration(200)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Enriched Bedrock Soot Solution -> Platinum + Osmium + Enriched Naquadah + Clean Enriched Bedrock Solution
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedBedrockSootSolution.getFluid(2000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Osmium, 3, 1000, 0)
                .chancedOutput(dust, NaquadahEnriched, 1000, 0)
                .fluidOutputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .duration(300)
                .EUt(98304)
                .buildAndRegister();

        //  Clean Enriched Bedrock Solution -> Bedrock + Heavy Enriched Bedrock Smoke + Medium Enriched Bedrock Smoke + Light Enriched Bedrock Smoke
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 4)
                .fluidOutputs(HeavyEnrichedBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumEnrichedBedrockSmoke.getFluid(320))
                .fluidOutputs(LightEnrichedBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(140)
                .EUt(40960)
                .buildAndRegister();

        //  Heavy Enriched Bedrock Smoke -> Bedrock + Naquadria + Iridium + Osmium + Heavy Enriched Taranium Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 5)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(HeavyEnrichedTaraniumGas.getFluid(4000))
                .duration(1200)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Medium Enriched Bedrock Smoke -> Bedrock + Naquadria + Irridium + Osmium + Medium Enriched Taranium Gas
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 4)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(MediumEnrichedTaraniumGas.getFluid(4000))
                .duration(960)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Light Enriched Bedrock Smoke -> Bedrock + Naquadria + Iridium + Osmium
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 3)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(LightEnrichedTaraniumGas.getFluid(4000))
                .duration(600)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Radon + Heavy Enriched Taranium Gas -> Cracked Heavy Enriched Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(6000))
                .fluidInputs(HeavyEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyEnrichedTaranium.getFluid(2000))
                .duration(300)
                .EUt(49152)
                .buildAndRegister();

        //  Radon + Medium Enriched Taranium Gas -> Cracked Medium Enriched Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(4000))
                .fluidInputs(MediumEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumEnrichedTaranium.getFluid(1600))
                .duration(250)
                .EUt(49152)
                .buildAndRegister();

        //  Radon + Light Enriched Taranium Gas -> Cracked Light Enriched Taranium
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(2000))
                .fluidInputs(LightEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightEnrichedTaranium.getFluid(1200))
                .duration(200)
                .EUt(49152)
                .buildAndRegister();

        //  Cracked Heavy Enriched Taranium -> Taranium + Radon + Heavy Enriched Taranium Fuel + Medium Enriched Taraniium Fuel + Light Enriched Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(250))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(160)
                .EUt(98304)
                .buildAndRegister();

        //  Cracked Medium Enriched Taranium -> Taranium + Radon + Heavy Enriched Taranium Fuel + Medium Enriched Taraniium Fuel + Light Enriched Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(150))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(140)
                .EUt(98304)
                .buildAndRegister();

        //  Cracked Light Enriched Taranium -> Taranium + Radon + Heavy Enriched Taranium Fuel + Medium Enriched Taraniium Fuel + Light Enriched Taranium Fuel
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(50))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(150))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(120)
                .EUt(98304)
                .buildAndRegister();

        //  Bedrock Gas -> Bedrock + Helium-3
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockGas.getFluid(1000))
                .output(dust, Bedrock)
                .fluidOutputs(Helium3.getFluid(20))
                .duration(100)
                .EUt(1024)
                .buildAndRegister();

        //  Bedrock -> Adamantite + Monazite + Zirconium
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Bedrock)
                .chancedOutput(dust, Adamantite, 3000, 500)
                .chancedOutput(dust, Monazite, 2, 3000, 0)
                .chancedOutput(dust, Zirconium, 3, 3000, 0)
                .duration(120)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Adamantium + Naquadah -> Naquadah + Uranium-238 + Adamantium Unstable
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Adamantium, 4)
                .fluidInputs(Naquadah.getFluid(L * 4))
                .output(dust, Naquadah)
                .output(dust, Uranium238)
                .fluidOutputs(AdamantiumUnstable.getFluid(L * 4))
                .duration(800)
                .EUt(VA[LuV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Adamantium), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Adamantium), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(L))
                .output(ingotHot, Adamantium)
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FUSION_RECIPES, Americium.getFluid(128), Naquadria.getFluid(128));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Orichalcum), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Orichalcum), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        //  Orichalcum + Helium -> Orichalcum Energized
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(Helium.getPlasma(125))
                .output(dust, OrichalcumEnergized)
                .duration(200)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Orichalcum Energized dust -> Orichalcum hot ingot
        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .circuitMeta(1)
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(2000)
                .EUt(VA[UV])
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .circuitMeta(2)
                .fluidInputs(Argon.getFluid(50))
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(1000)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Gravistar
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES,
                new ItemStack[]{QUANTUM_STAR.getStackForm()},
                new FluidStack[]{Neutronium.getFluid(288)});

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .fluidInputs(Orichalcum.getFluid(288))
                .output(GRAVI_STAR)
                .EUt(7680)
                .duration(480)
                .buildAndRegister();

        //  Vibranium
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, DeepIron, 4)
                .output(dust, Iron, 2)
                .output(dust, Trinium)
                .output(dust, Indium)
                .duration(600)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Adamantium Enriched + Naquadah Enriched -> Naquadah Enriched + Plutonium-239 + Vibranium Unstable
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AdamantiumEnriched, 4)
                .fluidInputs(NaquadahEnriched.getFluid(L * 4))
                .output(dust, NaquadahEnriched, 2)
                .output(dust, Plutonium239)
                .fluidOutputs(VibraniumUnstable.getFluid(L * 4))
                .duration(1600)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Vibranium), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Vibranium), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(L))
                .output(ingotHot, Vibranium)
                .duration(400)
                .EUt(500000)
                .buildAndRegister();

        //  TODO Unstable Star for UEV-UIV Emitter/Sensor? May be use Vibranium or Adamantium
    }
}
