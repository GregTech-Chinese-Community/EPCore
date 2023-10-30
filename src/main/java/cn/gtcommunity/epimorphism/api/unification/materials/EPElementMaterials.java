package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.EPElements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPElementMaterials {
    public static void register() {
        //  Range 26000-26100
        Draconium = new Material.Builder(26000, gregtechId("draconium"))
                .ingot()
                .fluid()
                .color(0xbe49ed)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .element(EPElements.Draconium)
                .toolStats(new ToolProperty(7.0F, 25.0F, 17000, 22))
                .blastTemp(10800, BlastProperty.GasTier.HIGHEST, VA[UHV])
                .build();
        AwakenedDraconium = new Material.Builder(26001, gregtechId("awakened_draconium"))
                .ingot()
                .fluid()
                .color(0xf58742)
                .iconSet(BRIGHT)
                .flags(NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .element(EPElements.AwakenedDraconium)
                .cableProperties(V[UHV], 16, 4)
                .build();
        ChaoticDraconium = new Material.Builder(26002, gregtechId("chaotic_draconium"))
                .ingot()
                .fluid()
                .color(0x2C195A)
                .iconSet(SHINY)
                .flags(NO_SMELTING)
                .element(EPElements.ChaoticDraconium)
                .cableProperties(V[UEV], 32, 16)
                .build();
        //  FIXME Pay attention to these materials, they are just foil (not foil in gregtech)!
        Orichalcum = new Material.Builder(26003, gregtechId("orichalcum"))
                .ingot()
                .fluid()
                .color(0x72A0C1)
                .iconSet(METALLIC)
                .element(EPElements.Orichalcum)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR)
                .blastTemp(9000, BlastProperty.GasTier.HIGH)
                .build();
        Vibranium = new Material.Builder(26004, gregtechId("vibranium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xC880FF)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE, GENERATE_FRAME)
                .element(EPElements.Vibranium)
                .blastTemp(4852, BlastProperty.GasTier.HIGH)
                .build();
        Adamantium = new Material.Builder(26005, gregtechId("adamantium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xFF0040)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND)
                .element(EPElements.Adamantium)
                .blastTemp(5225, BlastProperty.GasTier.HIGH)
                .build();
        Taranium = new Material.Builder(26006, gregtechId("taranium"))
                .ingot()
                .fluid()
                .color(0x4F404F)
                .iconSet(METALLIC)
                .element(EPElements.Taranium)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();
    }
}
