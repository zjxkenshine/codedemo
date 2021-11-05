package com.kenshine.ehcache.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 21:49
 * @description：模拟用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = -69371250970922238L;
    private Integer id;
    private String username;
    private String password;

}
