package com.noahkeller.auteur.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AuteurReplayBrowserScreen extends Screen {

    public AuteurReplayBrowserScreen() {
        super(Component.literal("Auteur Replays"));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {

        renderBackground(
                graphics,
                mouseX,
                mouseY,
                delta
        );

        graphics.drawCenteredString(
                font,
                "Auteur Replays",
                width / 2,
                20,
                0xFFFFFF
        );

        super.render(
                graphics,
                mouseX,
                mouseY,
                delta
        );
    }
}
