package com.kenshine.chapter06;

import javafx.scene.control.Cell;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.LongBinaryOperator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 22:06
 * @description：
 * @modified By：
 * @version: $
 * LongAdder 源码分析
 */
public class Test11_LongAdderSource{

    // add源码
//    public void add(long x) {
//        // as 为累加单元数组, b 为基础值, x 为累加值
//        Cell[] as; long b, v; int m; Cell a;
//        // 进入 if 的两个条件
//        // 1. as 有值, 表示已经发生过竞争, 进入 if
//        // 2. cas 给 base 累加时失败了, 表示 base 发生了竞争, 进入 if
//        // 3. 如果 as 没有创建, 然后 cas 累加成功就返回，累加到 base 中 不存在线程竞争的时候用到。
//        if ((as = cells) != null || !casBase(b = base, b + x)) {
//            // uncontended 表示 cell 是否有竞争，这里赋值为 true 表示有竞争
//            boolean uncontended = true;
//            if (
//                // as 还没有创建
//                    as == null || (m = as.length - 1) < 0 ||
//                            // 当前线程对应的 cell 还没有被创建，a为当线程的cell
//                            (a = as[getProbe() & m]) == null ||
//                            // 给当前线程的 cell 累加失败 uncontended=false ( a 为当前线程的 cell )
//                            !(uncontended = a.cas(v = a.value, v + x))
//            ) {
//                // 当 cells 为空时，累加操作失败会调用方法，
//                // 当 cells 不为空，当前线程的 cell 创建了但是累加失败了会调用方法，
//                // 当 cells 不为空，当前线程 cell 没创建会调用这个方法
//                // 进入 cell 数组创建、cell 创建的流程
//                longAccumulate(x, null, uncontended);
//            }
//        }
//    }
//
//    // longAccumulate源码
//    final void longAccumulate(long x, LongBinaryOperator fn,
//                              boolean wasUncontended) {
//        int h;
//        // 当前线程还没有对应的 cell, 需要随机生成一个 h 值用来将当前线程绑定到 cell
//        if ((h = getProbe()) == 0) {
//            // 初始化 probe
//            ThreadLocalRandom.current();
//            // h 对应新的 probe 值, 用来对应 cell
//            h = getProbe();
//            wasUncontended = true;
//        }
//        // collide 为 true 表示需要扩容
//        boolean collide = false;
//        for (; ; ) {
//            Cell[] as;
//            Cell a;
//            int n;
//            long v;
//            // 已经有了 cells
//            if ((as = cells) != null && (n = as.length) > 0) {
//                // 但是还没有当前线程对应的 cell
//                if ((a = as[(n - 1) & h]) == null) {
//                    // 为 cellsBusy 加锁, 创建 cell, cell 的初始累加值为 x
//                    // 成功则 break, 否则继续 continue 循环
//                    if (cellsBusy == 0) {       // Try to attach new Cell
//                        Cell r = new Cell(x);   // Optimistically create
//                        if (cellsBusy == 0 && casCellsBusy()) {
//                            boolean created = false;
//                            try {               // Recheck under lock
//                                Cell[] rs;
//                                int m, j;
//                                if ((rs = cells) != null &&
//                                        (m = rs.length) > 0 &&
//                                        // 判断槽位确实是空的
//                                        rs[j = (m - 1) & h] == null) {
//                                    rs[j] = r;
//                                    created = true;
//                                }
//                            } finally {
//                                cellsBusy = 0;
//                            }
//                            if (created)
//                                break;
//                            continue;           // Slot is now non-empty
//                        }
//                    }
//                    // 有竞争, 改变线程对应的 cell 来重试 cas
//                    else if (!wasUncontended)
//                        wasUncontended = true;
//                        // cas 尝试累加, fn 配合 LongAccumulator 不为 null, 配合 LongAdder 为 null
//                    else if (a.cas(v = a.value, ((fn == null) ? v + x : fn.applyAsLong(v, x))))
//                        break;
//                        // 如果 cells 长度已经超过了最大长度, 或者已经扩容, 改变线程对应的 cell 来重试 cas
//                    else if (n >= NCPU || cells != as)
//                        collide = false;
//                        // 确保 collide 为 false 进入此分支, 就不会进入下面的 else if 进行扩容了
//                    else if (!collide)
//                        collide = true;
//                        // 加锁
//                    else if (cellsBusy == 0 && casCellsBusy()) {
//                        // 加锁成功, 扩容
//                        continue;
//                    }
//                    // 改变线程对应的 cell
//                    h = advanceProbe(h);
//                }
//                // 还没有 cells, cells==as是指没有其它线程修改cells，as和cells引用相同的对象，使用casCellsBusy()尝试给 cellsBusy 加锁
//                else if (cellsBusy == 0 && cells == as && casCellsBusy()) {
//                    // 加锁成功, 初始化 cells, 最开始长度为 2, 并填充一个 cell
//                    // 成功则 break;
//                    boolean init = false;
//                    try {                           // Initialize table
//                        if (cells == as) {
//                            Cell[] rs = new Cell[2];
//                            rs[h & 1] = new Cell(x);
//                            cells = rs;
//                            init = true;
//                        }
//                    } finally {
//                        cellsBusy = 0;
//                    }
//                    if (init)
//                        break;
//                }
//                // 上两种情况失败, 尝试给 base 使用casBase累加
//                else if (casBase(v = base, ((fn == null) ? v + x : fn.applyAsLong(v, x))))
//                    break;
//            }
//        }
//    }
//
//    // sum 源码
//    public long sum() {
//        Cell[] as = cells; Cell a;
//        long sum = base;
//        if (as != null) {
//            for (int i = 0; i < as.length; ++i) {
//                if ((a = as[i]) != null)
//                    sum += a.value;
//            }
//        }
//        return sum;
//    }
}
