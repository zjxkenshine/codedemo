package com.kenshine.crane4j.Test03;

import cn.crane4j.core.container.Container;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname UserContainer
 * @Description 用户自定义容器
 * @Date 2023-10-16 15:04
 * @modified By：
 * @version: 1.0$
 */
@RequiredArgsConstructor
public class UserContainer implements Container<Integer> {
    private final UserService userService;

    public String getNamespace() {
        return "user";
    }

    public Map<Integer, UserDO> get(Collection<Integer> ids) {
        List<UserDO> users = userService.listByIds(ids);
        return users.stream().collect(Collectors.toMap(UserDO::getId, Function.identity()));
    }
}
