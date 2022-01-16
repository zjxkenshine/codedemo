package com.kenshine.airline.Test02Converter;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.annotations.Parser;
import com.kenshine.airline.Test01.TestStart;

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
        commands = { TestStart.class},
        //自定义类型转换器
        parserConfiguration = @Parser(typeConverter = ExtendedTypeConverter.class))
public class BasicCli2 {
    public static void main(String[] args) {
        com.github.rvesse.airline.Cli<Runnable> cli = new com.github.rvesse.airline.Cli<>(BasicCli2.class);
        Runnable cmd = cli.parse(args);
        cmd.run();
    }
}
