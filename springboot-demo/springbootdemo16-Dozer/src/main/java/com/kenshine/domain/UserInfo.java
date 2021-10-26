package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:12
 * @description：用户信息
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class UserInfo {
    private String gender;
    private String email;
    private String birthday;
}
