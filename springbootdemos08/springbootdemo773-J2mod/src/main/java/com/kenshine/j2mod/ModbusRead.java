package com.kenshine.j2mod;

import com.ghgande.j2mod.modbus.facade.ModbusTCPMaster;
import lombok.extern.slf4j.Slf4j;

/**
 * @author by kenshine
 * @Classname ModbusRead
 * @Description Modebus主站读取
 * @Date 2024-04-14 11:52
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class ModbusRead {
    public static void main(String[] args) {
        ModbusTCPMaster master;
        try {
            // master = new ModbusTCPMaster(<address>);  // Uses port 502 and a timeout of 3000ms
            // master = new ModbusTCPMaster(<address>, <port>); // Uses a timeout of 3000ms
            master = new ModbusTCPMaster("127.0.0.1", 502);
            // 连接从站
            master.connect();
            // 读取线圈
            master.readCoils(1, 0, 1).getBit(0);
            // 读取输入离散量
            master.readInputDiscretes(1, 0,1);
            // 读取输入寄存器
            master.readInputRegisters(1, 0,1);
            // 读取保存寄存器
            master.readMultipleRegisters(1,0,1);
            // 关闭连接
            master.disconnect();
        }
        catch (Exception e) {
            log.error("Cannot connect to slave - %s", e.getMessage());
        }
    }
}
