package com.kenshine.nlpchaizi;

import com.github.houbb.nlp.hanzi.similar.util.ChaiziHelper;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname ChaiziTest
 * @Description 拆字
 * @Date 2023-11-11 8:37
 * @modified By：
 * @version: 1.0$
 */
public class ChaiziTest {

    /**
     * 拆一个字
     */
    @Test
    public void test01(){
        List<String> chai=ChaiziHelper.chai('洪');
        System.out.println(chai);

        List<String> chai1=ChaiziHelper.chai('鑫');
        System.out.println(chai1);
    }

    /**
     * 拆字符串
     */
    @Test
    public void test02(){
       String chai=ChaiziHelper.chai("上海辟谣平台等针对此消息已进行多次报道辟谣");
       System.out.println(chai);
    }

    /**
     * 自定义拆字 nlp_chaizi_define.txt
     */
    @Test
    public void test03(){
        List<String> chai=ChaiziHelper.chai('在');
        System.out.println(chai);
    }



}
