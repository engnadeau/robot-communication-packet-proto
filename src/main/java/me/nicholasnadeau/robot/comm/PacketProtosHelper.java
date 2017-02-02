package me.nicholasnadeau.robot.comm;

import com.google.protobuf.Timestamp;

public class PacketProtosHelper {
    public static Timestamp getCurrentTimestamp() {
        long millis = System.currentTimeMillis();
        return Timestamp.newBuilder()
                .setSeconds((long) (millis / 1e3))
                .setNanos((int) ((millis % 1e3) * 1e6)).build();
    }
}
