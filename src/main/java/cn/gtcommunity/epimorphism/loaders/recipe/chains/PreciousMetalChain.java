package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PreciousMetalChain {
    public static void init() {

        //  Gold Primitive Blast recipe
        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(gem, Coal, 2)
                .output(nugget, Gold)
                .output(dustTiny, DarkAsh, 2)
                .duration(600)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(dust, Coal, 2)
                .output(nugget, Gold)
                .output(dustTiny, DarkAsh, 2)
                .duration(600)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(gem, Charcoal, 2)
                .output(nugget, Gold)
                .output(dustTiny, DarkAsh, 2)
                .duration(600)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(dust, Charcoal, 2)
                .output(nugget, Gold)
                .output(dustTiny, DarkAsh, 2)
                .duration(600)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(gem, Coke, 2)
                .output(nugget, Gold)
                .output(dustTiny, Ash, 2)
                .duration(300)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, PreciousMetal)
                .input(dust, Coke, 2)
                .output(nugget, Gold)
                .output(dustTiny, Ash, 2)
                .duration(300)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(block, PreciousMetal)
                .input(block, Coal, 2)
                .output(ingot, Gold)
                .output(dust, DarkAsh, 2)
                .duration(5400)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(block, PreciousMetal)
                .input(block, Charcoal, 2)
                .output(ingot, Gold)
                .output(dust, DarkAsh, 2)
                .duration(5400)
                .buildAndRegister();

        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                .input(block, PreciousMetal)
                .input(block, Coke, 2)
                .output(ingot, Gold)
                .output(dust, Ash, 2)
                .duration(5400)
                .buildAndRegister();

        //  Fix
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Gold, 2)},
                new FluidStack[]{HydrochloricAcid.getFluid(8000)});

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Gold, 2)},
                new FluidStack[]{HydrochloricAcid.getFluid(8000)});

        //  Gold Copper Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Copper, 3)
                .input(dust, PreciousMetal)
                .output(dust, GoldCopperMixture, 4)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  Nickel Copper Mixture (For Platinum group step1)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 3)
                .input(dust, PreciousMetal)
                .output(dust, GoldNickelMixture, 4)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  Gold Copper Mixture -> Leaching Gold + Nitrogen Dioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GoldCopperMixture, 4)
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, LeachingGold, 4)
                .fluidOutputs(NitrogenDioxide.getFluid(2000))
                .EUt(VA[LV])
                .duration(80)
                .buildAndRegister();

        //  Gold Nickel Mixture -> Leaching Nickel + Nitrogen Dioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GoldNickelMixture, 4)
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, LeachingNickel, 4)
                .fluidOutputs(NitrogenDioxide.getFluid(2000))
                .EUt(VA[LV])
                .duration(80)
                .buildAndRegister();

        //  Leaching Gold Electrolyzer recipe
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, LeachingGold, 4)
                .fluidInputs(Hydrogen.getFluid(1000))
                .output(dust, Copper, 3)
                .output(dustTiny, Gold, 8)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV])
                .duration(300)
                .buildAndRegister();

        //  Leaching Nickel Electrolyzer recipe
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, LeachingNickel, 4)
                .fluidInputs(Hydrogen.getFluid(1000))
                .output(dust, Nickel, 3)
                .output(dustTiny, Gold, 8)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV])
                .duration(300)
                .buildAndRegister();

        //  Leaching Gold -> Leaching Copper + Chloroauric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LeachingGold, 4)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, LeachingCopper, 4)
                .fluidOutputs(ChloroauricAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(80)
                .buildAndRegister();

        //  Potassium + Sulfur + Oxygen -> Potassium Metabisulfite
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Potassium, 2)
                .input(dust, Sulfur, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .circuitMeta(1)
                .output(dust, PotassiumMetabisulfite, 9)
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();

        //  Chloroauric Acid -> Gold + Water + Chlorine (recycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, PotassiumMetabisulfite)
                .fluidInputs(ChloroauricAcid.getFluid(1000))
                .output(dust, Gold, 2)
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .EUt(VA[LV])
                .duration(160)
                .buildAndRegister();

        //  Leaching Copper Dryer recipe
        DRYER_RECIPES.recipeBuilder()
                .input(dust, LeachingCopper, 4)
                .output(dust, Copper, 3)
                .output(dustSmall, Silver, 2)
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();

        //  Delete Platinum Group Step 1
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Chalcopyrite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Chalcocite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Bornite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Tetrahedrite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Pentlandite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Cooperite)},
                new FluidStack[]{NitricAcid.getFluid(100)});

        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Chalcopyrite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Chalcocite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Bornite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Tetrahedrite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Pentlandite)},
                new FluidStack[]{NitricAcid.getFluid(100)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(crushedPurified, Cooperite)},
                new FluidStack[]{NitricAcid.getFluid(100)});

        //  Platinum process Step 1: Leaching Copper/Nickel + Aqua Regia -> Platinum Group Sludge
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .input(dust, LeachingCopper, 4)
                .fluidInputs(AquaRegia.getFluid(100))
                .output(dust, PlatinumGroupSludge, 2)
                .fluidOutputs(SulfuricCopperSolution.getFluid(1000))
                .EUt(VA[HV])
                .duration(140)
                .buildAndRegister();

        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .input(dust, LeachingNickel, 4)
                .fluidInputs(AquaRegia.getFluid(100))
                .output(dust, PlatinumGroupSludge, 2)
                .fluidOutputs(SulfuricNickelSolution.getFluid(1000))
                .EUt(VA[HV])
                .duration(140)
                .buildAndRegister();

        //  Platinum process Step 2: Platinum Group Sludge -> Platinum Group Sludge Solution
        GTRecipeHandler.removeRecipesByInputs(CENTRIFUGE_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PlatinumGroupSludge, 6)},
                new FluidStack[]{AquaRegia.getFluid(1200)});

        DIGESTER_RECIPES.recipeBuilder()
                .input(dust, PlatinumGroupSludge)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(PlatinumGroupSludgeSolution.getFluid(1000))
                .EUt(VA[HV])
                .duration(450)
                .buildAndRegister();

        //  Platinum process Step 3: Platinum Group Sludge Solution + Ammonium Chloride -> Ammonium Hexachloro Platinum Group Sludge
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 4)
                .fluidInputs(PlatinumGroupSludgeSolution.getFluid(1000))
                .fluidOutputs(AmmoniumHexachloroPlatinumGroupSludge.getFluid(1000))
                .EUt(VA[EV])
                .duration(40)
                .buildAndRegister();

        //  Platinum process Step 4: Ammonium Hexachloro Platinum Group Sludge -> Precious Metal dust + Silicon Dioxide dust + Platinum Metal + Rarest Metal Mixture + Inert Metal Mixture
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumHexachloroPlatinumGroupSludge.getFluid(1000))
                .output(dust, PreciousMetal)
                .output(dust, SiliconDioxide)
                .output(dust, PlatinumMetal, 2)
                .chancedOutput(dustTiny, RarestMetalMixture, 3, 8500, 0)
                .chancedOutput(dustTiny, InertMetalMixture, 3, 9500, 0)
                .chancedOutput(dustTiny, PalladiumMetal, 6, 9500, 0)
                .EUt(VA[EV])
                .duration(500)
                .buildAndRegister();

        //  Platinum Chain Step 1: Platinum Metal -> Platinum Slag + Concentrate Platinum
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PlatinumMetal, 2)
                .fluidInputs(AquaRegia.getFluid(1000))
                .output(dustTiny, PlatinumSlag, 5)
                .output(dust, AmmoniumChloride, 2)
                .fluidOutputs(ConcentratePlatinum.getFluid(1000))
                .EUt(VA[LV])
                .duration(250)
                .buildAndRegister();

        //  Platinum Chain Step 2: Concentrate Platinum + Ammonium Chloride -> Crude Platinum + Platinum Raw + Palladium Rich Ammonia + Nitric Acid + Hydrogen
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ConcentratePlatinum.getFluid(2000))
                .fluidInputs(AmmoniumChloride.getFluid(200))
                .output(dustSmall, CrudePlatinum, 10)
                .output(dust, PlatinumRaw, 2)
                .fluidOutputs(PalladiumRichAmmonia.getFluid(200))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1200))
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        //  Palladium Rich Ammonia cycle
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PalladiumRichAmmonia.getFluid(1000))
                .output(dust, PalladiumRaw, 2)
                .chancedOutput(dustTiny, PalladiumMetal, 2, 1000, 500)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        //  Crude Platinum cycle
        SIFTER_RECIPES.recipeBuilder()
                .input(dust, CrudePlatinum)
                .output(dust, PlatinumRaw)
                .chancedOutput(dustSmall, AmmoniumChloride, 3, 2000, 1000)
                .chancedOutput(dustTiny, PlatinumMetal, 2, 1000, 500)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        //  Iridium-Osmium Chain Step1: Rarest Metal Mixture + Hydrochloric Acid -> Iridium Platinum Metal Dust + Acidic Osmium Solution
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, RarestMetalMixture, 7)},
                new FluidStack[]{HydrochloricAcid.getFluid(4000)});

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, RarestMetalMixture, 2)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, IridiumPlatinumMetalDust, 2)
                .fluidOutputs(AcidicOsmiumSolution.getFluid(2000))
                .EUt(VA[MV])
                .duration(100)
                .temperature(775)
                .buildAndRegister();

        //  Iridium Step 2: Iridium Platinum Metal -> Iridium Metal Residue + Platinum Metal + Palladium Metal
        SIFTER_RECIPES.recipeBuilder()
                .input(dust, IridiumPlatinumMetalDust, 2)
                .output(dust, IridiumMetalResidue)
                .output(dustTiny, PlatinumMetal, 4)
                .chancedOutput(dustTiny, PalladiumMetal, 2, 2000, 500)
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        //  Iridium Step 3: Iridium Metal Residue -> Iridium Dioxide + Platinum Sludge Residue
        GTRecipeHandler.removeRecipesByInputs(CENTRIFUGE_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, IridiumMetalResidue, 5)});

        BLAST_RECIPES.recipeBuilder()
                .input(dust, IridiumMetalResidue)
                .output(dust, IridiumDioxide, 6)
                .output(dust, PlatinumSludgeResidue, 5)
                .EUt(VA[MV])
                .duration(200)
                .blastFurnaceTemp(845)
                .buildAndRegister();

        //  Iridium Step 4: Iridium Dioxide + Hydrochloric Acid -> Acidic Iridium Solution
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, IridiumDioxide, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(AcidicIridiumSolution.getFluid(1000))
                .EUt(VA[LV])
                .duration(300)
                .buildAndRegister();

        //  Iridium Step 5: Acidic Iridium Solution + Ammonium Chloride -> Iridium Chloride + Ammonia + Water (recycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcidicIridiumSolution.getFluid(1000))
                .fluidInputs(AmmoniumChloride.getFluid(4000))
                .output(dust, IridiumChloride, 8)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        //  Iridium Step 6 back to electrolyzer recipe

        //  Delete osmium recipes
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, AcidicOsmiumSolution.getFluid(2000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLERY_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{AcidicOsmiumSolution.getFluid(400)});
        GTRecipeHandler.removeRecipesByInputs(DISTILLERY_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{AcidicOsmiumSolution.getFluid(400)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, OsmiumTetroxide, 5)},
                new FluidStack[]{Hydrogen.getFluid(8000)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, OsmiumTetroxide, 5)},
                new FluidStack[]{Hydrogen.getFluid(8000)});

        //  Osmium Step 1: Acidic Osmium Solution + Calcite -> Osmium Tetroxide + Calcium + Ash
        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(AcidicOsmiumSolution.getFluid(2000))
                .input(dust, Calcite, 20)
                .output(dust, OsmiumTetroxide, 5)
                .output(dust, Calcium, 4)
                .output(dust, Ash, 4)
                .EUt(VA[HV])
                .duration(100)
                .temperature(1145)
                .buildAndRegister();

        //  Osmium Step 2: Osmium Tetroxide + Thionyl Chloride -> Osmium Tetrachloride + Sulfur Trioxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, OsmiumTetroxide, 5)
                .fluidInputs(ThionylChloride.getFluid(2000))
                .output(dust, OsmiumTetrachloride, 5)
                .fluidOutputs(SulfurTrioxide.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        //  Osmium Step 3: back to electrolyzer recipe

        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});

        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES, RhodiumSulfate.getFluid(1000));

        //  Ruthenium-Rhodium Chain Step 1
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, InertMetalMixture, 6)
                .fluidInputs(CarbonTetrachloride.getFluid(2000))
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .output(dust, RutheniumChloride, 8)
                .fluidOutputs(RhodiumSulfate.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(Methane.getFluid(1000))
                .duration(100)
                .EUt(VA[EV])
                .CasingTier(4)
                .buildAndRegister();

        //  Sodium Peroxide
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, SodiumPeroxide, 2)
                .temperature(403)
                .duration(40)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Ruthenium Step 1: Ruthenium Chloride + Sodium Peroxide + Chlorine -> Ruthenium Tetroxide + Salt
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RutheniumChloride, 4)
                .input(dust, SodiumPeroxide, 8)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, RutheniumTetroxide, 5)
                .output(dust, Salt, 8)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Ruthenium Step 2: back to electrolyzer recipe

        //  Rhodium Step 1: Rhodium Sulfate + Water -> Rhodium Oxide + Sulfuric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RhodiumSulfate.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .output(dust, RhodiumOxide, 5)
                .fluidOutputs(SulfuricAcid.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Rhodium Step 2: back to electrolyzer recipe

        //  Delete Raw things
        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, PlatinumRaw, 3));
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});

        //  Raw Palladium -> Palladium
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumRaw, 3)
                .fluidInputs(FormicAcid.getFluid(1000))
                .output(dust, Palladium)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(250)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Raw Platinum -> Platinum
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PlatinumRaw, 3)
                .fluidInputs(FormicAcid.getFluid(1000))
                .output(dust, Platinum)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(250)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Palladium Metal -> Palladium Rich Ammonia
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumMetal, 2)
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(PalladiumRichAmmonia.getFluid(1000))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        //  Platinum Slag -> Raw Platinum + Raw Palladium
        SIFTER_RECIPES.recipeBuilder()
                .input(dust, PlatinumSlag)
                .output(dust, PlatinumRaw)
                .chancedOutput(dustTiny, PalladiumRaw, 2, 500, 500)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();
    }
}