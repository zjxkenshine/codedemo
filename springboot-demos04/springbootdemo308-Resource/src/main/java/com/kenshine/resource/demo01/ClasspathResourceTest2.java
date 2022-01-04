package com.kenshine.resource.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 22:30
 * @description：Value注入Resource
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class ClasspathResourceTest2{
    @Value("classpath:data/test.txt")
    private Resource resource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext context;


    /**
     * localhost:8080/test
     */
    @GetMapping
    public void test() throws FileNotFoundException {
        System.out.println(resource.getDescription());
        System.out.println(resourceLoader.getResource("classpath:data/test.txt"));
        System.out.println(context.getResource("classpath:data/test.txt").getFilename());

        System.out.println(ResourceUtil.getResourceFile().getName());
    }

    /**
     * 读取数据
     */
    @GetMapping("/2")
    public void test2() throws IOException {
        //不使用于读取jar包中的文件
        File resource = new ClassPathResource("data/test.txt").getFile();
        String content = new String(Files.readAllBytes(resource.toPath()));
        System.out.println(content);

        //Reader方式读取
        InputStream resource1 = new ClassPathResource("data/test.txt").getInputStream();
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(resource1))){
            String content1 = reader.readLine().concat("\n");
            System.out.println(content1);
        }
    }




}
