package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.api.recipe.properties.CasingTierProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.loaders.formula.FormulaManager;
import cn.gtcommunity.epimorphism.loaders.recipe.EPRecipeManager;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MaterialComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;
import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        EPLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(EPMetablocks.EP_GLASS_CASING);
        registry.register(EPMetablocks.EP_PMMA_CASING);
        registry.register(EPMetablocks.EP_MULTIBLOCK_CASING);
        registry.register(EPMetablocks.EP_CRUCIBLE_CASING);
        registry.register(EPMetablocks.EP_MILL_CASING);
        registry.register(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EPLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(EPMetablocks.EP_GLASS_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_PMMA_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_CRUCIBLE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MILL_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = (ItemBlock)producer.apply(block);
        itemBlock.setRegistryName((ResourceLocation) Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    //  Recipe Event
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        EPLog.logger.info("Registering recipes...");
        FormulaManager.init();
        EPRecipeManager.init();
        FusionEUToStartProperty.registerFusionTier(9, "(MK4)");
        FusionEUToStartProperty.registerFusionTier(10, "(MK5)");
        FusionEUToStartProperty.registerFusionTier(11, "(MK6)");
        CasingTierProperty.registerCasingTier(1, "A");
        CasingTierProperty.registerCasingTier(2, "B");
        CasingTierProperty.registerCasingTier(3, "C");
        CasingTierProperty.registerCasingTier(4, "D");
        CasingTierProperty.registerCasingTier(5, "E");
    }

    @SubscribeEvent
    public static void registerRecipeHandlers(RegistryEvent.Register<IRecipe> event) {
        EPRecipeHandlerList.register();
    }

    //  Crafting Component Event
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void initComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        MaterialComponents.init();
    }
}
