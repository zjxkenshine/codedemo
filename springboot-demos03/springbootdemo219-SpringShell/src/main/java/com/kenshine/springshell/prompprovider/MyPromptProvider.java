package com.kenshine.springshell.prompprovider;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:34
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class MyPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        // 定制命令提示符为红色的“#”
        return new AttributedString("#", AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }
}
