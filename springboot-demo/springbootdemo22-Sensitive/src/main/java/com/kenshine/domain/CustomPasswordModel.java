package com.kenshine.domain;

import com.github.houbb.sensitive.annotation.strategy.SensitiveStrategyPassword;
import com.kenshine.annotation.SensitiveCustomPasswordCondition;
import com.kenshine.annotation.SensitiveCustomPasswordStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname CustomPasswordModel
 * @Description 自定义注解测试
 * @Date 2023-11-10 11:48
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomPasswordModel {
    @SensitiveCustomPasswordCondition
    @SensitiveCustomPasswordStrategy
    private String password;

    @SensitiveCustomPasswordCondition
    @SensitiveStrategyPassword
    private String fooPassword;
}
