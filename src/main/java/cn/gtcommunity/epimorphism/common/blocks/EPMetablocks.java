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
    public static EPBlockMultiblockCasingB EP_MULTIBLOCK_CASING_B;
    public static EPBlockCrucibleCasing EP_CRUCIBLE_CASING;
    public static EPBlockMillCasing EP_MILL_CASING;
    public static EPBlockActiveMultiblockCasing EP_ACTIVE_MULTIBLOCK_CASING;

    private EPMetablocks() {/**/}

    public static void init() {
        EP_GLASS_CASING = new EPBlockGlassCasing();
        EP_GLASS_CASING.setRegistryName("ep_glass_casing");
        EP_PMMA_CASING = new EPBlockPMMACasing();
        EP_PMMA_CASING.setRegistryName("ep_pmma_casing");
        EP_MULTIBLOCK_CASING = new EPBlockMultiblockCasing();
        EP_MULTIBLOCK_CASING.setRegistryName("ep_multiblock_casing");
        EP_MULTIBLOCK_CASING_B = new EPBlockMultiblockCasingB();
        EP_MULTIBLOCK_CASING_B.setRegistryName("ep_multiblock_casing_b");
        EP_CRUCIBLE_CASING = new EPBlockCrucibleCasing();
        EP_CRUCIBLE_CASING.setRegistryName("ep_crucible_casing");
        EP_MILL_CASING = new EPBlockMillCasing();
        EP_MILL_CASING.setRegistryName("ep_mill_casing");
        EP_ACTIVE_MULTIBLOCK_CASING = new EPBlockActiveMultiblockCasing();
        EP_ACTIVE_MULTIBLOCK_CASING.setRegistryName("ep_active_multiblock_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(EP_MULTIBLOCK_CASING);
        registerItemModel(EP_CRUCIBLE_CASING);
        registerItemModel(EP_MILL_CASING);
        registerItemModel(EP_MULTIBLOCK_CASING_B);

        //  VariantActiveBlock Registry
        EP_GLASS_CASING.onModelRegister();
        EP_PMMA_CASING.onModelRegister();
        EP_ACTIVE_MULTIBLOCK_CASING.onModelRegister();
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
