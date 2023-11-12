package com.kenshine.async.service;

import com.github.houbb.async.core.model.async.AsyncResult;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 22:15
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserService {
    AsyncResult<String> queryUser(String id);
}
