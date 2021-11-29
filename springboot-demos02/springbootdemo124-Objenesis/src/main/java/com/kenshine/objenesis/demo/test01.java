package com.kenshine.objenesis.demo;


import com.kenshine.objenesis.common.MyThingy;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 14:16
 * @description：基本使用
 * @modified By：
 * @version: $
 */
public class test01 {

    public static void main(String[] args) {
        Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
        ObjectInstantiator thingyInstantiator = objenesis.getInstantiatorOf(MyThingy.class);

        MyThingy thingy1 = (MyThingy)thingyInstantiator.newInstance();
        MyThingy thingy2 = (MyThingy)thingyInstantiator.newInstance();
        MyThingy thingy3 = (MyThingy)thingyInstantiator.newInstance();

    }
}
