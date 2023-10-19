package com.kenshine.nginxparser.test02;

import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxDumper;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test01_Load
 * @Description 加载配置文件
 * @Date 2023-10-19 10:21
 * @modified By：
 * @version: 1.0$
 */
public class Test01_Load {

    @Test
    public void test() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        // 序列化配置
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }


}
