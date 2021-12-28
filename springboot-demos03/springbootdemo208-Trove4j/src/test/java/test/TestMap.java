package test;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.map.hash.TIntIntHashMap;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 22:55
 * @description：
 * @modified By：
 * @version: $
 */
public class TestMap {
    @Test
    public void test(){
        //实例化
        TIntIntHashMap map = new TIntIntHashMap();
        //存放值
        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        //判断是否为空
        if (!map.isEmpty()) {
            System.out.println("map集合不为空");
        }
        //循环遍历--方式1
        int[] keys = map.keys();
        for (int i = 0; i < keys.length; i++) {
            System.out.println("key:" + keys[i] + "\tvalue:" + map.get(keys[i]));
        }
        //循环遍历--方式2
        TIntIterator iter =  map.keySet().iterator();
        System.out.println("第二种方式遍历的结果为：");
        while (iter.hasNext()) {
            int key = iter.next();
            System.out.println("key:" + key + "\tvalue:" + map.get(key));
        }
        //指定key位置key加上某数
        map.adjustValue(2, 1);
        System.out.println("key为2的value加上1结果为:");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("key:" + keys[i] + "\tvalue:" + map.get(keys[i]));
        }
        //指定key位置加上某数返回该数
        int adjust = map.adjustOrPutValue(1, 5, 1);
        System.out.println("加上5为:" + adjust);
        System.out.println("加上某值的结果为：");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("key:" + keys[i] + "\tvalue:" + map.get(keys[i]));
        }
        //是否包含某个key值
        if (map.containsKey(1)) {
            System.out.println("包含key---1");
        }
        //value是否包含某值
        if (map.containsValue(4)) {
            System.out.println("包含value---4");
        }
    }
}
