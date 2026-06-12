package com.noahkeller.auteur.replay.playback;

import com.noahkeller.auteur.record.RecordedFrame;
import com.noahkeller.auteur.replay.io.AuteurReplay;

public class AuteurPlaybackController {

    private AuteurReplay replay;

    private int frameIndex = 0;

    private boolean playing = false;

    public void load(AuteurReplay replay) {

        this.replay = replay;

        this.frameIndex = 0;

        this.playing = true;
    }

    public boolean isPlaying() {
        return playing;
    }

    public RecordedFrame currentFrame() {

        if (replay == null) {
            return null;
        }

        if (frameIndex >= replay.frames().size()) {
            return null;
        }

        return replay.frames().get(frameIndex);
    }

    public void tick() {

        if (!playing || replay == null) {
            return;
        }

        frameIndex++;

        if (frameIndex >= replay.frames().size()) {

            frameIndex =
                replay.frames().size() - 1;

            playing = false;
        }
    }

    public void stop() {
        playing = false;
    }
}
