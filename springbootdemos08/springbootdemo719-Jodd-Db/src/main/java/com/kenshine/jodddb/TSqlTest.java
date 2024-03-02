package com.kenshine.jodddb;

import com.kenshine.jodddb.bean.Boy;
import com.kenshine.jodddb.bean.Girl;
import jodd.db.DbOom;
import jodd.db.DbSession;
import jodd.db.oom.DbOomQuery;
import jodd.db.oom.sqlgen.DbSqlBuilder;
import org.junit.Test;

import static jodd.db.oom.sqlgen.DbSqlBuilder.sql;

/**
 * @author by kenshine
 * @Classname TSqlTest
 * @Description 模板SQL测试
 * @Date 2024-03-02 16:20
 * @modified By：
 * @version: 1.0$
 */
public class TSqlTest {

    /**
     * $M 数学宏
     */
    @Test
    public void test01(){
        Boy boy = new Boy();
        boy.setId(1);
        boy.setId(2);
        DbSqlBuilder s = sql("select * from $T{boy} where $M{boy=boy}").use("boy", boy);
        System.out.println(s.toString());
    }

    /**
     * 对象引用
     */
    @Test
    public void test02(){
        DbSession dbSession = new DbSession(null);
        DbOomQuery q = DbOomQuery.query(dbSession, sql(
                "select $C{girl.*}, $C{boy.*} from $T{Girl girl} " +
                        "join $T{Boy boy} on girl.id=$boy.girlId"));
        Boy boy = q.withHints("boy.girl, boy").find(Girl.class, Boy.class);
    }

    /**
     * DbEntitySql 简化Sql操作
     */
    @Test
    public void test03(){
        DbOom dbOom = DbOom.get();
        DbSession session = new DbSession(null);
        DbOomQuery.query(session, dbOom.entities().insert(new Girl())).executeUpdate();
        dbOom.entities().insert(new Girl()).
        query(session).executeUpdate();

        Girl girl = new Girl();
        dbOom.entities().find(girl);
        dbOom.entities().findById(girl);
        dbOom.entities().deleteById(girl);
    }
}
