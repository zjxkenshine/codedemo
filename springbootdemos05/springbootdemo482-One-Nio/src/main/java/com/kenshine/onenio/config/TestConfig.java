package com.kenshine.onenio.config;

import lombok.Data;
import one.nio.config.Config;

/**
 * 测试配置
 */
@Config
@Data
public class TestConfig{
    private String a;
    private String b;
    private String c;
}