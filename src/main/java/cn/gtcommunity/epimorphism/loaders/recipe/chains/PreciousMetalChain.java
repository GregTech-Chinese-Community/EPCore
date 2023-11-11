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

        //  Gold Copper Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Copper, 3)
                .input(dust, PreciousMetal)
                .output(dust, GoldCopperMixture, 4)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 3)
                .input(dust, PreciousMetal)
                .output(dust, GoldNickelMixture, 4)
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        //  Gold Copper Mixture -> Leaching Gold
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GoldCopperMixture, 4)
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, LeachingGold, 4)
                .fluidOutputs(NitrogenDioxide.getFluid(2000))
                .EUt(VA[LV])
                .duration(80)
                .buildAndRegister();

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

        //  Potassium Metabisulfite
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Potassium, 2)
                .input(dust, Sulfur, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .circuitMeta(1)
                .output(dust, PotassiumMetabisulfite, 9)
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();

        //  Chloroauric Acid -> Gold
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

        //  Delete Platinum Group Step1
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

        //  Platinum process Step1
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

        //  Platinum process Step2
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

        //  Platinum process Step3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 4)
                .fluidInputs(PlatinumGroupSludgeSolution.getFluid(1000))
                .fluidOutputs(AmmoniumHexachloroPlatinumGroupSludge.getFluid(1000))
                .EUt(VA[EV])
                .duration(40)
                .buildAndRegister();

        //  Platinum process Step4
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

        //  Platinum Chain Step1: Platinum Metal -> Platinum Slag + Concentrate Platinum
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PlatinumMetal, 2)
                .fluidInputs(AquaRegia.getFluid(1000))
                .output(dustTiny, PlatinumSlag, 5)
                .output(dust, AmmoniumChloride, 2)
                .fluidOutputs(ConcentratePlatinum.getFluid(1000))
                .EUt(VA[LV])
                .duration(250)
                .buildAndRegister();

        //  Platinum Chain Step2
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

        //  Ir-Os Chain
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

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, IridiumPlatinumMetalDust, 2)
                .output(dust, IridiumMetalResidue)
                .output(dustTiny, PlatinumMetal, 4)
                .chancedOutput(dustTiny, PalladiumMetal, 2, 2000, 500)
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        //  Ir Chain
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

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, IridiumDioxide, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(AcidicIridiumSolution.getFluid(1000))
                .EUt(VA[LV])
                .duration(300)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcidicIridiumSolution.getFluid(1000))
                .fluidInputs(AmmoniumChloride.getFluid(4000))
                .output(dust, IridiumChloride, 8)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, AcidicOsmiumSolution.getFluid(2000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLERY_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{AcidicOsmiumSolution.getFluid(400)});
        GTRecipeHandler.removeRecipesByInputs(DISTILLERY_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{AcidicOsmiumSolution.getFluid(400)});

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, OsmiumTetroxide, 5)
                .fluidInputs(ThionylChloride.getFluid(2000))
                .output(dust, OsmiumTetrachloride, 5)
                .fluidOutputs(SulfurTrioxide.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});

        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES, RhodiumSulfate.getFluid(1000));

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

        //  Ruthenium Chain Fin
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RutheniumChloride, 4)
                .input(dust, SodiumPeroxide, 8)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, RutheniumTetroxide, 5)
                .output(dust, Salt, 8)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Rhodium
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RhodiumSulfate.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .output(dust, RhodiumOxide, 5)
                .fluidOutputs(SulfuricAcid.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Delete Raw things
        GTRecipeHandler.removeRecipesByInputs(ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, PlatinumRaw, 3));
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumRaw, 3)
                .fluidInputs(FormicAcid.getFluid(1000))
                .output(dust, Palladium)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(250)
                .EUt(VA[LV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PlatinumRaw, 3)
                .fluidInputs(FormicAcid.getFluid(1000))
                .output(dust, Platinum)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(250)
                .EUt(VA[LV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumMetal, 2)
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(PalladiumRichAmmonia.getFluid(1000))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, PlatinumSlag)
                .output(dust, PlatinumRaw)
                .chancedOutput(dustTiny, PalladiumRaw, 2, 500, 500)
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();
    }
}