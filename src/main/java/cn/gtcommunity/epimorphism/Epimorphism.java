package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.capability.pollution.IPollution;
import cn.gtcommunity.epimorphism.api.capability.pollution.PollutionProvider;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.common.ConfigHolder;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.concurrent.Callable;

@Mod(
        modid = "epimorphism",
        name = "Epimorphism",
        acceptedMinecraftVersions = "[1.12.2,1.13)",
        version = "0.0.1-beta",
        dependencies = "required-after:gcym"
)
public class Epimorphism {

    public static final String MODID = "epimorphism";
    public static final String NAME = "Epimorphism";
    public static final String VERSION = "0.0.1-beta";

    @SidedProxy(
            modId = MODID,
            clientSide = "cn.gtcommunity.epimorphism.client.ClientProxy",
            serverSide = "cn.gtcommunity.epimorphism.common.CommonProxy"
    )
    public static CommonProxy proxy;

    public Epimorphism() {}

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event)
    {
        ConfigHolder.machines.highTierContent = true;
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        EPLog.init(event.getModLog());
        ConfigHolder.machines.highTierContent = true;
        EPLog.logger.info("Enabled GregTechCEu highTierContent");
        EPMetaItems.initialization();
        EPMetablocks.init();
        EPAPI.APIBlockInit();
        EPMetaTileEntities.init();

        CapabilityManager.INSTANCE.register(IPollution.class, new PollutionProvider.Storage(), PollutionProvider.Impl::new);
        proxy.preLoad();
    }
}
