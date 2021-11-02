package com.kenshine.kapatcha.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 0:04
 * @description：验证码配置
 * @modified By：
 * @version: $
 */
@Configuration
@ConditionalOnProperty(havingValue = "true", value = "kaptcha.enabled", matchIfMissing = false)
public class KaptchaConfig {

    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //验证码是否带边框 No
        properties.setProperty("kaptcha.border", "no");
        //验证码字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        //验证码整体宽度
        properties.setProperty("kaptcha.image.width", "400");
        //验证码整体高度
        properties.setProperty("kaptcha.image.height", "125");
        //文字个数
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //文字大小
        properties.setProperty("kaptcha.textproducer.font.size", "100");
        //文字随机字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //文字距离
        properties.setProperty("kaptcha.textproducer.char.space", "16");
        //干扰线颜色
        properties.setProperty("kaptcha.noise.color", "blue");
        //自定义验证码样式
        //properties.setProperty("kaptcha.obscurificator.impl", "com.example.sbs.config.DisKaptchaCssImpl");
        //自定义验证码背景
        //properties.setProperty("kaptcha.background.impl", "com.example.sbs.config.NoKaptchaBackhround");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }


}
