package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
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
        //  25222 Bedrock
        Bedrock = new Material.Builder(25222, gregtechId("bedrock"))
                .dust()
                .color(0x404040)
                .iconSet(ROUGH)
                .build();
        //  25223 Bedrock Smoke
        BedrockSmoke = new Material.Builder(25223, gregtechId("bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x525252)
                .build();
        //  25224 Bedrock Soot Solution
        BedrockSootSolution = new Material.Builder(25224, gregtechId("bedrock_soot_solution"))
                .fluid()
                .color(0x1E2430)
                .build();
        //  25225 Clean Bedrock Solution
        CleanBedrockSolution = new Material.Builder(25225, gregtechId("clean_bedrock_solution"))
                .fluid()
                .color(0xA89F9E)
                .build();
        //  25226 Heavy Bedrock Smoke
        HeavyBedrockSmoke = new Material.Builder(25226, gregtechId("heavy_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x242222)
                .build();
        //  25227 Medium Bedrock Smoke
        MediumBedrockSmoke = new Material.Builder(25227, gregtechId("medium_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x2E2C2C)
                .build();
        //  25228 Light Bedrock Smoke
        LightBedrockSmoke = new Material.Builder(25228, gregtechId("light_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x363333)
                .build();
        //  25229 Ultralight Bedrock Smoke
        UltralightBedrockSmoke = new Material.Builder(25229, gregtechId("ultralight_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x403D3D)
                .build();
        //  25230 Heavy Taranium Gas
        HeavyTaraniumGas = new Material.Builder(25230, gregtechId("heavy_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x262626)
                .build();
        //  25231 Medium Taranium Gas
        MediumTaraniumGas = new Material.Builder(25231, gregtechId("medium_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x313131)
                .build();
        //  25232 Light Taranium Gas
        LightTaraniumGas = new Material.Builder(25232, gregtechId("light_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x404040)
                .build();
        //  25233 Bedrock Gas
        BedrockGas = new Material.Builder(25233, gregtechId("bedrock_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x575757)
                .build();
        //  25234 Cracked Heavy Taranium
        CrackedHeavyTaranium = new Material.Builder(25234, gregtechId("cracked_heavy_taranium"))
                .fluid()
                .color(0x1F2B2E)
                .build();
        //  25235 Cracked Medium Taranium
        CrackedMediumTaranium = new Material.Builder(25235, gregtechId("cracked_medium_taranium"))
                .fluid()
                .color(0x29393D)
                .build();
        //  25236 Cracked Light Taranium
        CrackedLightTaranium = new Material.Builder(25236, gregtechId("cracked_light_taranium"))
                .fluid()
                .color(0x374C52)
                .build();
        //  25237 Enriched Bedrock Soot Solution
        EnrichedBedrockSootSolution = new Material.Builder(25237, gregtechId("enriched_bedrock_soot_solution"))
                .fluid()
                .color(0x280C26)
                .build();
        //  25238 Clean Enriched Bedrock Solution
        CleanEnrichedBedrockSolution = new Material.Builder(25238, gregtechId("clean_enriched_bedrock_solution"))
                .fluid()
                .color(0x828C8C)
                .build();
        //  25239 Heavy Enriched Bedrock Smoke
        HeavyEnrichedBedrockSmoke = new Material.Builder(25239, gregtechId("heavy_enriched_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x1A2222)
                .build();
        //  25240 Medium Enriched Bedrock Smoke
        MediumEnrichedBedrockSmoke = new Material.Builder(25240, gregtechId("medium_enriched_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x1E2C2C)
                .build();
        //  25241 Light Enriched Bedrock Smoke
        LightEnrichedBedrockSmoke = new Material.Builder(25241, gregtechId("light_enriched_bedrock_smoke"))
                .fluid(FluidTypes.GAS)
                .color(0x163333)
                .build();
        //  25242 Heavy Enriched Taranium Gas
        HeavyEnrichedTaraniumGas = new Material.Builder(25242, gregtechId("heavy_enriched_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x1F2626)
                .build();
        //  25243 Medium Enriched Taranium Gas
        MediumEnrichedTaraniumGas = new Material.Builder(25243, gregtechId("medium_enriched_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x1F3131)
                .build();
        //  25244 Light Enriched Taranium Gas
        LightEnrichedTaraniumGas = new Material.Builder(25244, gregtechId("light_enriched_taranium_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x1F4040)
                .build();
        //  25245 Cracked Heavy Enriched Taranium
        CrackedHeavyEnrichedTaranium = new Material.Builder(25245, gregtechId("cracked_heavy_enriched_taranium"))
                .fluid()
                .color(0x2E1F2E)
                .build();
        //  25246 Cracked Medium Enriched Taranium
        CrackedMediumEnrichedTaranium = new Material.Builder(25246, gregtechId("cracked_medium_enriched_taranium"))
                .fluid()
                .color(0x29393D)
                .build();
        //  25247 Cracked Light Enriched Taranium
        CrackedLightEnrichedTaranium = new Material.Builder(25247, gregtechId("cracked_light_enriched_taranium"))
                .fluid()
                .color(0x374C52)
                .build();
        //  25248 Energetic Naquadria
        EnergeticNaquadria = new Material.Builder(25248, gregtechId("energetic_naquadria"))
                .fluid()
                .color(0x202020)
                .build();
        //  25249 Light Hyper Fuel
        LightHyperFuel = new Material.Builder(25249, gregtechId("light_hyper_fuel"))
                .fluid()
                .color(0x8C148C)
                .build();
        //  25250 Medium Hyper Fuel
        MediumHyperFuel = new Material.Builder(25250, gregtechId("medium_hyper_fuel"))
                .fluid()
                .color(0xDC0A0A)
                .build();
        //  25251 Heavy Hyper Fuel
        HeavyHyperFuel = new Material.Builder(25251, gregtechId("heavy_hyper_fuel"))
                .fluid()
                .color(0x1E5064)
                .build();
        //  25252 Crude Rare Earth Turbid Solution
        CrudeRareEarthTurbidSolution = new Material.Builder(25252, gregtechId("crude_rare_earth_turbid_solution"))
                .fluid()
                .color(0x9C5C6B)
                .iconSet(DULL)
                .build();
        //  25253 Nitrated Rare Earth Turbid Solution
        NitratedRareEarthTurbidSolution = new Material.Builder(25253, gregtechId("nitrated_rare_earth_turbid_solution"))
                .fluid()
                .color(0x754550)
                .iconSet(DULL)
                .build();
        //  25254 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = new Material.Builder(25254, gregtechId("rare_earth_hydroxides_solution"))
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();
        //  25255 Rare Earth Chlorides Slurry
        RareEarthChloridesSlurry = new Material.Builder(25255, gregtechId("rare_earth_chlorides_slurry"))
                .dust()
                .color(0x838367)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();
        //  25256 Low-purity Rare Earth Chlorides Solution
        LowPurityRareEarthChloridesSolution = new Material.Builder(25256, gregtechId("low_purity_rare_earth_chlorides_solution"))
                .fluid()
                .color(0x838333)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 2)
                .build();
        //  25257 Roughly Purified Rare Earth Chlorides Solution
        RoughlyPurifiedRareEarthChloridesSolution = new Material.Builder(25257, gregtechId("roughly_purified_rare_earth_chlorides_solution"))
                .fluid()
                .color(0xA2A27F)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(LowPurityRareEarthChloridesSolution, 4, AquaRegia, 2)
                .build();
        //  25258 High Purity Rare Earth Chlorides Slurry
        HighPurityRareEarthChloridesSlurry = new Material.Builder(25258, gregtechId("high_purity_rare_earth_chlorides_slurry"))
                .dust()
                .color(0x838367)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();
        //  25259 High Purity Rare Earth Chlorides Solution
        HighPurityRareEarthChloridesSolution = new Material.Builder(25259, gregtechId("high_purity_rare_earth_chlorides_solution"))
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();
        //  25260 Low Purity Rare Earth Chlorides Slag
        LowPurityRareEarthChloridesSlag = new Material.Builder(25260, gregtechId("low_purity_rare_earth_chlorides_slag"))
                .dust()
                .color(0x62624D)
                .iconSet(DULL)
                .build();
        //  25261 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = new Material.Builder(25261, gregtechId("la_pr_nd_ce_oxides_solution"))
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();
        //  25262 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = new Material.Builder(25262, gregtechId("sc_eu_gd_sm_oxides_solution"))
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();
        //  25263 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = new Material.Builder(25263, gregtechId("y_tb_dy_ho_oxides_solution"))
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();
        //  25264 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = new Material.Builder(25264, gregtechId("er_tm_yb_lu_oxides_solution"))
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();
    }
}
