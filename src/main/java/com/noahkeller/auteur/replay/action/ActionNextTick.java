package com.noahkeller.auteur.replay.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ActionNextTick implements AuteurAction {

    @Override
    public String id() {
        return "next_tick";
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
    }

    @Override
    public void read(DataInputStream in) throws IOException {
    }
}
