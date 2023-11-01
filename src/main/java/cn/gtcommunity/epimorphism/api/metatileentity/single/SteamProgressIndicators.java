package cn.gtcommunity.epimorphism.api.metatileentity.single;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;

public class SteamProgressIndicators {

    public static final SteamProgressIndicator COMPRESS = new SteamProgressIndicator(GuiTextures.PROGRESS_BAR_COMPRESS_STEAM, ProgressWidget.MoveType.HORIZONTAL, 20, 15);
    public static final SteamProgressIndicator ARROW = new SteamProgressIndicator(GuiTextures.PROGRESS_BAR_ARROW_STEAM, ProgressWidget.MoveType.HORIZONTAL, 20, 15);
}
