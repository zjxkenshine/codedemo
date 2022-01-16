package com.kenshine.airline.Test01;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Arguments;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:02
 * @description：
 * @modified By：
 * @version: $
 */
@Command(name = "getting-started", description = "We're just getting started")
public class TestStart extends Thread{

    //一个不需要值的选项
    @Option(name = { "-f", "--flag" }, description = "An option that requires no values")
    private boolean flag = false;

    //额外参数
    @Arguments(description = "额外的参数")
    private List<String> args;

    public static void main(String[] args) {
        args = new String[]{"-f", "aaa"};
        SingleCommand<TestStart> parser = SingleCommand.singleCommand(TestStart.class);
        TestStart cmd = parser.parse(args);
        cmd.run();
    }

    @Override
    public void run() {
        System.out.println("Flag was " + (this.flag ? "set" : "not set"));
        if (args != null) {
            System.out.println("Arguments were " + StringUtils.join(args, ","));
        }
    }
}
