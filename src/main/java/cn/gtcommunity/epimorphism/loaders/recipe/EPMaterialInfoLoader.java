package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockPMMACasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.metatileentities.MetaTileEntities;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.MetaBlocks.*;

public class EPMaterialInfoLoader {
    public static void init() {
        //  UHV Machine Casing
        OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV), new ItemMaterialInfo(
                new MaterialStack(Draconium, M * 8)));

        //  UEV Machine Casing
        OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV), new ItemMaterialInfo(
                new MaterialStack(Neutronium, M * 8)));

        //  UHV Machine Hull
        OreDictUnifier.registerOre(MetaTileEntities.HULL[9].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Draconium, M * 8),
                new MaterialStack(Europium, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        //  UEV Machine Hull
        OreDictUnifier.registerOre(MetaTileEntities.HULL[10].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Neutronium, M * 8),
                new MaterialStack(CarbonNanotube, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        //  UHV Voltage Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, ChromiumGermaniumTellurideMagnetic)
                .input(wireFine, Vibranium, 16)
                .circuitMeta(1)
                .output(VOLTAGE_COIL_UHV)
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        OreDictUnifier.registerOre(VOLTAGE_COIL_UHV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Vibranium, M * 2)));

        //  UEV Voltage Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, ChromiumGermaniumTellurideMagnetic)
                .input(wireFine, Seaborgium, 16)
                .circuitMeta(1)
                .output(VOLTAGE_COIL_UEV)
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        OreDictUnifier.registerOre(VOLTAGE_COIL_UEV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Seaborgium, M * 2)));

        //  PMMA
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, PMMA, 4)
                .outputs(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS))
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS),
                new ItemMaterialInfo(new MaterialStack(PMMA, M * 4)));

        //  TODO other glass info
    }
}