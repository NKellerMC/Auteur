package com.noahkeller.auteur.record;

import java.util.ArrayList;
import java.util.List;

public class AuteurRecorder {
    private final List<RecordedFrame> frames = new ArrayList<>();
    private boolean recording = true;
    private long tick = 0;

    public void record(double x, double y, double z, float yaw, float pitch) {
        if (!recording) return;

        frames.add(new RecordedFrame(tick++, x, y, z, yaw, pitch));
    }

    public int size() {
        return frames.size();
    }

    public List<RecordedFrame> getFrames() {
        return frames;
    }
}
