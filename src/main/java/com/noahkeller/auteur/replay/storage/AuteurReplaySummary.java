package com.noahkeller.auteur.replay.storage;

import java.nio.file.Path;

public class AuteurReplaySummary {

    private final Path folder;

    private final String replayName;

    private final String createdAt;

    private final int totalFrames;

    private final String minecraftVersion;

    public AuteurReplaySummary(
            Path folder,
            String replayName,
            String createdAt,
            int totalFrames,
            String minecraftVersion
    ) {
        this.folder = folder;
        this.replayName = replayName;
        this.createdAt = createdAt;
        this.totalFrames = totalFrames;
        this.minecraftVersion = minecraftVersion;
    }

    public Path folder() {
        return folder;
    }

    public String replayName() {
        return replayName;
    }

    public String createdAt() {
        return createdAt;
    }

    public int totalFrames() {
        return totalFrames;
    }

    public String minecraftVersion() {
        return minecraftVersion;
    }
}
