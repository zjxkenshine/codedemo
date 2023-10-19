package com.kenshine.nginxparser.test02;

import com.github.odiszapc.nginxparser.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Test04_Del
 * @Description 删除配置
 * @Date 2023-10-19 11:11
 * @modified By：
 * @version: 1.0$
 */
public class Test04_Del {

    @Test
    public void test() throws IOException {
        NgxConfig conf = NgxConfig.read("nginx1.conf");
        NgxBlock ngxBlockHttp = conf.findBlock("http");

        List<NgxEntry> serverList = ngxBlockHttp.findAll(NgxConfig.BLOCK,"server");
        for (NgxEntry ngxEntry : serverList) {
            NgxBlock ngxBlock = (NgxBlock) ngxEntry;
            NgxParam ngxParam = ngxBlock.findParam("listen");
            if ("81".equals(ngxParam.getValue())) {
                // 删除端口为81的块
                ngxBlockHttp.remove(ngxBlock);
            }
        }

        String content = new NgxDumper(conf).dump();
        System.out.println(content);
    }
}
