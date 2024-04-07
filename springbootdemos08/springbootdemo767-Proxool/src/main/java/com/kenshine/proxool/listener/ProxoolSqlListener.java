package com.kenshine.proxool.listener;

import org.logicalcobwebs.proxool.ConnectionListenerIF;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author by kenshine
 * @Classname ProxoolSqlListener
 * @Description sql监听
 * @Date 2024-04-07 9:05
 * @modified By：
 * @version: 1.0$
 */
public class ProxoolSqlListener implements ConnectionListenerIF {
    @Override
    public void onBirth(Connection connection) throws SQLException {

    }

    @Override
    public void onDeath(Connection connection, int i) throws SQLException {

    }

    @Override
    public void onExecute(String s, long l) {

    }

    @Override
    public void onFail(String s, Exception e) {

    }
}
