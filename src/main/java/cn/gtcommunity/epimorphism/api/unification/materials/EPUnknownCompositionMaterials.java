package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class EPUnknownCompositionMaterials {
    //  Range 25201-25400
    public static void register() {
        //  25201 BZMedium
        BZMedium = new Material.Builder(25201, gregtechId("bz_medium"))
                .fluid()
                .color(10681653)
                .build();
        //  25202 EDP
        EDP = new Material.Builder(25202, gregtechId("edp"))
                .fluid()
                .color(16514839)
                .build();
        //  25203 Rich Nitrogen Mixture
        RichNitrogenMixture = new Material.Builder(25203, gregtechId("rich_nitrogen_mixture"))
                .fluid(FluidTypes.GAS)
                .color(0x6891D8)
                .build();
        //  25204 Rich Ammonia Mixture
        RichAmmoniaMixture = new Material.Builder(25204, gregtechId("rich_ammonia_mixture"))
                .fluid()
                .color(0x708ACD)
                .build();
        //  25205 Blazing Pyrotheum
        BlazingPyrotheum = new Material.Builder(25205, gregtechId("blazing_pyrotheum"))
                .fluid(FluidTypes.LIQUID, true)
                .color(0xE19352)
                .iconSet(DULL)
                .fluidTemp(8000)
                .build();
        //  25206 Gelid Cryotheum
        GelidCryotheum = new Material.Builder(25206, gregtechId("gelid_cryotheum"))
                .fluid(FluidTypes.LIQUID, true)
                .color(0x40B8FB)
                .fluidTemp(8)
                .build();
        //  25207 Co/AC-AB Catalyst
        CoACABCatalyst = new Material.Builder(25207, gregtechId("co_ac_ab_catalyst"))
                .dust()
                .color(0x6B4312)
                .iconSet(METALLIC)
                .build();
        //  25208 PhosphoreneSolution
        PhosphoreneSolution = new Material.Builder(25208, gregtechId("phosphorene_solution"))
                .fluid()
                .color(0x465966)
                .build();
        //  25209 Methylamine Mixture
        MethylamineMixture = new Material.Builder(25209, gregtechId("methylamine_mixture"))
                .fluid()
                .color(0xAA4400)
                .build();
        //  25210 Molybdenum Flue
        MolybdenumFlue = new Material.Builder(25210, gregtechId("molybdenum_flue"))
                .fluid(FluidTypes.GAS)
                .color(0x39194A)
                .build();
        //  25211 Trace Rhenium Flue
        TraceRheniumFlue = new Material.Builder(25211, gregtechId("trace_rhenium_flue"))
                .fluid(FluidTypes.GAS)
                .color(0x96D6D5)
                .build();
        //  25212 Chalcogen Anode Mud
        ChalcogenAnodeMud = new Material.Builder(25212, gregtechId("chalcogen_anode_mud"))
                .dust()
                .color(0x8A3324)
                .iconSet(FINE)
                .build();
        //  25213 Precious Metal
        PreciousMetal = new Material.Builder(25213, gregtechId("precious_metal"))
                .dust()
                .color(0xDAA520)
                .ore()
                .build();
        //  25214 Iridium Platinum Metal Dust
        IridiumPlatinumMetalDust = new Material.Builder(25214, gregtechId("iridium_platinum_metal_dust"))
                .dust()
                .color(0x87CEFA)
                .ore()
                .build();
        //  25215 Rarest Metal Residue
        RarestMetalResidue = new Material.Builder(25215, gregtechId("rarest_metal_residue"))
                .dust()
                .color(0xA0522D)
                .ore()
                .build();
        //  25216 Crude Naquadah Fuel
        CrudeNaquadahFuel = new Material.Builder(25216, gregtechId("crude_naquadah_fuel"))
                .fluid()
                .color(0x077F4E)
                .iconSet(DULL)
                .build();
        //  25217 Heavy Naquadah Fuel
        HeavyNaquadahFuel = new Material.Builder(25217, gregtechId("heavy_naquadah_fuel"))
                .fluid()
                .color(0x088C56)
                .build();
        //  25218 Medium Naquadah Fuel
        MediumNaquadahFuel = new Material.Builder(25218, gregtechId("medium_naquadah_fuel"))
                .fluid()
                .color(0x09A566)
                .build();
        //  25219 Light Naquadah Fuel
        LightNaquadahFuel = new Material.Builder(25219, gregtechId("light_naquadah_fuel"))
                .fluid()
                .color(0x0BBF75)
                .build();
        //  25220 Naquadah Gas
        NaquadahGas = new Material.Builder(25220, gregtechId("naquadah_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x0CD985)
                .iconSet(GAS)
                .build();
        //  25221 Fracturing Fluid
        FracturingFluid = new Material.Builder(25221, gregtechId("fracturing_fluid"))
                .fluid()
                .color(0x96D6D5)
                .build();
    }
}
