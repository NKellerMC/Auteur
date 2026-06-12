package com.noahkeller.auteur.replay.io;

import com.noahkeller.auteur.record.RecordedFrame;

import java.util.ArrayList;
import java.util.List;

public class AuteurReplay {

    private final List<RecordedFrame> frames =
            new ArrayList<>();

    public List<RecordedFrame> frames() {
        return frames;
    }

}
