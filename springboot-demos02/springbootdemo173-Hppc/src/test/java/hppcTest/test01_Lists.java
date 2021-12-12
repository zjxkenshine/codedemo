package hppcTest;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.procedures.IntProcedure;
import org.junit.Test;

import static hppcTest.Helpers.printfln;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:37
 * @description：遍历List
 * @modified By：
 * @version: $
 */
public class test01_Lists {
    public final IntArrayList list = IntArrayList.from(1, 1, 2, 3, 5);

    /**
     * 使用游标遍历，开销小
     */
    @Test
    public void cursor() {
        for (IntCursor c : list) {
            printfln("list[%d] = %d", c.index, c.value);
        }
    }

    /**
     * 循环索引方式
     */
    @Test
    public void simpleLoop() {
        for (int i = 0, max = list.size(); i < max; i++) {
            printfln("list[%d] = %d", i, list.get(i));
        }
    }

    /**
     * 带有Procedure匿名类的forEach循环
     */
    @Test
    public void forEachLoop() {
        list.forEach(
                new IntProcedure() {
                    int index;
                    public void apply(int value) {
                        printfln("list[%d] = %d", index++, value);
                    }
                });
    }

    /**
     * 直接字符访问
     */
    @Test
    public void directBufferLoop() {
        final int[] buffer = list.buffer;
        final int size = list.size();
        for (int i = 0; i < size; i++) {
            printfln("list[%d] = %d", i, buffer[i]);
        }
    }

}
