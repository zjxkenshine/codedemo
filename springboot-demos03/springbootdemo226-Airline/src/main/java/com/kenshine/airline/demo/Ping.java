package com.kenshine.airline.demo;

import com.github.rvesse.airline.HelpOption;
import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;

import javax.inject.Inject;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:55
 * @description：
 * @modified By：
 * @version: $
 */
@Command(name = "ping", description = "network test utility")
public class Ping {
    @Inject
    public HelpOption helpOption;

    @Option(name = {"-c", "--count"}, description = "Send count packets")
    public int count = 1;

    public static void main(String... args) {
        Ping ping = SingleCommand.singleCommand(Ping.class).parse(args);
        if (ping.helpOption.showHelpIfRequested()) {
            return;
        }

        ping.run();
    }

    public void run() {
        System.out.println("Ping count: " + count);
    }
}
