package com.kenshine.springshell.converter;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:41
 * @description：
 * @modified By：
 * @version: $
 */
// 使用自定义转换类型
@ShellComponent
public class ConverterCmd {
    // 在命令方法中直接可以获取Food对象，这是通过前面的自定义类型转换器MyConverter实现的
    //food apple
    @ShellMethod("Conversion food")
    public String food(Food food) {
        return food.toString();
    }
}
