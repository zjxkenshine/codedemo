package vavr;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.test.Arbitrary;
import io.vavr.test.Property;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 9:42
 * @description：vavr集合测试
 * @modified By：
 * @version: $
 */
public class CollectionsTest {
    /**
     * 1.List
     */
    @Test
    public void test01_List(){
        Number num=List.of(1, 2, 3).sum();
        System.out.println(num);
    }

    /**
     * 2.Stream
     */
    @Test
    public void test02_Stream(){
        Stream.from(1).filter(i -> i % 2 == 0);
    }

    /**
     * 3.属性检查
     * Property 在vavr-test包
     */
    @Test
    public void test03(){
        Arbitrary<Integer> ints = Arbitrary.integer();

        // square(int) >= 0: OK, passed 1000 tests.
        Property.def("square(int) >= 0")
                .forAll(ints)
                .suchThat(i -> i * i >= 0)
                .check()
                .assertIsSatisfied();
    }


}
