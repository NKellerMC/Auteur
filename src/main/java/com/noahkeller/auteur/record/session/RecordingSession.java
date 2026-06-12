package com.noahkeller.auteur.record.session;

import com.noahkeller.auteur.record.AuteurRecorder;
import com.noahkeller.auteur.replay.save.ReplaySaver;

public class RecordingSession {

    private AuteurRecorder recorder;

    private boolean recording;

    public void start() {

        recorder = new AuteurRecorder();

        recording = true;
    }

    public void stop() {

        recording = false;

        if (recorder != null) {
            ReplaySaver.save(
                    recorder
            );
        }

    }

    public boolean isRecording() {

        return recording;
    }

    public AuteurRecorder recorder() {

        return recorder;
    }
}
