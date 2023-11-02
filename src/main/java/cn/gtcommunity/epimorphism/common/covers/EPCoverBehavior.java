package cn.gtcommunity.epimorphism.common.covers;

import cn.gtcommunity.epimorphism.Epimorphism;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.cover.CoverBehavior;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.cover.ICoverable;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.CoverConveyor;
import gregtech.common.covers.CoverPump;
import gregtech.common.covers.CoverRoboticArm;
import gregtech.common.items.behaviors.CoverPlaceBehavior;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiFunction;

import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;

public class EPCoverBehavior {
    public static void init() {
        //  Id Range: 113-200
        registerBehavior(113, new ResourceLocation(Epimorphism.MODID, "pump.ulv"), ELECTRIC_PUMP_ULV, (tile, side) -> new CoverPump(tile, side, GTValues.ULV, 320));
        registerBehavior(114, new ResourceLocation(Epimorphism.MODID, "conveyor_module.ulv"), CONVEYOR_MODULE_ULV, (tile, side) -> new CoverConveyor(tile, side, GTValues.ULV, 4));
        registerBehavior(115, new ResourceLocation(Epimorphism.MODID, "robot_arm.ulv"), ROBOT_ARM_ULV, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.ULV, 4));
        registerBehavior(116, new ResourceLocation(Epimorphism.MODID, "pump.max"), ELECTRIC_PUMP_MAX, (tile, side) -> new CoverPump(tile, side, GTValues.MAX, 1048576));
        registerBehavior(117,  new ResourceLocation(Epimorphism.MODID, "conveyor_module.max"), CONVEYOR_MODULE_MAX, (tile, side) -> new CoverConveyor(tile, side, GTValues.MAX, 1024));
        registerBehavior(118, new ResourceLocation(Epimorphism.MODID, "robot_arm.max"), ROBOT_ARM_MAX, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.MAX, 1024));
    }

    public static void registerBehavior(int coverNetworkId, ResourceLocation coverId, MetaItem.MetaValueItem placerItem, BiFunction<ICoverable, EnumFacing, CoverBehavior> behaviorCreator) {
        placerItem.addComponents(new CoverPlaceBehavior(registerCover(coverNetworkId, coverId, placerItem, behaviorCreator)));
    }

    public static CoverDefinition registerCover(int coverNetworkId, ResourceLocation coverId, MetaItem.MetaValueItem itemStack, BiFunction<ICoverable, EnumFacing, CoverBehavior> behaviorCreator) {
        CoverDefinition coverDefinition = new CoverDefinition(coverId, behaviorCreator, itemStack.getStackForm());
        GregTechAPI.COVER_REGISTRY.register(coverNetworkId, coverId, coverDefinition);
        return coverDefinition;
    }
}
