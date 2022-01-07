package com.kenshine.scope.demo02;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 10:16
 * @description：
 * @modified By：
 * @version: $
 *
 * 不加proxyMode = ScopedProxyMode.TARGET_CLASS同样值会有一个对象
 */
@Scope(value = DefaultListableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopeProxyBean {

    public void code() {
        System.out.println(this.hashCode());
    }
}
