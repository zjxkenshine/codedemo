package com.kenshine.deferredresult.demo04;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:06
 * @description：异步任务
 * @modified By：
 * @version: $
 */
@Service
public class WebAsyncService {
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
