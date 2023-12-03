package com.kenshine.distream.handler;

import cn.langpy.core.DataHandler;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 14:28
 * @description：自定义处理器
 * @modified By：
 * @version: $
 */
public class MapHandler implements DataHandler<Map<String, Object>> {
    @Override
    public Map<String, Object> handle(Map<String, Object> line) {
        line.put("newKey",1);
        return line;
    }
}
