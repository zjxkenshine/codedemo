package com.kenshine.joddproxetta;

/**
 * @author kenshine
 */
public class Foo implements BaseFoo{

    @Override
    @Log
    public void foo(){
        System.out.println("foo");
    }
}