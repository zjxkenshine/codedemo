package com.kenshine.i18n.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 16:12
 * @description：配置
 * @modified By：
 * @version: $
 *
 *
 */
@Configuration
public class MessageSourceAutoConfiguration {
    /**
     * 多语言的资源文件路径,在application.properties中增加配置spring.messages.basename=classpath:i18n/message;classpath:i18n/log
     */
    @Value("${spring.messages.basename}")
    private String path;

    /**
     * 功能描述：  加载一下语言资源
     *
     * @param
     * @author wangcanfeng
     * @time 2019/3/4 22:03
     * @since v1.0
     **/
    @Bean("messageSource")
    @ConditionalOnMissingBean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // 用分号隔开各个语言资源路径
        String[] paths=path.split(";");
        messageSource.setBasenames(paths);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

}
