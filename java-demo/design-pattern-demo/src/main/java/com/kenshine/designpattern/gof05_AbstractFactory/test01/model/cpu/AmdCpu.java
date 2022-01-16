package com.kenshine.designpattern.gof05_AbstractFactory.test01.model.cpu;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 23:57
 * @description：
 * @modified By：
 * @version: $
 */
public class AmdCpu implements Cpu {
 /**
 * CPU的针脚数
 */
private int pins = 0;
    public  AmdCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }

}
