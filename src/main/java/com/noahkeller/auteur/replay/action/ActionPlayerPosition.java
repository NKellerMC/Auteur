package com.noahkeller.auteur.replay.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ActionPlayerPosition implements AuteurAction {

    public double x;
    public double y;
    public double z;

    public float yaw;
    public float pitch;

    public ActionPlayerPosition() {
    }

    public ActionPlayerPosition(
            double x,
            double y,
            double z,
            float yaw,
            float pitch
    ) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public String id() {
        return "player_position";
    }

    @Override
    public void write(DataOutputStream out) throws IOException {

        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);

        out.writeFloat(yaw);
        out.writeFloat(pitch);
    }

    @Override
    public void read(DataInputStream in) throws IOException {

        x = in.readDouble();
        y = in.readDouble();
        z = in.readDouble();

        yaw = in.readFloat();
        pitch = in.readFloat();
    }
}
