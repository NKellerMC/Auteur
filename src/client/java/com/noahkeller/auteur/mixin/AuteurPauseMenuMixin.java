package com.noahkeller.auteur.mixin;

import com.noahkeller.auteur.record.RecordingManager;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public abstract class AuteurPauseMenuMixin extends Screen {

    protected AuteurPauseMenuMixin() {
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
                        auteur$text(),
                        button -> {

                            if (!RecordingManager.SESSION.isRecording()) {

                                RecordingManager.SESSION.start();

                            } else {

                                RecordingManager.SESSION.stop();

                            }

                            button.setMessage(
                                    auteur$text()
                            );

                        }
                )
                .bounds(
                        10,
                        10,
                        140,
                        20
                )
                .build()

        );

    }

    @Unique
    private Component auteur$text() {

        return RecordingManager.SESSION.isRecording()

                ? Component.literal(
                        "Auteur - Parar"
                )

                : Component.literal(
                        "Auteur - Gravar"
                );
    }

}
