package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPFirstDegreeMaterials {
    //  Range 24000-24500
    public static void register() {
        //  24001 GrapheneOxide
        GrapheneOxide = new Material.Builder(24001, gregtechId("graphene_oxide"))
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();
        //  24002 Hydrazine
        Hydrazine = new Material.Builder(24002, gregtechId("hydrazine"))
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        //  24003 BerylliumOxide
        BerylliumOxide = new Material.Builder(24003, gregtechId("beryllium_oxide"))
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        //  24004 Hydrogen Peroxide
        HydrogenPeroxide = new Material.Builder(24004, gregtechId("hydrogen_peroxide"))
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();
    }
}
