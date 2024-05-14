package com.kenshine.easydict;

import idea.verlif.easy.dict.EasyDict;
import idea.verlif.easy.dict.map.HashMapDictProvider;
import idea.verlif.easy.dict.properties.PropertiesDictProvider;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname EasyDictTest
 * @Description easydict测试
 * @Date 2024-05-14 13:42
 * @modified By：
 * @version: 1.0$
 */
public class EasyDictTest {

    /**
     * 测试
     */
    @Test
    public void test01(){
        // 创建properties字典提供者
        PropertiesDictProvider propertiesDictProvider = new PropertiesDictProvider();
        // 加载properties文件夹下的所有字典文件数据
        propertiesDictProvider.load("properties");
        // 创建hashMap字典提供者
        HashMapDictProvider hashMapDictProvider = new HashMapDictProvider();
        // 手动添加字典数据
        hashMapDictProvider.put("zh", "nihao", "你好呀");
        hashMapDictProvider.put("zh", "tahao", "他好");
        // 创建字典使用对象
        EasyDict dict = new EasyDict();
        // 将hashMap字典作为优先字典添加，后添加properties字典作为补充
        dict.addProvider(hashMapDictProvider);
        dict.addProvider(propertiesDictProvider);
        // 字典查询
        System.out.println(dict.query("zh", "nihao"));
        System.out.println(dict.query("zh", "tahao"));
        System.out.println(dict.query("en", "nihao"));
    }

}
