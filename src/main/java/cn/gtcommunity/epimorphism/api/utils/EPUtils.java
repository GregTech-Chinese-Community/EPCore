package cn.gtcommunity.epimorphism.api.utils;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class EPUtils {
    @Nonnull
    public static ResourceLocation epId(@Nonnull String path) {
        return new ResourceLocation("epimorphism", path);
    }
}
