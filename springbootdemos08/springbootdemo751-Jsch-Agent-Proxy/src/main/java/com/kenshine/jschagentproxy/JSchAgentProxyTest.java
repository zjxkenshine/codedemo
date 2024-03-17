package com.kenshine.jschagentproxy;

import com.jcraft.jsch.*;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Connector;
import com.jcraft.jsch.agentproxy.ConnectorFactory;
import com.jcraft.jsch.agentproxy.RemoteIdentityRepository;

import javax.swing.*;

/**
 * @author by kenshine
 * @Classname JSchAgentProxyTest
 * @Description jsch代理测试
 * @Date 2024-03-17 9:45
 * @modified By：
 * @version: 1.0$
 */
public class JSchAgentProxyTest {

    /**
     * 使用JSch库实现了一个SSH连接器，通过使用密钥认证或用户交互来建立到远程主机的SSH会话
     */
    public static void main(String[] args) throws Exception {
        try{
            JSch jsch=new JSch();
            // 设置首选认证方式为公钥
            JSch.setConfig("PreferredAuthentications", "publickey");
            Connector con = null;
            try {
                // 创建代理对象
                ConnectorFactory cf = ConnectorFactory.getDefault();
                con = cf.createConnector();
            }
            catch(AgentProxyException e){
                System.out.println(e);
            }
            if(con != null ){
                // 设置IdentityRepository以使用公钥进行认证
                IdentityRepository irepo = new RemoteIdentityRepository(con);
                jsch.setIdentityRepository(irepo);
            }
            String host=null;
            if(args.length>0){
                host=args[0];
            }
            else{
                host= JOptionPane.showInputDialog("Enter username@hostname",
                        System.getProperty("user.name")+
                                "@localhost");
            }
            String user=host.substring(0, host.indexOf('@'));
            host=host.substring(host.indexOf('@')+1);
            // 创建session
            Session session=jsch.getSession(user, host, 22);
            // 用户名和密码将通过UserInfo接口提供
            UserInfo ui=new MyUserInfo();
            session.setUserInfo(ui);
            session.connect();
            // 打开一个shell通道并启用代理转发，将标准输入和输出流与通道关联
            Channel channel=session.openChannel("shell");
            ((ChannelShell)channel).setAgentForwarding(true);
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            // 连接通道
            channel.connect();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static class MyUserInfo implements UserInfo, UIKeyboardInteractive {
        @Override
        public String getPassword() {
            return passwd;
        }

        @Override
        public boolean promptYesNo(String str) {
            return true;
        }

        String passwd = null;

        @Override
        public String getPassphrase() {
            return null;
        }

        @Override
        public boolean promptPassphrase(String message) {
            return true;
        }

        @Override
        public boolean promptPassword(String message) {
            return true;
        }

        @Override
        public void showMessage(String message) {
        }

        @Override
        public String[] promptKeyboardInteractive(String destination,
                                                  String name,
                                                  String instruction,
                                                  String[] prompt,
                                                  boolean[] echo) {
            String[] response = new String[prompt.length];
            response[0] = passwd;
            return response;
        }
    }
}
