package cn.gtcommunity.epimorphism.common.items;

import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.StandardMetaItem;

import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;

public class EPMetaItem1 extends StandardMetaItem {
    public EPMetaItem1() {
        this.setRegistryName("ep_meta_item_1");
        setCreativeTab(GregTechAPI.TAB_GREGTECH);
    }

    public void registerSubItems() {
        CELL_MUTATION_INDUCTION_REAGENT = this.addItem(2000,"reagent.cell_mutation_induction");

    }
}
