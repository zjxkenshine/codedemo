package com.kenshine.objenesis.demo;

import com.kenshine.objenesis.common.MyThingy;
import org.objenesis.ObjenesisHelper;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 14:31
 * @description：
 * @modified By：
 * @version: $
 */
public class test04 {
    public static void main(String[] args) {
        MyThingy thingy1 = ObjenesisHelper.newInstance(MyThingy.class);
        //需要MyThingy实现Serializable接口
        MyThingy thingy2 = ObjenesisHelper.newSerializableInstance(MyThingy.class);
    }
}
