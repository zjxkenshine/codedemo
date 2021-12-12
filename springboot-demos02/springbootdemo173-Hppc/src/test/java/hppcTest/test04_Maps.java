package hppcTest;

import com.carrotsearch.hppc.IntLongHashMap;
import com.carrotsearch.hppc.IntLongWormMap;
import com.carrotsearch.hppc.cursors.IntLongCursor;
import com.carrotsearch.hppc.procedures.IntLongProcedure;
import com.carrotsearch.hppc.procedures.IntProcedure;
import org.junit.Before;
import org.junit.Test;

import static hppcTest.Helpers.printfln;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:54
 * @description：Map遍历
 * @modified By：
 * @version: $
 */
public class test04_Maps {
    public IntLongHashMap hashMap;
    public IntLongWormMap wormMap;

    @Before
    public void setup() {
        hashMap = IntLongHashMap.from(new int[] {1, 1, 2, 3, 5, 0}, new long[] {1, 2, 3, 4, 5, 6});
        //get比put多的Map
        wormMap = IntLongWormMap.from(new int[] {1, 1, 2, 3, 5, 0}, new long[] {1, 2, 3, 4, 5, 6});
    }

    /**
     * 游标遍历Map
     */
    @Test
    public void cursor() {
        for (IntLongCursor c : hashMap) {
            printfln("hashMap %d => %d (at buffer index %d)", c.key, c.value, c.index);
            assertThat(c.value).isEqualTo(hashMap.values[c.index]);
            assertThat(c.key).isEqualTo(hashMap.keys[c.index]);
        }
    }

    /**
     * 匿名foreach遍历
      */
    @Test
    public void forEachLoop() {
        hashMap.forEach(
                new IntLongProcedure() {
                    @Override
                    public void apply(int key, long value) {
                        printfln("hashMap %d => %d", key, value);
                    }
                });
    }

    /**
     * foreach遍历key
     */
    @Test
    public void keys() {
        wormMap .keys()
                .forEach(
                        new IntProcedure() {
                            @Override
                            public void apply(int key) {
                                printfln("key %d", key);
                            }
                        });
    }
}
