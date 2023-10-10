package cn.gtcommunity.epimorphism.common.blocks;

import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EPMetablocks {
    public static EPBlockGlassCasing EP_GLASS_CASING;
    public static EPBlockPMMACasing EP_PMMA_CASING;
    public static EPBlockMultiblockCasing EP_MULTIBLOCK_CASING;


    private EPMetablocks() {/**/}

    public static void init() {
        EP_GLASS_CASING = new EPBlockGlassCasing();
        EP_GLASS_CASING.setRegistryName("ep_glass_casing");
        EP_PMMA_CASING = new EPBlockPMMACasing();
        EP_PMMA_CASING.setRegistryName("ep_pmma_casing");
        EP_MULTIBLOCK_CASING = new EPBlockMultiblockCasing();
        EP_MULTIBLOCK_CASING.setRegistryName("ep_multiblock_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(EP_GLASS_CASING);
        registerItemModel(EP_PMMA_CASING);
        registerItemModel(EP_MULTIBLOCK_CASING);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }
}
