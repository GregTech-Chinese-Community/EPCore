package cn.gtcommunity.epimorphism.loaders.recipe;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;

public class EPFusionLoader {
    public static void init() {
        //  (Mk III) Americium + Naquadria -> Orichalcum
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(128))
                .fluidInputs(Naquadria.getFluid(128))
                .fluidOutputs(Orichalcum.getFluid(32))
                .EUToStart(600000000L)
                .duration(200)
                .EUt(VA[LuV] * 3)
                .buildAndRegister();

        //  (Mk II) Europium + Unstable Adamantium -> Adamantium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Europium.getFluid(16))
                .fluidInputs(AdamantiumUnstable.getFluid(16))
                .fluidOutputs(Adamantium.getPlasma(16))
                .EUToStart(300000000L)
                .duration(32)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  (Mk III) Orichalcum + Unstable Vibranium -> Vibranium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(L))
                .fluidInputs(VibraniumUnstable.getFluid(L))
                .fluidOutputs(Vibranium.getPlasma(L))
                .EUToStart(620000000L)
                .duration(64)
                .EUt(VA[ZPM] * 2)
                .buildAndRegister();

        //  (Mk II) Uranium-238 + Neutron -> Neptunium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Uranium238.getFluid(144))
                .fluidInputs(Neutron.getPlasma(144))
                .fluidOutputs(Neptunium.getFluid(288))
                .EUt(VA[UV])
                .duration(80)
                .EUToStart(300000000L)
                .buildAndRegister();

        //  Nickel + Polonium -> Copernicium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(576))
                .fluidInputs(Polonium.getFluid(576))
                .fluidOutputs(Copernicium.getFluid(576))
                .EUt(VA[UV])
                .duration(100)
                .EUToStart(480000000L)
                .buildAndRegister();

        //  Nickel + Astatine -> Nihonium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(288))
                .fluidInputs(Astatine.getFluid(288))
                .fluidOutputs(Nihonium.getFluid(576))
                .EUt(358690)
                .duration(180)
                .EUToStart(410000000L)
                .buildAndRegister();

        //  Neptunium + Titanium -> Moscovium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Neptunium.getFluid(288))
                .fluidInputs(Titanium.getFluid(288))
                .fluidOutputs(Moscovium.getFluid(576))
                .EUt(473960)
                .duration(220)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  Americium + Titanium -> Tennessine
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(288))
                .fluidInputs(Titanium.getFluid(288))
                .fluidOutputs(Tennessine.getFluid(576))
                .EUt(509370)
                .duration(300)
                .EUToStart(420000000L)
                .buildAndRegister();

        //  (Mk III) Americium + Neon -> Dubnium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Dubnium.getFluid(125))
                .EUt(VA[ZPM])
                .duration(160)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  (Mk III) Plutonium-244 + Calcium -> Seaborgium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(16))
                .fluidInputs(Calcium.getFluid(32))
                .fluidOutputs(Seaborgium.getFluid(48))
                .EUt(VA[UV])
                .duration(220)
                .EUToStart(400000000L)
                .buildAndRegister();

        //  (Mk I) Plutonium-244 + Neon -> Rutherfordium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Rutherfordium.getFluid(16))
                .EUt(VA[LuV])
                .duration(120)
                .EUToStart(150000000L)
                .buildAndRegister();

        //  (Mk IV) Plutonium-244 + Titanium -> Livermorium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(32))
                .fluidInputs(Titanium.getFluid(32))
                .fluidOutputs(Livermorium.getFluid(64))
                .EUt(VA[UV])
                .duration(200)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  (Mk II) Plutonium-239 + Helium -> Curium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium239.getFluid(32))
                .fluidInputs(Helium.getPlasma(144))
                .fluidOutputs(Curium.getFluid(144))
                .EUt(VA[ZPM])
                .duration(50)
                .EUToStart(280000000L)
                .buildAndRegister();

        //  (Mk III) Curium + Sodium -> Bohrium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Curium.getFluid(288))
                .fluidInputs(Sodium.getFluid(288))
                .fluidOutputs(Bohrium.getFluid(576))
                .EUt(VA[UHV])
                .duration(140)
                .EUToStart(400000000L)
                .buildAndRegister();

        //  (Mk III) Plutonium-241 + Neutron -> Fermium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(144))
                .fluidInputs(Neutron.getPlasma(144))
                .fluidOutputs(Fermium.getFluid(288))
                .EUt(VA[UV])
                .duration(80)
                .EUToStart(500000000L)
                .buildAndRegister();

        //  Iron + Bismuth-209 -> Meitnerium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Iron.getPlasma(L))
                .fluidInputs(Bismuth209.getFluid(L))
                .fluidOutputs(Meitnerium.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(140)
                .EUToStart(400000000L)
                .buildAndRegister();

        //  Nickel + Bismuth-209 -> Roentgenium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Nickel.getPlasma(L))
                .fluidInputs(Bismuth209.getFluid(L))
                .fluidOutputs(Roentgenium.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(180)
                .EUToStart(440000000L)
                .buildAndRegister();

        //  (Mk IV) Metastable Oganesson
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidInputs(Californium252.getFluid(L * 2))
                .fluidOutputs(OganessonBreedingBase.getFluid(L * 4))
                .EUt(VA[IV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(OganessonBreedingBase.getFluid(144))
                .fluidInputs(Curium.getFluid(36))
                .fluidOutputs(HotOganesson.getFluid(144))
                .EUt(VA[UHV])
                .duration(100)
                .EUToStart(700000000L)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(HotOganesson.getFluid(144))
                .output(ingotHot, MetastableOganesson)
                .EUt(VA[UHV])
                .duration(120)
                .buildAndRegister();

        //  (Mk IV) Infinity + Chaotic Draconium -> Rhugnor
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Infinity.getFluid(L))
                .fluidInputs(ChaoticDraconium.getFluid(L * 2))
                .fluidOutputs(Rhugnor.getFluid(L))
                .EUt(VA[UV])
                .duration(200)
                .EUToStart(800000000L)
                .buildAndRegister();

        //  (Mk V) Dragon Blood + Rhugnor -> Hypogen
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Rhugnor.getFluid(L * 2))
                .fluidInputs(DragonBlood.getFluid(L))
                .fluidOutputs(Hypogen.getPlasma(L))
                .EUt(VA[UEV])
                .duration(600)
                .EUToStart(1800000000L)
                .buildAndRegister();

        //  Hypogen plasma Containment Cell
        CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(Hypogen.getPlasma(1000))
                .outputs(HYPOGEN_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();

        //  Astral Titanium Chain
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Neon.getFluid(144))
                .fluidInputs(Bedrock.getFluid(144))
                .fluidOutputs(Taranium.getPlasma(1000))
                .EUt(VA[UV])
                .duration(64)
                .EUToStart(100000000L)
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Krypton.getFluid(1000))
                .fluidInputs(Taranium.getPlasma(1000))
                .fluidOutputs(AstralTitanium.getPlasma(1000))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(300000000L)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(AstralTitanium.getPlasma(L))
                .output(ingotHot, AstralTitanium)
                .EUt(VA[UEV])
                .duration(120)
                .buildAndRegister();

        //  Celestial Tungsten Chain
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Xenon.getFluid(1000))
                .fluidInputs(Taranium.getPlasma(1000))
                .fluidOutputs(CelestialTungsten.getPlasma(1000))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(300000000L)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(CelestialTungsten.getPlasma(L))
                .output(ingotHot, CelestialTungsten)
                .EUt(VA[UEV])
                .duration(120)
                .buildAndRegister();

        //  Metastable Fl Chain
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Uranium238.getFluid(125))
                .fluidInputs(Uranium238.getFluid(125))
                .fluidOutputs(QuasifissioningPlasma.getFluid(125))
                .EUt(600000)
                .duration(100)
                .EUToStart(250000000L)
                .buildAndRegister();

        //  Adamantium + Nether Star -> Ichor Liquid
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Adamantium.getFluid(L * 2))
                .fluidInputs(NetherStar.getFluid(L * 2))
                .fluidOutputs(IchorLiquid.getFluid(L * 4))
                .EUt(500000)
                .duration(20)
                .EUToStart(360000000L)
                .buildAndRegister();

        //  Ichor Liquid + Radon -> Ichorium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(IchorLiquid.getFluid(L))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(Ichorium.getFluid(L))
                .EUt(VA[UV])
                .duration(60)
                .EUToStart(340000000L)
                .buildAndRegister();

        //  Vibranium + Duranium -> Crystal Matrix
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(L * 2))
                .fluidInputs(Duranium.getFluid(L * 2))
                .fluidOutputs(CrystalMatrix.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(120)
                .EUToStart(350000000L)
                .buildAndRegister();

        //  Orichalcum + Lutetium -> Dragon Tear
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(L))
                .fluidInputs(Lutetium.getFluid(L))
                .fluidOutputs(DragonTear.getFluid(L * 2))
                .EUt(VA[UV])
                .duration(240)
                .EUToStart(346000000L)
                .buildAndRegister();

        //  Europium + Dragon Tear -> Mithril
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Europium.getFluid(L * 2))
                .fluidInputs(DragonTear.getFluid(L * 2))
                .fluidOutputs(Mithril.getPlasma(L * 4))
                .EUt(VA[UHV])
                .duration(120)
                .EUToStart(440000000L)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(Mithril.getPlasma(L))
                .output(ingotHot, Mithril)
                .duration(200)
                .EUt(VA[ZPM])
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Mithril), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Mithril), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Krypton.getFluid(50)});

        //  Crystal Matrix + Mithril -> Infinity
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(CrystalMatrix.getFluid(L * 2))
                .fluidInputs(Mithril.getFluid(L * 2))
                .fluidOutputs(Infinity.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(240)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Metastable Hassium Chain
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Radium.getFluid(L))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(RadiumRadonMixture.getFluid(L * 2))
                .EUt(VA[UV])
                .duration(130)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(RadiumRadonMixture.getFluid(L * 2))
                .fluidOutputs(Radium.getFluid(L))
                .fluidOutputs(Radon.getFluid(1000))
                .EUt(VA[IV])
                .duration(260)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Scandium.getFluid(L))
                .fluidInputs(Titanium.getFluid(L))
                .fluidOutputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .EUt(VA[UV])
                .duration(130)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .fluidOutputs(Scandium.getFluid(L))
                .fluidOutputs(Titanium.getFluid(L))
                .EUt(VA[IV])
                .duration(260)
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(RadiumRadonMixture.getFluid(L * 2))
                .fluidInputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .fluidOutputs(MetastableHassium.getFluid(L * 4))
                .EUt(VA[UEV])
                .duration(100)
                .EUToStart(2500000000L)
                .buildAndRegister();
    }
}
