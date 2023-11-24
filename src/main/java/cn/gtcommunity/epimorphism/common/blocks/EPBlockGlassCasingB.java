package cn.gtcommunity.epimorphism.common.blocks;

import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
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
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class EPBlockGlassCasingB extends VariantActiveBlock<EPBlockGlassCasingB.GlassType> {
    public EPBlockGlassCasingB() {
        super(Material.GLASS);
        setTranslationKey("ep_glass_casing_b");
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 1);
        setDefaultState(this.getState(GlassType.INFINITY_GLASS));
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        EPBlockGlassCasingB.GlassType type = getState(state);
        if( type == GlassType.INFINITY_GLASS
        ) {
            return super.canRenderInLayer(state, layer);
        }
        return layer == BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        VariantItemBlock itemBlock = (VariantItemBlock<EPBlockGlassCasingB.GlassType, EPBlockGlassCasingB>) stack.getItem();
        IBlockState stackState = itemBlock.getBlockState(stack);
        EPBlockGlassCasingB.GlassType glassType =  this.getState(stackState);
        tooltip.add(I18n.format("epimorphism.glass_tier.tooltip", glassType.getTireNameColored()));
        if (glassType.isOpticalGlass) {
            tooltip.add(glassType.getOpticalTierName());
        }
    }

    public enum GlassType implements IStringSerializable, ITierGlassBlockState {
        INFINITY_GLASS("infinity_glass", GTValues.OpV, false),
        FORCE_FIELD_CONSTRAINED_GLASS("force_field_constrained_glass", GTValues.UHV, false),
        COSMIC_MICROWAVE_BACKGROUND_RADIATION_ABSORPTION_GLASS("cosmic_microwave_background_radiation_absorption_glass", GTValues.UEV, false),
        SPACETIME_SUPERCONDENSER_GLASS("spacetime_supercondenser_glass", GTValues.UIV, false),
        SUPRACAUSAL_LIGHT_CONE_GLASS("supracausal_light_cone_glass", GTValues.UXV, false);

        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;

        GlassType(String name, int tier, boolean isOpticalGlass) {
            this.name = name;
            this.tier = tier;
            this.isOpticalGlass = isOpticalGlass;
        }

        @Nonnull
        @Override
        public String getName() {return this.name;}

        @Override
        public int getGlassTier() {return this.tier;}

        public boolean isOpticalGlass() {return isOpticalGlass;}

        @Nonnull
        @Override
        public String toString() {return getName();}
    }
}
