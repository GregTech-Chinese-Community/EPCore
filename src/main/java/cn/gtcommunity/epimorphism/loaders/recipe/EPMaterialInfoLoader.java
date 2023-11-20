package cn.gtcommunity.epimorphism.loaders.recipe;

import cn.gtcommunity.epimorphism.common.blocks.*;
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
import static gregtech.common.items.MetaItems.*;

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

        //  UIV Machine Hull
        OreDictUnifier.registerOre(MetaTileEntities.HULL[11].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(NeutronStarCoreMaterial, M * 8),
                new MaterialStack(CosmicNeutronium, M),
                new MaterialStack(Kevlar, M * 2)));

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
                .input(wireFine, Mithril, 16)
                .circuitMeta(1)
                .output(VOLTAGE_COIL_UEV)
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        OreDictUnifier.registerOre(VOLTAGE_COIL_UEV.getStackForm(), new ItemMaterialInfo (
                new MaterialStack(ChromiumGermaniumTellurideMagnetic, M / 2),
                new MaterialStack(Mithril, M * 2)));

        //  PMMA Glass
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, PMMA, 4)
                .outputs(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS))
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS),
                new ItemMaterialInfo(new MaterialStack(PMMA, M * 4)));

        //  BPA Polycarbonate
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, BPAPolycarbonate, 4)
                .outputs(EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS))
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BPAPolycarbonate, M * 4)));

        //  CBDO Polycarbonate
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, CBDOPolycarbonate, 4)
                .outputs(EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS))
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_TRANSPARENT_CASING.getItemVariant(EPBlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(CBDOPolycarbonate, M * 4)));

        //  Boron Silicate Glass
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, BorosilicateGlass, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4)));

        //  Titanium-reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .input(plate, Titanium, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.TI_BORON_SILICATE_GLASS))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.TI_BORON_SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                                     new MaterialStack(Titanium, M * 4)));

        //  Tungsten-reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .input(plate, Tungsten, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.W_BORON_SILICATE_GLASS))
                .EUt(VA[EV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.W_BORON_SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                                     new MaterialStack(Tungsten, M * 4)));

        //  Thorium-reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .input(plate, Thorium, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.THY_BORON_SILICATE_GLASS))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.THY_BORON_SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                                     new MaterialStack(Thorium, M * 4)));

        //  Osmiridium-reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .input(plate, Osmiridium, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.OSMIR_BORON_SILICATE_GLASS))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.OSMIR_BORON_SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                                     new MaterialStack(Osmiridium, M * 4)));

        //  Naquadah-reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.SILICATE_GLASS))
                .input(plate, Naquadah, 4)
                .outputs(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.NAQ_BORON_SILICATE_GLASS))
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING.getItemVariant(EPBlockGlassCasing.CasingType.NAQ_BORON_SILICATE_GLASS),
                new ItemMaterialInfo(new MaterialStack(BorosilicateGlass, M * 4),
                                     new MaterialStack(Naquadah, M * 4)));

        //  Neutronium-reinforced PMMA Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.PMMA_GLASS))
                .input(plate, Neutronium, 4)
                .outputs(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.NEU_PMMA_GLASS))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_PMMA_CASING.getItemVariant(EPBlockPMMACasing.CasingType.NEU_PMMA_GLASS),
                new ItemMaterialInfo(new MaterialStack(PMMA, M * 4),
                                     new MaterialStack(Neutronium, M * 4)));

        //  Infinity Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, Infinity, 4)
                .notConsumable(SHAPE_MOLD_BLOCK)
                .outputs(EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.INFINITY_GLASS))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        OreDictUnifier.registerOre(EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.INFINITY_GLASS),
                new ItemMaterialInfo(new MaterialStack(Infinity, M * 4)));
    }
}