package bilibili.collections;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 14:57
 * @description：Multimaps的使用
 * @modified By：
 * @version: $
 *
 *  可放重复key的map
 */
public class MultimapsTest {

    /**
     * 创建
     */
    @Test
    public void testCreate(){
        LinkedListMultimap<String,String> multimap = LinkedListMultimap.create();
        HashMap<String,String> hashMap = Maps.newHashMap();
        hashMap.put("1","1");
        hashMap.put("1","2");
        System.out.println(hashMap);

        multimap.put("1","2");
        multimap.put("1","1");
        System.out.println(multimap);
    }


}
