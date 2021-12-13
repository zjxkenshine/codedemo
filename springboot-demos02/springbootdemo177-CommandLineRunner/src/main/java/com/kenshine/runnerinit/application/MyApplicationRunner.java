package com.kenshine.runnerinit.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 22:55
 * @description：ApplicationRunner
 * @modified By：
 * @version: $
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    /**
     * JVN参数 aaa,bbb --foo=bar --developer.name=kenshine
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===MyApplicationRunner==="+ Arrays.asList(args.getSourceArgs()));
        //aaa,bbb
        System.out.println("===getOptionNames========"+args.getOptionNames());
        //--foo=bar
        System.out.println("===getOptionValues======="+args.getOptionValues("foo"));
        //--developer.name=kenshine
        System.out.println("==getOptionValues========"+args.getOptionValues("developer.name"));
    }
}
