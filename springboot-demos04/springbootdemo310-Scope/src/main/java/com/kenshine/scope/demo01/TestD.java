package com.kenshine.scope.demo01;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 9:53
 * @description：接口，使用jdk动态代理
 * @modified By：
 * @version: $
 *
 * 加在接口上没有效果
 */
@Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
public interface TestD {
}
