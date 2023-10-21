package com.kenshine.autoservice.processer;

import com.google.auto.service.AutoService;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 8:26
 * @description：
 * @modified By：
 * @version: $
 */
@AutoService(value = {TestService.class})
public class TestService02 implements TestService {
    @Override
    public String getName() {
        return "test02";
    }
}