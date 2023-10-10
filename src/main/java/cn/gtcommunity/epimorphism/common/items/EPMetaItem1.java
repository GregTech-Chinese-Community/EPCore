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

        //  Components
        OPTICAL_TRANSISTOR = this.addItem(26, "component.optical_smd.transistor");
        OPTICAL_RESISTOR = this.addItem(27, "component.optical_smd.resistor");
        OPTICAL_CAPACITOR = this.addItem(28, "component.optical_smd.capacitor");
        OPTICAL_DIODE = this.addItem(29, "component.optical_smd.diode");
        OPTICAL_INDUCTOR = this.addItem(30, "component.optical_smd.inductor");
        SPINTRONIC_TRANSISTOR = this.addItem(31, "component.spintronic_smd.transistor");
        SPINTRONIC_RESISTOR = this.addItem(32, "component.spintronic_smd.resistor");
        SPINTRONIC_CAPACITOR = this.addItem(33, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = this.addItem(34, "component.spintronic_smd.diode");
        SPINTRONIC_INDUCTOR = this.addItem(35, "component.spintronic_smd.inductor");
        COSMIC_TRANSISTOR = this.addItem(36, "component.cosmic_smd.transistor");
        COSMIC_RESISTOR = this.addItem(37, "component.cosmic_smd.resistor");
        COSMIC_CAPACITOR = this.addItem(38, "component.cosmic_smd.capacitor");
        COSMIC_DIODE = this.addItem(39, "component.cosmic_smd.diode");
        COSMIC_INDUCTOR = this.addItem(40, "component.cosmic_smd.inductor");
        SUPRACAUSAL_TRANSISTOR = this.addItem(41, "component.supracausal_smd.transistor");
        SUPRACAUSAL_RESISTOR = this.addItem(42, "component.supracausal_smd.resistor");
        SUPRACAUSAL_CAPACITOR = this.addItem(43, "component.supracausal_smd.capacitor");
        SUPRACAUSAL_DIODE = this.addItem(44, "component.supracausal_smd.diode");
        SUPRACAUSAL_INDUCTOR = this.addItem(45, "component.supracausal_smd.inductor");

        //  Gooware Processor Components
        BZ_REACTION_CHAMBER = this.addItem(46, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = this.addItem(47, "nonlinear_chemical_oscillator");

        //  Optical Processor Components
        PHASE_CHANGE_MEMORY = this.addItem(48, "plate.phase_change_memory");
        OPTICAL_FIBER = this.addItem(49, "optical_fiber");
        DIELECTRIC_MIRROR = this.addItem(50, "dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = this.addItem(51, "laser.assembly.empty");
        HELIUM_NEON_LASER = this.addItem(52, "laser.helium_neon");
        ND_YAG_LASER = this.addItem(53, "laser.nd_yag");
        OPTICAL_LASER_CONTROL_UNIT = this.addItem(54, "optical_laser_control_unit");

        //  Spintronic Processor Components
        SPIN_TRANSFER_TORQUE_MEMORY = this.addItem(55, "plate.spin_transfer_torque_memory");
        TOPOLOGICAL_INSULATOR_TUBE = this.addItem(56, "tube.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = this.addItem(57, "containment_unit.bose_einstein_condensate");
        BOSE_EINSTEIN_CONDENSATE = this.addItem(58, "bose_einstein_condensate");
        ESR_COMPUTATION_UNIT = this.addItem(59, "esr_computation_unit");
    }
}
