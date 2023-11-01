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
public class EPBlockMultiblockCasing extends VariantBlock<EPBlockMultiblockCasing.CasingType> {
    public EPBlockMultiblockCasing() {
        super(Material.IRON);
        this.setTranslationKey("ep_multiblock_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(CasingType.SUBSTRATE_CASING));
    }
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }
    public static enum CasingType implements IStringSerializable {
        SUBSTRATE_CASING("substrate_casing"),
        ADVANCED_SUBSTRATE_CASING("advanced_substrate_casing"),
        ADVANCED_INVAR_CASING("advanced_invar_casing"),
        ADVANCED_ALUMINIUM_CASING("advanced_aluminium_casing"),
        VACUUM_CASING("vacuum_casing"),
        DRILL_HEAD("drill_head"),
        NAQUADRIA_CASING("naquadria_casing"),
        HYPER_CASING("hyper_casing"),
        TALONITE_CASING("talonite_casing"),
        IRIDIUM_CASING("iridium_casing"),
        FARM_PIPE_CASING("farm_pipe_casing"),
        FARM_CASING("farm_casing"),
        BREEDING_CASING("breeding_casing"),
        TRITANIUM_CASING("tritanium_casing"),
        QUANTUM_CASING("quantum_casing"),
        REFLECTIVE_CASING("reflective_casing");
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
