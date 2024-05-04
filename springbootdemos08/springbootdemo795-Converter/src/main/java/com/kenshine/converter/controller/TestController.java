package com.kenshine.converter.controller;

import com.github.liaochong.converter.core.BeanConverter;
import com.kenshine.converter.bean.UserBO;
import com.kenshine.converter.bean.UserDO;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2024-05-04 14:03
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 单个对象转换
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01(){
        UserDO userDO = new UserDO();
        userDO.setName("kenshine");
        UserBO user = BeanConverter.convert(userDO , UserBO.class);
        System.out.println(user);
    }

    /**
     * 列表转换
     * localhost:8080/test02
     */
    @GetMapping("/test02")
    public void test02(){
        List<UserDO> list = new ArrayList<>();
        UserDO userDO1 = new UserDO();
        userDO1.setName("kenshine1");
        UserDO userDO2 = new UserDO();
        userDO2.setName("kenshine2");
        list.add(userDO1);
        list.add(userDO2);
        List<UserBO> users = BeanConverter.convert(list , UserBO.class);
        System.out.println(users);
    }

    /**
     * 并行转换
     * localhost:8080/test03
     */
    @GetMapping("/test03")
    public void test03(){
        List<UserDO> list = new ArrayList<>();
        UserDO userDO1 = new UserDO();
        userDO1.setName("kenshine1");
        UserDO userDO2 = new UserDO();
        userDO2.setName("kenshine2");
        list.add(userDO1);
        list.add(userDO2);
        List<UserBO> users = BeanConverter.parallelConvert(list , UserBO.class);
        System.out.println(users);
    }
}
