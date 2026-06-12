package com.noahkeller.auteur.replay;

import com.noahkeller.auteur.record.RecordedFrame;
import com.noahkeller.auteur.replay.meta.ReplayMetadata;

import java.nio.file.Path;
import java.util.List;

public class AuteurReplay {

    private final Path folder;

    private final ReplayMetadata metadata;

    private final List<RecordedFrame> frames;

    public AuteurReplay(
            Path folder,
            ReplayMetadata metadata,
            List<RecordedFrame> frames
    ) {
        this.folder = folder;
        this.metadata = metadata;
        this.frames = frames;
    }

    public Path folder() {
        return folder;
    }

    public ReplayMetadata metadata() {
        return metadata;
    }

    public List<RecordedFrame> frames() {
        return frames;
    }

}
