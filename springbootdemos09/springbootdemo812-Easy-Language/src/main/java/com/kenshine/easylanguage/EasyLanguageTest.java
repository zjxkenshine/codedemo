package com.kenshine.easylanguage;

import idea.verlif.easy.language.MessageGetter;
import idea.verlif.easy.language.config.GetterConfig;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;

/**
 * @author by kenshine
 * @Classname EasyLanguageTest
 * @Description EasyLanguage测试
 * @Date 2024-05-13 13:38
 * @modified By：
 * @version: 1.0$
 */
public class EasyLanguageTest {

    /**
     * 使用示例
     */
    @Test
    public void test01() throws IOException {
        // 实例化信息获取器，这里也可以设定默认语言，否则以系统语言为准。
        MessageGetter getter = new MessageGetter();
        // 添加语言文件，可以同时添加不同文件夹。也可以在添加时直接指定对应语言。
        getter.addResource("src\\main\\resources");
        // 更改信息获取器设置
        getter.getConfig().setResultType(GetterConfig.ResultType.WITH_NULL);
        // 使用信息获取器默认的语言获取文本
        System.out.println(getter.get("nihao"));
        // 指定语言获取文本
        System.out.println(getter.get("nihao", Locale.ENGLISH));
        // 由于之前的设定，当没有此语言文件时，优先从备用语言资源中获取。
        System.out.println(getter.get("nihao", Locale.FRENCH));
        // 可以直接指定语言文件后缀
        System.out.println(getter.get("nihao", "test"));
        // 由于之前的设定，当备用语言资源中也没有此语言代码时，会返回null
        System.out.println(getter.get("wohao"));
        // 对已有的语言进行信息追加。这里的语言传入null则会追加到备用语言资源中。
        getter.addResource("src\\main\\resources\\resource_addon.properties", (Locale) null);
        // 此时再次获取则会查询到信息
        System.out.println(getter.get("wohao"));
    }
}
