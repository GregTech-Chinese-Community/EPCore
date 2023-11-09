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
    public static EPBlockComponentAssemblyLineCasing EP_COMPONENT_ASSEMBLY_LINE_CASING;
    public static EPBlockCleanroomCasing EP_CLEANROOM_CASING;
    public static EPBlockBoilerCasing EP_BOILER_CASING;
    public static EPBlockExplosive EP_EXPLOSIVE_BLOCK;
    public static EPBlockWireCoil EP_WIRE_COIL;

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
        EP_COMPONENT_ASSEMBLY_LINE_CASING = new EPBlockComponentAssemblyLineCasing();
        EP_COMPONENT_ASSEMBLY_LINE_CASING.setRegistryName("ep_component_assembly_line_casing");
        EP_CLEANROOM_CASING = new EPBlockCleanroomCasing();
        EP_CLEANROOM_CASING.setRegistryName("ep_cleanroom_casing");
        EP_BOILER_CASING = new EPBlockBoilerCasing();
        EP_BOILER_CASING.setRegistryName("ep_boiler_casing");
        EP_EXPLOSIVE_BLOCK = new EPBlockExplosive();
        EP_EXPLOSIVE_BLOCK.setRegistryName("ep_explosive_block");
        EP_WIRE_COIL = new EPBlockWireCoil();
        EP_WIRE_COIL.setRegistryName("ep_wire_coil");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(EP_MULTIBLOCK_CASING);
        registerItemModel(EP_CRUCIBLE_CASING);
        registerItemModel(EP_MILL_CASING);
        registerItemModel(EP_MULTIBLOCK_CASING_B);
        registerItemModel(EP_COMPONENT_ASSEMBLY_LINE_CASING);
        registerItemModel(EP_CLEANROOM_CASING);
        registerItemModel(EP_BOILER_CASING);
        registerItemModel(EP_EXPLOSIVE_BLOCK);

        //  VariantActiveBlock Registry
        EP_GLASS_CASING.onModelRegister();
        EP_PMMA_CASING.onModelRegister();
        EP_ACTIVE_MULTIBLOCK_CASING.onModelRegister();
        EP_WIRE_COIL.onModelRegister();
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
