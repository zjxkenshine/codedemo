package bilibili.collections;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 17:06
 * @description：Ordering测试
 * @modified By：
 * @version: $
 *
 * 排序
 */
public class OrderingTest {

    /**
     * 测试jdk的排序
     */
    @Test
    public void testJDKOrder(){
        List<Integer> list = Arrays.asList(1,5,3,8,2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    /**
     * null优先自然排序
     */
    @Test
    public void testOrderNaturalByNullFirst(){
        List<Integer> list = Arrays.asList(1,5,null,8,2);
        Collections.sort(list, Ordering.natural().nullsFirst());
        System.out.println(list);
    }

    /**
     * null滞后自然排序
     */
    @Test
    public void testOrderNaturalByNullLast(){
        List<Integer> list = Arrays.asList(1,5,null,8,2);
        Collections.sort(list, Ordering.natural().nullsLast());
        System.out.println(list);
    }

    /**
     * 是否排序
     */
    @Test
    public void testIsOrderNatural(){
        List<Integer> list = Arrays.asList(1,3,5,8,2);
        //自然排序
        Collections.sort(list);
        System.out.println(Ordering.natural().isOrdered(list));
    }

    /**
     * 是否排序
     */
    @Test
    public void testOrderReserve(){
        List<Integer> list = Arrays.asList(1,3,5,8,2);
        //自然排序
        Collections.sort(list,Ordering.natural().reversed());
        System.out.println(Ordering.natural().reverse().isOrdered(list));
    }



}
