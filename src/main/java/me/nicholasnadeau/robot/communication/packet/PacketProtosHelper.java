package me.nicholasnadeau.robot.communication.packet;

import com.google.common.base.Joiner;
import com.google.protobuf.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class PacketProtosHelper {
    public static Timestamp getCurrentTimestamp() {
        long millis = System.currentTimeMillis();
        return Timestamp.newBuilder()
                .setSeconds((long) (millis / 1e3))
                .setNanos((int) ((millis % 1e3) * 1e6)).build();
    }

    public static String toSummaryString(PacketProtos.Packet packet) {
        List<String> strings = new ArrayList<String>();

        strings.add(String.format("id:%d", packet.getId()));
        strings.add(String.format("seconds:%d", packet.getTimestamp().getSeconds()));
        strings.add(String.format("nanos:%d", packet.getTimestamp().getNanos()));
        strings.add(String.format("status:%d", packet.getStatusCode()));
        strings.add(String.format("command:%s", packet.getCommandId()));
        strings.add(String.format("subCommand:%s", packet.getSubCommandId()));
        strings.add(String.format("jointPositions:%s", Joiner.on(",").join(packet.getJointPositionList())));
        strings.add(String.format("intJointTorques:%s", Joiner.on(",").join(packet.getIntJointTorquesList())));
        strings.add(String.format("extJointTorques:%s", Joiner.on(",").join(packet.getExtJointTorquesList())));
        strings.add(String.format("cartesianPose:%s", Joiner.on(",").join(packet.getCartesianPoseList())));
        strings.add(String.format("cartesianWrench:%s", Joiner.on(",").join(packet.getCartesianWrenchList())));

        return Joiner.on(", ").join(strings);
    }

    public static String toCsvString(PacketProtos.Packet packet) {
        List<String> strings = new ArrayList<String>();

        strings.add(String.valueOf(packet.getId()));
        strings.add(String.valueOf(packet.getTimestamp().getSeconds()));
        strings.add(String.valueOf(packet.getTimestamp().getNanos()));
        strings.add(String.valueOf(packet.getStatusCode()));
        strings.add(packet.getCommandId().name());
        strings.add(packet.getSubCommandId().name());
        strings.add(Joiner.on(",").join(packet.getJointPositionList()));
        strings.add(Joiner.on(",").join(packet.getIntJointTorquesList()));
        strings.add(Joiner.on(",").join(packet.getExtJointTorquesList()));
        strings.add(Joiner.on(",").join(packet.getCartesianPoseList()));
        strings.add(Joiner.on(",").join(packet.getCartesianWrenchList()));

        return Joiner.on(",").join(strings);
    }
}
