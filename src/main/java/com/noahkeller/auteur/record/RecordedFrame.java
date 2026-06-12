package com.noahkeller.auteur.record;

public record RecordedFrame(
    long tick,
    double x,
    double y,
    double z,
    float yaw,
    float pitch
) {}
