package com.kenshine.nryaml;

import com.resare.nryaml.YAMLMapping;
import com.resare.nryaml.YAMLUtil;
import com.resare.nryaml.YAMLValue;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author by kenshine
 * @Classname NryamlTest
 * @Description 测试
 * @Date 2023-10-27 14:57
 * @modified By：
 * @version: 1.0$
 */
public class NryamlTest {

    /**
     * 读取yml
     */
    @Test
    public void test01(){
        Iterable<YAMLValue> yamlValueList=YAMLUtil.allFromPath(Paths.get("src\\main\\resources\\test.yml"));
        yamlValueList.forEach(yamlValue -> {
            System.out.println(yamlValue.toString());
            System.out.println(
                yamlValue.toBareObject()
            );
        });
    }

    /**
     * 对象转yml
     */
    @Test
    public void test02(){
        YAMLValue value= YAMLUtil.fromString(new User(1,"kenshine").toString());
        System.out.println(YAMLUtil.toString(value));
    }
}
