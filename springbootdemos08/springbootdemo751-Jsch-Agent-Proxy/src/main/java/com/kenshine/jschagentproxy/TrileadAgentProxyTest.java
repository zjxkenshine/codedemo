package com.kenshine.jschagentproxy;

import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Connector;
import com.jcraft.jsch.agentproxy.ConnectorFactory;
import com.jcraft.jsch.agentproxy.TrileadAgentProxy;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;
import com.trilead.ssh2.auth.AgentProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author by kenshine
 * @Classname TrileadAgentProxyTest
 * @Description Trilead-SSH2 代理测试
 * @Date 2024-03-17 10:01
 * @modified By：
 * @version: 1.0$
 */
public class TrileadAgentProxyTest {
    public static void main(String[] arg) throws IOException {
        if(arg.length != 2) {
            System.err.println("Usage: test-ssh user@host command");
            System.exit(1);
        }

        int splitPoint = arg[0].indexOf("@");
        if(splitPoint <= 0) {
            System.err.println("Usage: test-ssh user@host command");
            System.exit(1);
        }
        // 它接受两个命令行参数：user@host和command
        // 解析user@host字符串以获取用户名和主机名
        String user = arg[0].substring(0, splitPoint);
        String host = arg[0].substring(splitPoint + 1);
        // 获取代理
        AgentProxy agentProxy = getAgentProxy();

        if(agentProxy == null) {
            System.err.println("ERROR: Unable to connect to SSH agent");
            System.exit(1);
        }
        // 通过SSH代理进行身份验证，并连接到指定的远程主机
        Connection conn = new Connection(host);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithAgent(user, agentProxy);
        if(!isAuthenticated) {
            System.err.println("ERROR: Agent authentication not accepted");
            System.exit(1);
        }
        // 身份验证成功，它将执行传入的命令
        Session sess = conn.openSession();
        sess.execCommand(arg[1]);
        BufferedReader br = new BufferedReader(new InputStreamReader(new StreamGobbler(sess.getStdout())));
        while(true) {
            String line = br.readLine();
            if(line == null) {
                break;
            }
            System.out.println(line);
        }
        // 关闭SSH会话和连接，并根据命令执行的退出状态退出程序
        Integer exitStatus = sess.getExitStatus();
        sess.close();
        conn.close();
        System.exit(exitStatus == null ? 1 : exitStatus);
    }

    /**
     * 获取代理
     */
    static TrileadAgentProxy getAgentProxy() {
        try {
            Connector con = ConnectorFactory.getDefault().createConnector();
            return new TrileadAgentProxy(con);
        } catch(AgentProxyException e) {
            return null;
        }
    }
}
