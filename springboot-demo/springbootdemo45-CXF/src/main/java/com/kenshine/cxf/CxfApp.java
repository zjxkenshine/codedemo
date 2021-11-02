package com.kenshine.cxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:25
 * @description：Cxf实现webservice
 * @modified By：
 * @version: $
 *
 * wsdl访问地址：http://localhost:8080/webservice/demo?wsdl
 */
@SpringBootApplication
public class CxfApp {

    public static void main(String[] args) {
        SpringApplication.run(CxfApp.class, args);
    }

}
