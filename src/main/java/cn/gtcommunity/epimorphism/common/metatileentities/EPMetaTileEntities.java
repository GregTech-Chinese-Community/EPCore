package cn.gtcommunity.epimorphism.common.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraft.util.ResourceLocation;

public class EPMetaTileEntities {
    private static ResourceLocation epId(String name) {
        return new ResourceLocation("epimorphism", name);
    }
    //  Need an id, and can sometimes use registerMetaTileEntity()
    /*
    private static <T extends MetaTileEntity> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMultiMetaTileEntity(id + <any number>, mte);
    }*/
    public static void init() {}
}
