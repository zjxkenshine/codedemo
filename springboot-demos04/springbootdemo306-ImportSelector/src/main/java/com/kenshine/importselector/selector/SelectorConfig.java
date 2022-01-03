package com.kenshine.importselector.selector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 22:27
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@Import({TestImportSelector.class,TestDeferredImportSelector.class})
public class SelectorConfig {
    @Bean
    public Demo test() {
        System.out.println("Demo类实例化");
        return new Demo();
    }
}


