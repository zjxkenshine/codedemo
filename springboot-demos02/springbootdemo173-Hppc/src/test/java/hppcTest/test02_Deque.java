package hppcTest;

import com.carrotsearch.hppc.IntArrayDeque;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.procedures.IntProcedure;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static hppcTest.Helpers.printfln;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:46
 * @description：
 * @modified By：
 * @version: $
 */
public class test02_Deque {
    public IntArrayDeque deque;

    @Before
    public void setup() {
        deque = new IntArrayDeque();
        deque.addLast(1, 1, 2, 3, 5);
    }

    /**
     * 游标输出
     */
    @Test
    public void cursorFirstToLast() {
        for (IntCursor c : deque) {
            printfln("deque[%d] = %d", c.index, c.value);
        }
    }

    /**
     * 逆序输出
     */
    @Test
    public void cursorLastToFirst() {
        for (Iterator<IntCursor> i = deque.descendingIterator(); i.hasNext(); ) {
            IntCursor c = i.next();
            printfln("deque[%d] = %d", c.index, c.value);
        }
    }

    /**
     * 匿名类foreach循环
     */
    @Test
    public void forEachLoop() {
        deque.forEach(
                (IntProcedure) value -> Helpers.printfln("deque[?] = %d", value));
    }

    /**
     * 逆序foreach循环
     */
    @Test
    public void forEachLoopReversed() {
        deque.descendingForEach(
                new IntProcedure() {
                    public void apply(int value) {
                        printfln("deque[?] = %d", value);
                    }
                });
    }
}
