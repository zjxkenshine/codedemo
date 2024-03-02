package com.kenshine.jodddb;

import com.kenshine.jodddb.bean.Boy;
import com.kenshine.jodddb.bean.Girl;
import jodd.db.DbSession;
import jodd.db.oom.DbOomQuery;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname DbOomQueryTest
 * @Description DbOomQuery 使用示例
 * @Date 2024-03-02 13:33
 * @modified By：
 * @version: 1.0$
 */
public class DbOomQueryTest {

    /**
     * find方法 查找对象集
     */
    @Test
    public void test01(){
        DbSession dbSession = new DbSession(null);
        DbOomQuery q = DbOomQuery.query(dbSession,
                "select * from GIRL join BOY on... where...");
        Object[] girlAndBoy = q.find(Girl.class, Boy.class);
        Girl girl = (Girl) girlAndBoy[0];
        Boy boy = (Boy) girlAndBoy[1];
        girl.setBoy(boy);
    }

    /**
     * find 查找单个类型
     */
    @Test
    public void test02(){
        DbSession dbSession = new DbSession(null);
        DbOomQuery q = DbOomQuery.query(dbSession, "select * from GIRL ... where...");
        Girl girl = q.find(Girl.class);
    }

    /**
     * list、listSet 查询列表对象
     */
    @Test
    public void test03(){
        DbSession session = new DbSession(null);
        DbOomQuery q = DbOomQuery.query(session,
                "select * from GIRL join BOY on... where...");
        List<Object[]> girlsAndBoys = q.list(Girl.class, Boy.class);
        Set<Object[]> girlsAndBoysSet = q.listSet(Girl.class, Boy.class);
        List<Girl> girls = q.list(Girl.class);
    }

    /**
     * 一对一映射，设置内部值 girl.boy
     */
    @Test
    public void test04(){
        DbSession session = new DbSession(null);
        DbOomQuery q = DbOomQuery.query(session,
                "select girl.*, boy.* from GIRL girl join BOY boy on girl.ID=boy.GIRL_ID");
        List<Boy> boys = q.withHints("girl.boy", "girl").list(Boy.class, Girl.class);
    }


}
