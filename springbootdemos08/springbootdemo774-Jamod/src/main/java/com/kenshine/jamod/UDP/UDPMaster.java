package com.kenshine.jamod.UDP;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusUDPTransaction;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.net.UDPMasterConnection;

import java.net.InetAddress;

/**
 * @author by kenshine
 * @Classname UDPMaster
 * @Description UDP客户端
 * @Date 2024-04-15 9:43
 * @modified By：
 * @version: 1.0$
 */
public class UDPMaster {
    public static void main(String[] args) {
        args= new String[]{"127.0.0.1:502", "0", "4", "3"};
        try {
            // 连接
            UDPMasterConnection con = null;
            // 事务
            ModbusUDPTransaction trans = null;
            // 请求
            ReadInputDiscretesRequest req = null;
            // 响应
            ReadInputDiscretesResponse res = null;

            //用于存储参数的变量
            // 服务器地址
            InetAddress addr = null;
            int port = Modbus.DEFAULT_PORT;
            // 偏移开始读取的位置
            int ref = 0;
            // 读取数量
            int count = 0;
            //用于重复事务的循环
            int repeat = 1;

            // 1.设置参数
            try {
                String astr = args[0];
                int idx = astr.indexOf(':');
                port = Integer.parseInt(astr.substring(idx+1));
                astr = astr.substring(0,idx);
                addr = InetAddress.getByName(astr);
                ref = Integer.decode(args[1]);
                count = Integer.decode(args[2]);
                repeat = Integer.parseInt(args[3]);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(1);
            }

            //2.打开连接
            con = new UDPMasterConnection(addr);
            con.setPort(port);
            con.connect();

            //3. 准备请求
            req = new ReadInputDiscretesRequest(ref, count);

            //4. 准备事务
            trans = new ModbusUDPTransaction(con);
            trans.setRequest(req);

            //5. 重复执行事务
            int k = 0;
            do {
                trans.execute();
                res = (ReadInputDiscretesResponse) trans.getResponse();
                System.out.println("Digital Inputs Status=" + res.getDiscretes().toString());
                k++;
            } while (k < repeat);

            //6. 关闭连接
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
