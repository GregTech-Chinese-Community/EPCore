package cn.gtcommunity.epimorphism.loaders.recipe.components;

import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import gregtech.api.unification.stack.UnificationEntry;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

public class MaterialComponents {
    public static void init() {
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
