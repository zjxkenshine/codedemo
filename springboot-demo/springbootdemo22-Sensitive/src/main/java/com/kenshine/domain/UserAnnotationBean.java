package com.kenshine.domain;

import com.github.houbb.sensitive.annotation.strategy.*;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname UserAnnotationBean
 * @Description com.kenshine.sensitive 简化注解
 * @Date 2023-11-10 11:32
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserAnnotationBean {

    /**
     * 相当于@Sensitive(strategy = StrategyChineseName.class)
     *
     *  @SensitiveStrategyChineseName与@Sensitive一起使用时优先使用@Sensitive
     */
    @SensitiveStrategyChineseName
    private String username;

    @SensitiveStrategyPassword
    private String password;

    @SensitiveStrategyPassport
    private String passport;

    @SensitiveStrategyIdNo
    private String idNo;

    @SensitiveStrategyCardId
    private String bandCardId;

    @SensitiveStrategyPhone
    private String phone;

    @SensitiveStrategyEmail
    private String email;

    @SensitiveStrategyAddress
    private String address;

    @SensitiveStrategyBirthday
    private String birthday;

    @SensitiveStrategyGps
    private String gps;

    @SensitiveStrategyIp
    private String ip;

    @SensitiveStrategyMaskAll
    private String maskAll;

    @SensitiveStrategyMaskHalf
    private String maskHalf;

    @SensitiveStrategyMaskRange
    private String maskRange;
}
