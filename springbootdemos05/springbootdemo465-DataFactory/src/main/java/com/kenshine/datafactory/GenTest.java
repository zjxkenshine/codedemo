package com.kenshine.datafactory;

import com.github.houbb.data.factory.core.util.DataUtil;
import com.kenshine.datafactory.model.RegexBean;
import com.kenshine.datafactory.model.User;
import com.kenshine.datafactory.model.UserAnnotationNumber;
import com.kenshine.datafactory.model.UserDefineAnnotationData;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author by kenshine
 * @Classname GenTest
 * @Description 生成测试
 * @Date 2023-11-08 11:30
 * @modified By：
 * @version: 1.0$
 */
public class GenTest {

    /**
     * 基础类型
     */
    @Test
    public void test01(){
        String s= DataUtil.build(String.class);
        System.out.println(s);
        Integer i=DataUtil.build(Integer.class);
        System.out.println(i);
        Boolean b=DataUtil.build(Boolean.class);
        System.out.println(b);
        LocalDateTime localDateTime=DataUtil.build(LocalDateTime.class);
        System.out.println(localDateTime);
        // ...
    }

    /**
     * 自动生成对象
     */
    @Test
    public void test02(){
        User user = DataUtil.build(User.class);
        System.out.println(user);
    }

    /**
     * @DataFactory 指定生成规则
     */
    @Test
    public void test03(){
        UserAnnotationNumber user=DataUtil.build(UserAnnotationNumber.class);
        System.out.println(user);
    }

    /**
     * 自定义注解
     */
    @Test
    public void test04(){
        UserDefineAnnotationData data = DataUtil.build(UserDefineAnnotationData.class);
        System.out.println(data);
    }

    /**
     * 正则表达式
     */
    @Test
    public void test05(){
        RegexBean bean = DataUtil.build(RegexBean.class);
        System.out.println(bean);
    }
}
