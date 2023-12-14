package com.kenshine.moco;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.MocoJsonRunner;
import com.github.dreamhead.moco.SocketServer;
import com.github.dreamhead.moco.WebSocketServer;
import com.github.dreamhead.moco.bootstrap.arg.HttpArgs;
import com.github.dreamhead.moco.bootstrap.arg.StartArgs;
import com.github.dreamhead.moco.runner.RunnerFactory;
import org.junit.Test;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.running;

/**
 * @author by kenshine
 * @Classname MocoTest
 * @Description 测试
 * @Date 2023-12-14 13:35
 * @modified By：
 * @version: 1.0$
 */
public class MocoTest {

    /**
     * java方式启动 单配置文件
     * jsonHttpServer
     * http://localhost:8099/login
     */
    @Test
    public void test01() throws Exception {
        final HttpServer server = MocoJsonRunner.jsonHttpServer(8099, file("lib\\moco-get.json"));
        running(server, () -> {
            System.out.println("启动成功!!");
            Thread.sleep(10000);
            System.out.println("关闭!!");
        });
    }

    /**
     * 多配制文件启动
     * http://localhost:8099/login
     */
    @Test
    public void test02() throws InterruptedException {
        RunnerFactory factory = new RunnerFactory("SHUTDOWN");
        StartArgs startArgs= new HttpArgs.Builder()
                .withPort(8099)
                .withSettings("lib\\config1.json")
                .build();
        factory.createRunner(startArgs).run();
        Thread.sleep(10000);
    }

    /**
     * WebSocketServer启动方式 java配置
     */
    @Test
    public void test03() throws Exception {
        HttpServer httpServer = httpServer(12306);
        WebSocketServer server = httpServer.websocket("/ws");
        server.connected(text("hello"));
        server.ping(text("success"));
        running(httpServer, ()->{
            System.out.println("启动成功");
        });
        Thread.sleep(10000);
    }

    /**
     * SocketServer 启动 java代码配置
     */
    @Test
    public void test04() throws Exception {
        SocketServer server = socketServer(8011);
        server.request(and(by(uri("/target")), by(version("1.0")))).response(with(text("foo")));
        running(server, ()->{
            System.out.println("启动成功");
        });
    }

}
