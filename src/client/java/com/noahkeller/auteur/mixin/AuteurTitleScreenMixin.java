package com.noahkeller.auteur.mixin;

import com.noahkeller.auteur.gui.AuteurReplayBrowserScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class AuteurTitleScreenMixin extends Screen {

    protected AuteurTitleScreenMixin() {
        super(Component.empty());
    }

    @Inject(
            method = "init",
            at = @At("TAIL")
    )
    private void auteur$addButton(
            CallbackInfo ci
    ) {

        this.addRenderableWidget(

                Button.builder(
                        Component.literal("A"),
                        button -> minecraft.setScreen(
                                new AuteurReplayBrowserScreen()
                        )
                )

                .bounds(
                        this.width / 2 + 104,
                        this.height / 4 + 48,
                        20,
                        20
                )

                .build()
        );
    }
}
