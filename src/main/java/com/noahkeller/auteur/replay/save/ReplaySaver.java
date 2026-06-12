package com.noahkeller.auteur.replay.save;

import com.noahkeller.auteur.record.AuteurRecorder;
import com.noahkeller.auteur.replay.meta.ReplayMetadata;
import com.noahkeller.auteur.replay.serializer.AuteurReplaySerializer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReplaySaver {

    public static void save(
            AuteurRecorder recorder
    ) {

        try {

            String timestamp =
                    LocalDateTime.now()
                            .format(
                                    DateTimeFormatter.ofPattern(
                                            "yyyy-MM-dd_HH-mm-ss"
                                    )
                            );

            Path folder =
                    Paths.get("auteur_replays")
                            .resolve(timestamp);

            ReplayMetadata metadata =
                    new ReplayMetadata();

            metadata.replayName =
                    timestamp;

            metadata.createdAt =
                    LocalDateTime.now().toString();

            metadata.totalFrames =
                    recorder.size();

            metadata.minecraftVersion =
                    "26.1.2";

            AuteurReplaySerializer.save(
                    folder,
                    metadata,
                    recorder.getFrames()
            );

            System.out.println(
                    "[Auteur] Replay salvo em: "
                            + folder
            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
