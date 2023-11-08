package cn.gtcommunity.epimorphism.api.block.impl;

import cn.gtcommunity.epimorphism.api.block.ITier;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class WrappedTired implements ITier {
    private final IStringSerializable inner;

    public WrappedTired(IStringSerializable inner) {
        this.inner = inner;
    }

    @Override
    @Nonnull
    public String getName() {
        return inner.getName();
    }
}
