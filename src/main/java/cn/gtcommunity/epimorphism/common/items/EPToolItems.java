package cn.gtcommunity.epimorphism.common.items;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.items.toolitem.EPToolClasses;
import gregtech.api.GTValues;
import gregtech.api.items.toolitem.*;
import gregtech.common.items.ToolItems;
import gregtech.common.items.tool.BlockRotatingBehavior;
import gregtech.common.items.tool.EntityDamageBehavior;
import gregtech.common.items.tool.GrassPathBehavior;
import gregtech.common.items.tool.RotateRailBehavior;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;

public class EPToolItems {
    public static IGTTool BENDING_CYLINDER;
    public static IGTTool SMALL_BENDING_CYLINDER;
    public static IGTTool COMBINATION_WRENCH;
    public static IGTTool UNIVERSAL_SPADE;
    public static IGTTool SOLDERING_IRON_LV;
    public static IGTTool SOLDERING_IRON_HV;
    public static IGTTool SOLDERING_IRON_IV;

    private EPToolItems() {}

    public static void init() {
        BENDING_CYLINDER = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "bending_cylinder")
                .toolStats(b -> b.crafting().cannotAttack().attackSpeed(-2.8F))
                .oreDict("toolBendingCylinder")
                .secondaryOreDicts("craftingToolBendingCylinder")
                .toolClasses(EPToolClasses.BENDING_CYLINDER)
        );
        SMALL_BENDING_CYLINDER = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "small_bending_cylinder")
                .toolStats(b -> b.crafting().cannotAttack().attackSpeed(-1.8F))
                .oreDict("toolSmallBendingCylinder")
                .secondaryOreDicts("craftingToolSmallBendingCylinder")
                .toolClasses(EPToolClasses.SMALL_BENDING_CYLINDER)
        );
        COMBINATION_WRENCH = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "combination_wrench")
                .toolStats(b -> b.blockBreaking().crafting().sneakBypassUse()
                        .attackDamage(1.0F).attackSpeed(-2.8F)
                        .behaviors(BlockRotatingBehavior.INSTANCE, new EntityDamageBehavior(3.0F, EntityGolem.class)))
                .sound(GTSoundEvents.WRENCH_TOOL, true)
                .oreDict(ToolOreDict.toolWrench)
                .secondaryOreDicts(ToolOreDict.toolHammer.toString(), "craftingToolWrench", "craftingToolHardHammer")
                .toolClasses(ToolClasses.WRENCH, ToolClasses.HARD_HAMMER)
        );
        UNIVERSAL_SPADE = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "universal_spade")
                .toolStats(b -> b.blockBreaking().crafting().sneakBypassUse()
                        .attackDamage(3.0F).attackSpeed(-2.4F)
                        .behaviors(GrassPathBehavior.INSTANCE, RotateRailBehavior.INSTANCE))
                .sound(SoundEvents.ENTITY_ITEM_BREAK)
                .oreDict(ToolOreDict.toolShovel)
                .secondaryOreDicts(ToolOreDict.toolCrowbar.toString(), ToolOreDict.toolSpade.toString(), ToolOreDict.toolSaw.toString(), "craftingToolSaw")
                .toolClasses(ToolClasses.CROWBAR, ToolClasses.SHOVEL)
        );
        SOLDERING_IRON_LV = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "soldering_iron_lv")
                .toolStats(b -> b.crafting().attacking()
                        .attackDamage(8.0F).attackSpeed(-2.4F)
                        .behaviors(new EntityDamageBehavior(3.0F, EntityGolem.class))
                        .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_LV)
                        .defaultEnchantment(Enchantments.FIRE_ASPECT, 2)
                )
                .sound(GTSoundEvents.WRENCH_TOOL, true)
                .oreDict("toolSolderingIron")
                .secondaryOreDicts("craftingToolSolderingIron")
                .toolClasses(EPToolClasses.SOLDERING_IRON)
                .electric(GTValues.LV));
        SOLDERING_IRON_HV = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "soldering_iron_hv")
                .toolStats(b -> b.crafting().attacking()
                        .attackDamage(8.0F).attackSpeed(-2.4F)
                        .behaviors(new EntityDamageBehavior(3.0F, EntityGolem.class))
                        .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_HV)
                        .defaultEnchantment(Enchantments.FIRE_ASPECT, 2)
                )
                .sound(GTSoundEvents.WRENCH_TOOL, true)
                .oreDict("toolSolderingIron")
                .secondaryOreDicts("craftingToolSolderingIron")
                .toolClasses(EPToolClasses.SOLDERING_IRON)
                .electric(GTValues.HV));
        SOLDERING_IRON_IV = ToolItems.register(ItemGTTool.Builder.of(Epimorphism.MODID, "soldering_iron_iv")
                .toolStats(b -> b.crafting().attacking()
                        .attackDamage(8.0F).attackSpeed(-2.4F)
                        .behaviors(new EntityDamageBehavior(3.0F, EntityGolem.class))
                        .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_IV)
                        .defaultEnchantment(Enchantments.FIRE_ASPECT, 2)
                )
                .sound(GTSoundEvents.WRENCH_TOOL, false)
                .oreDict("toolSolderingIron")
                .secondaryOreDicts("craftingToolSolderingIron")
                .toolClasses(EPToolClasses.SOLDERING_IRON)
                .electric(GTValues.IV));
    }
}
