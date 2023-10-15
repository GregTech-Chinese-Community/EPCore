package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.api.unification.OrePrefixAdditions;
import cn.gtcommunity.epimorphism.common.items.EPToolItems;
import gregtech.api.unification.material.event.MaterialEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Epimorphism.MODID)
public class EPEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
        OrePrefixAdditions.init();
        EPToolItems.init();
    }

}
