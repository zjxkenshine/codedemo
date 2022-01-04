package com.kenshine.resource.demo01;

import com.kenshine.resource.ResourceApp;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 22:26
 * @description：
 * @modified By：
 * @version: $
 */
public class ClasspathResourceTest1 {
    public static void main(String[] args) throws IOException {
        Resource resource1 = new ClassPathResource("data/test.txt");
        System.out.println(resource1.getFilename());

        Resource resource2 = new ClassPathResource("data/test.txt", ClasspathResourceTest1.class.getClassLoader());
        System.out.println(resource2.getURL());

        Resource resource3=new ClassPathResource("data/test.txt", ResourceApp.class.getClassLoader());
        System.out.println(resource3.getFile().getName());
    }
}
