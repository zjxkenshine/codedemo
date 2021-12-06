package com.kenshine.reqctxholder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/6 22:32
 * @description：使用RequestContextHolder获取请求
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class ReqCtxHolderApp {
    public static void main(String[] args) {
        SpringApplication.run(ReqCtxHolderApp.class,args);
    }
}
