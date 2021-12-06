package com.kenshine.coherence.cache.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/20 8:38
 * @description：用户信息
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class UserInfo {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
