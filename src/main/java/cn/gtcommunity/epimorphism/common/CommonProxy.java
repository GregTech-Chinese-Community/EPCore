package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.loaders.recipe.EPRecipeManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;
import java.util.function.Function;

@EventBusSubscriber(
        modid = "epimorphism"
)
public class CommonProxy {
    public CommonProxy() {
    }

    public void preLoad() {
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
    }

    //@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        EPLog.logger.info("Registering blocks...");
    }

    //@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EPLog.logger.info("Registering Items...");
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = (ItemBlock)producer.apply(block);
        itemBlock.setRegistryName((ResourceLocation) Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        EPLog.logger.info("Registering recipes...");
        EPRecipeManager.init();
    }
}
