package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraft.init.Items;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class DragonChain {
    public static void init() {

        //  Dragon process Step1
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, DragonDust, 16)
                .inputs(SodiumPerchlorate.getItemStack(6))
                .fluidInputs(SulfurDioxide.getFluid(8000))
                .fluidInputs(NitricAcid.getFluid(L * 40))
                .output(dust, Astatine, 8)
                .output(dust, SeleniumDioxide, 24)
                .fluidOutputs(NitratedDragonDustSolution.getFluid(4000))
                .EUt(VA[ZPM])
                .duration(270)
                .temperature(2440)
                .buildAndRegister();

        //  Dragon process Step2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 36)
                .fluidInputs(NitratedDragonDustSolution.getFluid(2000))
                .output(dust, ActiniumDraconiumHydroxides, 29)
                .output(dust, SodiumSulfide, 12)
                .fluidOutputs(ResidualDraconiumSolution.getFluid(2000))
                .EUt(VA[UV])
                .duration(190)
                .buildAndRegister();

        //  Actinium Draconium Hydroxides -> Actinium Radium Hydroxide Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, ActiniumDraconiumHydroxides, 58)
                .input(dust, Radium)
                .input(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .fluidInputs(Water.getFluid(2000))
                .output(SATURATED_FULLERENE_SIEVING_MATRIX)
                .fluidOutputs(ActiniumRadiumHydroxideSolution.getFluid(2000))
                .EUt(VA[UV])
                .duration(210)
                .buildAndRegister();

        //  Actinium Radium Hydroxide Solution -> Actinium Radium Nitrate Solution
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .fluidInputs(ActiniumRadiumHydroxideSolution.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(12000))
                .fluidOutputs(ActiniumRadiumNitrateSolution.getFluid(13000))
                .EUt(VA[IV])
                .duration(290)
                .buildAndRegister();

        //  Actinium Radium Nitrate Solution -> Actinium Nitrate + Radium Nitrate + Th, Pa, Fr, Ra
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ActiniumRadiumNitrateSolution.getFluid(13000))
                .output(dust, ActiniumNitrate, 26)
                .output(dust, RadiumNitrate, 27)
                .output(dustSmall, Thorium)
                .output(dustSmall, Protactinium)
                .output(dustSmall, Francium)
                .output(dustSmall, Radium)
                .EUt(VA[ZPM])
                .duration(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ActiniumNitrate, 13)
                .fluidInputs(Water.getFluid(4000))
                .output(dust, Actinium)
                .fluidOutputs(Nitrogen.getFluid(3000))
                .fluidOutputs(Oxygen.getFluid(9000))
                .fluidOutputs(Steam.getFluid(4000))
                .EUt(VA[HV])
                .duration(210)
                .temperature(1998)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, RadiumNitrate, 9)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, Radium)
                .fluidOutputs(Nitrogen.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(6000))
                .fluidOutputs(Steam.getFluid(2000))
                .EUt(VA[HV])
                .duration(210)
                .temperature(2137)
                .buildAndRegister();


        //  Fullerene Sieving Matrix
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Fluorocarborane, 50)
                .input(wireFine, Naquadah, 6)
                .input(dust, Osmium)
                .fluidInputs(Perfluorobenzene.getFluid(2000))
                .output(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .EUt(VA[UV])
                .duration(380)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Saturated Fullerene Sieving Matrix cycle
        CHEMICAL_RECIPES.recipeBuilder()
                .input(SATURATED_FULLERENE_SIEVING_MATRIX)
                .fluidInputs(FluoroantimonicAcid.getFluid(8000))
                .fluidInputs(KryptonDifluoride.getFluid(16000))
                .output(dust, AntimonyTrifluoride, 32)
                .output(dust, Fluorocarborane, 50)
                .fluidOutputs(Krypton.getFluid(16000))
                .fluidOutputs(HeavyFluorinatedDraconiumSolution.getFluid(8000))
                .EUt(VA[ZPM])
                .duration(180)
                .buildAndRegister();

        //  Heavy Fluorinated Draconium Solution
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyFluorinatedDraconiumSolution.getFluid(8000))
                .output(dust, DraconiumTetrafluoride, 60)
                .fluidOutputs(Fluorine.getFluid(16000))
                .fluidOutputs(Perfluorobenzene.getFluid(2000))
                .EUt(VA[LuV])
                .duration(360)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, DraconiumTetrafluoride, 5)
                .fluidInputs(Sodium.getFluid(500))
                .output(dust, Draconium)
                .output(dust, Sodium, 2)
                .fluidOutputs(Fluorine.getFluid(6000))
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        //  Krypton Difluoride
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .fluidInputs(Krypton.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(KryptonDifluoride.getFluid(1000))
                .EUt(VA[HV])
                .duration(170)
                .buildAndRegister();

        //  Perfluorobenzene
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Rhenium)
                .input(dust, PotassiumFluoride, 12)
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, RockSalt, 12)
                .fluidOutputs(Perfluorobenzene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[HV])
                .duration(190)
                .buildAndRegister();

        //  Fluorocarborane
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, CaesiumCarborane, 50)
                .input(dust, SilverNitrate, 10)
                .input(dust, Iodine, 2)
                .fluidInputs(Fluorine.getFluid(44000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(Trimethylsilane.getFluid(1000))
                .output(dust, Fluorocarborane, 50)
                .output(dust, CaesiumNitrate, 10)
                .output(dust, SilverIodide, 4)
                .fluidOutputs(HydrofluoricAcid.getFluid(22000))
                .fluidOutputs(Trimethylchlorosilane.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(320)
                .CasingTier(5)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


        //  Silver Nitrate
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silver)
                .fluidInputs(NitricAcid.getFluid(2000))
                .output(dust, SilverNitrate, 5)
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(150)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SilverOxide)
                .fluidInputs(NitricAcid.getFluid(2000))
                .output(dust, SilverNitrate, 10)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(150)
                .buildAndRegister();

        //  Caesium Carbonrane
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, CaesiumCarboranePrecursor, 38)
                .input(dust, LithiumHydride)
                .fluidInputs(BoraneDimethylsulfide.getFluid(1000))
                .fluidInputs(Tetrahydrofuran.getFluid(1000))
                .output(dust, CaesiumCarborane, 25)
                .output(dust, LithiumChloride, 2)
                .fluidOutputs(Trimethylamine.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(Methane.getFluid(2000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .EUt(VA[LuV])
                .duration(260)
                .CasingTier(3)
                .buildAndRegister();

        //  Caesium Carborane Precursor
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, CaesiumHydroxide, 3)
                .input(dust, Decaborane, 24)
                .inputs(SodiumCyanide.getItemStack())
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Methanol.getFluid(3000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, CaesiumCarboranePrecursor, 38)
                .output(dust, Salt, 2)
                .fluidOutputs(Water.getFluid(4000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(240)
                .CasingTier(2)
                .buildAndRegister();

        //  Caesium Hydroxide
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Caesium, 2)
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, CaesiumHydroxide, 6)
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();

        //  Decaborane
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, SodiumBorohydride, 51)
                .fluidInputs(HydrofluoricAcid.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(2000))
                .fluidInputs(BoronTrifluorideEtherate.getFluid(10000))
                .output(dust, Decaborane, 24)
                .output(dust, SodiumFluoride, 2)
                .output(dust, SodiumTetrafluoroborate, 45)
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(20000))
                .fluidOutputs(DiethylEther.getFluid(10000))
                .EUt(VA[IV])
                .duration(280)
                .CasingTier(4)
                .buildAndRegister();

        //  Sodium Borohydride
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 8)
                .input(dust, LithiumHydride, 8)
                .fluidInputs(BoricAcid.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(3000))
                .notConsumable(SulfuricAcid.getFluid(1))
                .output(dust, SodiumBorohydride, 6)
                .output(dust, SodiumEthoxide, 27) //TODO use of Sodium Ethoxide
                .output(dust, Lithium, 8)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        //  Sodium Tetrafluoroborate cycle
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumTetrafluoroborate, 6)
                .circuitMeta(0)
                .output(dust, SodiumFluoride, 2)
                .fluidOutputs(BoronTrifluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Diethyl Ether -> Boron Trifluoride Etherate cycle
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(DiethylEther.getFluid(1000))
                .fluidInputs(BoronTrifluoride.getFluid(1000))
                .fluidOutputs(BoronTrifluorideEtherate.getFluid(1000))
                .EUt(VA[MV])
                .duration(150)
                .buildAndRegister();

        //  Borane Dimethylsulfide
        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(DiethylEther.getFluid(1000))
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Diborane.getFluid(1000))
                .fluidInputs(DimethylSulfide.getFluid(1000))
                .fluidOutputs(BoraneDimethylsulfide.getFluid(2000))
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        DISSOLUTION_TANK_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(DimethylSulfide.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[EV])
                .duration(1000)
                .buildAndRegister();

        //  Trimethylsilane
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(Chloromethane.getFluid(3000))
                .fluidOutputs(Trimethylsilane.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .EUt(VA[EV])
                .duration(180)
                .buildAndRegister();

        //  Silver Iodide -> Iodine cycle
        BLAST_RECIPES.recipeBuilder()
                .input(dust, SilverIodide, 4)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, SilverOxide, 3)
                .output(dust, Iodine, 2)
                .EUt(VA[MV])
                .duration(210)
                .blastFurnaceTemp(1100)
                .buildAndRegister();

        //  Trimethylchlorosilane -> Trimethylsilane cycle
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 2)
                .fluidInputs(Trimethylchlorosilane.getFluid(1000))
                .output(dust, LithiumChloride, 2)
                .fluidOutputs(Trimethylsilane.getFluid(1000))
                .EUt(VA[EV])
                .duration(170)
                .buildAndRegister();

        //  Residual Draconium Solution
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(ResidualDraconiumSolution.getFluid(2000))
                .output(dust, SodiumNitrate, 20)
                .output(dust, Salt)
                .fluidOutputs(DraconiumSlagSolution.getFluid(500))
                .EUt(VA[LuV])
                .duration(240)
                .buildAndRegister();

        //  Draconium Slag Solution -> Draconium dust
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(DraconiumSlagSolution.getFluid(500))
                .output(dust, Draconium)
                .chancedOutput(dustSmall, Draconium, 3, 2000, 0)
                .chancedOutput(dustTiny, Draconium, 7, 3000, 0)
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Dragon Breath compatibility
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH)
                .output(Items.GLASS_BOTTLE)
                .fluidOutputs(DragonBreath.getFluid(1000))
                .EUt(VA[HV])
                .duration(50)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(Items.GLASS_BOTTLE)
                .fluidInputs(DragonBreath.getFluid(1000))
                .output(Items.DRAGON_BREATH)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Draconium + Dragon Breath -> Concentrate Dragon Breath
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Draconium)
                .fluidInputs(DragonBreath.getFluid(1000))
                .fluidOutputs(ConcentrateDragonBreath.getFluid(1000))
                .EUt(VA[IV])
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Awakened Draconium + Concentrate Dragon Breath + Radon -> Dragon Blood
        MIXER_RECIPES.recipeBuilder()
                .input(dust, AwakenedDraconium)
                .fluidInputs(ConcentrateDragonBreath.getFluid(1000))
                .fluidInputs(Radon.getFluid(1000))
                .output(dust, Ash)
                .fluidOutputs(DragonBlood.getFluid(1000))
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();
    }
}