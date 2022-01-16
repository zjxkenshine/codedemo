package com.kenshine.airline.Test01;

import com.github.rvesse.airline.annotations.Cli;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:32
 * @description： 复杂命令构建
 * @modified By：
 * @version: $
 */
@Cli(name = "basic",
        description = "Provides a basic example CLI",
        defaultCommand = TestStart.class,
        commands = { TestStart.class})
public class BasicCli {
    public static void main(String[] args) {
        com.github.rvesse.airline.Cli<Runnable> cli = new com.github.rvesse.airline.Cli<>(BasicCli.class);
        Runnable cmd = cli.parse(args);
        cmd.run();
    }
}
