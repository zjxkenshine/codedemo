package com.kenshine.jxpath.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname Employee
 * @Description bean
 * @Date 2024-01-29 9:58
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Employee {
    private Map addressMap = new HashMap();
    {
        addressMap.put("home", new Address("aaaa"));
        addressMap.put("office", new Address("bbbb"));
    }

    public Map getAddresses(){
        return addressMap;
    }

    private String firstName;
    private Address homeAddress;
}
