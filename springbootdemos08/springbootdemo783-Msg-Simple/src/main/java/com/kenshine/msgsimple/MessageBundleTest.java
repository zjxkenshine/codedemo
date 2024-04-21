package com.kenshine.msgsimple;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.locale.LocaleUtils;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.provider.StaticMessageSourceProvider;
import com.github.fge.msgsimple.source.MapMessageSource;
import com.github.fge.msgsimple.source.MessageSource;
import org.junit.Test;

import java.util.Locale;

/**
 * @author by kenshine
 * @Classname MessageBundleTest
 * @Description 创建Message
 * @Date 2024-04-21 9:21
 * @modified By：
 * @version: 1.0$
 */
public class MessageBundleTest {

    /**
     * 通过MessageSourceProvider构建
     */
    @Test
    public void test01(){
        MessageSource source1 = MapMessageSource.newBuilder()
                .put("key1", "value1")
                .put("key2", "value2")
                .build();
        MessageSource source2 = MapMessageSource.newBuilder()
                .put("key1", "值1")
                .put("key2", "值2")
                .build();

        // 设置MessageSource
        MessageSourceProvider provider = StaticMessageSourceProvider.newBuilder()
                .addSource(Locale.ENGLISH, source1)
                .addSource(LocaleUtils.parseLocale("zh_CN"), source2)
                .build();

        final MessageBundle bundle = MessageBundle.newBuilder()
                // 附加列表
                .appendProvider(provider)
                // 预加载
                .prependProvider(provider)
                .freeze();
    }

    /**
     * 通过MessageSource构建
     */
    @Test
    public void test02(){
        MessageSource source1 = MapMessageSource.newBuilder()
                .put("key1", "value1")
                .put("key2", "value2")
                .build();
        MessageSource source2 = MapMessageSource.newBuilder()
                .put("key1", "值1")
                .put("key2", "值2")
                .build();
        // 所有locales
        MessageBundle.newBuilder()
                .appendSource(source1)
                .prependSource(source2)
                .freeze();
        // 指定locale
        MessageBundle.newBuilder()
                .appendSource(Locale.ENGLISH, source1)
                .prependSource(Locale.SIMPLIFIED_CHINESE, source2)
                .freeze();
    }

    /**
     * 重新绑定
     */
    @Test
    public void test03(){
        MessageSource source1 = MapMessageSource.newBuilder()
                .put("key1", "value1")
                .put("key2", "value2")
                .build();
        MessageSource source2 = MapMessageSource.newBuilder()
                .put("key1", "值1")
                .put("key2", "值2")
                .build();
        MessageBundle otherBundle = MessageBundle.newBuilder()
                .appendSource(source1)
                .freeze();
        // 重新绑定 使用了btf中的冻结/解冻模式
        MessageBundle myBundle = otherBundle.thaw().prependSource(source2).freeze();
    }
}
