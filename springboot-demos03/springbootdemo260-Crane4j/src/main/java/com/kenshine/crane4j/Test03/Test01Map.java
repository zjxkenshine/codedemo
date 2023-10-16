package com.kenshine.crane4j.Test03;

import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname Test01Map
 * @Description Map集合
 * @Date 2023-10-16 12:31
 * @modified By：
 * @version: 1.0$
 */
public class Test01Map {
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "value");
        Container<String> container = Containers.forMap("a",map);
    }
}
