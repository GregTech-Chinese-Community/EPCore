package cn.gtcommunity.epimorphism.common.items;

import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;

import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;

public class EPMetaItem1 extends StandardMetaItem {
    public EPMetaItem1() {
        this.setRegistryName("ep_meta_item_1");
        setCreativeTab(GregTechAPI.TAB_GREGTECH);
    }

    public void registerSubItems() {

        //  Boards
        GOOWARE_BOARD = this.addItem(0, "board.gooware");
        OPTICAL_BOARD = this.addItem(1, "board.optical");
        SPINTRONIC_BOARD = this.addItem(2, "board.spintronic");
        GOOWARE_CIRCUIT_BOARD = this.addItem(3, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = this.addItem(4, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = this.addItem(5, "circuit_board.spintronic");

        //  Circuits
        GOOWARE_PROCESSOR = this.addItem(6, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = this.addItem(7, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = this.addItem(8, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = this.addItem(9, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_PROCESSOR = this.addItem(10, "circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = this.addItem(11, "circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = this.addItem(12, "circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = this.addItem(13, "circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_PROCESSOR = this.addItem(14, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = this.addItem(15, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = this.addItem(16, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = this.addItem(17, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_PROCESSOR = this.addItem(18, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = this.addItem(19, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = this.addItem(20, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = this.addItem(21, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_PROCESSOR = this.addItem(22, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = this.addItem(23, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = this.addItem(24, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = this.addItem(25, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

    }
}
