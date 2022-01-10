package com.kenshine.basic._09_Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:48
 * @description：
 * @modified By：
 * @version: $
 * 细节自己找八股文
 */
public class Test06_HashMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Kenshine");
        map.put(2, "Qin");
        map.forEach((k,v) -> System.out.println(k+" , "+v));
    }
}
