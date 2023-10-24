package com.kenshine.plc4x;

import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.types.PlcResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestModbus
 * @Description modebus连接测试
 * @Date 2023-10-24 11:32
 * @modified By：
 * @version: 1.0$
 */
public class TestModbus {

    private static Logger logger = LoggerFactory.getLogger(String.valueOf(TestModbus.class));

    public static void main(String[] args) {
        String connectionString = "modbus-tcp://127.0.0.1:502?unit-identifier=1";

        final List<String> list = new ArrayList<>();

        try (PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString)) {
            if (!plcConnection.getMetadata().canRead()) {
                logger.warn("This connection doesn't support reading.");
                return;
            }else {
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
                builder.addItem("value_1", "coil:3");
                builder.addItem("value_2", "coil:4[5]");
                builder.addItem("value_3", "holding-register:2");
                builder.addItem("value_4", "holding-register:4[6]");
                PlcReadRequest readRequest = builder.build();
                PlcReadResponse response = readRequest.execute().get();
                if (response.getResponseCode("value_1").equals(PlcResponseCode.OK)) {
                    Object node1Value = response.getObject("value_1");
                    System.out.println("value_1 value: " + node1Value);
                    list.add("value_1 value: " + node1Value);
                }

                if (response.getResponseCode("value_2").equals(PlcResponseCode.OK)) {
                    Object node2Value = response.getObject("value_2");
                    System.out.println("value_2 value: " + node2Value);
                    list.add("value_2 value: " + node2Value);
                }

                if (response.getResponseCode("value_3").equals(PlcResponseCode.OK)) {
                    Object node3Value = response.getObject("value_3");
                    System.out.println("value_3 value: " + node3Value);
                    list.add("value_3 value: " + node3Value);
                }

                if (response.getResponseCode("value_4").equals(PlcResponseCode.OK)) {
                    Object node3Value = response.getObject("value_4");
                    System.out.println("value_4 value: " + node3Value);
                    list.add("value_4 value: " + node3Value);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                logger.info(list.get(i));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String connectionString1 = "modbus-tcp://127.0.0.1:502?unit-identifier=2";
        try (PlcConnection plcConnection = new PlcDriverManager().getConnection(connectionString1)) {
            if (!plcConnection.getMetadata().canRead()) {
                logger.warn("This connection doesn't support reading.");
                return;
            }else {
                PlcReadRequest.Builder builder = plcConnection.readRequestBuilder();
                builder.addItem("value_1", "coil:3");
                builder.addItem("value_2", "coil:4[5]");
                builder.addItem("value_3", "holding-register:2");
                builder.addItem("value_4", "holding-register:4[6]");
                PlcReadRequest readRequest = builder.build();
                PlcReadResponse response = readRequest.execute().get();
                if (response.getResponseCode("value_1").equals(PlcResponseCode.OK)) {
                    Object node1Value = response.getObject("value_1");
                    System.out.println("value_1 value: " + node1Value);
                    list.add("value_1 value: " + node1Value);
                }

                if (response.getResponseCode("value_2").equals(PlcResponseCode.OK)) {
                    Object node2Value = response.getObject("value_2");
                    System.out.println("value_2 value: " + node2Value);
                    list.add("value_2 value: " + node2Value);
                }

                if (response.getResponseCode("value_3").equals(PlcResponseCode.OK)) {
                    Object node3Value = response.getObject("value_3");
                    System.out.println("value_3 value: " + node3Value);
                    list.add("value_3 value: " + node3Value);
                }

                if (response.getResponseCode("value_4").equals(PlcResponseCode.OK)) {
                    Object node3Value = response.getObject("value_4");
                    System.out.println("value_4 value: " + node3Value);
                    list.add("value_4 value: " + node3Value);
                }
            }
            for (String s : list) {
                logger.info(s);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
