package com.kenshine.msgsimple;

import com.github.fge.msgsimple.locale.LocaleUtils;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider;
import com.github.fge.msgsimple.provider.MessageSourceLoader;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.provider.StaticMessageSourceProvider;
import com.github.fge.msgsimple.source.MapMessageSource;
import com.github.fge.msgsimple.source.MessageSource;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname MessageSourceProviderTest
 * @Description MessageSourceProvider测试
 * @Date 2024-04-21 9:08
 * @modified By：
 * @version: 1.0$
 */
public class MessageSourceProviderTest {
    /**
     * StaticMessageSourceProvider
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
    }

    /**
     * LoadingMessageSourceProvider
     */
    @Test
    public void test02(){
        MessageSourceLoader loader = locale -> {
            MessageSource source1 = MapMessageSource.newBuilder()
                    .put("key1", "value1")
                    .put("key2", "value2")
                    .build();
            MessageSource source2 = MapMessageSource.newBuilder()
                    .put("key1", "值1")
                    .put("key2", "值2")
                    .build();
            if(locale==Locale.ENGLISH){
                return source1;
            }else{
                return source2;
            }
        };
        MessageSourceProvider provider = LoadingMessageSourceProvider.newBuilder()
                // 设置MessageSourceLoader实现
                .setLoader(loader)
                // （可选）设置默认源（如果有）
                //.setDefaultSource(source)
                // 可选：设置超时（默认为5秒）
                .setLoadTimeout(10L, TimeUnit.SECONDS)
                // 可选：设置到期时间（默认为10分钟）
                .setExpiryTime(2L, TimeUnit.HOURS)
                // 永不过期
                .neverExpires()
                .build();
    }
}
