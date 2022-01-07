package com.kenshine.scope.demo01;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 9:51
 * @description：
 * @modified By：
 * @version: $
 * 抽象类 使用 cglib动态代理
 *
 * 加在这里同样不会有效果
 */
@Scope(value = DefaultListableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public abstract class TestC {
}
