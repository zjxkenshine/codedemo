package vavr;

import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 8:28
 * @description：元组测试
 * @modified By：
 * @version: $
 */
public class TupleTest {

    //元素基本创建方式
    @Test
    public void test01_base(){
        //二元组
        Tuple2<String, Integer> tup = Tuple.of("Java", 8);
        System.out.println(tup._1);
        System.out.println(tup._2);
    }

    /**
     * 2.map 映射
     */
    @Test
    public void test02_map(){
        //二元组
        Tuple2<String, Integer> tup = Tuple.of("Java", 8);
        System.out.println(tup._1);
        System.out.println(tup._2);

        //映射 map
        Tuple2<String, Integer> that1 = tup.map(
                s -> s.substring(2) + "vr",
                i -> i / 8
        );
        System.out.println(that1);

        //一个映射器
        Tuple2<String, Integer> that2 = that1.map(
                (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
        );
        System.out.println(that2);
    }

    /**
     * 3. Transform转换元组
     */
    @Test
    public void test03_Transform(){
        //二元组
        Tuple2<String, Integer> tup = Tuple.of("Java", 8);
        System.out.println(tup._1);
        System.out.println(tup._2);

        //转换为字符串
        String that = tup.apply(
             (s, i) -> s.substring(2) + "vr " + i / 8
        );
        System.out.println(that);
    }




}
