package com.kenshine.service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:25
 * @description：redis业务接口
 * @modified By：
 * @version: $
 */
public interface RedisService {

    void setObj(String key, Object obj, long timeout);

    Object getObj(String key);

}
