package cn.gtcommunity.epimorphism.common.items;

import gregtech.api.items.metaitem.MetaItem;

import java.util.ArrayList;
import java.util.List;

public class EPMetaItems {
    public static final List<MetaItem<?>> ITEMS = EPMetaItem1.getMetaItems();

    public static MetaItem<?>.MetaValueItem CELL_MUTATION_INDUCTION_REAGENT;


    private EPMetaItems() {/**/}

    public static void initialization()
    {
        EPMetaItem1 item1 = new EPMetaItem1();
    }

    public static void initSubItems()
    {
        EPMetaItem1.registerItems();
    }
}
