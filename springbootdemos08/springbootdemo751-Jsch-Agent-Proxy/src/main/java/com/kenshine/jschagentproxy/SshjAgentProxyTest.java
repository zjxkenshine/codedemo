package com.kenshine.jschagentproxy;

import com.jcraft.jsch.agentproxy.*;
import com.jcraft.jsch.agentproxy.sshj.AuthAgent;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.userauth.method.AuthMethod;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname SshjAgentProxyTest
 * @Description sshj代理测试
 * @Date 2024-03-17 9:56
 * @modified By：
 * @version: 1.0$
 */
public class SshjAgentProxyTest {

    public static void main(String[] args) throws Exception {
        String target = getTarget(args);
        String username = target.substring(0, target.indexOf('@'));
        String hostname = target.substring(target.indexOf('@') + 1);

        AgentProxy agentProxy = getAgentProxy();
        if (agentProxy == null) {
            fail("Could not find or connect to an agent");
        }
        // ssh客户端
        SSHClient client = new SSHClient();
        client.loadKnownHosts();
        client.connect(hostname);
        assert agentProxy != null;
        client.auth(username, getAuthMethods(agentProxy));
        // 创建session
        Session session = client.startSession();
        // 执行ls-l
        Session.Command command = session.exec("ls -l");
        BufferedReader reader = new BufferedReader(new InputStreamReader(command.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        session.join();
        client.close();
    }

    /**
     * 连接目标
     */
    private static String getTarget(String[] args) {
        if (args.length > 0) {
            return args[0];
        } else {
            return JOptionPane.showInputDialog("Enter username@hostname", System.getProperty("user.name") + "@localhost");
        }
    }

    private static void fail(String message) {
        System.err.println(message);
        System.exit(1);
    }

    /**
     * 获取代理
     */
    private static AgentProxy getAgentProxy() {
        Connector connector = getAgentConnector();
        if (connector != null) {
            return new AgentProxy(connector);
        }
        return null;
    }

    /**
     * 获取代理连接
     */
    private static Connector getAgentConnector() {
        try {
            return ConnectorFactory.getDefault().createConnector();
        } catch (AgentProxyException e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * 获取认证方法列表
     */
    private static List<AuthMethod> getAuthMethods(AgentProxy agent) throws Exception {
        Identity[] identities = agent.getIdentities();
        List<AuthMethod> result = new ArrayList<>();
        // 遍历身份列表identities，对于每个身份，创建一个新的AuthAgent对象，并将其添加到result列表中
        for (Identity identity : identities) {
            result.add(new AuthAgent(agent, identity));
        }
        return result;
    }
}
