package cn.gtcommunity.epimorphism.common.blocks;

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
public class EPBlockPMMACasing extends VariantActiveBlock<EPBlockPMMACasing.CasingType> {
    public EPBlockPMMACasing() {
        super(Material.GLASS);
        setTranslationKey("ep_pmma_casing");
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setHarvestLevel(ToolClasses.PICKAXE, 3);
        setDefaultState(this.getState(CasingType.PMMA_GLASS));
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
        //  渲染相关，可能启用，请不要修改
        /*EPBlockPMMACasing.CasingType type = getState(state);
        if( type == EPBlockPMMACasing.CasingType.
        ) {
            return super.canRenderInLayer(state, layer);
        }*/
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

    public enum CasingType implements IStringSerializable {

        PMMA_GLASS("pmma_glass"),
        NEU_PMMA_GLASS("neu_pmma_glass");

        private final String name;

        CasingType(String name) {this.name = name;}

        @Nonnull
        @Override
        public String getName() {return this.name;}
    }
}
