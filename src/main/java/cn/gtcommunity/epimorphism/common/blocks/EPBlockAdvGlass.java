package cn.gtcommunity.epimorphism.common.blocks;

import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.block.VariantItemBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EPBlockAdvGlass extends VariantBlock<EPBlockAdvGlass.AdvGlassType> {


    public EPBlockAdvGlass() {
        super(Material.IRON);
        this.setTranslationKey("ep_adv_glass_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }
    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean canRenderInLayer(@Nonnull IBlockState state, @Nonnull BlockRenderLayer layer) {
        return super.canRenderInLayer(state, layer);
    }
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(@Nonnull IBlockState state, IBlockAccess world, BlockPos pos, @Nonnull EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        VariantItemBlock itemBlock = (VariantItemBlock<EPBlockAdvGlass.AdvGlassType, EPBlockAdvGlass>) stack.getItem();
        IBlockState stackState = itemBlock.getBlockState(stack);
        EPBlockAdvGlass.AdvGlassType glassType =  this.getState(stackState);
        tooltip.add(I18n.format("epimorphism.glass_tier.tooltip", glassType.getTireNameColored()));
        if (glassType.isOpticalGlass) {
            tooltip.add(glassType.getOpticalTierName());
        }
    }

    public enum AdvGlassType implements IStringSerializable, ITierGlassBlockState {

        ADV_MACHINE_GLASS("adv_machine_glass", GTValues.ZPM, false),
        ADV_MACHINE_GLASS_R("adv_machine_glass_r", GTValues.ZPM, false),
        ADV_MACHINE_GLASS_O("adv_machine_glass_o", GTValues.ZPM, false),
        TECH_FUSION_GLASS_IV("tech_fusion_glass_4", GTValues.ZPM, false),
        TECH_FUSION_GLASS_V("tech_fusion_glass_5", GTValues.ZPM, false),
        TECH_FUSION_GLASS_VI("tech_fusion_glass_6", GTValues.ZPM, false);
        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;

        AdvGlassType(String name, int tier, boolean isOpticalGlass) {
            this.name = name;
            this.tier = tier;
            this.isOpticalGlass = isOpticalGlass;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean isOpticalGlass() {
            return isOpticalGlass;
        }

        @Override
        public int getGlassTier() {
            return tier;
        }
    }
}