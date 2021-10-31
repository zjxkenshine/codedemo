package bilibili.collections;

import com.google.common.collect.BoundType;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 15:40
 * @description：Range测试 范围
 * @modified By：
 * @version: $
 */
public class RangeTest {

    /**
     * 创建范围 0~9集合
     * 闭区间
     */
    @Test
    public void testClosedRange(){
        Range<Integer> range = Range.closed(0, 9);
        System.out.println(range);
        System.out.println(range.contains(5));
        System.out.println(range.contains(9));
    }

    /**
     * 开区间
     * 还有左开右闭合左闭右开
     */
    @Test
    public void testOpenRange(){
        Range<Integer> range = Range.open(0, 9);
        System.out.println(range);
        System.out.println(range.contains(5));
        System.out.println(range.contains(9));
    }


    /**
     * 某个值到无穷大 不包含当前值
     */
    @Test
    public void testGreaterThan(){
        Range<Integer> range = Range.greaterThan(10);
        System.out.println(range.contains(10));
        System.out.println(range.contains(Integer.MAX_VALUE));
    }


    /**
     * 通过Range截取map
     */
    @Test
    public void testMapRange(){
        TreeMap<String, Integer> treeMap = Maps.newTreeMap();
        treeMap.put("1",1);
        treeMap.put("2",2);
        treeMap.put("3",3);
        System.out.println(treeMap);

        //对比key并截取
        NavigableMap<String, Integer> map2 = Maps.subMap(treeMap, Range.closed("2", "9"));
        System.out.println(map2);
    }


    /**
     * 其他方法
     */
    @Test
    public void testOtherMethod(){
        //2到正无穷,包含2
        Range<Integer> range1 = Range.atLeast(2);
        System.out.println(range1);

        //其他集合
        System.out.println(Range.lessThan(10));
        System.out.println(Range.atMost(5));
        System.out.println(Range.all());
        System.out.println(Range.downTo(10, BoundType.CLOSED));
        System.out.println(Range.upTo(10, BoundType.OPEN));

    }

    /**
     * RangeMap key为一个范围
     */
    @Test
    public void testRangeMap(){
        TreeRangeMap<Integer,String> range = TreeRangeMap.create();
        //不及格
        range.put(Range.closed(0,60),"F");
        range.put(Range.closed(61,70),"D");
        range.put(Range.closed(71,80),"C");
        range.put(Range.closed(81,90),"B");
        range.put(Range.closed(91,100),"A");
        System.out.println(range);

        System.out.println(range.get(77));
    }



}
