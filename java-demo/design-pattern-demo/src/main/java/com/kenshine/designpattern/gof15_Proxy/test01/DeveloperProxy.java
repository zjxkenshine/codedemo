package com.kenshine.designpattern.gof15_Proxy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 19:41
 * @description：代理类
 * @modified By：
 * @version: $
 */
public class DeveloperProxy implements IDeveloper{
    private IDeveloper developer;
    public DeveloperProxy(IDeveloper developer){
        this.developer = developer;
    }
    @Override
    public void writeCode() {
        System.out.println("Write documentation...");
        this.developer.writeCode();
    }
}
