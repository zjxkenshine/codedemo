package com.kenshine.jschagentproxy;

import com.jcraft.jsch.agentproxy.AgentProxy;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Identity;
import com.jcraft.jsch.agentproxy.connector.PageantConnector;

/**
 * @author by kenshine
 * @Classname PageantTest
 * @Description Pageant代理使用
 * @Date 2024-03-17 9:28
 * @modified By：
 * @version: 1.0$
 */
public class PageantTest {

    public static void main(String[] args) {
        try{
            // 建立与代理Pageant的连接
            AgentProxy ap = new AgentProxy(new PageantConnector());
            // 获取代理的认证身份信息，并打印身份数量、注释和身份验证数据（blob）
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

                // 对给定数据进行签名，并打印签名结果
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
