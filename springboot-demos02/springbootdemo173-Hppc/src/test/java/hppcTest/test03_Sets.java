package hppcTest;

import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.procedures.IntProcedure;
import org.junit.Before;
import org.junit.Test;

import static hppcTest.Helpers.printfln;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:51
 * @description：集合
 * @modified By：
 * @version: $
 */
public class test03_Sets {

    public IntHashSet hashSet;

    @Before
    public void setup() {
        hashSet = IntHashSet.from(1, 1, 2, 3, 5, 0);
    }

    /**
     * 游标遍历
     */
    @Test
    public void cursor() {
        for (IntCursor c : hashSet) {
            printfln("hashSet contains %d (at buffer index %d)", c.value, c.index);
            assertThat(c.value).isEqualTo(hashSet.keys[c.index]);
        }
    }

    /**
     * 匿名foreach循环
     */
    @Test
    public void forEachLoop() {
        hashSet.forEach(
                new IntProcedure() {
                    @Override
                    public void apply(int value) {
                        printfln("hashSet contains %d", value);
                    }
                });
    }

}
