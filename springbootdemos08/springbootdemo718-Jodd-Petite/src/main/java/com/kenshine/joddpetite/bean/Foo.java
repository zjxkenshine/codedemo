package com.kenshine.joddpetite.bean;

import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInitMethod;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo
 * @Description 测试类
 * @Date 2024-03-02 8:21
 * @modified By：
 * @version: 1.0$
 */
@PetiteBean
@Data
public class Foo {
    private String name;
    @PetiteInitMethod
    public void init(){
        this.name = "kenshine";
    }

    public void foo(){
        System.out.println(name);
    }
}
