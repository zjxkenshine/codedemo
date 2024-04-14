package com.kenshine.j2mod;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.net.TCPConnectionHandler;
import com.ghgande.j2mod.modbus.procimg.*;
import com.ghgande.j2mod.modbus.slave.ModbusSlave;
import com.ghgande.j2mod.modbus.slave.ModbusSlaveFactory;

/**
 * @author by kenshine
 * @Classname ModbusTCPServer
 * @Description ModbusTCP服务器
 * @Date 2024-04-14 10:53
 * @modified By：
 * @version: 1.0$
 */
public class ModbusTCPServer {
    public static void main(String[] args) throws ModbusException, InterruptedException {
        // 基本使用
        test01();
        // test02();
        // test03();
    }

    public static void test01() throws ModbusException, InterruptedException {
        // 创建ModbusSlave 从站
        ModbusSlave slave = ModbusSlaveFactory.createTCPSlave(502, 5);
        // 创建一个输入寄存器和一个输出线圈
        SimpleRegister register = new SimpleRegister(1234);
        SimpleDigitalOut coil = new SimpleDigitalOut();
        // 将寄存器和线圈添加到进程图像中
        SimpleProcessImage image = new SimpleProcessImage();
        image.addRegister(register);
        image.addDigitalOut(coil);
        // 将进程图像添加到从站中
        slave.addProcessImage(1, image);
        // 打开
        slave.open();
        while (true) {
            Thread.sleep(1000);
        }
//        Thread.sleep(10000);
//        // 关闭
//        slave.close();
    }

    /**
     * 工厂模式创建
     */
    public void test02() throws ModbusException {
        ProcessImage image = new SimpleProcessImage();

        ModbusSlave slave = ModbusSlaveFactory.createTCPSlave(502, 5);
        slave.addProcessImage(1, image);
        slave.open();
        ModbusSlaveFactory.close();
    }

    /**
     * 多从站
     */
    public void test03() throws ModbusException {
        ProcessImage image = new SimpleProcessImage();
        ProcessImage image1 = new SimpleProcessImage();

        ModbusSlave slave502 = ModbusSlaveFactory.createTCPSlave(502, 5);
        slave502.addProcessImage(1, image);
        slave502.addProcessImage(2, image1);
        slave502.open();

        ModbusSlave slave503 = ModbusSlaveFactory.createUDPSlave(503);
        slave503.addProcessImage(1, image);
        slave503.open();
        ModbusSlaveFactory.close();
    }
}
