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
public class Cmd1 {
    @ShellMethod(value = "Cmd1 action1", group = "CMD")
    public void action11() {
        System.out.println("cmd1 action1");
    }

    @ShellMethod(value = "Cmd1 action2", group = "CMD")
    public void action12() {
        System.out.println("cmd1 action2");
    }
}
