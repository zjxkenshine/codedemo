package com.kenshine.j2mod;

import com.ghgande.j2mod.modbus.Modbus;
import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.msg.ModbusRequest;
import com.ghgande.j2mod.modbus.msg.ReadInputDiscretesRequest;
import com.ghgande.j2mod.modbus.msg.ReadInputDiscretesResponse;
import com.ghgande.j2mod.modbus.msg.WriteCoilRequest;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * DIDOExample 类用于演示通过 Modbus 协议读取输入离散量（DI）并根据其状态更新输出离散量（DO）。
 * 需要提供设备地址、输入离散量寄存器参考号和输出离散量寄存器参考号作为命令行参数。
 */
public class DIDOExample {

    // 日志记录器
    private static final Logger logger = LoggerFactory.getLogger(DIDOExample.class);

    /**
     * 主函数入口。
     * @param args 命令行参数：设备地址、输入离散量寄存器参考号、输出离散量寄存器参考号。
     */
    public static void main(String[] args) {

        InetAddress addr = null; // 设备地址
        TCPMasterConnection con = null; // Modbus 主连接
        ModbusRequest di_req; // 读取输入离散量的请求
        WriteCoilRequest do_req; // 写入输出离散量的请求

        ModbusTCPTransaction di_trans; // 读取输入离散量的事务
        ModbusTCPTransaction do_trans; // 写入输出离散量的事务

        int di_ref = 0; // 输入离散量寄存器参考号
        int do_ref = 0; // 输出离散量寄存器参考号
        int port = Modbus.DEFAULT_PORT; // 端口号

        try {

            // 设置运行参数
            if (args.length < 3) {
                printUsage();
                System.exit(1);
            }
            else {
                try {
                    String astr = args[0];
                    int idx = astr.indexOf(':');
                    if (idx > 0) {
                        port = Integer.parseInt(astr.substring(idx + 1));
                        astr = astr.substring(0, idx);
                    }
                    addr = InetAddress.getByName(astr);
                    di_ref = Integer.parseInt(args[1]);
                    do_ref = Integer.parseInt(args[2]);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    printUsage();
                    System.exit(1);
                }
            }

            // 打开连接
            con = new TCPMasterConnection(addr);
            con.setPort(port);
            con.connect();
            System.out.printf("Connected to %s:%d", addr.toString(), con.getPort());

            // 准备请求
            di_req = new ReadInputDiscretesRequest(di_ref, 1);

            do_req = new WriteCoilRequest();
            do_req.setReference(do_ref);

            di_req.setUnitID(0);
            do_req.setUnitID(0);

            // 准备事务
            di_trans = new ModbusTCPTransaction(con);
            di_trans.setRequest(di_req);
            di_trans.setReconnecting(false);
            do_trans = new ModbusTCPTransaction(con);
            do_trans.setRequest(do_req);
            do_trans.setReconnecting(false);

            // 上一状态 holders
            boolean last_out = false; // 上一输出状态
            boolean new_in; // 新输入状态

            // 循环执行事务，持续读取并更新输出状态
            do {
                di_trans.execute();
                new_in = ((ReadInputDiscretesResponse)
                        di_trans.getResponse()).getDiscreteStatus(0);

                // 只有状态改变时才写入新的输出状态
                if (new_in != last_out) {
                    do_req.setCoil(new_in);
                    do_trans.execute();
                    last_out = new_in;
                    System.out.printf("Updated coil with state from DI");
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

    /**
     * 打印用法信息。
     */
    private static void printUsage() {
        System.out.printf("\nUsage:\n    java com.ghgande.j2mod.modbus.cmd.DIDOExample <address{:<port>} [String]> <register d_in [int16]> <register d_out [int16]>");
    }
}