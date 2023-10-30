package cn.gtcommunity.epimorphism.loaders.recipe;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

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
    }

    private static void GTOverrideRecipes() {
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

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 32)
                .input(ingot, Dubnium, 4)
                .input(dust, GalliumArsenide, 2)
                .fluidInputs(Xenon.getFluid(8000))
                .output(DUBNIUM_BOULE)
                .blastFurnaceTemp(6484)
                .EUt(VA[IV])
                .duration(18000)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 64)
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
    }
}
