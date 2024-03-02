package com.kenshine.jodddb;

import com.kenshine.jodddb.bean.Boo;
import jodd.db.type.SqlTypeManager;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MappingTest
 * @Description Mapping使用示例
 * @Date 2024-03-02 13:54
 * @modified By：
 * @version: 1.0$
 */
public class MappingTest {

    /**
     * 自定义类型映射注册
     */
    @Test
    public void test01(){
        SqlTypeManager.get().register(Boo.class, BooSqlType.class);
    }

}
