package com.kenshine.wrapper.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 9:35
 * @description：Xss配置
 * @modified By：
 * @version: $
 */
@Data
@Component
@ConfigurationProperties(prefix = "xss")
public class XssProperties {
    /**
     * 过滤开关
     */
    private String enabled;

    /**
     * 排除链接（多个用逗号分隔）
     */
    private String excludes;

    /**
     * 匹配链接
     */
    private String urlPatterns;
}
