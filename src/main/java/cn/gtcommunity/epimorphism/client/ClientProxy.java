package cn.gtcommunity.epimorphism.client;

import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public ClientProxy() {}

    public void preLoad() {
        super.preLoad();
        EPTextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        EPMetablocks.registerItemModels();
    }
}
