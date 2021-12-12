package hppcTest;

import com.carrotsearch.hppc.IntIntHashMap;
import com.carrotsearch.hppc.procedures.IntIntProcedure;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:59
 * @description：
 * @modified By：
 * @version: $
 */
public class test05_ForEachValues {

    @Test
    public void forEach_FilteredCounting() {
        // 创建键值对映射
        final IntIntHashMap map = new IntIntHashMap();
        map.put(1, 2);
        map.put(2, -5);
        map.put(3, 10);
        map.put(4, -1);
        map.put(5, 1);

        // 非负整数计数器
        int count = map.forEach(
                        new IntIntProcedure() {
                            int counter;

                            public void apply(int key, int value) {
                                if (value >= 0) {
                                    counter++;
                                }
                            }
                        }).counter;

        System.out.println("有" + count + "个非负整数");
    }
}
