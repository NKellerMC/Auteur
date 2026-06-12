package com.noahkeller.auteur.replay.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface AuteurAction {

    String id();

    void write(DataOutputStream out) throws IOException;

    void read(DataInputStream in) throws IOException;

}
