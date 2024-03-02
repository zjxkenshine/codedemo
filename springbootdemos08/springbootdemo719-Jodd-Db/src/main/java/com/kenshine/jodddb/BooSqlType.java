package com.kenshine.jodddb;

import com.kenshine.jodddb.bean.Boo;
import jodd.db.type.SqlType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kenshine
 * 自定义类型映射
 */
public class BooSqlType extends SqlType<Boo> {

    @Override
    public void set(PreparedStatement st, int index, Boo value, int dbSqlType) throws SQLException {
        st.setInt(index, value.value);
    }

    @Override
    public Boo get(ResultSet rs, int index, int dbSqlType) throws SQLException {
        Boo boo = new Boo();
        boo.value = rs.getInt(index);
        return boo;
    }
}