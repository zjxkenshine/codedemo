package com.kenshine.importselector.classes;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 22:18
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@Import({TestA.class,TestB.class})
public class Config {
}
