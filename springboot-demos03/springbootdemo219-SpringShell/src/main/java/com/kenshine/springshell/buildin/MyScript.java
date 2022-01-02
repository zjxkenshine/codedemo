package com.kenshine.springshell.buildin;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.commands.Script;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:31
 * @description：
 * @modified By：
 * @version: $
 *
 *实现接口org.springframework.shell.standard.commands.Script.Command
 */
@ShellComponent
public class MyScript implements Script.Command {

    // 注意：命令名称与内置命令保持一致
    // 默认不会再在Built-In Commands分组
    @ShellMethod(value = "Read and execute commands from a file.", group = "Built-In Commands")
    public void script() {
        // 实现自定义逻辑
        System.out.println("override default script command");
    }

}
