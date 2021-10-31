package bilibili.collections;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 11:40
 * @description：guava lists
 * @modified By：
 * @version: $
 */
public class ListsTest {

    /**
     * 笛卡尔集测试
     */
    @Test
    public void testCartesianProduct(){
        List<List<String>> result = Lists.cartesianProduct (
                Lists.newArrayList("a","b"),
                Lists.newArrayList("1","2")
        );
        System.out.println(result);
    }

    /**
     * 测试转换
     */
    @Test
    public void testTransform(){
        ArrayList<String> sourceList = Lists.newArrayList("Scala","Java","Lists");
        Lists.transform(sourceList,e->e.toUpperCase()).forEach(System.out::println);


    }


    /**
     * 测试 newArrayListWithCapacity
     * 初始化arrayList
     */
    @Test
    public void testNewArrayListWithCapacity(){
        ArrayList<Object> result = Lists.newArrayListWithCapacity(2);
        result.add("x");
        result.add("y");
        result.add("z");
        System.out.println(result);
    }

    /**
     * 翻转
     */
    @Test
    public void testReverse(){
       ArrayList<String> list = Lists.newArrayList("1","2","3");
        System.out.println(list);
        System.out.println(Lists.reverse(list));
    }


    /**
     * 分区，拆分
     */
    @Test
    public void testPartition(){
        ArrayList<String> list = Lists.newArrayList("1","2","3","4");
        List<List<String>> result = Lists.partition(list,2);

        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }

}
