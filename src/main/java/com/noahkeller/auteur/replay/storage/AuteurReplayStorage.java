package com.noahkeller.auteur.replay.storage;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AuteurReplayStorage {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd_HH-mm-ss"
            );

    public static Path getReplayRoot() {

        return FabricLoader
                .getInstance()
                .getGameDir()
                .resolve("auteur_replays");
    }

    public static void ensureExists()
            throws IOException {

        Files.createDirectories(
                getReplayRoot()
        );
    }

    public static Path createReplayFolder()
            throws IOException {

        ensureExists();

        String name =
                "Replay_" +
                LocalDateTime.now()
                        .format(FORMATTER);

        Path folder =
                getReplayRoot()
                        .resolve(name);

        Files.createDirectories(folder);

        return folder;
    }

    public static List<Path> listReplayFolders()
            throws IOException {

        ensureExists();

        try (var stream =
                     Files.list(
                             getReplayRoot()
                     )) {

            return stream
                    .filter(Files::isDirectory)
                    .sorted()
                    .toList();
        }
    }

}
