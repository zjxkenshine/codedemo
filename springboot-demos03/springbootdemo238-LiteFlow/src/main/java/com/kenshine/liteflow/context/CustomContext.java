package com.kenshine.liteflow.context;

import com.yomahub.liteflow.slot.DefaultContext;

import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname CustomContext
 * @Description 自定义上下文
 * @Date 2023/3/17 11:11
 * @modified By：
 * @version: 1.0$
 *
 * 流程入参，是整个流程的入参。需要通过reqeustData去取，而上下文的作用主要是给组件之间的保存参数和传递参数用的。
 */
public class CustomContext extends DefaultContext {
    private HashMap<String,String> map=new HashMap<>();

    @Override
    public String getData(String key) {
        return map.get(key);
    }


    public void setData(String key, String value) {
        map.put(key,value);
    }
}
