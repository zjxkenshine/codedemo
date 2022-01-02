package com.kenshine.springshell.method;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.validation.constraints.Size;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:02
 * @description：
 * @modified By：
 * @version: $
 */
@ShellComponent
public class ValidateArgs {

    // 使用@Size注解校验参数长度
    /**
     * change-pwd 123  当参数长度小于最小值6时报错
     * change-pwd 1234567890123456789012345678901 当参数长度大于最大值30时报错
     * change-pwd 1234567890    参数在指定范围是成功
     */
    @ShellMethod("Change password")
    public void changePwd(@Size(min = 6, max = 30) String pwd) {
        System.out.println(pwd);
    }
}
