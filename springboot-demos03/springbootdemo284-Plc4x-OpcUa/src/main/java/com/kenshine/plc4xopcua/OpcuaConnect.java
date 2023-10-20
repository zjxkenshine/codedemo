package com.kenshine.plc4xopcua;

import org.apache.plc4x.java.PlcDriverManager;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by kenshine
 * @Classname OpcuaConnect
 * @Description Opcua连接
 * @Date 2023-10-20 9:41
 * @modified By：
 * @version: 1.0$
 */
public class OpcuaConnect {
    private static Logger logger = LoggerFactory.getLogger(OpcuaConnect.class);

    public static void main(String[] args) {
        // Opcua Driver running in ACTIVE mode 表示连接成功
        String connectionString = "opcua:tcp://192.168.20.12:4840";
        try {
            PlcConnection opcuaConnection = new PlcDriverManager().getConnection(connectionString);
            assert opcuaConnection.isConnected();
            opcuaConnection.close();
            assert !opcuaConnection.isConnected();
        } catch (PlcConnectionException e) {
            logger.warn("连接失败： " + e.getMessage());
        } catch (Exception e) {
            logger.warn("连接失败：" + e.getMessage());
        }
    }
}
