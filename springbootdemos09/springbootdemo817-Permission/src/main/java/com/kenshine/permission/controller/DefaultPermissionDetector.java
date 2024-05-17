package com.kenshine.permission.controller;

import com.kenshine.permission.data.User;
import idea.verlif.spring.permission.PermData;
import idea.verlif.spring.permission.PermissionDetector;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname DefaultPermissionDetector
 * @Description 初始化数据
 * @Date 2024-05-17 11:14
 * @modified By：
 * @version: 1.0$
 */
public class DefaultPermissionDetector implements PermissionDetector<String> {

    public DefaultPermissionDetector() {
    }

    /**
     * 权限数据是否拥有角色
     * @param data 权限数据，从下面的{@link #getRequestData()}获取的权限数据
     * @param role @Perm的hasRole参数
     * @return 权限数据是否拥有角色
     */
    @Override
    public boolean hasRole(PermData<String> data, String role) {
        return data.getRoles().stream().anyMatch(o -> o.equals(role));
    }

    /**
     * 权限数据是否拥有权限
     * @param data 权限数据，从下面的{@link #getRequestData()}获取的权限数据
     * @param key @Perm的hasKey参数
     * @return 权限数据是否拥有权限
     */
    @Override
    public boolean hasKey(PermData<String> data, String key) {
        return data.getKeys().stream().anyMatch(s -> s.equals(key));
    }

    /**
     * 主要实现以下方法，这个方法用于获取当前的访问者权限数据
     **/
    @Override
    public PermData<String> getRequestData() {
        // 模拟获取用户信息
        User user = new User();
        user.setRoles(Arrays.asList("user"));
        return user;
    }
}