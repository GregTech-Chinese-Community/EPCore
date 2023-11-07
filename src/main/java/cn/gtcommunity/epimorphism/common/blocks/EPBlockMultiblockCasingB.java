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

public class EPBlockMultiblockCasingB extends VariantBlock<EPBlockMultiblockCasingB.CasingType> {
    public EPBlockMultiblockCasingB() {
        super(Material.IRON);
        this.setTranslationKey("ep_multiblock_casing_b");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(EPBlockMultiblockCasingB.CasingType.GENERAL_PROCESSING_CASING));
    }
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }
    public static enum CasingType implements IStringSerializable {
        GENERAL_PROCESSING_CASING("general_processing_casing"),
        MARAGING_STEEL_CASING("maraging_steel_casing"),
        BABBITT_ALLOY_CASING("babbitt_alloy_casing"),
        ZIRCONIUM_CARBIDE_CASING("zirconium_carbide_casing"),
        SUPERCRITICAL_FLUID_TURBINE_CASING("supercritical_fluid_turbine_casing"),
        CORROSION_CASING("corrosion_casing"),
        HASTELLOYX78_CASING("hastelloy_x78_casing"),
        STELLAR_CONTAINMENT_CASING("stellar_containment_casing"),
        HASTELLOYK243_CASING("hastelloy_k243_casing");

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
