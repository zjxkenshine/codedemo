package com.kenshine.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 19:03
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class SpringShellApp {
    public static void main(String[] args) {
        //禁用help命令
        String[] disabledCommands = new String[]{"--spring.shell.command.help.enabled=false"};
        String[] fullArgs = StringUtils.concatenateStringArrays(args, disabledCommands);
        //SpringApplication.run(SpringShellApp.class,fullArgs);
        SpringApplication.run(SpringShellApp.class,args);
    }
}
