package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.api.recipe.properties.CACasingTierProperty;
import cn.gtcommunity.epimorphism.api.recipe.properties.PACasingTierProperty;
import cn.gtcommunity.epimorphism.common.covers.EPCoverBehavior;
import cn.gtcommunity.epimorphism.api.recipe.properties.CasingTierProperty;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.items.BehaviorAddition;
import cn.gtcommunity.epimorphism.loaders.formula.FormulaManager;
import cn.gtcommunity.epimorphism.loaders.recipe.EPRecipeManager;
import cn.gtcommunity.epimorphism.loaders.recipe.components.MaterialComponents;
import cn.gtcommunity.epimorphism.loaders.recipe.handlers.EPRecipeHandlerList;
import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
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
        registry.register(EPMetablocks.EP_MULTIBLOCK_CASING_B);
        registry.register(EPMetablocks.EP_MULTIBLOCK_CASING_C);
        registry.register(EPMetablocks.EP_CRUCIBLE_CASING);
        registry.register(EPMetablocks.EP_MILL_CASING);
        registry.register(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING);
        registry.register(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING);
        registry.register(EPMetablocks.EP_CLEANROOM_CASING);
        registry.register(EPMetablocks.EP_BOILER_CASING);
        registry.register(EPMetablocks.EP_EXPLOSIVE_BLOCK);
        registry.register(EPMetablocks.EP_WIRE_COIL);
        registry.register(EPMetablocks.EP_TRANSPARENT_CASING);
        registry.register(EPMetablocks.EP_GLASS_CASING_B);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        EPLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(EPMetablocks.EP_GLASS_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_PMMA_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MULTIBLOCK_CASING_B, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MULTIBLOCK_CASING_C, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_CRUCIBLE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_MILL_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_CLEANROOM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_BOILER_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_EXPLOSIVE_BLOCK, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_WIRE_COIL, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(EPMetablocks.EP_GLASS_CASING_B, VariantItemBlock::new));
        BehaviorAddition.init();
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = (ItemBlock)producer.apply(block);
        itemBlock.setRegistryName((ResourceLocation) Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    //  Cover Behavior Event
    @SubscribeEvent
    public static void registerCoverBehavior(GregTechAPI.RegisterEvent<CoverDefinition> event) {
        EPCoverBehavior.init();
    }

    //  Recipe Event
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        EPLog.logger.info("Registering recipes...");
        FusionEUToStartProperty.registerFusionTier(9, "(MK4)");
        FusionEUToStartProperty.registerFusionTier(10, "(MK5)");
        CasingTierProperty.registerCasingTier(1, I18n.format("epimorphism.recipe.casing_tier.1"));
        CasingTierProperty.registerCasingTier(2, I18n.format("epimorphism.recipe.casing_tier.2"));
        CasingTierProperty.registerCasingTier(3, I18n.format("epimorphism.recipe.casing_tier.3"));
        CasingTierProperty.registerCasingTier(4, I18n.format("epimorphism.recipe.casing_tier.4"));
        CasingTierProperty.registerCasingTier(5, I18n.format("epimorphism.recipe.casing_tier.5"));
        PACasingTierProperty.registerPACasingTier(1, I18n.format("epimorphism.machine.precise_assembler.tier.1"));
        PACasingTierProperty.registerPACasingTier(2, I18n.format("epimorphism.machine.precise_assembler.tier.2"));
        PACasingTierProperty.registerPACasingTier(3, I18n.format("epimorphism.machine.precise_assembler.tier.3"));
        CACasingTierProperty.registerCACasingTier(1, I18n.format("epimorphism.machine.component_assembly_line.tier.1"));
        CACasingTierProperty.registerCACasingTier(2, I18n.format("epimorphism.machine.component_assembly_line.tier.2"));
        CACasingTierProperty.registerCACasingTier(3, I18n.format("epimorphism.machine.component_assembly_line.tier.3"));
        CACasingTierProperty.registerCACasingTier(4, I18n.format("epimorphism.machine.component_assembly_line.tier.4"));
        CACasingTierProperty.registerCACasingTier(5, I18n.format("epimorphism.machine.component_assembly_line.tier.5"));
        CACasingTierProperty.registerCACasingTier(6, I18n.format("epimorphism.machine.component_assembly_line.tier.6"));
        CACasingTierProperty.registerCACasingTier(7, I18n.format("epimorphism.machine.component_assembly_line.tier.7"));
        CACasingTierProperty.registerCACasingTier(8, I18n.format("epimorphism.machine.component_assembly_line.tier.8"));
        CACasingTierProperty.registerCACasingTier(9, I18n.format("epimorphism.machine.component_assembly_line.tier.9"));
        CACasingTierProperty.registerCACasingTier(10, I18n.format("epimorphism.machine.component_assembly_line.tier.10"));
        CACasingTierProperty.registerCACasingTier(11, I18n.format("epimorphism.machine.component_assembly_line.tier.11"));
        CACasingTierProperty.registerCACasingTier(12, I18n.format("epimorphism.machine.component_assembly_line.tier.12"));
        CACasingTierProperty.registerCACasingTier(13, I18n.format("epimorphism.machine.component_assembly_line.tier.13"));
        CACasingTierProperty.registerCACasingTier(14, I18n.format("epimorphism.machine.component_assembly_line.tier.14"));
        FormulaManager.init();
        EPRecipeManager.init();
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
