package com.kenshine.retrofit.service;

import com.kenshine.retrofit.domain.TestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 22:54
 * @description： 测试
 * @modified By：
 * @version: $
 */
public interface TestService {
    void test01();

    List<TestEntity> test02();

    List<TestEntity> test03();

    List<TestEntity> test04();

    void test05();
}
