package com.kenshine.nginxparser.test02;

import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxEntry;
import com.github.odiszapc.nginxparser.NgxParam;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02_Search
 * @Description 查询配置
 * @Date 2023-10-19 10:32
 * @modified By：
 * @version: 1.0$
 */
public class Test02_Search {

    /**
     * 查找块BLOCK
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");

        NgxBlock httpBlock = conf.findBlock("http");
        // 这里只能查找到第一个server 端口80的那个
        NgxBlock serverBlock1 = httpBlock.findBlock("server");
        System.out.println(serverBlock1);

        // 单个块 server{...
        NgxBlock serverBlock2 = conf.findBlock("http","server");
        System.out.println(serverBlock2);

        System.out.println  ("所有block:");
        // 所有block
        List<NgxEntry> serverBlockList = conf.findAll(NgxConfig.BLOCK, "http", "server");
        for (NgxEntry serverBlockEntry : serverBlockList) {
            NgxBlock serverBlock = (NgxBlock) serverBlockEntry;
            serverBlock.getName();
            System.out.println(serverBlock);
        }
    }

    /**
     * 查找单行参数Param
     */
    @Test
    public void test02() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");

        NgxBlock httpBlock = conf.findBlock("http");
        // 这里只能查找到第一个server 端口80的那个
        NgxBlock serverBlock = httpBlock.findBlock("server");

        // 普通单个 listen 80;
        NgxParam listen1 = serverBlock.findParam("listen");
        System.out.println(listen1);

        // 高级单个 listen 80;
        NgxParam listen2 = conf.findParam("http", "server", "listen");
        System.out.println(listen2);

        // 所有 listen
        List<NgxEntry> listenS = conf.findAll(NgxConfig.PARAM, "http", "server","listen"); // 获取所有listen 80;listen 81;
        for (NgxEntry listen : listenS) {
            NgxParam listenParam = (NgxParam) listen;
            listenParam.getName();
            System.out.println(listenParam);
        }
    }

    /**
     * 查找k-v
     */
    @Test
    public void test03() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxParam listenParam = conf.findParam("http", "server", "listen");
        String key = listenParam.getName(); // listen
        System.out.println(key);
        String value = listenParam.getValue(); // 80
        System.out.println(value);
    }

}
