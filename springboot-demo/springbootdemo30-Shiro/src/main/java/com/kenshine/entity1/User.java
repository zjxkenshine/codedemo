package com.kenshine.entity1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 12:02
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String  id;
    private String username;
    private String password;
    private String salt;
    private List<Role> roles;
}
