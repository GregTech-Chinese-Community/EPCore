package cn.gtcommunity.epimorphism.api.unification;

import cn.gtcommunity.epimorphism.api.unification.materials.EPMaterialFlagAddition;
import cn.gtcommunity.epimorphism.api.unification.materials.EPMaterialPropertyAddition;
import cn.gtcommunity.epimorphism.api.unification.materials.EPOrganicChemistryMaterials;
import cn.gtcommunity.epimorphism.api.unification.materials.EPUnknownCompositionMaterials;
import gregtech.api.unification.material.Material;

public class EPMaterials {
public EPMaterials() {}

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

    //  Unknown Composition Materials
    public static Material BZMedium;
    public static Material EDP;

    //  Range: 25000-26000
    public static void init() {
        EPMaterialPropertyAddition.init();
        EPMaterialFlagAddition.init();
        EPOrganicChemistryMaterials.register();
        EPUnknownCompositionMaterials.register();
    }

}
