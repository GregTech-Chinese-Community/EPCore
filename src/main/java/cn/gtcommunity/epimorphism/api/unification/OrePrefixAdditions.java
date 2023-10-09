package cn.gtcommunity.epimorphism.api.unification;

import cn.gtcommunity.epimorphism.api.unification.ore.EPOrePrefix;
import gregtech.common.items.MetaItems;

public class OrePrefixAdditions {
    public static void init() {
        MetaItems.addOrePrefix(EPOrePrefix.coil);
        MetaItems.addOrePrefix(EPOrePrefix.plateCurved);
    }
}
