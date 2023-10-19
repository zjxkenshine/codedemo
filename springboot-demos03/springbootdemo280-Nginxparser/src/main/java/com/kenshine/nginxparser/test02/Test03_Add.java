package com.kenshine.nginxparser.test02;

import com.github.odiszapc.nginxparser.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test03_Add
 * @Description 添加配置
 * @Date 2023-10-19 10:51
 * @modified By：
 * @version: 1.0$
 */
public class Test03_Add {
    /**
     *  添加块
     */
    @Test
    public void test01() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock httpBlock = conf.findBlock("http");

        NgxBlock serverBlock = new NgxBlock();
        serverBlock.addValue("server");
        httpBlock.addEntry(serverBlock);

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }


    /**
     *  添加单行参数Param 方式1
     */
    @Test
    public void test02() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock locationBlock = conf.findBlock("http","server","location");

        // 添加单行参数Param
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("proxy_pass http://192.168.0.1");
        locationBlock.addEntry(ngxParam);

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }

    /**
     *  添加单行参数Param 方式2
     */
    @Test
    public void test03() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock locationBlock = conf.findBlock("http","server","location");

        // 添加单行参数Param
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("proxy_pass");
        ngxParam.addValue("http://192.168.0.1");
        locationBlock.addEntry(ngxParam);

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }


    /**
     *  添加多行参数 方式3
     */
    @Test
    public void test04() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock locationBlock = conf.findBlock("http","server","location");

        // 添加多行参数Param
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("      proxy_pass http://www.nginx.cn;\n" +
                "      proxy_set_header Host $host;\n" +
                "      proxy_set_header X-Real-IP $remote_addr;\n" +
                "      proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;");
        locationBlock.addEntry(ngxParam);

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }

    /**
     *  多行文本添加
     */
    @Test
    public void test05() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");

        NgxComment xxx = new NgxComment("  代码添加的\n" + //这里2个空格 + \n
                "  server {\n" +
                "    listen 81;\n" +
                "    server_name localhost;\n" +
                "    location / {\n" +
                "      proxy_pass http://192.168.0.1;\n" +
                "    }\n" +
                "  }");
        conf.findBlock("http").addEntry(xxx);
        String content = new NgxDumper(conf).dump();
        System.out.println(content);
    }

    /**
     * 添加server示例
     */
    @Test
    public void test06() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock httpBlock = conf.findBlock("http");

        NgxBlock serverBlock = new NgxBlock();
        serverBlock.addValue("server");  //新建 server块
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("listen 80"); // 新建 listen 参数
        serverBlock.addEntry(ngxParam); // 添加 listen 80 参数
        ngxParam = new NgxParam();
        ngxParam.addValue("server_name localhost"); // 新建 server_name参数
        serverBlock.addEntry(ngxParam);  // 添加 server_name localhost 参数
        httpBlock.addEntry(serverBlock); // 添加server块到http块
        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }


    /**
     * 添加location
     */
    @Test
    public void test07() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock serverBlock = conf.findBlock("http","server");

        NgxBlock locatioBlock = new NgxBlock();
        locatioBlock.addValue("location /");
        // locatioBlock.addValue("/"); // 或者这样处理
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("proxy_pass http://192.168.0.1");
        locatioBlock.addEntry(ngxParam);
        ngxParam = new NgxParam();
        ngxParam.addValue("proxy_set_header Host $host");
        locatioBlock.addEntry(ngxParam);
        serverBlock.addEntry(locatioBlock);

        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }

}
