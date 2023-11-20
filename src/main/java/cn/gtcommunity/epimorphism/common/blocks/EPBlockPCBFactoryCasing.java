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
public class EPBlockPCBFactoryCasing extends VariantBlock<EPBlockPCBFactoryCasing.CasingType> {
    public EPBlockPCBFactoryCasing() {
        super(Material.IRON);
        this.setTranslationKey("ep_pcb_factory_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 3);
        this.setDefaultState(this.getState(CasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING));
    }
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public static enum CasingType implements IStringSerializable {
        BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING("basic_photolithographic_framework_casing"),
        MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING("mold_printing_assembly_framework_casing"),
        RADIATION_PROOF_SCAN_FRAMEWORK_CASING("radiation_proof_scan_framework_casing"),
        BIOLOGICAL_STERILE_MACHINE_CASING("biological_sterile_machine_casing"),
        WATER_COOLED_MACHINE_CASING("water_cooled_machine_casing"),
        INFINITY_COOLED_MACHINE_CASING("infinity_cooled_machine_casing");

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