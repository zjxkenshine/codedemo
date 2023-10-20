package com.kenshine.plc4xopcua;

import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.types.PlcResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname PLC4XConnectionChecker
 * @Description 连接测试
 * @Date 2023-10-20 9:33
 * @modified By：
 * @version: 1.0$
 */
public class PLC4XConnectionChecker {
    private static final int READ_INTERVAL = 2000; // 读取间隔，可以根据需要修改
    private static final int HEARTBEAT_INTERVAL = 5000; // 心跳包发送间隔，可以根据需要修改
    private static final int CONNECTION_TIMEOUT = 10000; // 连接超时时间，可以根据需要修改

    private final PlcConnection connection;

    private static List<String> list = new ArrayList<>();

    private static Logger logger = LoggerFactory.getLogger(PLC4XConnectionChecker.class);

    public PLC4XConnectionChecker(String url) throws Exception {
        connection = new PlcDriverManager().getConnection(url);
        startChecking();
    }

    private void startChecking() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    checkConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, READ_INTERVAL);
    }

    protected synchronized void checkConnection() throws Exception {
        boolean connected = false;
        try {
            PlcReadRequest.Builder builder = connection.readRequestBuilder();
            builder.addItem("test_2", "ns=3;i=1010");
            builder.addItem("test_3", "ns=3;i=1011");
            PlcReadRequest readRequest = builder.build();
            PlcReadResponse response = readRequest.execute().get(5000, TimeUnit.MILLISECONDS);
            if (response.getResponseCode("test_1").equals(PlcResponseCode.OK)) {
                Object node1Value = response.getObject("test_1");
                list.add("test_1 value: " + node1Value);
            }

            if (response.getResponseCode("test_2").equals(PlcResponseCode.OK)) {
                Object node2Value = response.getObject("test_2");
                list.add("test_2 value: " + node2Value);
            }
            if (response.getResponseCode("test_3").equals(PlcResponseCode.OK)) {
                Object node3Value = response.getObject("test_3");
                list.add("test_3 value: " + node3Value);
            }
//            读取一个节点
//            PlcReadRequest readRequest = connection.readRequestBuilder().addItem("test_1", "ns=3;i=1008").build();
//            PlcReadResponse readResponse = readRequest.execute().get(10000, TimeUnit.MILLISECONDS);
//            readResponse.getObject("test_1");
            connected = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!connected) {
            // 重连
            connection.connect();
        }
    }

    public void close() throws Exception {
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        PLC4XConnectionChecker checker = new PLC4XConnectionChecker("opcua:tcp://192.168.20.12:4840");
        for (int i = 0; i < list.size(); i++) {
            logger.info(list.get(i));
        }
        Thread.sleep(HEARTBEAT_INTERVAL);
        list.clear();
        checker.close();
    }
}
