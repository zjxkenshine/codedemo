package com.kenshine.objenesis.demo;

import com.kenshine.objenesis.common.MyThingy;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 14:19
 * @description：
 * @modified By：
 * @version: $
 *
 * 重用ObjectInstantiator对象
 */
public class test02 {

    public static void main(String[] args) {
        Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
        MyThingy thingy1 = (MyThingy) objenesis.newInstance(MyThingy.class);

        // or (a little bit more efficient if you need to create many objects)
        Objenesis objenesis1 = new ObjenesisStd(); // or ObjenesisSerializer
        ObjectInstantiator thingyInstantiator = objenesis1.getInstantiatorOf(MyThingy.class);

        MyThingy thingy2 = (MyThingy)thingyInstantiator.newInstance();
        MyThingy thingy3 = (MyThingy)thingyInstantiator.newInstance();
        MyThingy thingy4 = (MyThingy)thingyInstantiator.newInstance();
    }

}
