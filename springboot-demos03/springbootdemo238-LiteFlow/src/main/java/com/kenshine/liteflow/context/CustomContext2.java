package com.kenshine.liteflow.context;

import com.yomahub.liteflow.slot.DefaultContext;

import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname CustomContext2
 * @Description 自定义上下文2
 * @Date 2023/3/21 15:38
 * @modified By：
 * @version: 1.0$
 */
public class CustomContext2 extends DefaultContext {
    private HashMap<String,String> map=new HashMap<>();

    @Override
    public String getData(String key) {
        return map.get(key);
    }


    public void setData(String key, String value) {
        map.put(key,value);
    }
}
