package com.kenshine.jamod.UDP;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusUDPListener;
import net.wimpi.modbus.procimg.*;

/**
 * @author by kenshine
 * @Classname UDPSlave
 * @Description udp服务器
 * @Date 2024-04-15 9:29
 * @modified By：
 * @version: 1.0$
 */
public class UDPSlave {
    public static void main(String[] args) {
        try {
            ModbusUDPListener listener = null;
            SimpleProcessImage spi = null;
            int port = Modbus.DEFAULT_PORT;

            //1. 从命令行参数设置端口号
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

            //3. 准备耦合器固定图像引用
            ModbusCoupler.getReference().setProcessImage(spi);
            ModbusCoupler.getReference().setMaster(false);
            ModbusCoupler.getReference().setUnitID(15);
            //4. 在池中创建一个具有3个线程的侦听器
            listener = new ModbusUDPListener();
            listener.setPort(port);
            listener.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
