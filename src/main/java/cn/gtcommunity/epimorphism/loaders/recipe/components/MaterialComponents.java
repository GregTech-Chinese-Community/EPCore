package cn.gtcommunity.epimorphism.loaders.recipe.components;

import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

public class MaterialComponents {
    public static void init() {
        WIRE_ELECTRIC.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtSingle, Trinium)}
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_QUAD.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtQuadruple, Europium)},
                {10, new UnificationEntry(OrePrefix.wireGtQuadruple, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_OCT.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtOctal, Europium)},
                {10, new UnificationEntry(OrePrefix.wireGtOctal, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_HEX.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtHex, Europium)},
                {10, new UnificationEntry(OrePrefix.wireGtHex, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE.appendIngredients(Stream.of(new Object[][]{
                {10, new UnificationEntry(cableGtSingle, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_QUAD.appendIngredients(Stream.of(new Object[][]{
                {10, new UnificationEntry(OrePrefix.cableGtQuadruple, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_OCT.appendIngredients(Stream.of(new Object[][]{
                {10, new UnificationEntry(OrePrefix.cableGtOctal, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_HEX.appendIngredients(Stream.of(new Object[][]{
                {10, new UnificationEntry(OrePrefix.cableGtHex, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_TIER_UP.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.cableGtSingle, CarbonNanotube)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtDouble, Trinium)},
                {10, new UnificationEntry(OrePrefix.wireGtDouble, Tritanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING_DOUBLE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.wireGtQuadruple, Trinium)},
                {10, new UnificationEntry(OrePrefix.wireGtQuadruple, Tritanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        HULL_PLATE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.plate, Polyetheretherketone)},
                {10, new UnificationEntry(OrePrefix.plate, Polyetheretherketone)},
                {11, new UnificationEntry(OrePrefix.plate, Kevlar)},
                {12, new UnificationEntry(OrePrefix.plate, Kevlar)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_DISTILLATION.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(OrePrefix.spring, Trinium)},
                {10, new UnificationEntry(OrePrefix.spring, Tritanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_ELECTROMAGNETIC.appendIngredients(Stream.of(new Object[][]{
                {5, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {6, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {7, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {8, new UnificationEntry(OrePrefix.stick, VanadiumGallium)},
                {9, new UnificationEntry(OrePrefix.stickLong, VanadiumGallium)},
                {10, new UnificationEntry(OrePrefix.stick, PedotTMA)},
                {11, new UnificationEntry(OrePrefix.stick, PedotTMA)},
                {12, new UnificationEntry(OrePrefix.stickLong, PedotTMA)},
                {13, new UnificationEntry(OrePrefix.stickLong, PedotTMA)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SAWBLADE.appendIngredients(Stream.of(new Object[][]{
                {9, new UnificationEntry(toolHeadBuzzSaw, CubicBoronNitride)}
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        POWER_COMPONENT.appendIngredients(Stream.of(new Object[][]{
                {8, EPMetaItems.NANO_PIC_CHIP},
                {9, EPMetaItems.NANO_PIC_CHIP},
                {10, EPMetaItems.PICO_PIC_CHIP},
                {11, EPMetaItems.PICO_PIC_CHIP},
                {12, EPMetaItems.FEMTO_PIC_CHIP},
                {13, EPMetaItems.ATTO_PIC_CHIP},
                {14, EPMetaItems.ZEPTO_PIC_CHIP},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        VOLTAGE_COIL.appendIngredients(Stream.of(new Object[][]{
                {9, EPMetaItems.VOLTAGE_COIL_UHV},
                {10, EPMetaItems.VOLTAGE_COIL_UEV},
                {11, EPMetaItems.VOLTAGE_COIL_UIV},
                {12, EPMetaItems.VOLTAGE_COIL_UXV},
                {13, EPMetaItems.VOLTAGE_COIL_OPV},
                {14, EPMetaItems.VOLTAGE_COIL_MAX},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
