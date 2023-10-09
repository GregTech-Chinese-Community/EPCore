package cn.gtcommunity.epimorphism.common.items;

import gregtech.api.items.metaitem.MetaItem;

import java.util.ArrayList;
import java.util.List;

public class EPMetaItems {
    public static final List<MetaItem<?>> ITEMS = EPMetaItem1.getMetaItems();

    //  Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CIRCUIT_BOARD;

    //  Circuits
    public static MetaItem<?>.MetaValueItem GOOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem GOOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem GOOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem GOOWARE_MAINFRAME;
    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_MAINFRAME;
    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME;

    //  Components
    public static MetaItem<?>.MetaValueItem OPTICAL_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_RESISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_CAPACITOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_DIODE;
    public static MetaItem<?>.MetaValueItem OPTICAL_INDUCTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_RESISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CAPACITOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_DIODE;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_INDUCTOR;
    public static MetaItem<?>.MetaValueItem COSMIC_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem COSMIC_RESISTOR;
    public static MetaItem<?>.MetaValueItem COSMIC_CAPACITOR;
    public static MetaItem<?>.MetaValueItem COSMIC_DIODE;
    public static MetaItem<?>.MetaValueItem COSMIC_INDUCTOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_RESISTOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_CAPACITOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_DIODE;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_INDUCTOR;

    private EPMetaItems() {}

    public static void initialization()
    {
        EPMetaItem1 item1 = new EPMetaItem1();
    }

    public static void initSubItems()
    {
        EPMetaItem1.registerItems();
    }
}
