package hppcTest;

import com.carrotsearch.hppc.ObjectArrayList;
import org.junit.Test;

import static hppcTest.Helpers.printfln;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 19:03
 * @description：遍历对象缓冲
 * @modified By：
 * @version: $
 */
public class test06_ObjectBuffers {
    public final ObjectArrayList<Integer> list = ObjectArrayList.from(1, 1, 2, 3, 5);

    /**
     * 遍历对象缓冲
     */
    @Test
    public void directBufferLoop() {
        final Object[] buffer = list.buffer;
        final int size = list.size();
        for (int i = 0; i < size; i++) {
            printfln("list[%d] = %d", i, buffer[i]);
        }
    }
}
