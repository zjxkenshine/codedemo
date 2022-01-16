package com.kenshine.designpattern.gof05_AbstractFactory.test01.factory;

import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.cpu.Cpu;
import com.kenshine.designpattern.gof05_AbstractFactory.test01.model.mainboard.Mainboard;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 23:55
 * @description：
 * @modified By：
 * @version: $
 */
public interface AbstractFactory {
    /**
     * 创建CPU对象
     * @return CPU对象
     */
    Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    Mainboard createMainboard();

}
