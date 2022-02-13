package com.kenshine.chapter09;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 13:28
 * @description：
 * @modified By：
 * @version: $
 */
public class GenericDao {
    static String URL = "jdbc:mysql://localhost:3306/test";
    static String USERNAME = "root";
    static String PASSWORD = "root";

    public <T> List<T> queryList(Class<T> beanClass, String sql, Object... args) {
        System.out.println("sql: [" + sql + "] params:" + Arrays.toString(args));
        BeanRowMapper<T> mapper = new BeanRowMapper<>(beanClass);
        return queryList(sql, mapper, args);
    }

    public <T> T queryOne(Class<T> beanClass, String sql, Object... args) {
        System.out.println("sql: [" + sql + "] params:" + Arrays.toString(args));
        BeanRowMapper<T> mapper = new BeanRowMapper<>(beanClass);
        return queryOne(sql, mapper, args);
    }

    private <T> List<T> queryList(String sql, RowMapper<T> mapper, Object... args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement psmt = conn.prepareStatement(sql)) {
                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        psmt.setObject(i + 1, args[i]);
                    }
                }
                List<T> list = new ArrayList<>();
                try (ResultSet rs = psmt.executeQuery()) {
                    while (rs.next()) {
                        T obj = mapper.map(rs);
                        list.add(obj);
                    }
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T queryOne(String sql, RowMapper<T> mapper, Object... args) {
        List<T> list = queryList(sql, mapper, args);
        return list.size() == 0 ? null : list.get(0);
    }

    public int update(String sql, Object... args) {
        System.out.println("sql: [" + sql + "] params:" + Arrays.toString(args));
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement psmt = conn.prepareStatement(sql)) {
                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        psmt.setObject(i + 1, args[i]);
                    }
                }
                return psmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    interface RowMapper<T> {
        T map(ResultSet rs);
    }

    static class BeanRowMapper<T> implements RowMapper<T> {

        private Class<T> beanClass;
        private Map<String, PropertyDescriptor> propertyMap = new HashMap<>();

        public BeanRowMapper(Class<T> beanClass) {
            this.beanClass = beanClass;
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd : propertyDescriptors) {
                    propertyMap.put(pd.getName().toLowerCase(), pd);
                }
            } catch (IntrospectionException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public T map(ResultSet rs) {
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                T t = beanClass.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    PropertyDescriptor pd = propertyMap.get(columnLabel.toLowerCase());
                    if (pd != null) {
                        pd.getWriteMethod().invoke(t, rs.getObject(i));
                    }
                }
                return t;
            } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
