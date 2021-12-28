package test;

import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 22:49
 * @description：性能测试
 * @modified By：
 * @version: $
 */
public class Test01 {

    @Test
    public void test(){
        System.gc();

        long currInitUseMemory1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("当前初始化使用的内存" + currInitUseMemory1);

        System.out.println("=====list占用内存对比=====");
        TIntList tIntList = new TIntArrayList();
        for (int i = 0; i < 100000; i++) {
            tIntList.add(i);
        }
        long currUseMemory2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("TIntList 中增加10000个元素使用内存" + (currUseMemory2 - currInitUseMemory1));

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long currUseMemory3 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("ArrayList中增加10000个元素使用内存" + (currUseMemory3 - currUseMemory2));

        System.out.println("=====map占用内存对比=====");

        TIntIntMap tIntIntMap = new TIntIntHashMap();
        for (int i = 0; i < 100000; i++) {
            tIntIntMap.put(i,i);
        }
        long currUseMemory4 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("tIntIntMap中增加10000个元素使用内存" + (currUseMemory4 - currUseMemory3));

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            hashMap.put(i,i);
        }
        long currUseMemory5 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("hashMap   中增加10000个元素使用内存" + (currUseMemory5 - currUseMemory4));
    }
}
