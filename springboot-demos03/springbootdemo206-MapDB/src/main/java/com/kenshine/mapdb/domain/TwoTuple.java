package com.kenshine.mapdb.domain;

import org.checkerframework.checker.units.qual.A;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 10:08
 * @description：
 * @modified By：
 * @version: $
 */
public class TwoTuple<A, B>{
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }
}
