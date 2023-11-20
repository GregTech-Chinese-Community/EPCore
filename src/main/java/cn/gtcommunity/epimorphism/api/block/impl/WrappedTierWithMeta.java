package cn.gtcommunity.epimorphism.api.block.impl;

import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;

import javax.annotation.Nonnull;

public class WrappedTierWithMeta implements ITierGlassBlockState {
    private final ITierGlassBlockState inner;
    private final int meta;

    public WrappedTierWithMeta(ITierGlassBlockState inner, int meta) {
        this.inner = inner;
        this.meta = meta;
    }

    @Nonnull
    @Override
    public String getName() {
        return inner.getName() + "#" + meta;
    }

    public int getMeta() {
        return meta;
    }

    @Override
    public boolean isOpticalGlass() {
        return inner.isOpticalGlass();
    }

    @Override
    public int getGlassTier() {
        return inner.getGlassTier();
    }
}
