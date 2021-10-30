package com.kenshine.i18n.util;

import com.kenshine.i18n.message.LocaleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:52
 * @description：工具类
 * @modified By：
 * @version: $
 */
@Component
public class I18nUtils {


    @Autowired
    private LocaleMessage localeMessage;

    /**
     * 获取key
     * @param key
     * @return
     */
    public  String getKey(String key) {
        String name = localeMessage.getMessage(key);
        return name;
    }

    /**
     * 获取指定哪个配置文件下的key
     * @param key
     * @param local
     * @return
     */
    public  String getKey(String key, Locale local) {
        String name = localeMessage.getMessage(key, local);
        return name;
    }

}
