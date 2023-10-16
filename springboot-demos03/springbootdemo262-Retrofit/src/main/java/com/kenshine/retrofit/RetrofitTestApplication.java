package com.kenshine.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 22:39
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@RetrofitScan("com.kenshine.retrofit")
public class RetrofitTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitTestApplication.class, args);
    }
}
