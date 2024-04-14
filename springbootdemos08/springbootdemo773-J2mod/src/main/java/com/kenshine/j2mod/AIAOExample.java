package com.kenshine.j2mod;

import com.ghgande.j2mod.modbus.Modbus;
import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.io.ModbusTransaction;
import com.ghgande.j2mod.modbus.msg.ModbusRequest;
import com.ghgande.j2mod.modbus.msg.ReadInputRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadInputRegistersResponse;
import com.ghgande.j2mod.modbus.msg.WriteSingleRegisterRequest;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import com.ghgande.j2mod.modbus.procimg.SimpleRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * 该Java示例是一个用于读取和写入工业自动化设备输入输出寄存器的程序。主要功能包括：
 *
 * 解析命令行参数，获取设备地址、输入寄存器和输出寄存器的参考编号。
 * 建立与设备的TCP连接。
 * 创建读取输入寄存器和写入输出寄存器的请求，并设置单元ID。
 * 创建事务，将请求与连接关联，并执行事务。
 * 循环读取输入寄存器的值，并将值写入输出寄存器中，仅在值发生变化时更新输出寄存器。
 * 关闭与设备的连接。
 */
public class AIAOExample {

    private static final Logger logger = LoggerFactory.getLogger(AIAOExample.class);

    private static void printUsage() {
        System.out.printf("\nUsage:\n    java com.ghgande.j2mod.modbus.cmd.AIAOExample <address{:<port>} [String]> <register a_in [int16]> <register a_out [int16]>");
    }

     /**
     * 程序主入口。
     *
     * @param args 命令行参数
     *          args[0]: 服务器地址，格式为 address[:port][unit_id]，可选地包含单元标识符。
     *          args[1]: 输入寄存器(a_in)的参考编号。
     *          args[2]: 输出寄存器(a_out)的参考编号。
     */
    public static void main(String[] args) {

        InetAddress addr = null; // 服务器地址
        TCPMasterConnection con = null; // Modbus TCP 主连接
        ModbusRequest ai_req; // 用于读取输入寄存器的请求
        WriteSingleRegisterRequest ao_req; // 用于写入单个寄存器的请求

        ModbusTransaction ai_trans; // 输入寄存器的事务
        ModbusTransaction ao_trans; // 输出寄存器的事务

        int ai_ref = 0; // 输入寄存器参考编号
        int ao_ref = 0; // 输出寄存器参考编号
        int port = Modbus.DEFAULT_PORT; // 默认端口号
        int unit_in = 0; // 输入单元标识符
        int unit_out = 0; // 输出单元标识符

        // 参数设置阶段
        if (args.length < 3) {
            printUsage();
            System.exit(1);
        }
        try {

            try {
                // 解析服务器地址参数
                String serverAddress = args[0];
                String parts[] = serverAddress.split(" *: *");

                String address = parts[0];
                if (parts.length > 1) {
                    port = Integer.parseInt(parts[1]);
                    if (parts.length > 2) {
                        unit_in = unit_out = Integer.parseInt(parts[2]);
                        if (parts.length > 3) {
                            unit_out = Integer.parseInt(parts[3]);
                        }
                    }
                }
                addr = InetAddress.getByName(address);
                ai_ref = Integer.parseInt(args[1]);
                ao_ref = Integer.parseInt(args[2]);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                printUsage();
                System.exit(1);
            }

            // 建立连接
            con = new TCPMasterConnection(addr);
            con.setPort(port);
            con.connect();
            System.out.printf("Connected to %s:%d", addr.toString(), con.getPort());

            // 准备请求
            ai_req = new ReadInputRegistersRequest(ai_ref, 1);
            ao_req = new WriteSingleRegisterRequest();
            ao_req.setReference(ao_ref);

            // 设置单元标识符
            ai_req.setUnitID(unit_in);
            ao_req.setUnitID(unit_out);

            // 准备事务
            ai_trans = new ModbusTCPTransaction(con);
            ai_trans.setRequest(ai_req);
            ao_trans = new ModbusTCPTransaction(con);
            ao_trans.setRequest(ao_req);

            // 准备只在变化时更新的持有器
            SimpleRegister new_out = new SimpleRegister(0);
            ao_req.setRegister(new_out);
            int last_out = Integer.MIN_VALUE; // 上一次输出寄存器的值

            // 循环执行事务，仅在输入寄存器值变化时更新输出寄存器
            do {
                ai_trans.execute();
                int new_in = ((ReadInputRegistersResponse)ai_trans.getResponse()).getRegister(0).getValue();

                // 仅在值变化时写入
                if (new_in != last_out) {
                    new_out.setValue(new_in); // 更新寄存器值
                    ao_trans.execute();
                    last_out = new_in;
                    System.out.printf("Updated Output Register with value from Input Register");
                }
            } while (true);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // 关闭连接
            if (con != null) {
                con.close();
            }
        }
    }
}