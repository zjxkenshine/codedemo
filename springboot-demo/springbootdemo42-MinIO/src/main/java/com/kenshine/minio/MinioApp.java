package com.kenshine.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 8:22
 * @description：springboot整合minio
 * @modified By：
 * @version: $
 *
 * 这个只是简单整合
 * TODO linux下安装minio,集群,多租户,其他功能
 */
@SpringBootApplication
public class MinioApp {

    public static void main(String[] args) {
        SpringApplication.run(MinioApp.class,args);
    }

}
