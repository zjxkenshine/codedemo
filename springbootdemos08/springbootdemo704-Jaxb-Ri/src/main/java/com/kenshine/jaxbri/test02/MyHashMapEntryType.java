package com.kenshine.jaxbri.test02;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Map;

/**
 * @author kenshine
 */
public class MyHashMapEntryType {
        @XmlAttribute
        public String key;

        @XmlAttribute
        public int value;

        public MyHashMapEntryType() {}
        public MyHashMapEntryType(Map.Entry<String,Integer> e) {
            key = e.getKey();
            value = e.getValue();
        }
    }