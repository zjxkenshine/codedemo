package com.kenshine.jmockit.mock;

import java.util.Locale;

/**
 * 基于行为的mock
 * @author kenshine
 */
public class HelloJMockit {
    // 向JMockit打招呼
    public String sayHello() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA)) {
            // 在中国，就说中文
            return "你好，JMockit!";
        } else {
            // 在其它国家，就说英文
            return "Hello，JMockit!";
        }
    }
}