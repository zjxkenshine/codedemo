package com.kenshine.gulava.model;

import gulava.DelayedGoal;
import gulava.Goal;
import gulava.annotation.MakeLogicValue;
import gulava.annotation.MakePredicates;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static gulava.Goals.conj;
import static gulava.Goals.same;

/**
 * 逻辑类型生成
 * 表示AB之间的串联关系
 */
@MakeLogicValue
public abstract class Cons<A,B> {

    Cons() {}
    public abstract A a();
    public abstract B b();

    public static <A, B> Cons<A, B> of(A a, B b) {
        return new MakeLogicValue_Cons<>(a, b);
    }

    public static Cons<?, ?> s(Object... o) {
        return Cons.list(Arrays.asList(o));
    }

    public static Cons list(List<?> values) {
        Cons result = null;
        for (ListIterator<?> valueIter = values.listIterator(values.size()); valueIter.hasPrevious();) {
            result = Cons.of(valueIter.previous(), result);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[")
                .append(a());
        Object rest = b();
        while (rest instanceof Cons) {
            Cons restCons = (Cons) rest;
            result.append(",")
                    .append(restCons.a());
            rest = restCons.b();
        }
        if (rest != null) {
            result.append("|")
                    .append(rest);
        }
        return result
                .append("]")
                .toString();
    }

    public static final Goals goals = new MakePredicates_Cons_Goals();

    /**
     * 谓语生成
     */
    @MakePredicates
    public static abstract class Goals {
        //
        public abstract Goal append(Object a, Object b, Object ab);

        final gulava.Goal append_baseCase(Void a, Object b, Object ab) {
            return same(b, ab);
        }

        final gulava.Goal append_iterate(Cons<?, ?> a, Object b, Cons<?, ?> ab) {
            return new DelayedGoal(
                    conj(same(a.a(), ab.a()),
                            append(a.b(), b, ab.b())));
        }
    }
}