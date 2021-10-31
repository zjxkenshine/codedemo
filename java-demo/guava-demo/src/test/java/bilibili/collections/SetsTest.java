package bilibili.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 12:18
 * @description：Sets集合操作
 * @modified By：
 * @version: $
 *
 * 不包含 ImmutableSet操作
 */
public class SetsTest {


    /**
     * 测试创建
     */
    @Test
    public void testCreate(){
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        System.out.println(set);

        ArrayList<Integer> list = Lists.newArrayList(1, 1, 2, 3);
        HashSet<Integer> set1 = new HashSet<>(list);
        System.out.println(set1);

    }

    /**
     * 笛卡尔集
     */
    @Test
    public void testCartesianProduct(){
        Set<List<Integer>> set = Sets.cartesianProduct(Sets.newHashSet(1,2),Sets.newHashSet(3,4));
        System.out.println(set);
    }

    /**
     * 子集
     */
    @Test
    public void testCombinations(){
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        //1:子集元素个数
        Set<Set<Integer>> combinations = Sets.combinations(set, 1);
        combinations.forEach(System.out::println);
    }

    /**
     * 差集 difference
     */
    @Test
    public void testDiff(){
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(1, 5, 6);
        Sets.SetView<Integer> differResult1 = Sets.difference(set1,set2);
        System.out.println(differResult1);

        Sets.SetView<Integer> differResult2 = Sets.difference(set2,set1);
        System.out.println(differResult2);
    }

    /**
     * 交集 intersection
     */
    @Test
    public void testInterception(){
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(1, 5, 6);
        System.out.println(Sets.intersection(set1,set2));
    }


    /**
     * 并集 union
     */
    @Test
    public void testUnion(){
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(1, 5, 6);
        System.out.println(Sets.union(set1,set2));
    }





}
