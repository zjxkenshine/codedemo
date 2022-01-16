package com.kenshine.airline.Test03Extends;

import com.github.rvesse.airline.annotations.Option;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:47
 * @description：
 * @modified By：
 * @version: $
 */
public abstract  class BaseCommand implements ExampleRunnable {

    @Option(name = { "-v", "--verbose" }, description = "Enables verbose mode")
    protected boolean verbose = false;

}
