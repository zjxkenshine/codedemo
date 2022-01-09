package com.kenshine.basic._02_generic;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 11:49
 * @description：
 * @modified By：
 * @version: $
 */
public class test10_GenericPECS {

    /**
     * 要从中获取元素的 extends
     * 要把元素穿进去处理的 super
     */
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (comp.compare(next, candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

}
