package com.kenshine.idcore;

import com.github.houbb.id.core.util.IdHelper;
import com.github.houbb.id.core.util.IdThreadLocalHelper;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname IdCoreTest
 * @Description id-core使用测试
 * @Date 2023-11-11 8:18
 * @modified By：
 * @version: 1.0$
 */
public class IdCoreTest {

    /**
     * IdHelper id生成
     */
    @Test
    public void test01(){
        String id1=IdHelper.uuid8();
        String id2=IdHelper.human();
        String id3=IdHelper.random();
        String id4=IdHelper.random("PO",5);
        String id5=IdHelper.local();
        String id6=IdHelper.snowflake();
        String id7=IdHelper.uuid32();
        String id8=IdHelper.uuidNum();

        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);
        System.out.println(id4);
        System.out.println(id5);
        System.out.println(id6);
        System.out.println(id7);
        System.out.println(id8);
    }

    /**
     * IdThreadLocalHelper
     */
    @Test
    public void test02(){
        IdThreadLocalHelper.put(IdHelper.random());
        System.out.println(IdThreadLocalHelper.get());
        // 移除
        IdThreadLocalHelper.remove();
        System.out.println(IdThreadLocalHelper.get());
    }

}
