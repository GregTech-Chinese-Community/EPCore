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
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EPBlockExplosive extends VariantBlock<EPBlockExplosive.CasingType> {
    public EPBlockExplosive() {
        super(Material.IRON);
        this.setTranslationKey("ep_explosive_block");
        this.setHardness(10.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.SLIME);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(CasingType.NAQUADRIA_CHARGE));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public static enum CasingType implements IStringSerializable {
        NAQUADRIA_CHARGE("naquadria_charge"),
        TARANIUM_CHARGE("taranium_charge"),
        LEPTONIC_CHARGE("leptonic_charge"),
        QUANTUM_CHROMODYNAMIC_CHARGE("quantum_chromodynamic_charge");

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
