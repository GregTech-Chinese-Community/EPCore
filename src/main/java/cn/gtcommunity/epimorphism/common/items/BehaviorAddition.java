package cn.gtcommunity.epimorphism.common.items;

import cn.gtcommunity.epimorphism.common.items.behaviors.renderer.DataRenderItemBehavior;
import cn.gtcommunity.epimorphism.common.items.behaviors.EPDataItemBehavior;
import gregtech.common.items.MetaItems;

public class BehaviorAddition {
    public static void init() {
        MetaItems.TOOL_DATA_STICK.addComponents(new EPDataItemBehavior(), new DataRenderItemBehavior());
        MetaItems.TOOL_DATA_ORB.addComponents(new EPDataItemBehavior(), new DataRenderItemBehavior());
        MetaItems.TOOL_DATA_MODULE.addComponents(new EPDataItemBehavior(), new DataRenderItemBehavior());
    }
}
