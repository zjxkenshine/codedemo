package com.kenshine.plc4x;

import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.types.PlcResponseCode;

import java.util.concurrent.ExecutionException;

/**
 * @author by kenshine
 * @Classname TestS7
 * @Description S7读取测试
 * @Date 2023-10-24 11:22
 * @modified By：
 * @version: 1.0$
 */
public class TestS7 {
    public static void main(String[] args) throws PlcConnectionException, ExecutionException, InterruptedException {
        String connectionString = "s7://192.168.20.94:102?remote-rack=0&remote-slot=2&controller-type=S7_300";
        PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString);
        PlcReadRequest.Builder readrequest = plcConnection.readRequestBuilder();

        readrequest.addItem("T", "%DB1201.DBB1004:WORD");
        PlcReadRequest rr = readrequest.build();
        PlcReadResponse response = rr.execute().get();
        if (response.getResponseCode("T") == PlcResponseCode.OK) {
            Object node1Value = response.getObject("T");
            System.out.println("T value: " + node1Value);
        }
    }
}
