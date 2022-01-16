package com.kenshine.designpattern.gof05_AbstractFactory.test01.factory;

import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.cpu.Cpu;
import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.cpu.IntelCpu;
import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.mainboard.IntelMainboard;
import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.mainboard.Mainboard;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 0:00
 * @description：
 * @modified By：
 * @version: $
 */
public class IntelFactory implements AbstractFactory {
    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}
