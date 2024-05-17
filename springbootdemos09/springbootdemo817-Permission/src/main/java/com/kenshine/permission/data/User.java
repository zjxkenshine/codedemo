package com.kenshine.permission.data;

import idea.verlif.spring.permission.PermData;
import lombok.Data;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户
 * @Date 2024-05-17 11:24
 * @modified By：
 * @version: 1.0$
 */
@Setter
public class User implements PermData<String> {
   private List<String> roles;


    @Override
    public Set<String> getRoles() {
        return new HashSet<>(roles);
    }
    @Override
    public Set<String> getKeys() {
        return null;
    }
}
