package com.noahkeller.auteur.replay.meta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;

public class MetadataWriter {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static void save(
            Path file,
            ReplayMetadata metadata
    ) throws Exception {

        Files.writeString(
                file,
                GSON.toJson(metadata)
        );
    }

}
