package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;

public class EPSecondDegreeMaterials {
    // Range: 25401 - 25500
    private static int startId = 25401;
    private static final int END_ID = startId + 100;

    public static void init() {
        //  25401 Dragon Breath
        DragonBreath = new Material.Builder(getMaterialsId(), gregtechId("dragon_breath"))
                .fluid(FluidTypes.ACID)
                .color(0x9400D3)
                .build()
                .setFormula("Dc?", false);
        //  25402 Concentrate Dragon Breath
        ConcentrateDragonBreath = new Material.Builder(getMaterialsId(), gregtechId("concentrate_dragon_breath"))
                .fluid(FluidTypes.ACID)
                .color(0x9400D3)
                .build()
                .setFormula("Dc2?", true);
        //  25403 Dragon Blood
        DragonBlood = new Material.Builder(getMaterialsId(), gregtechId("dragon_blood"))
                .fluid()
                .color(0xDC2814)
                .iconSet(DULL)
                .build()
                .setFormula("*Dc*Rn?", true);
        //  25404 Dragon Tear
        DragonTear = new Material.Builder(getMaterialsId(), gregtechId("dragon_tear"))
                .fluid()
                .fluidTemp(2992)
                .color(0x9999FF)
                .iconSet(DULL)
                .build()
                .setFormula("⚙", false);
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
