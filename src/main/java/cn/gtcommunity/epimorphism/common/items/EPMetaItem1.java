package cn.gtcommunity.epimorphism.common.items;

import cn.gtcommunity.epimorphism.common.items.behaviors.MillBallBehavior;
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

        //  Gooware Components
        BZ_REACTION_CHAMBER = this.addItem(46, "component.gooware.reaction_chamber");
        NONLINEAR_CHEMICAL_OSCILLATOR = this.addItem(47, "component.gooware.nonlinear_chemical_oscillator");

        //  Optical Components
        OPTICAL_LASER_CONTROL_UNIT = this.addItem(48, "component.optical.optical_laser_control_unit");

        //  Spintronic Components
        ESR_COMPUTATION_UNIT = this.addItem(49, "component.spintronic.esr_computation_unit");

        //  Cosmic Components
        COSMIC_INFORMATION_MODULE = this.addItem(50, "component.cosmic.information_module");
        HOLOGRAPHIC_INFORMATION_IMC = this.addItem(51, "component.cosmic.holographic_imc");

        //  Supracausal Components
        SPACETIME_CONDENSER = this.addItem(52, "component.supracausal.spacetime_condenser");
        LIGHT_CONE_MODULE = this.addItem(53, "component.supracausal.light_cone_module");

        //  Lasers
        OPTICAL_FIBER = this.addItem(54, "laser.optical_fiber");
        DIELECTRIC_MIRROR = this.addItem(55, "laser.dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = this.addItem(56, "laser.emitter.empty");
        HELIUM_LASER = this.addItem(57, "laser.emitter.helium");
        NEON_LASER = this.addItem(58, "laser.emitter.neon");
        ARGON_LASER = this.addItem(59, "laser.emitter.argon");
        KRYPTON_LASER = this.addItem(60, "laser.emitter.krypton");
        XENON_LASER = this.addItem(61, "laser.emitter.xenon");
        HELIUM_NEON_LASER = this.addItem(62, "laser.emitter.helium_neon");
        ND_YAG_LASER = this.addItem(63, "laser.emitter.nd_yag");

        //  Condenser Components
        TOPOLOGICAL_INSULATOR_TUBE = this.addItem(64, "tube.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = this.addItem(65, "containment_unit.bose_einstein_condensate");
        BOSE_EINSTEIN_CONDENSATE = this.addItem(66, "bose_einstein_condensate");

        //  Wafers
        PHASE_CHANGE_MEMORY = this.addItem(67, "wafer.chip.phase_change_memory");
        OPTICAL_NOR_MEMORY_CHIP = this.addItem(68, "wafer.chip.optical_nor_memory_chip");
        SPIN_TRANSFER_TORQUE_MEMORY = this.addItem(69, "wafer.chip.spin_transfer_torque_memory");
        NANO_PIC_WAFER = this.addItem(70, "wafer.nano_pic");
        NANO_PIC_CHIP = this.addItem(71, "wafer.chip.nano_pic");
        PICO_PIC_WAFER = this.addItem(72, "wafer.pico_pic");
        PICO_PIC_CHIP = this.addItem(73, "wafer.chip.pico_pic");
        FEMTO_PIC_WAFER = this.addItem(74, "wafer.femto_pic");
        FEMTO_PIC_CHIP = this.addItem(75, "wafer.chip.femto_pic");
        ATTO_PIC_WAFER = this.addItem(76, "wafer.atto_pic");
        ATTO_PIC_CHIP = this.addItem(77, "wafer.chip.atto_pic");
        ZEPTO_PIC_WAFER = this.addItem(78, "wafer.zepto_pic");
        ZEPTO_PIC_CHIP = this.addItem(79, "wafer.chip.zepto_pic");
        DUBNIUM_BOULE = this.addItem(80, "boule.dubnium");
        DUBNIUM_WAFER = this.addItem(81, "wafer.dubnium");

        //  Others
        MAGNETRON = this.addItem(82, "magnetron");
        VOLTAGE_COIL_UHV = this.addItem(83, "voltage_coil.uhv");
        VOLTAGE_COIL_UEV = this.addItem(84, "voltage_coil.uev");
        VOLTAGE_COIL_UIV = this.addItem(85, "voltage_coil.uiv");
        VOLTAGE_COIL_UXV = this.addItem(86, "voltage_coil.uxv");
        VOLTAGE_COIL_OPV = this.addItem(87, "voltage_coil.opv");
        VOLTAGE_COIL_MAX = this.addItem(88, "voltage_coil.max");
        CARBON_ALLOTROPE = this.addItem(89, "carbon_allotrope");
        GRAPHENE_ALIGNED = this.addItem(90, "graphene_aligned");

        //  Biological Components
        ELECTROCHEMICAL_GRADIENT_RECORDER = this.addItem(301, "biological.components.electrochemical_gradient_recorder");
        ULTRA_MICRO_PHASE_SEPARATOR = this.addItem(302, "biological.components.ultra_micro_phase_separator");
        QUANTUM_TUNNELING_MICROTUBULE = this.addItem(303, "biological.components.quantum_tunneling_microtubule");
        HYPERRIBOSOME = this.addItem(304, "biological.components.hyperribosome");
        NEUTRON_ABSORBING_PROTEIN = this.addItem(305, "biological.components.neutron_absorbing_protein");
        SUPEREXCITED_CONDUCTIVE_POLYMER = this.addItem(306, "biological.components.superexcited_conductive_polymer");
        DNA_ENCODER = this.addItem(307, "biological.components.dna_encoder");
        DNA_DECODER = this.addItem(308, "biological.components.dna_decoder");
        DNA_DECODE_ENCODER = this.addItem(309, "biological.components.dna_decode_encoder");

        //  Mill Balls
        GRINDBALL_SOAPSTONE = this.addItem(350, "mill.grindball_soapstone").setMaxStackSize(1).addComponents(new MillBallBehavior());
        GRINDBALL_ALUMINIUM = this.addItem(351, "mill.grindball_aluminium").setMaxStackSize(1).addComponents(new MillBallBehavior());

    }
}
