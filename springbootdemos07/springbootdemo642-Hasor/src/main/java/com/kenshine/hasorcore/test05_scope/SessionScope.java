package com.kenshine.hasorcore.test05_scope;

import net.hasor.core.Scope;

import javax.servlet.http.HttpSession;
import java.util.function.Supplier;

/**
 * 自定义作用域
 * @author kenshine
 */
public class SessionScope implements Scope {
    public static final ThreadLocal<HttpSession> session
            = new ThreadLocal<HttpSession>();

    @Override
    public <T> Supplier<T> scope(Object key, Supplier<T> supplier) {
        HttpSession httpSession = session.get();
        if (httpSession == null) {
            return supplier;
        }
        // 为了避免保存到 Session 中的 Bean 和本身 Session 中的数据 key
        // 出现冲突，增加一个前缀用于区分
        String keyStr = "session_scope_" + key.toString();
        Object attribute = httpSession.getAttribute(keyStr);
        Supplier<T> finalProvider = supplier;
        if (attribute == null) {
            httpSession.setAttribute(keyStr, supplier);
        } else {
            finalProvider = (Supplier<T>) httpSession.getAttribute(keyStr);
        }
        return finalProvider;
    }
}