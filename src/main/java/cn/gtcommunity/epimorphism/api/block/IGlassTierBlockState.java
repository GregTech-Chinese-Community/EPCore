package cn.gtcommunity.epimorphism.api.block;

import javax.annotation.Nonnull;

public interface IGlassTierBlockState {

    @Nonnull
    String getName();

    int getTier();
}
