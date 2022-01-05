package com.kenshine.io.Test04_Serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 22:49
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
