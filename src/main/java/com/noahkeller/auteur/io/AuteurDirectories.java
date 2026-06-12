package com.noahkeller.auteur.io;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AuteurDirectories {

    public static Path root() {

        return FabricLoader
                .getInstance()
                .getGameDir()
                .resolve("auteur");
    }

    public static Path replays() {

        return root()
                .resolve("replays");
    }

    public static Path cache() {

        return root()
                .resolve("cache");
    }

    public static Path exports() {

        return root()
                .resolve("exports");
    }

    public static void createDirectories()
            throws IOException {

        Files.createDirectories(root());

        Files.createDirectories(replays());

        Files.createDirectories(cache());

        Files.createDirectories(exports());
    }
}
