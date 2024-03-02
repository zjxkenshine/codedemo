package com.kenshine.jodddb;

import jodd.db.*;
import jodd.db.connection.ConnectionProvider;
import jodd.db.connection.DataSourceConnectionProvider;
import org.junit.Test;

import java.sql.ResultSet;

/**
 * @author by kenshine
 * @Classname DbSessionTest
 * @Description DbSession使用
 * @Date 2024-03-02 12:53
 * @modified By：
 * @version: 1.0$
 */
public class DbSessionTest {

    /**
     * DbSession基本使用
     */
    @Test
    public void test01(){
        DataSourceConnectionProvider connectionProvider =new DataSourceConnectionProvider("name");
        DbSession session = new DbSession(connectionProvider);
        session.beginTransaction(DbTransactionMode.READ_ONLY_TX);
        DbQuery query = DbQuery.query(session, "insert into...");
        query.executeUpdate();
        session.commitTransaction();
        DbQuery query2 = DbQuery.query(session, "select * from... ");
        ResultSet rs = query2.execute();
        session.close();
    }

    /**
     * DbThreadSession 分配给线程
     */
    @Test
    public void test02(){
        DbSession session = new DbThreadSession(new DataSourceConnectionProvider("name"));
        DbSession session1 = DbThreadSession.getCurrentSession();
        DbQuery query = DbQuery.query(session1, "select...");
        session.close();
    }

    /**
     *  自动session设置
     */
    @Test
    public void test03(){
        DbSession session = new DbThreadSession(null);
        DbQuery query = DbQuery.query("select...");
        session.close();
    }

    /**
     * 设置事务
     */
    @Test
    public void test04(){
        DbSession session = new DbSession(new DataSourceConnectionProvider("name"));
        session.beginTransaction(DbTransactionMode.READ_ONLY_TX);
        try {
            DbQuery query = DbQuery.query(session, "insert into...");
            query.executeUpdate();
            session.commitTransaction();
        } catch(DbSqlException dbSqlException) {
            session.rollbackTransaction();
        }
        System.out.println(session.isTransactionActive());
    }
}
