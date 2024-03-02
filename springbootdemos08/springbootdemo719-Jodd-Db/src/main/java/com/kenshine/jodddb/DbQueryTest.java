package com.kenshine.jodddb;

import com.kenshine.jodddb.bean.Foo;
import jodd.db.DbCallResult;
import jodd.db.DbOom;
import jodd.db.DbQuery;
import jodd.db.oom.DbOomQuery;
import org.junit.Test;

import java.sql.ResultSet;

/**
 * @author by kenshine
 * @Classname DbQueryTest
 * @Description DbQuery使用示例
 * @Date 2024-03-02 11:53
 * @modified By：
 * @version: 1.0$
 */
public class DbQueryTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        DbOom connection = DbOom.create().get();
        DbQuery query = new DbQuery(connection, "create table ...");
        query.executeUpdate();
        query.close();

        query = new DbQuery(connection, "select * from ....");
        query.setString(1, "param1");
        ResultSet rs = query.execute();

        query.closeResultSet(rs);
        query.close();
    }

    /**
     * 传参
     */
    @Test
    public void test02(){
        DbOom connection = DbOom.create().get();
        DbQuery query = new DbQuery(connection,
                "select * from FOO where id=:id and name=:name");
        query.setLong("id", 1);
        query.setString("name", "john");
        ResultSet rs = query.execute();
        query.close();
    }

    /**
     * debug模式，会打印实际值
     */
    @Test
    public void test03(){
        DbOom connection = DbOom.create().get();
        DbQuery query = new DbQuery(connection,
                "select * from FOO where id=:id and name=:name");
        query.setDebugMode();          // must be called before setting parameters
        query.setLong("id", 1);
        query.setString("name", "jodd");
        System.out.println(query);
    }

    /**
     * 通过bean设置参数
     */
    @Test
    public void test04(){
        DbOom connection = DbOom.create().get();
        DbQuery query = new DbQuery(connection,
                "select * from FOO f where f.ID=:foo.id and f.NAME=:foo.names[0]");
        query.setBean("foo", new Foo());
    }

    /**
     * 设置自增长
     */
    public void test05(){
        DbOom connection = DbOom.create().get();
        DbOomQuery q = new DbOomQuery(connection,
                "insert into FOO(Data) values('data')");
        // 设置自增长的字段
        q.setGeneratedColumns("id");
        q.executeUpdate();

        // 设置自增长
        long key = q.getGeneratedKey();
        q.close();
    }

    /**
     * 调用存储过程
     */
    @Test
    public void test06(){
        DbOom connection = DbOom.create().get();
        DbQuery query = new DbQuery(connection, "{ :upp = call upper( :str ) }");
        query.setDebugMode();
        query.setString("str", "some lowercase value");
        query.outString("upp");

        DbCallResult callResult = query.executeCall();
        String str = callResult.getString("upp");
        query.close();
    }



}
