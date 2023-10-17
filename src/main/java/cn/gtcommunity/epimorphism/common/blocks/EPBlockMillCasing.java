package cn.gtcommunity.epimorphism.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class EPBlockMillCasing extends VariantBlock<EPBlockMillCasing.CasingType> {
    public EPBlockMillCasing() {
        super(Material.IRON);
        this.setTranslationKey("ep_mill_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(CasingType.ISA_MILL_CASING));
    }

    public enum CasingType implements IStringSerializable {

        ISA_MILL_CASING("isa_mill_casing"),
        ISA_MILL_CASING_GEARBOX("isa_mill_casing_gearbox"),
        ISA_MILL_CASING_PIPE("isa_mill_casing_pipe"),
        FLOTATION_CASING("flotation_casing"),
        FLOTATION_CASING_GEARBOX("flotation_casing_gearbox"),
        FLOTATION_CASING_PIPE("flotation_casing_pipe");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        @Nonnull
        public String getName() {return this.name;}
    }
}
