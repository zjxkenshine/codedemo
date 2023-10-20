package com.kenshine.milo;

import com.kenshine.milo.client.OpcUaStart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname OpcUaApp
 * @Description opcua测试
 * @Date 2023-10-20 10:02
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class OpcUaApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OpcUaApp.class, args);
        OpcUaStart opcUa = new OpcUaStart();
        opcUa.start();
    }

}
