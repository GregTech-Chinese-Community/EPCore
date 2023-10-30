package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.Material;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.util.GTUtility.gregtechId;

public class EPBiologicalMaterials {
    //  Range 25601-25800
    public static void register() {
        //  25401 Dry Red Algae
        DryRedAlgae = new Material.Builder(25601, gregtechId("dry_red_algae"))
                .dust()
                .color(0x880808)
                .build();
        //  25402 Red Algae
        RedAlgae = new Material.Builder(25602, gregtechId("red_algae"))
                .dust()
                .color(0xAA4A44)
                .build();
        //  25403 Dry Green Algae
        DryGreenAlgae = new Material.Builder(25603, gregtechId("dry_green_algae"))
                .dust()
                .color(0x4F7942)
                .build();
        //  25404 Green Algae
        GreenAlgae = new Material.Builder(25604, gregtechId("green_algae"))
                .dust()
                .color(0x5F8575)
                .build();
        //  25405 Dry Golden Algae
        DryGoldenAlgae = new Material.Builder(25605, gregtechId("dry_golden_algae"))
                .dust()
                .color(0xDAA520)
                .build();
        //  25406 Golden Algae
        GoldenAlgae = new Material.Builder(25606, gregtechId("golden_algae"))
                .dust()
                .color(0xEEDC82)
                .build();
        //  25407 Dry Brown Algae
        DryBrownAlgae = new Material.Builder(25607, gregtechId("dry_brown_algae"))
                .dust()
                .color(0x5C4033)
                .build();
        //  25408 Brown Algae
        BrownAlgae = new Material.Builder(25608, gregtechId("brown_algae"))
                .dust()
                .color(0x988558)
                .build();
    }
}
