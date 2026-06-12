package com.noahkeller.auteur.replay.io;

import com.noahkeller.auteur.record.RecordedFrame;

import java.io.DataOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AuteurWriter {

    public static void save(
            Path path,
            List<RecordedFrame> frames
    ) throws Exception {

        Files.createDirectories(
                path.getParent()
        );

        try (
            DataOutputStream out =
                new DataOutputStream(
                    Files.newOutputStream(path)
                )
        ) {

            out.writeUTF("AUTEUR");

            out.writeInt(1);

            out.writeInt(
                frames.size()
            );

            for (RecordedFrame frame : frames) {

                out.writeLong(frame.tick());

                out.writeDouble(frame.x());
                out.writeDouble(frame.y());
                out.writeDouble(frame.z());

                out.writeFloat(frame.yaw());
                out.writeFloat(frame.pitch());

            }

        }

    }

}
