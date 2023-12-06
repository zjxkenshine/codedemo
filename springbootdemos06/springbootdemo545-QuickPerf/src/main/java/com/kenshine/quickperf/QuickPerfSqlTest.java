package com.kenshine.quickperf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quickperf.annotation.DebugQuickPerf;
import org.quickperf.junit4.QuickPerfJUnitRunner;
import org.quickperf.sql.annotation.AnalyzeSql;
import org.quickperf.sql.annotation.DisplaySql;
import org.quickperf.sql.annotation.ProfileConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname QuickPerfSqlTest
 * @Description Sql相关注解
 * @Date 2023-12-06 16:40
 * @modified By：
 * @version: 1.0$
 */
@DebugQuickPerf
@RunWith(QuickPerfJUnitRunner.class)
public class QuickPerfSqlTest {

    @AnalyzeSql
    @Test
    public void test01(){
    }

    @ProfileConnection
    @Test
    public void test02(){
    }

    /**
     * 打印sql
     * 直接JDBC无效
     */
    @DisplaySql
    @AnalyzeSql
    @ProfileConnection
    @Test
    public void test03() {
    }
}
