package com.noahkeller.auteur.replay.session;

import com.noahkeller.auteur.record.RecordedFrame;
import com.noahkeller.auteur.replay.io.AuteurReplay;

public class AuteurReplaySession {

    private AuteurReplay replay;

    private int currentFrame = 0;

    private boolean paused = true;

    public void load(AuteurReplay replay) {

        this.replay = replay;

        this.currentFrame = 0;

        this.paused = true;
    }

    public boolean hasReplay() {
        return replay != null;
    }

    public void play() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public boolean paused() {
        return paused;
    }

    public int currentFrameIndex() {
        return currentFrame;
    }

    public void seek(int frame) {

        if (replay == null) {
            return;
        }

        currentFrame = Math.max(
                0,
                Math.min(
                        replay.frames().size() - 1,
                        frame
                )
        );
    }

    public RecordedFrame currentFrame() {

        if (replay == null) {
            return null;
        }

        if (currentFrame >= replay.frames().size()) {
            return null;
        }

        return replay.frames().get(currentFrame);
    }

    public void tick() {

        if (paused || replay == null) {
            return;
        }

        currentFrame++;

        if (currentFrame >= replay.frames().size()) {

            currentFrame =
                    replay.frames().size() - 1;

            paused = true;
        }
    }

}
