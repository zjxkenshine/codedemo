package com.kenshine.jodddb;

import jodd.db.DbOom;
import jodd.db.DbSession;
import jodd.db.oom.DbOomQuery;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname DbOomTest
 * @Description DbOom 映射对象
 * @Date 2024-03-02 13:25
 * @modified By：
 * @version: 1.0$
 */
public class DbOomTest {

    /**
     * 构建DbOom对象
     */
    @Test
    public void test01(){
        DbOom dbOom = DbOom.create().get();
        dbOom.connect();
        // 方法2
        DbOom.create()
                .withSessionProvider(dbOom.sessionProvider())
                .withConnectionProvider(dbOom.connectionProvider())
                .get()
                .connect();
    }

    /**
     * 单数据库模式
     */
    @Test
    public void test02(){
        DbSession session = new DbSession(null);
        DbOom dbOom = DbOom.get();
        DbOomQuery q = new DbOomQuery(dbOom, session, "select * from ...");
        DbOomQuery q1 = dbOom.query("select * from ...");
    }
}
