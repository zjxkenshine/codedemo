package com.kenshine.sux4j;

import it.unimi.dsi.bits.TransformationStrategies;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongBigList;
import it.unimi.dsi.fastutil.longs.LongBigLists;
import it.unimi.dsi.sux4j.mph.GOV3Function;
import it.unimi.dsi.sux4j.mph.MWHCFunction;
import it.unimi.dsi.sux4j.mph.TwoStepsGOV3Function;
import it.unimi.dsi.sux4j.mph.codec.Codec;
import it.unimi.dsi.sux4j.mph.solve.Modulo2System;
import it.unimi.dsi.sux4j.mph.solve.Modulo2System.*;
import it.unimi.dsi.sux4j.mph.solve.Orient3Hypergraph;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname Sux4jTest02
 * @Description mph包
 * @Date 2023-12-12 22:02
 * @modified By：
 * @version: 1.0$
 */
public class Sux4jTest02 {

    /**
     * Codec 压缩中间态
     */
    @Test
    public void test01(){
        final Codec.Gamma gamma = new Codec.Gamma();
        final Long2LongOpenHashMap frequencies = new Long2LongOpenHashMap(new long[] { 6, 9, 1, 2, 4, 5, 3, 4, 7, 10000000 }, new long[] { 64, 32, 16, 1, 8, 4, 20, 2, 1, 10 });
        final Codec.Coder coder = gamma.getCoder(frequencies);
        final Codec.Decoder decoder = coder.getDecoder();
        for (int i = 0; i < 1000; i++) {
            final long encoded = coder.encode(i);
            // maxCodewordLength 返回与给定符号关联的Codeword的最大长度
            final long longEncoded = Long.reverse(encoded) >>> Long.SIZE - coder.maxCodewordLength();
            final long decoded = decoder.decode(longEncoded);
            System.out.println(decoded);
        }
    }

    /**
     * Modulo2System
     */
    @Test
    public void test02(){
        final Modulo2System system = new Modulo2System(11);
        system.add(new Modulo2Equation(0, 11).add(1).add(4).add(10));
        system.add(new Modulo2Equation(2, 11).add(1).add(4).add(9));
        system.add(new Modulo2Equation(0, 11).add(0).add(6).add(8));
        system.add(new Modulo2Equation(1, 11).add(0).add(6).add(9));
        system.add(new Modulo2Equation(2, 11).add(2).add(4).add(8));
        system.add(new Modulo2Equation(0, 11).add(2).add(6).add(10));
        final long[] solution = new long[11];
        Arrays.fill(solution, 0);

        // 使用惰性高斯消去法求解系统
        system.copy().lazyGaussianElimination(solution);
        // 结果
        System.out.println(system.check(solution));
        System.out.println(system.toString());
    }

    /**
     * GOV3Function 不可变函数存储
     */
    @Test
    public void test03() throws IOException {
        final GOV3Function<CharSequence> mph = new GOV3Function.Builder<CharSequence>().keys(Arrays.asList("a", "b", "c", "d")).transform(TransformationStrategies.utf16()).dictionary(8).build();
        System.out.println(mph.getLong("a")); // 存在1，不存在0
        System.out.println(mph.getLong("b"));
        System.out.println(mph.getLong("c"));
        System.out.println(mph.getLong("d"));
        System.out.println(mph.getLong("e"));

        final LongArrayList l = new LongArrayList(new long[] { 0x234904309830498L, 0xae049345e9eeeeeL, 0x23445234959234L, 0x239234eaeaeaeL });
        GOV3Function<CharSequence> function = new GOV3Function.Builder<CharSequence>().keys(Arrays.asList("a", "b", "c", "d")).transform(TransformationStrategies.utf16()).values(l).build();
        System.out.println(function.getLong("a"));
        System.out.println(function.getLong("c"));
        System.out.println(function.getLong("d"));
        System.out.println(function.getLong("e"));
    }


}
