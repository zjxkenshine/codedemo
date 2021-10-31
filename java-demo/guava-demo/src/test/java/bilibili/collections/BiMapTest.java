package bilibili.collections;

import com.google.common.collect.HashBiMap;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 15:05
 * @description：BiMap测试
 * @modified By：
 * @version: $
 *
 * 值不能重复的map
 */
public class BiMapTest {

    /**
     * bimap特性
     */
    @Test
    public void testCreate(){

        HashBiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","2");
        //会覆盖值
        biMap.put("1","3");
        System.out.println(biMap);
        //会报值已存在异常
        biMap.put("2","3");
    }

    /**
     * 键值翻转
     */
    @Test
    public void testBiMapInverse(){
        HashBiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","2");
        biMap.put("2","3");
        biMap.put("3","4");
        System.out.println(biMap);
        System.out.println(biMap.inverse());
    }

    /**
     * 强制插入
     */
    @Test
    public void testForcePut(){
        HashBiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","2");
        //强制插入 会把key为1的值替换掉
        biMap.forcePut("2","2");
        System.out.println(biMap);
    }




}
