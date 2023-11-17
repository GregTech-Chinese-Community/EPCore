package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.core.unification.material.internal.MaterialRegistryManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collection;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class EPOverrideRecipes {
    public static void init() {
        VanillaOverrideRecipes();
        GTOverrideRecipes();
    }

    private static void VanillaOverrideRecipes() {
        //  Iron bucket
        ModHandler.removeRecipeByName("gregtech:iron_bucket");
        ModHandler.addShapedRecipe("iron_bucket", new ItemStack(Items.BUCKET),
                "ChC", " P ",
                'C', new UnificationEntry(plateCurved, Iron),
                'P', new UnificationEntry(plate, Iron));

        //  Hopper
        ModHandler.removeRecipeByName("gregtech:hopper");
        ModHandler.addShapedRecipe("hopper", new ItemStack(Blocks.HOPPER),
                "UCU", "UGU", "wPh",
                'U', new UnificationEntry(plateCurved, Iron),
                'C', "chestWood",
                'G', new UnificationEntry(gearSmall, Iron),
                'P', new UnificationEntry(plate, Iron));

        //  Cauldron
        ModHandler.removeRecipeByName("gregtech:cauldron");
        ModHandler.addShapedRecipe("cauldron", new ItemStack(Items.CAULDRON),
                "C C", "ChC", "CPC",
                'C', new UnificationEntry(plateCurved, Iron),
                'P', new UnificationEntry(plate, Iron));

        //  Compass
        ModHandler.removeRecipeByName("minecraft:compass");
        ModHandler.addShapedRecipe("compass", new ItemStack(Items.COMPASS),
                " C ", "CRC", " C ",
                'C', new UnificationEntry(plateCurved, Iron),
                'R', new UnificationEntry(bolt, RedAlloy));

        //  Clock
        ModHandler.removeRecipeByName("minecraft:clock");
        ModHandler.addShapedRecipe("clock", new ItemStack(Items.CLOCK),
                " C ", "CRC", " C ",
                'C', new UnificationEntry(plateCurved, Gold),
                'R', new UnificationEntry(bolt, RedAlloy));

        //  Fishing Rod
        ModHandler.removeRecipeByName("minecraft:fishing_rod");
        ModHandler.addShapedRecipe("fishing_rod", new ItemStack(Items.FISHING_ROD),
                "  R", " RS", "R I",
                'R', new UnificationEntry(stickLong, Wood),
                'S', "string",
                'I', new UnificationEntry(ring, Iron));

        //  Shears
        ModHandler.removeRecipeByName("minecraft:shears");
        ModHandler.addShapedRecipe("shears", new ItemStack(Items.SHEARS),
                "PSP", "hRf", "XsX",
                'P', new UnificationEntry(plate, Iron),
                'S', new UnificationEntry(screw, Iron),
                'R', new UnificationEntry(ring, Iron),
                'X', new UnificationEntry(stick, Wood));

        //  Tool Override Recipe
        Collection<Material> list = MaterialRegistryManager.getInstance().getRegisteredMaterials();
        for (Material material : list) {
            if (material.hasFlag(MaterialFlags.GENERATE_FOIL) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.removeRecipeByName(String.format("gregtech:foil_%s", material));
            }
            if (material.hasFlag(MaterialFlags.GENERATE_RING) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.removeRecipeByName(String.format("gregtech:ring_%s", material));
            }
            if (material.hasFlag(MaterialFlags.GENERATE_SPRING) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.removeRecipeByName(String.format("gregtech:spring_%s", material));
            }
            if (material.hasFlag(MaterialFlags.GENERATE_SPRING_SMALL) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
                ModHandler.removeRecipeByName(String.format("gregtech:spring_small_%s", material));
            }
            if (material.hasFlag(MaterialFlags.GENERATE_ROTOR) && !material.hasFlag(MaterialFlags.NO_SMASHING))  {
                ModHandler.removeRecipeByName(String.format("gregtech:rotor_%s", material));
            }
        }
    }

    private static void GTOverrideRecipes() {
        NeutroniumWaferOverride();
        NewRubberOverride();
        EnergyHatchOverride();
    }

    private static void NeutroniumWaferOverride() {
        //  Neutronium Boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 32),
                        OreDictUnifier.get(ingot, Neutronium, 4),
                        OreDictUnifier.get(dust, GalliumArsenide, 2)},
                new FluidStack[]{Xenon.getFluid(8000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Water.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{DistilledWater.getFluid(750)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Lubricant.getFluid(250)});

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.GRAPHITE_CRUCIBLE))
                .input(block, SolarGradeSilicon, 32)
                .input(ingot, Dubnium, 4)
                .input(dust, GalliumArsenide, 2)
                .fluidInputs(Xenon.getFluid(8000))
                .output(DUBNIUM_BOULE)
                .blastFurnaceTemp(6484)
                .EUt(VA[IV])
                .duration(18000)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.BORON_NITRIDE_CRUCIBLE))
                .input(block, SolarGradeSilicon, 64)
                .input(ingot, Neutronium, 8)
                .input(dust, GalliumArsenide, 4)
                .fluidInputs(Radon.getFluid(8000))
                .output(NEUTRONIUM_BOULE)
                .blastFurnaceTemp(8864)
                .EUt(VA[LuV])
                .duration(21000)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(3600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(2400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(6400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(3200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Red: Integrated Logic Circuit Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Red));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Green: RAM Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Green));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Light Blue: CPU Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, LightBlue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Blue: ULPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Blue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Orange: LPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Orange));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cyan: Simple SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Cyan));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Gray: NAND Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Gray));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Pink: NOR Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Pink));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Brown: PIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Brown));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Yellow: SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Yellow));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Purple: ASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Purple));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Black: HASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Black));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  UHASoC
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(lens, MagnetoResonatic)
                .output(UHASOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Water.getFluid(1000))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1800)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1350)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Lubricant.getFluid(250))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(900)
                .buildAndRegister();
    }

    private static void NewRubberOverride() {

        //  Conveyor Module Recipes
        ModHandler.addShapedRecipe(true, "conveyor_module_lv_nitrile_butadiene_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "conveyor_module_lv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tin)
                    .input(ELECTRIC_MOTOR_LV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_nitrile_butadiene_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Copper)
                    .input(ELECTRIC_MOTOR_MV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_nitrile_butadiene_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Gold)
                    .input(ELECTRIC_MOTOR_HV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_nitrile_butadiene_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Aluminium)
                    .input(ELECTRIC_MOTOR_EV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_nitrile_butadiene_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tungsten)
                    .input(ELECTRIC_MOTOR_EV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        //  TODO LuV-UV

        //  Electric Pump Recipes
        ModHandler.addShapedRecipe(true, "electric_pump_lv_nitrile_butadiene_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "electric_pump_lv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_mv_nitrile_butadiene_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "electric_pump_mv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_hv_nitrile_butadiene_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "electric_pump_hv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_ev_nitrile_butadiene_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "electric_pump_ev_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_iv_nitrile_butadiene_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "electric_pump_iv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  TODO LuV-UV

    }

    private static void EnergyHatchOverride() {

        //  1A UHV Energy Input Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(),
                                OreDictUnifier.get(cableGtSingle, Europium, 4),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                                OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                                 SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .duration(1000)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  1A UEV Energy Input Hatch
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UEV])
                .input(cableGtSingle, CarbonNanotube, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(VOLTAGE_COIL_UEV, 2)
                .fluidInputs(SodiumPotassium.getFluid(14000))
                .fluidInputs(SolderingAlloy.getFluid(11520))
                .output(ENERGY_INPUT_HATCH[UEV])
                .duration(1200)
                .EUt(VA[UEV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UHV].getStackForm())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  1A UIV Energy Input Hatch
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UIV])
                .input(cableGtSingle, CosmicNeutronium, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(VOLTAGE_COIL_UIV, 2)
                .fluidInputs(SodiumPotassium.getFluid(16000))
                .fluidInputs(SolderingAlloy.getFluid(23040))
                .output(ENERGY_INPUT_HATCH[UIV])
                .duration(1400)
                .EUt(VA[UIV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UEV].getStackForm())
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  TODO 1A UXV Energy Input Hatch

        //  TODO 1A OpV Energy Input Hatch

        //  4A UHV Energy Input Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{TRANSFORMER[UHV].getStackForm(),
                                ENERGY_INPUT_HATCH[UHV].getStackForm(),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate),
                                OreDictUnifier.get(wireGtQuadruple, Europium, 2)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH[UHV])
                .input(NANO_PIC_CHIP)
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtQuadruple, Europium, 2)
                .output(ENERGY_INPUT_HATCH_4A[5])
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  4A UEV Energy Input Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UEV])
                .input(ENERGY_INPUT_HATCH[UEV])
                .input(PICO_PIC_CHIP)
                .input(wireGtQuadruple, CarbonNanotube, 2)
                .output(INPUT_ENERGY_HATCH_4A[0])
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  4A UIV Energy Input Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UIV])
                .input(ENERGY_INPUT_HATCH[UIV])
                .input(PICO_PIC_CHIP)
                .input(wireGtQuadruple, CosmicNeutronium, 2)
                .output(INPUT_ENERGY_HATCH_4A[1])
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  TODO 4A UXV Energy Hatch
        /*
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UXV])
                .input(ENERGY_INPUT_HATCH[UXV])
                .input(FEMTO_PIC_CHIP)
                .input(wireGtQuadruple, ... , 2)
                .output(INPUT_ENERGY_HATCH_4A[2])
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();
         */

        //  TODO 4A OpV Energy Hatch
        /*
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[OpV])
                .input(ENERGY_INPUT_HATCH[OpV])
                .input(ATTO_PIC_CHIP)
                .input(wireGtQuadruple, ... , 2)
                .output(INPUT_ENERGY_HATCH_4A[3])
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();
         */

        //  16A UHV Energy Input Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{ENERGY_INPUT_HATCH_4A[5].getStackForm(2),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate),
                                OreDictUnifier.get(wireGtOctal, Europium, 2)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_4A[5])
                .input(NANO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UHV)
                .input(cableGtOctal, Europium, 2)
                .output(ENERGY_INPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  16A UEV Energy Input Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UEV])
                .input(INPUT_ENERGY_HATCH_4A[0])
                .input(PICO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UEV)
                .input(cableGtOctal, CarbonNanotube, 2)
                .output(INPUT_ENERGY_HATCH_16A[0])
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  16A UIV Energy Input Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UIV])
                .input(INPUT_ENERGY_HATCH_4A[1])
                .input(PICO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UIV)
                .input(cableGtOctal, CosmicNeutronium, 2)
                .output(INPUT_ENERGY_HATCH_16A[1])
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  TODO 16A UXV Energy Input Hatch

        //  TODO 16A OpV Energy Input Hatch

        //  1A UHV Energy Output Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(),
                                OreDictUnifier.get(spring, Europium, 4),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                                OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                                 SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(spring, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .duration(1000)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  1A UEV Energy Output Hatch
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UEV])
                .input(spring, PedotTMA, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(VOLTAGE_COIL_UEV, 2)
                .fluidInputs(SodiumPotassium.getFluid(14000))
                .fluidInputs(SolderingAlloy.getFluid(11520))
                .output(ENERGY_OUTPUT_HATCH[UEV])
                .duration(1200)
                .EUt(VA[UEV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UHV].getStackForm())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  1A UIV Energy Output Hatch
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UIV])
                .input(spring, RutheniumTriniumAmericiumNeutronate, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(VOLTAGE_COIL_UIV, 2)
                .fluidInputs(SodiumPotassium.getFluid(16000))
                .fluidInputs(SolderingAlloy.getFluid(23040))
                .output(ENERGY_OUTPUT_HATCH[UIV])
                .duration(1400)
                .EUt(VA[UIV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UEV].getStackForm())
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  TODO 1A UXV Energy Output Hathc

        //  TODO 1A OpV Energy Output Hatch

        //  4A UHV Energy Output Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{ENERGY_OUTPUT_HATCH[UHV].getStackForm(2),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate),
                                OreDictUnifier.get(wireGtQuadruple, Europium, 2)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH[UHV])
                .input(NANO_PIC_CHIP)
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtQuadruple, Europium, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[5])
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  4A UEV Energy Output Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UEV])
                .input(ENERGY_OUTPUT_HATCH[UEV])
                .input(PICO_PIC_CHIP)
                .input(VOLTAGE_COIL_UEV)
                .input(wireGtQuadruple, CarbonNanotube, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[3])
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  4A UIV Energy Output Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UIV])
                .input(ENERGY_OUTPUT_HATCH[UIV])
                .input(PICO_PIC_CHIP)
                .input(VOLTAGE_COIL_UIV)
                .input(wireGtQuadruple, CosmicNeutronium, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[4])
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  TODO 4A UXV Energy Output Hatch

        //  TODO 4A OpV Energy Output Hatch

        //  16A UHV Energy Output Hatch
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{ENERGY_OUTPUT_HATCH_4A[5].getStackForm(2),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate),
                                OreDictUnifier.get(wireGtOctal, Europium, 2)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_4A[5])
                .input(NANO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtOctal, Europium, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  16A UEV Energy Output Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UEV])
                .input(OUTPUT_ENERGY_HATCH_4A[3])
                .input(PICO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UEV)
                .input(wireGtOctal, CarbonNanotube, 2)
                .output(OUTPUT_ENERGY_HATCH_16A[4])
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  16A UIV Energy Output Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UIV])
                .input(OUTPUT_ENERGY_HATCH_4A[4])
                .input(PICO_PIC_CHIP, 2)
                .input(VOLTAGE_COIL_UIV)
                .input(wireGtOctal, CosmicNeutronium, 2)
                .output(OUTPUT_ENERGY_HATCH_16A[5])
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  TODO 16A UXV Energy Output Hatch

        //  TODO 16A OpV Energy Output Hatch


        //  TODO Other transformers...
    }
}
