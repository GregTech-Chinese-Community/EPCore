package cn.gtcommunity.epimorphism.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class EPBlockMultiblockCasingC extends VariantBlock<EPBlockMultiblockCasingC.CasingType> {
    public EPBlockMultiblockCasingC() {
        super(Material.IRON);
        this.setTranslationKey("ep_multiblock_casing_c");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(EPBlockMultiblockCasingC.CasingType.DRACONIUM_CASING));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public static enum CasingType implements IStringSerializable {
        DRACONIUM_CASING("draconium_casing"),
        DRAGON_FUSION_COIL("dragon_fusion_coil");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
