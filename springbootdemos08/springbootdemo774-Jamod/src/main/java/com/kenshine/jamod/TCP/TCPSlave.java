package com.kenshine.jamod.TCP;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusTCPListener;
import net.wimpi.modbus.procimg.*;

/**
 * @author by kenshine
 * @Classname TCPSlave
 * @Description tcp服务器
 * @Date 2024-04-15 10:54
 * @modified By：
 * @version: 1.0$
 */
public class TCPSlave {
    public static void main(String[] args) {
        ModbusTCPListener listener = null;
        SimpleProcessImage spi = null;
        int port = Modbus.DEFAULT_PORT;

        //1. 设置参数
        if(args != null && args.length ==1) {
            port = Integer.parseInt(args[0]);
        }
        //2. 准备进程图像
        spi = new SimpleProcessImage();
        spi.addDigitalOut(new SimpleDigitalOut(true));
        spi.addDigitalOut(new SimpleDigitalOut(false));
        spi.addDigitalIn(new SimpleDigitalIn(false));
        spi.addDigitalIn(new SimpleDigitalIn(true));
        spi.addDigitalIn(new SimpleDigitalIn(false));
        spi.addDigitalIn(new SimpleDigitalIn(true));
        spi.addRegister(new SimpleRegister(251));
        spi.addInputRegister(new SimpleInputRegister(45));

        //3. 设置图像
        ModbusCoupler.getReference().setProcessImage(spi);
        ModbusCoupler.getReference().setMaster(false);
        ModbusCoupler.getReference().setUnitID(15);
        //4. 创建监听器
        listener = new ModbusTCPListener(3);
        listener.setPort(port);
        listener.start();
    }
}
