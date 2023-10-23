package cn.gtcommunity.epimorphism.api.capability;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.capability.pollution.PollutionProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Epimorphism.MODID)
public class CapabilityHandler {

    @SubscribeEvent
    public void attachChunkPollutionCapability(AttachCapabilitiesEvent<Chunk> event) {
        event.addCapability(new ResourceLocation(Epimorphism.MODID, "pollution_cap"), new PollutionProvider());
    }

}
