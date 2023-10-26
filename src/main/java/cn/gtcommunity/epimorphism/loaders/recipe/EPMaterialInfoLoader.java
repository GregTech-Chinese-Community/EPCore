package cn.gtcommunity.epimorphism.loaders.recipe;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.metatileentities.MetaTileEntities;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.blocks.MetaBlocks.MACHINE_CASING;

public class EPMaterialInfoLoader {
    public static void init() {
        OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV), new ItemMaterialInfo(
                new MaterialStack(Draconium, M * 8)));

        OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV), new ItemMaterialInfo(
                new MaterialStack(Neutronium, M * 8)));

        OreDictUnifier.registerOre(MetaTileEntities.HULL[9].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Draconium, M * 8),
                new MaterialStack(Europium, M),
                new MaterialStack(Polyetheretherketone, M * 2)));

        OreDictUnifier.registerOre(MetaTileEntities.HULL[10].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Neutronium, M * 8),
                new MaterialStack(CarbonNanotube, M),
                new MaterialStack(Polyetheretherketone, M * 2)));
    }
}
