package cn.gtcommunity.epimorphism.common.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraft.util.ResourceLocation;

public class EPMetaTileEntities {

    //  Range: 12300-13300
    private static <T extends MetaTileEntity> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMultiMetaTileEntity(id + 12300, mte);
    }

    public static void init() {}
}
