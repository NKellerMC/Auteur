package com.noahkeller.auteur;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.noahkeller.auteur.replay.action.AuteurActionRegistry;
import com.noahkeller.auteur.replay.action.ActionNextTick;
import com.noahkeller.auteur.replay.action.ActionPlayerPosition;


public class Auteur implements ModInitializer {

    public static final Logger LOGGER =
            LoggerFactory.getLogger("Auteur");

    @Override
    public void onInitialize() {
        LOGGER.info("Auteur iniciado!");

        AuteurActionRegistry.register(
                "next_tick",
                ActionNextTick::new
        );

        AuteurActionRegistry.register(
                "player_position",
                ActionPlayerPosition::new
        );

    }
}
