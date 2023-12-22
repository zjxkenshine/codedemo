package com.kenshine.beanfillertrace.model;

import io.github.beanfiller.annotation.annotations.Value;
import io.github.beanfiller.annotation.annotations.Var;

/**
 * @author by kenshine
 * @Classname Emoji
 * @Description 测试类
 * @Date 2023-12-22 9:49
 * @modified By：
 * @version: 1.0$
 */
public class Emoji {
    @Var(value = {@Value("^"), @Value("°"), @Value("ಠ"), @Value("≖"), @Value("•"),
            @Value("ˇ"), @Value("˘"), @Value("ᴗ"), @Value("\""), @Value("<"), @Value("╥")})
    char eye;

    @Var(value = {@Value("-"), @Value("_"), @Value("‿"), @Value("∇"), @Value("◡"),
            @Value("³"), @Value("ᴗ"), @Value("﹏"), @Value(".")})
    char snoot;

    @Var(value = {@Value("\\/"), @Value("ᕙᕗ"), @Value("ᕦᕤ"), @Value("┌ʃ")})
    String arms;

    public String getFace() {
        return (arms == null ? "" : arms.substring(0, 1))
                + '(' + eye + snoot + eye + ')' // chars cannot be null
                + (arms == null ? "" : arms.substring(1, 2));
    }
}
