package com.kenshine.socketpoint;

import idea.verlif.socketpoint.EndPointException;
import idea.verlif.socketpoint.SocketConfig;
import idea.verlif.socketpoint.SocketPoint;

import java.io.IOException;

/**
 * @author kenshine
 * SocketPoint 使用测试
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        // 开启端点服务器
        SocketPoint socketPoint = new SocketPoint();
        // 设置信息监听器
        socketPoint.setMessageListener((endPoint, message) -> {
            System.out.println(message);
            System.out.println("-----------------------------");
        });
        // 设置连接关闭监听器
        socketPoint.setClosedListener(endPoint ->
                System.out.println("连接被关闭 - " + endPoint.getTarget().getRemoteSocketAddress()));
        // 设置拒绝端点连接监听器，向来访端点发送拒绝信息
        socketPoint.setRejectedListener(endPoint ->
                endPoint.send("连接已达上限！ "));
        // 开启端点接收服务
        new Thread(() -> {
            try {
                socketPoint.start(new SocketConfig().max(2).tied(1));
            } catch (IOException e) {
                throw new EndPointException(e);
            }
        }).start();

        // 同时，此端点可以连接到另一个端点，这里是设置的本端点，默认的端口是16508
        SocketPoint.ConnectionHolder link = socketPoint.link("127.0.0.1", 16508);
        // 通过此连接进行信息交互
        link.send("你好呀！");
        // 一个端点可以连接无限个端点，并且共用之前设置的各种监听器
        SocketPoint.ConnectionHolder link2 = socketPoint.link("127.0.0.1", 16508);
        // 通过此连接进行信息交互
        link2.send("你好呀！");
    }
}