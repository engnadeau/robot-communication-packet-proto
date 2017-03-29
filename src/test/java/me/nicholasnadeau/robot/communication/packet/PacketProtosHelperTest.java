package me.nicholasnadeau.robot.communication.packet;

import com.google.protobuf.Timestamp;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class PacketProtosHelperTest {
    private static PacketProtos.Packet packet;

    @BeforeClass
    static public void onlyOnce() {
        // set members
        int id = 123;
        PacketProtos.Packet.CommandID commandID = PacketProtos.Packet.CommandID.STATUS;
        PacketProtos.Packet.SubCommandID subCommandID = PacketProtos.Packet.SubCommandID.INFO;
        Timestamp timestamp = PacketProtosHelper.getCurrentTimestamp();
        List<Double> doubles = new ArrayList<Double>();
        for (int i = 0; i < 6; i++) {
            doubles.add((double) i);
        }

        // set packet
        PacketProtos.Packet.Builder builder = PacketProtos.Packet.newBuilder();
        builder.setId(id);
        builder.setCommandId(commandID);
        builder.setSubCommandId(subCommandID);
        builder.setTimestamp(timestamp);
        builder.addAllJointPosition(doubles);
        builder.addAllIntJointTorques(doubles);
        builder.addAllExtJointTorques(doubles);
        builder.addAllCartesianPose(doubles);
        builder.addAllCartesianWrench(doubles);
        packet = builder.build();
    }

    @Test
    public void toSummaryString() throws Exception {
        System.out.println(PacketProtosHelper.toSummaryString(packet));
    }

    @Test
    public void toCsvString() throws Exception {
        System.out.println(PacketProtosHelper.toCsvString(packet));
    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCurrentTimestamp() throws Exception {
        long millis = System.currentTimeMillis();
        Timestamp t = PacketProtosHelper.getCurrentTimestamp();
        Assert.assertEquals(millis / 1e3, t.getSeconds(), 1);
    }
}