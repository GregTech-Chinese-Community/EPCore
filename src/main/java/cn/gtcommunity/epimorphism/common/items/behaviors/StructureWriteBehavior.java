package cn.gtcommunity.epimorphism.common.items.behaviors;

import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.client.renderer.handler.TestRenderer;
import codechicken.lib.vec.Vector3;
import com.google.common.eventbus.Subscribe;
import gregtech.api.gui.ModularUI;
import gregtech.api.items.gui.ItemUIFactory;
import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StructureWriteBehavior implements IItemBehaviour/*, ItemUIFactory */{

    public StructureWriteBehavior() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /*@Override
    public ModularUI createUI(PlayerInventoryHolder playerInventoryHolder, EntityPlayer entityPlayer) {
        return null;
    }*/

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {

    }
}
