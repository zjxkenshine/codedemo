package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:13
 * @description：
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class UserInfoDTO {
    private Long userId;
    private String userName;
    private Integer userAge;
    private UserInfo userInfo;
}
