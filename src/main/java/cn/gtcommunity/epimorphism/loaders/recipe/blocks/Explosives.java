package cn.gtcommunity.epimorphism.loaders.recipe.blocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockExplosive;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class Explosives {
    public static void init() {
        //  Naquadria Charge
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Uranium238)
                .input(dust, Naquadria)
                .inputs(GELLED_TOLUENE.getStackForm(4))
                .input(dust, Hexanitrohexaaxaisowurtzitane)
                .input(plate, Osmium)
                .input(bolt, Titanium, 4)
                .fluidInputs(GlycerylTrinitrate.getFluid(1000))
                .outputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.NAQUADRIA_CHARGE))
                .EUt(VA[UV])
                .duration(100)
                .scannerResearch(b -> b
                        .researchStack(DYNAMITE.getStackForm())
                        .EUt(VA[ZPM])
                        .duration(1200))
                .buildAndRegister();

        //  Taranium Charge (Require Degenerate Rhenium, i.e. Naquadria Charge)
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Plutonium241)
                .input(dust, Taranium)
                .inputs(GELLED_TOLUENE.getStackForm(4))
                .input(dust, Hexanitrohexaaxaisowurtzitane)
                .input(plate, DegenerateRhenium)
                .input(bolt, TungstenSteel, 4)
                .fluidInputs(GlycerylTrinitrate.getFluid(3000))
                .fluidInputs(Trinium.getFluid(L))
                .outputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.TARANIUM_CHARGE))
                .EUt(VA[UHV])
                .duration(100)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.NAQUADRIA_CHARGE))
                        .EUt(VA[UV])
                        .duration(1200))
                .buildAndRegister();

        //  Leptonic Charge
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.TARANIUM_CHARGE))
                .input(plate, MetastableOganesson)
                .input(plate, Vibranium)
                .input(bolt, Dubnium, 4)
                .fluidInputs(Tritanium.getFluid(576))
                .fluidInputs(FreeElectronGas.getFluid(1000))
                .outputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.LEPTONIC_CHARGE))
                .EUt(VA[UEV])
                .duration(100)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.TARANIUM_CHARGE))
                        .EUt(VA[UHV])
                        .duration(1200))
                .buildAndRegister();

        //  QCD Charge
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.LEPTONIC_CHARGE))
                .input(plate, HeavyQuarkDegenerateMatter, 2)
                .input(plate, CelestialTungsten, 2)
                .input(plate, AstralTitanium, 2)
                .input(plate, DegenerateRhenium, 2)
                .input(bolt, Legendarium, 16)
                .fluidInputs(Gluons.getFluid(1296))
                .fluidInputs(SuperheavyHAlloy.getFluid(L))
                .fluidInputs(SuperheavyLAlloy.getFluid(L))
                .outputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.QUANTUM_CHROMODYNAMIC_CHARGE))
                .EUt(VA[UIV])
                .duration(100)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.LEPTONIC_CHARGE))
                        .EUt(VA[UEV])
                        .duration(1200))
                .buildAndRegister();
    }
}
