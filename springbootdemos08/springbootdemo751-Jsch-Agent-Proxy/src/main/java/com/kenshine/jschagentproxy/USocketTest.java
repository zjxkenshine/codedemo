package com.kenshine.jschagentproxy;

import com.jcraft.jsch.agentproxy.AgentProxy;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Identity;
import com.jcraft.jsch.agentproxy.USocketFactory;
import com.jcraft.jsch.agentproxy.connector.SSHAgentConnector;
import com.jcraft.jsch.agentproxy.usocket.JNAUSocketFactory;

/**
 * @author by kenshine
 * @Classname USocketTest
 * @Description 代理USocket SSH连接
 * @Date 2024-03-17 9:44
 * @modified By：
 * @version: 1.0$
 */
public class USocketTest {

    public static void main(String[] args) {
        try{
            //USocketFactory udsf = new JUnixDomainSocketFactory();
            //USocketFactory udsf = new NCUSocketFactory();
            // 创建一个USocketFactory对象，用于建立Unix域套接字连接
            USocketFactory udsf = new JNAUSocketFactory();
            // 使用该USocketFactory对象创建一个AgentProxy对象，用于代理SSH代理连接。
            AgentProxy ap = new AgentProxy(new SSHAgentConnector(udsf));
            // 获取AgentProxy对象的身份验证信息，并输出身份验证信息的数量
            Identity[] identities = ap.getIdentities();
            System.out.println("count: "+identities.length);

            for(int i=0; i<identities.length; i++){
                System.out.println("  comment: "+
                        new String(identities[i].getComment()));
                byte[] blob = identities[i].getBlob();
                System.out.print("  blob: ");
                for(int j=0; j<blob.length; j++){
                    System.out.print(Integer.toHexString(blob[j]&0xff)+":");
                }
                System.out.println("");
                // 对每个身份验证信息的blob进行签名，并输出签名后的数据
                String data = "foo";
                byte[] signed = ap.sign(blob, data.getBytes());
                System.out.print("  sign: "+data+" -> ");
                for(int j=0; j<signed.length; j++){
                    System.out.print(Integer.toHexString(signed[j]&0xff)+":");
                }
                System.out.println("");
            }
        }
        catch(AgentProxyException e){
            System.out.println(e);
        }
    }
}
