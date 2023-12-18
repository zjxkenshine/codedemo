package com.kenshine.props2yaml;

import io.codearte.props2yaml.Props2YAML;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author by kenshine
 * @Classname Props2yamlTest
 * @Description 转换使用测试
 * @Date 2023-12-18 9:01
 * @modified By：
 * @version: 1.0$
 */
public class Props2yamlTest {

    @Test
    public void test01(){
        String yaml = Props2YAML.fromContent("test01=aaa\n" +
                "test02=bbb\n" +
                "test03=ccc").convert();
        System.out.println(yaml);
    }

    @Test
    public void test02(){
        String yaml = Props2YAML.fromFile(new File("src/main/resources/test.properties")).convert();
        System.out.println(yaml);
    }

    @Test
    public void test03(){
        String yaml = Props2YAML.fromFile(Paths.get("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo598-Props2yaml\\src\\main\\resources\\test.properties")).convert();
        System.out.println(yaml);
    }


}
