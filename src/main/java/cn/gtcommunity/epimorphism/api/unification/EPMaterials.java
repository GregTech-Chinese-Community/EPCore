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

    //  Unknown Composition Materials
    public static Material BZMedium;
    public static Material EDP;
    public static Material RichNitrogenMixture;
    public static Material RichAmmoniaMixture;
    public static Material BlazingPyrotheum;
    public static Material GelidCryotheum;

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
