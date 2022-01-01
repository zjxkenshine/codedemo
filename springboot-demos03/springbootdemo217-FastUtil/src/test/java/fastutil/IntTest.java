package fastutil;

import com.carrotsearch.sizeof.RamUsageEstimator;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.junit.Test;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 21:41
 * @description：
 * @modified By：
 * @version: $
 */
public class IntTest {
    int count=10000;

    /**
     * 1.IntList
     * 添加比ArrayList慢，但是容量小了四分之三
     */
    @Test
    public void test01(){
        //起始时间
        long start1 =System.currentTimeMillis();
        List<Integer> list1= new ArrayList<>();
        for(int i =1;i<count;i++){
            list1.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("jdk List添加时长："+(end1-start1));
        System.out.println("jdk List占用大小："+RamUsageEstimator.sizeOf(list1));

        //FastUtil intList
        long start2 = System.currentTimeMillis();
        IntList list2 = new IntArrayList();
        for(int i =1;i<count;i++){
            list2.add(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("FastUtil intList添加时长："+(end2-start2));
        System.out.println("FastUtil intList占用大小："+RamUsageEstimator.sizeOf(list2));
    }


    /**
     * 2.Int2IntMap
     */
    @Test
    public void test02(){
        //起始时间
        long start1 =System.currentTimeMillis();
        Map<Integer,Integer> map1= new HashMap<>();
        for(int i =1;i<count;i++){
            map1.put(i,i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("jdk HashMap添加时长："+(end1-start1));
        System.out.println("jdk HashMap占用大小："+RamUsageEstimator.sizeOf(map1));

        //FastUtil intList
        long start2 = System.currentTimeMillis();
        Int2IntMap map2 = new Int2IntOpenHashMap();
        for(int i =1;i<count;i++){
            map2.put(i,i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("FastUtil int2intMap添加时长："+(end2-start2));
        System.out.println("FastUtil int2intMap占用大小："+RamUsageEstimator.sizeOf(map2));
    }

}
