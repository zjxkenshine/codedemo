package bilibili.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 16:38
 * @description：ImmutableCollection测试
 * @modified By：
 * @version: $
 *
 * 不可变集合
 */
public class ImmutableCollectionTest {

    /**
     * of创建
     */
    @Test
    public void testOf(){
        ImmutableList<Integer> list = ImmutableList.of(1,2,3);
        System.out.println(list);
        //会报错，不支持添加
        list.add(4);
    }

    /**
     * 拷贝
     */
    @Test
    public void testCopy(){
        Integer[] array = {1,2,3,4,5,6};
        System.out.println(ImmutableList.copyOf(array));
    }

    /**
     * builder创建
     */
    @Test
    public void testBuilder(){
        ImmutableList<Object> list = ImmutableList.builder().add(1).add(2,3,4).addAll(Arrays.asList(5,6)).build();
        System.out.println(list);
    }

    /**
     * 测试不可变map
     */
    @Test
    public void testImmutableMap(){
        ImmutableMap<String, String> map = ImmutableMap.of("Java", "1.8","mysql","8.0");
        System.out.println(map);
    }


}
