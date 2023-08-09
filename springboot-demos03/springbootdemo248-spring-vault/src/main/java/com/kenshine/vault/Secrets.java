package com.kenshine.vault;

import org.springframework.vault.annotation.VaultPropertySource;

/**
 * @author by kenshine
 * @Classname Secrets
 * @Description 加密类
 * @Date 2023-08-09 9:44
 * @modified By：
 * @version: 1.0$
 */
@VaultPropertySource(value = "secret/myapp")
public class Secrets {
    public String username;
    public String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
