package com.kenshine.jaxbri.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kenshine
 */
public class MyHashMapType {
    public List<MyHashMapEntryType> entry = new ArrayList<>();
    public MyHashMapType(Map<String,Integer> map) {
        for( Map.Entry<String,Integer> e : map.entrySet() ) {
            entry.add(new MyHashMapEntryType(e));
        }
    }
    public MyHashMapType() {}
}