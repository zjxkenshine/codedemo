package com.kenshine.jamod.TCP;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;

/**
 * @author by kenshine
 * @Classname TCPMaster
 * @Description Tcp客户端
 * @Date 2024-04-15 11:20
 * @modified By：
 * @version: 1.0$
 */
public class TCPMaster {
    public static void main(String[] args) {
        args= new String[]{"127.0.0.1:502", "0", "4", "3"};
        try {
            TCPMasterConnection con = null; //the connection
            ModbusTCPTransaction trans = null; //the transaction
            ReadInputDiscretesRequest req = null; //the request
            ReadInputDiscretesResponse res = null; //the response

            /* Variables for storing the parameters */
            InetAddress addr = null; //the slave's address
            int port = Modbus.DEFAULT_PORT;
            int ref = 0; //the reference; offset where to start reading from
            int count = 0; //the number of DI's to read
            int repeat = 1; //a loop for repeating the transaction

            //1. Setup the parameters
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
            //2. Open the connection
            con = new TCPMasterConnection(addr);
            con.setPort(port);
            con.connect();

            //3. Prepare the request
            req = new ReadInputDiscretesRequest(ref, count);

            //4. Prepare the transaction
            trans = new ModbusTCPTransaction(con);
            trans.setRequest(req);
            //5. Execute the transaction repeat times
            int k = 0;
            do {
                trans.execute();
                res = (ReadInputDiscretesResponse) trans.getResponse();
                System.out.println("Digital Inputs Status=" + res.getDiscretes().toString());
                k++;
            } while (k < repeat);

            //6. Close the connection
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
