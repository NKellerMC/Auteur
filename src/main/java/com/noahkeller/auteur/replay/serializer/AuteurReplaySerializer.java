package com.noahkeller.auteur.replay.serializer;

import com.noahkeller.auteur.record.RecordedFrame;
import com.noahkeller.auteur.replay.AuteurReplay;
import com.noahkeller.auteur.replay.io.AuteurReader;
import com.noahkeller.auteur.replay.io.AuteurWriter;
import com.noahkeller.auteur.replay.meta.MetadataReader;
import com.noahkeller.auteur.replay.meta.MetadataWriter;
import com.noahkeller.auteur.replay.meta.ReplayMetadata;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AuteurReplaySerializer {

    public static final String REPLAY_FILE = "replay.auteur";
    public static final String METADATA_FILE = "metadata.json";

    public static void save(
            Path folder,
            ReplayMetadata metadata,
            List<RecordedFrame> frames
    ) throws Exception {

        Files.createDirectories(folder);

        MetadataWriter.save(
                folder.resolve(METADATA_FILE),
                metadata
        );

        AuteurWriter.save(
                folder.resolve(REPLAY_FILE),
                frames
        );
    }

    public static AuteurReplay load(
            Path folder
    ) throws Exception {

        ReplayMetadata metadata =
                MetadataReader.load(
                        folder.resolve(METADATA_FILE)
                );

        var replayData =
                AuteurReader.load(
                        folder.resolve(REPLAY_FILE)
                );

        return new AuteurReplay(
                folder,
                metadata,
                replayData.frames()
        );
    }
}
