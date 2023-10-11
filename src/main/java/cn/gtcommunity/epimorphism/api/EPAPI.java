package cn.gtcommunity.epimorphism.api;

import cn.gtcommunity.epimorphism.api.block.IGlassTierBlockState;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockGlassCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockPMMACasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;


public class EPAPI {
    public static final Object2ObjectMap<IBlockState, IGlassTierBlockState> EP_Glass = new Object2ObjectOpenHashMap<>();

    public static void APIBlockInit() {
        for (EPBlockGlassCasing.CasingType type : EPBlockGlassCasing.CasingType.values()) {
            if (!type.isOpticalGlass()) {
                EP_Glass.put(EPMetablocks.EP_GLASS_CASING.getState(type), type);
            }
        }
        for (EPBlockPMMACasing.CasingType type : EPBlockPMMACasing.CasingType.values()) {
            EP_Glass.put(EPMetablocks.EP_PMMA_CASING.getState(type), type);
        }
    }
}
