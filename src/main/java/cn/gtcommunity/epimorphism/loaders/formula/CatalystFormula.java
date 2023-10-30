package cn.gtcommunity.epimorphism.loaders.formula;

import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CatalystFormula {
    public static List<ItemStack> NoConsumeCatalyst = new ArrayList<>();
    public static void addCatalyst() {
        NoConsumeCatalyst.add(MetaItems.INTEGRATED_CIRCUIT.getStackForm());
        NoConsumeCatalyst.add(MetaItems.BLACKLIGHT.getStackForm());
    }

    public static boolean checkCatalyst(ItemStack item) {
        for (ItemStack catalyst : NoConsumeCatalyst) {
            if (item.isItemEqual(catalyst)) return true;
        }
        return false;
    }

    // 并不保险
    public static boolean checkCatalyst(List<ItemStack> items) {
        return items.stream().allMatch(CatalystFormula::checkCatalyst);
    }
}
