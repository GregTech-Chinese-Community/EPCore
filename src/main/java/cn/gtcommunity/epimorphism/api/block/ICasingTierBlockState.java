package cn.gtcommunity.epimorphism.api.block;

import net.minecraft.util.IStringSerializable;

public interface ICasingTierBlockState extends IStringSerializable {
    default Object getInfo(){
        return null;
    }

    default Object getTire(){
        return this.getName();
    }
}