package com.kenshine.equator.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 10:11
 * @description：测试
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class UserDTO {
    private Long id;
    private String name;
    private String password;
}
