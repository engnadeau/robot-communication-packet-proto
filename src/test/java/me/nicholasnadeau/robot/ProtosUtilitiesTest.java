package me.nicholasnadeau.robot;

import com.google.protobuf.Timestamp;
import org.junit.Assert;
import org.junit.Test;

public class ProtosUtilitiesTest {
    @Test
    public void getCurrentTimestamp() throws Exception {
        Timestamp timestamp = ProtosUtilities.getCurrentTimestamp();

        Assert.assertNotNull(timestamp);
    }
}