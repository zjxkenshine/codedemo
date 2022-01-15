package com.kenshine.ezmorph.test;

import net.sf.ezmorph.MorphUtils;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:34
 * @description：Clendar复制
 * @modified By：
 * @version: $
 */
public class Test02 {
    public static void main(String[] args) {
        MorpherRegistry morperRegistry = new MorpherRegistry();
        MorphUtils.registerStandardMorphers(morperRegistry);
        Calendar dynaBean = Calendar.getInstance(); // initialized elsewhere
        System.out.println(dynaBean.getTime());

        //EZMorph只能处理public类型的构造方法，而Calendar的构造方法是protected的
        //最好还是使用Clone功能
        morperRegistry.registerMorpher(new BeanMorpher(GregorianCalendar.class,morperRegistry));
        Calendar myBean = (Calendar) morperRegistry.morph(GregorianCalendar.class, dynaBean);
        System.out.println(myBean.getTime());
    }
}
