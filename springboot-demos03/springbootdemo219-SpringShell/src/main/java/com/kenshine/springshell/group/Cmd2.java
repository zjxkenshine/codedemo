package com.kenshine.springshell.group;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:15
 * @description：
 * @modified By：
 * @version: $
 */
@ShellComponent
@ShellCommandGroup("CMD")
public class Cmd2 {
    @ShellMethod(value = "Cmd2 action1", group = "CMD")
    public void action21() {
        System.out.println("cmd2 action1");
    }

    @ShellMethod(value = "Cmd2 action2", group = "CMD")
    public void action22() {
        System.out.println("cmd2 action2");
    }
}
