package com.kenshine.simplexml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname PersonList
 * @Description 外层标签
 * @Date 2023-12-09 14:16
 * @modified By：
 * @version: 1.0$
 */
@Root(name = "persons")
public class PersonList {
    @ElementList(inline = true)
    private List<Person> list;

    public PersonList() {
        list = new ArrayList<>();
    }

    public void add(Person p) {
        list.add(p);
    }

    public List<Person> getList() {
        return list;
    }
}
