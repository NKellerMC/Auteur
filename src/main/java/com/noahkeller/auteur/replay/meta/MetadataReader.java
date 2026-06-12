package com.noahkeller.auteur.replay.meta;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Path;

public class MetadataReader {

    private static final Gson GSON =
            new Gson();

    public static ReplayMetadata load(
            Path file
    ) throws Exception {

        return GSON.fromJson(
                Files.readString(file),
                ReplayMetadata.class
        );
    }

}
