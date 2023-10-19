package com.kenshine.nginxparser.test01;

import com.github.odiszapc.nginxparser.*;

import java.io.IOException;
import java.util.List;

/**
 * @author by kenshine
 * @Classname nginxparserTest
 * @Description 官方示例
 * @Date 2023-10-19 10:10
 * @modified By：
 * @version: 1.0$
 */
public class nginxparserTest {

    public static void main(String[] args) throws IOException {
        NgxConfig conf = NgxConfig.read("nginx.conf");
        NgxParam workers = conf.findParam("worker_processes");       // Ex.1
        workers.getValue(); // "1"
        NgxParam listen = conf.findParam("http", "server", "listen"); // Ex.2
        listen.getValue(); // "8889"
        List<NgxEntry> rtmpServers = conf.findAll(NgxConfig.BLOCK, "rtmp", "server"); // Ex.3
        for (NgxEntry entry : rtmpServers) {
            ((NgxBlock)entry).getName(); // "server"
            ((NgxBlock)entry).findParam("application", "live"); // "on" for the first iter, "off" for the second one
        }

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }
}
