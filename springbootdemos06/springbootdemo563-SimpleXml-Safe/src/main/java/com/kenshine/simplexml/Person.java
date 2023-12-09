package com.kenshine.simplexml;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Person
 * @Description bean
 * @Date 2023-12-09 14:14
 * @modified By：
 * @version: 1.0$
 */
@Root
@Data
public class Person {

    /**
     * 姓名
     */
    @Element
    private String name;

    /**
     * 电话号码
     */
    @ElementList(inline = true, entry = "phone", required = false)
    private List<String> phones;

    /**
     *
     */
    public Person() {
        phones = new ArrayList<>();
    }

    /**
     */
    public Person(String name) {
        this();
        this.name = name;
    }

    /**
     * 新增一个电话号码
     *
     * @param phone
     */
    public void addPhone(String phone) {
        phones.add(phone);
    }

}
