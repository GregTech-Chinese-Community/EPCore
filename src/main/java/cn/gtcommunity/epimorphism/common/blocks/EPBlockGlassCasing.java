package cn.gtcommunity.epimorphism.common.blocks;

import cn.gtcommunity.epimorphism.api.EPValues;
import cn.gtcommunity.epimorphism.api.block.IGlassTierBlockState;
import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EPBlockGlassCasing extends VariantActiveBlock<EPBlockGlassCasing.CasingType> {
    public EPBlockGlassCasing() {
        super(Material.GLASS);
        setTranslationKey("ep_glass_casing");
        setHardness(5.0F);
        setResistance(5.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 1);
        setDefaultState(this.getState(CasingType.SILICATE_GLASS));
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
//        EPBlockGlassCasing.CasingType type = getState(state);
//        if( type == CasingType.NAQ_BORON_SILICATE_GLASS
//        ) {
//            return super.canRenderInLayer(state, layer);
//        }
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

    public enum CasingType implements IStringSerializable, IGlassTierBlockState {

        SILICATE_GLASS("boron_silicate_glass", GTValues.HV, false),
        TI_BORON_SILICATE_GLASS("ti_boron_silicate_glass", GTValues.EV, false),
        W_BORON_SILICATE_GLASS("w_boron_silicate_glass", GTValues.IV, false),
        OSMIR_BORON_SILICATE_GLASS("osmir_boron_silicate_glass",GTValues.LuV, false),
        NAQ_BORON_SILICATE_GLASS("naq_boron_silicate_glass", GTValues.ZPM, false),
        THY_BORON_SILICATE_GLASS("thy_boron_silicate_glass", EPValues.OP, true);

        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;

        CasingType(String name, int tier, boolean isOpticalGlass) {
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

