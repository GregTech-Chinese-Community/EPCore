package cn.gtcommunity.epimorphism.api.unification;

import cn.gtcommunity.epimorphism.api.unification.materials.*;
import gregtech.api.unification.material.Material;

public class EPMaterials {
public EPMaterials() {}

    //  First Degree Materials
    public static Material GrapheneOxide;
    public static Material Hydrazine;
    public static Material BerylliumOxide;
    public static Material HydrogenPeroxide;
    public static Material TungstenTrioxide;
    public static Material HexagonalBoronNitride;
    public static Material CubicBoronNitride;
    public static Material BoricAcid;
    public static Material BoronTrioxide;
    public static Material BoronTrifluoride;
    public static Material LithiumHydride;
    public static Material LithiumTetrafluoroborate;
    public static Material Diborane;
    public static Material Borazine;
    public static Material BoronTrichloride;
    public static Material Trichloroborazine;
    public static Material AmorphousBoronNitride;
    public static Material Heterodiamond;
    public static Material CubicHeterodiamond;
    public static Material CarbonNanotube;
    public static Material SilverTetrafluoroborate;
    public static Material TrimethyltinChloride;
    public static Material SilverChloride;
    public static Material ChloroplatinicAcid;
    public static Material PotassiumTetrachloroplatinate;
    public static Material NickelTriphenylphosphite;
    public static Material NickelChloride;
    public static Material PhosphorusTrichloride;
    public static Material AmmoniumSulfate;
    public static Material AmmoniumPersulfate;
    public static Material HydroxylamineDisulfate;
    public static Material Hydroxylamine;
    public static Material AmmoniumNitrate;
    public static Material ThalliumSulfate;
    public static Material ThalliumChloride;
    public static Material IodizedBrine;
    public static Material IodineBrineMixture;
    public static Material BrominatedBrine;
    public static Material IodineSlurry;
    public static Material SodiumIodate;
    public static Material SodiumIodide;
    public static Material SodiumHypochlorite;
    public static Material SodiumPeriodate;
    public static Material AcidicBrominatedBrine;
    public static Material BromineSulfateSolution;
    public static Material OverheatedBromineSulfateSolution;
    public static Material WetBromine;
    public static Material DebrominatedWater;
    public static Material PalladiumChloride;
    public static Material PalladiumOnCarbon;
    public static Material PotassiumPermanganate;
    public static Material PotassiumManganate;
    public static Material TinChloride;
    public static Material SilverOxide;
    public static Material SodiumFluoride;
    public static Material ZnFeAlClCatalyst;
    public static Material SodiumNitrite;
    public static Material SodiumNitrate;
    public static Material FluoroboricAcid;
    public static Material BenzenediazoniumTetrafluoroborate;

    //  Organic Chemistry Materials
    public static Material KaptonK;
    public static Material KaptonE;
    public static Material Edot;
    public static Material Polystyrene;
    public static Material PolystyreneSulfonate;
    public static Material PedotPSS;
    public static Material PMMA;
    public static Material PedotTMA;
    public static Material TetramethylammoniumHydroxide;
    public static Material PotassiumHydroxide;
    public static Material PotassiumBromate;
    public static Material MalonicAcid;
    public static Material ChloroaceticAcid;
    public static Material Trichloroethylene;
    public static Material Dichloroethane;
    public static Material HydrobromicAcid;
    public static Material Butanediol;
    public static Material Diacetyl;
    public static Material EthyleneGlycol;
    public static Material SulfurDichloride;
    public static Material AcetoneCyanohydrin;
    public static Material ParaXylene;
    public static Material Cycloparaphenylene;
    public static Material Dichlorocyclooctadieneplatinium;
    public static Material Diiodobiphenyl;
    public static Material Bipyridine;
    public static Material PalladiumBisdibenzylidieneacetone;
    public static Material Octene;
    public static Material Acetylene;
    public static Material Cyclooctadiene;
    public static Material Pyridine;
    public static Material Formaldehyde;
    public static Material Dibenzylideneacetone;
    public static Material Benzaldehyde;
    public static Material BenzoylChloride;
    public static Material ThionylChloride;
    public static Material Polyetheretherketone;
    public static Material Difluorobenzophenone;
    public static Material Hydroquinone;
    public static Material Resorcinol;
    public static Material Fluorobenzene;
    public static Material Fluorotoluene;
    public static Material Kevlar;
    public static Material ParaPhenylenediamine;
    public static Material TerephthaloylChloride;
    public static Material NMethylPyrrolidone;
    public static Material Nitroaniline;
    public static Material Durene;
    public static Material PyromelliticDianhydride;
    public static Material Aminophenol;
    public static Material Aniline;
    public static Material Oxydianiline;
    public static Material Dimethylformamide;
    public static Material PhthalicAnhydride;
    public static Material BiphenylTetracarboxylicAcidDianhydride;

    //  Unknown Composition Materials
    public static Material BZMedium;
    public static Material EDP;
    public static Material RichNitrogenMixture;
    public static Material RichAmmoniaMixture;
    public static Material BlazingPyrotheum;
    public static Material GelidCryotheum;
    public static Material CoACABCatalyst;

    //  Machine Casing Materials
    public static Material Inconel625;
    public static Material HastelloyN;


    //  Biological Production Line
    /*public static Material ArtificialBaseX;
    public static Material ArtificialBaseZ;
    public static Material ;
    public static Material
    public static Material
    public static Material*/

    //  Range: 24000-28000
    public static void init() {
        EPMaterialPropertyAddition.init();
        EPMaterialFlagAddition.init();
        EPFirstDegreeMaterials.register();
        EPOrganicChemistryMaterials.register();
        EPUnknownCompositionMaterials.register();
        EPMachineCasingMaterials.register();
    }

}
