package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CrystalCircuits {
    public static void init() {
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(craftingLens, Blue)
        );

        //  Cubic Zirconia + Europium -> Europium-doped Cubic Zirconia Boule
        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.GRAPHITE_CRUCIBLE))
                .input(dust, CubicZirconia, 64)
                .input(dust, Europium, 8)
                .blastFurnaceTemp(3000)
                .output(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Europium-doped Cubic Zirconia Boule -> Europium-doped Cubic Zirconia Wafer
        CUTTER_RECIPES.recipeBuilder()
                .input(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
                .output(CUBIC_ZIRCONIA_EUROPIUM_WAFER, 8)
                .duration(100)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Europium-doped Cubic Zirconia Wafer -> Crystal Interface Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(CUBIC_ZIRCONIA_EUROPIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CRYSTAL_INTERFACE_WAFER)
                .duration(20)
                .EUt(VA[LuV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal Interface Wafer -> Crystal Interface Chip
        CUTTER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_WAFER)
                .output(CRYSTAL_INTERFACE_CHIP, 8)
                .duration(100)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Sapphire Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Sapphire)
                .notConsumable(craftingLens, Blue)
                .output(SAPPHIRE_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ruby Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Ruby)
                .notConsumable(craftingLens, Red)
                .output(RUBY_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Diamond Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Diamond)
                .notConsumable(craftingLens, LightBlue)
                .output(DIAMOND_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Sapphire Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SAPPHIRE_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(SAPPHIRE_MODULATOR, 8)
                .solderMultiplier(1)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ruby Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(RUBY_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(RUBY_MODULATOR, 8)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Diamond Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(DIAMOND_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(DIAMOND_MODULATOR, 8)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal SoC Socket
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_CHIP)
                .input(SAPPHIRE_MODULATOR)
                .input(RUBY_MODULATOR)
                .input(DIAMOND_MODULATOR)
                .input(wireFine, Europium, 4)
                .output(CRYSTAL_SOC_SOCKET)
                .duration(100)
                .EUt(VA[LuV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal SoC
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(CRYSTAL_SOC_SOCKET)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .output(CRYSTAL_SYSTEM_ON_CHIP)
                .duration(100)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
