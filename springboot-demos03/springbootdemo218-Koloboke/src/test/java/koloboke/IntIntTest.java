package koloboke;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.koloboke.collect.map.IntIntMap;
import com.koloboke.collect.map.IntIntMapFactory;
import com.koloboke.collect.map.hash.HashIntIntMaps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 13:43
 * @description：测试
 * @modified By：
 * @version: $
 */
public class IntIntTest {
    private int count = 100000;

    @Test
    public void test02(){
        long start1 =System.currentTimeMillis();
        Map<Integer,Integer> map1= new HashMap<>();
        for(int i =1;i<count;i++){
            map1.put(i,i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("jdk HashMap添加时长："+(end1-start1));
        System.out.println("jdk HashMap占用大小："+ RamUsageEstimator.sizeOf(map1));


        long start2 = System.currentTimeMillis();
        //创建
        IntIntMap map2 = HashIntIntMaps.newMutableMap();
        for(int i =1;i<count;i++){
            map2.put(i,i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Koloboke HashIntInt添加时长："+(end2-start2));
        System.out.println("Koloboke HashIntInt占用大小："+RamUsageEstimator.sizeOf(map2));
    }

}
