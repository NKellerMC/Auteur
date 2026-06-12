package com.noahkeller.auteur.replay.storage;

import com.noahkeller.auteur.replay.meta.MetadataReader;
import com.noahkeller.auteur.replay.meta.ReplayMetadata;

import java.nio.file.Path;

public class AuteurReplaySummaryLoader {

    public static AuteurReplaySummary load(
            Path replayFolder
    ) throws Exception {

        ReplayMetadata metadata =
                MetadataReader.load(
                        replayFolder.resolve(
                                "metadata.json"
                        )
                );

        return new AuteurReplaySummary(
                replayFolder,
                metadata.replayName,
                metadata.createdAt,
                metadata.totalFrames,
                metadata.minecraftVersion
        );
    }

}
