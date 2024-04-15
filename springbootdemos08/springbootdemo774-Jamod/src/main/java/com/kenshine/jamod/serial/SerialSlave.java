package com.kenshine.jamod.serial;

import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.net.ModbusSerialListener;
import net.wimpi.modbus.procimg.*;
import net.wimpi.modbus.util.SerialParameters;

/**
 * @author by kenshine
 * @Classname SerialSlave
 * @Description 服务端
 * @Date 2024-04-15 11:34
 * @modified By：
 * @version: 1.0$
 */
public class SerialSlave {
    public static void main(String[] args) {
        try {
            /* The important instances and variables */
            ModbusSerialListener listener = null;
            SimpleProcessImage spi = null;
            String portname = args[0]; //the portname of the serial port to listen to
            //1. Prepare a process image
            spi = new SimpleProcessImage();
            spi.addDigitalOut(new SimpleDigitalOut(true));
            spi.addDigitalOut(new SimpleDigitalOut(false));
            spi.addDigitalIn(new SimpleDigitalIn(false));
            spi.addDigitalIn(new SimpleDigitalIn(true));
            spi.addDigitalIn(new SimpleDigitalIn(false));
            spi.addDigitalIn(new SimpleDigitalIn(true));
            spi.addRegister(new SimpleRegister(251));
            spi.addInputRegister(new SimpleInputRegister(45));

            //2. Create the coupler and set the slave identity
            ModbusCoupler.getReference().setProcessImage(spi);
            ModbusCoupler.getReference().setMaster(false);
            ModbusCoupler.getReference().setUnitID(2);

            //3. Set up serial parameters
            SerialParameters params = new SerialParameters();
            params.setPortName(portname);
            params.setBaudRate(9600);
            params.setDatabits(8);
            params.setParity("None");
            params.setStopbits(1);
            params.setEncoding("ascii");
            params.setEcho(false);

            //4. Set up serial listener
            listener = new ModbusSerialListener(params);
            listener.setListening(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
