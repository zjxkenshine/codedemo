package bilibili.collections;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 14:35
 * @description：Maps的使用
 * @modified By：
 * @version: $
 */
public class MapsTest {

    /**
     * 创建数据
     */
    @Test
    public void testCreate(){
        ArrayList<String> valueList = Lists.newArrayList("1","2","3");
        //生成map
        ImmutableMap<String, String> map = Maps.uniqueIndex(valueList, k -> k + "_key");
        System.out.println(map);

        //值转换
        Map<String, String> map1 = Maps.asMap(Sets.newHashSet("2", "3", "4"), k -> k + "_v");
        System.out.println(map1);
    }

    /**
     * 转换值
     */
    @Test
    public void testTransform(){
        Map<String, String> map1 = Maps.asMap(Sets.newHashSet("1", "2", "3"), k -> k + "_v");
        Map<String, String> map2 = Maps.transformValues(map1, v -> v + "_value");
        System.out.println(map2);
    }

    /**
     *
     */
    @Test
    public void testFilter(){
        Map<String, String> map1 = Maps.asMap(Sets.newHashSet("1", "2", "3"), k -> k + "_v");
        //把key为3的过滤了
        Map<String, String> map2 = Maps.filterKeys(map1, k -> Lists.newArrayList("1", "2").contains(k));
        System.out.println(map2);
    }




}
