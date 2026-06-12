package com.noahkeller.auteur.replay.io;

import com.noahkeller.auteur.record.RecordedFrame;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.file.Path;

public class AuteurReader {

    public static AuteurReplay load(
            Path path
    ) throws Exception {

        AuteurReplay replay =
                new AuteurReplay();

        try (
            DataInputStream in =
                new DataInputStream(
                    new FileInputStream(
                        path.toFile()
                    )
                )
        ) {

            String magic = in.readUTF();

            if (!magic.equals("AUTEUR")) {
                throw new RuntimeException(
                    "Arquivo inválido"
                );
            }

            int version = in.readInt();

            int frameCount = in.readInt();

            for (
                int i = 0;
                i < frameCount;
                i++
            ) {

                long tick =
                        in.readLong();

                double x =
                        in.readDouble();

                double y =
                        in.readDouble();

                double z =
                        in.readDouble();

                float yaw =
                        in.readFloat();

                float pitch =
                        in.readFloat();

                replay.frames().add(
                    new RecordedFrame(
                        tick,
                        x,
                        y,
                        z,
                        yaw,
                        pitch
                    )
                );
            }
        }

        return replay;
    }
}
