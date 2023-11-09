package com.kenshine.lombokex;

import com.github.houbb.lombok.ex.annotation.Util;

/**
 * @author by kenshine
 * @Classname StringUtil
 * @Description @Util注解
 * @Date 2023-11-09 8:22
 * @modified By：
 * @version: 1.0$
 */
@Util
public class StringUtil {

    public static boolean isEmpty(final String string) {
        return null == string || "".equals(string);
    }
}
