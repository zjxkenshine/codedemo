package com.kenshine.autolog.service;

import com.github.houbb.auto.log.annotation.AutoLog;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    @AutoLog(description = "查询日志", enableTraceId = true)
    public String queryLog(String id) {
        return "result-"+id;
    }
}