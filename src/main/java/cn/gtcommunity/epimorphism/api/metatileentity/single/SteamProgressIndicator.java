package cn.gtcommunity.epimorphism.api.metatileentity.single;

import gregtech.api.gui.resources.SteamTexture;
import gregtech.api.gui.widgets.ProgressWidget;

public class SteamProgressIndicator {
    public SteamTexture progressBarTexture;
    public ProgressWidget.MoveType progressMoveType;
    public int width, height;

    /**  SteamProgressIndicator(SteamTexture progressBarTexture, ProgressWidget.MoveType progressMoveType, int width, int height)
     * @param progressBarTexture Progress Bar textures of machine, you can use renderer in EPGuiTextures or GuiTextures
     * @param progressMoveType Move type of progress bar
     * @param width Width of progress bar
     * @param height Height of progress bar
     */
    public SteamProgressIndicator(SteamTexture progressBarTexture, ProgressWidget.MoveType progressMoveType, int width, int height) {
        this.progressBarTexture = progressBarTexture;
        this.progressMoveType = progressMoveType;
        this.width = width;
        this.height = height;
    }
}
