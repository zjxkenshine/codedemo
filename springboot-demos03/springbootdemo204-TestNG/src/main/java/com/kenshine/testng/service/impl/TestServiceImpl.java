package com.kenshine.testng.service.impl;

import com.kenshine.testng.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 8:37
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class TestServiceImpl implements ITestService {
    @Override
    public String test01() {
        return "testNG";
    }
}
