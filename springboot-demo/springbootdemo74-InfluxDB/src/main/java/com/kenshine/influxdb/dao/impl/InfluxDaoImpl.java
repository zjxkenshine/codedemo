package com.kenshine.influxdb.dao.impl;

import com.kenshine.influxdb.annotation.Tag;
import com.kenshine.influxdb.dao.InfluxDao;
import com.kenshine.influxdb.model.property.InfluxProperty;
import com.kenshine.influxdb.utils.ReflectUtils;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.annotation.Measurement;
import org.influxdb.dto.*;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:44
 * @description：实现类
 * @modified By：
 * @version: $
 */
@Slf4j
@Component
public class InfluxDaoImpl implements InfluxDao {
    @Autowired
    private InfluxDB influxDB;

    @Autowired
    private InfluxProperty influxProperty;

    @Override
    public Boolean ping() {
        boolean isConnected = false;
        Pong pong;
        try {
            pong = influxDB.ping();
            if (pong != null) {
                isConnected = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConnected;
    }

    @Override
    public void createDataBase(String... dataBaseName) {
        if (dataBaseName.length > 0) {
            influxDB.createDatabase(dataBaseName[0]);
            return;
        }
        if (influxProperty.getDataBaseName() == null) {
            log.error("如参数不指定数据库名,配置文件 spring.influx.dataBaseName 必须指定");
            return;
        }
        influxDB.createDatabase(influxProperty.getDataBaseName());
    }

    @Override
    public void deleteDataBase(String... dataBaseName) {
        if (dataBaseName.length > 0) {
            influxDB.deleteDatabase(dataBaseName[0]);
            return;
        }
        if (influxProperty.getDataBaseName() == null) {
            log.error("如参数不指定数据库名,配置文件 spring.influx.dataBaseName 必须指定");
            return;
        }
        influxDB.deleteDatabase(influxProperty.getDataBaseName());
    }

    @Override
    public <T> void insert(T object) {
        // 构建一个Entity
        Object first = Lang.first(object);
        Class clazz = first.getClass();
        // 表名
        Boolean isAnnot = clazz.isAnnotationPresent(Measurement.class);
        if (!isAnnot) {
            log.error("插入的数据对应实体类需要@Measurement注解");
            return;
        }

        Measurement annotation = (Measurement) clazz.getAnnotation(Measurement.class);
        // 表名
        String measurement = annotation.name();
        Field[] arrfield = clazz.getDeclaredFields();
        // 数据长度
        int size = Lang.eleSize(object);
        String tagField = ReflectUtils.getField(object, Tag.class);
        if (tagField == null) {
            log.error("插入多条数据需对应实体类字段有@Tag注解");
            return;
        }
        BatchPoints batchPoints = BatchPoints
                .database(influxProperty.getDataBaseName())
                // 一致性
                .consistency(InfluxDB.ConsistencyLevel.ALL)
                .build();
        for (int i = 0; i < size; i++) {
            Map<String, Object> map = new HashMap<>();
            Point.Builder builder = Point.measurement(measurement);
            for (Field field : arrfield) {
                // 私有属性需要开启
                field.setAccessible(true);
                Object result = first;
                try {
                    if (size > 1) {
                        List objects = (List) (object);
                        result = objects.get(i);
                    }
                    if (field.getName().equals(tagField)) {
                        builder.tag(tagField, field.get(result).toString());
                    } else {
                        map.put(field.getName(), field.get(result));
                    }
                } catch (Exception e) {
                    log.error("实体转换出错:"+field.getName());
                    e.printStackTrace();
                }
            }
            builder.fields(map);
            batchPoints.point(builder.build());
        }
        influxDB.write(batchPoints);
    }

    @Override
    public <T> List<T> query(Class<T> clazz, String sql) {
        if (influxProperty.getDataBaseName() == null) {
            log.error("查询数据时配置文件 spring.influx.dataBaseName 必须指定");
            return null;
        }
        QueryResult results = influxDB.query(new Query(sql, influxProperty.getDataBaseName()));
        if (results != null) {
            if (results.getResults() == null) {
                return null;
            }
            List<Object> list = new ArrayList<>();

            for (QueryResult.Result result : results.getResults()) {
                List<QueryResult.Series> series = result.getSeries();
                if (series == null) {
                    list.add(null);
                    continue;
                }
                for (QueryResult.Series serie : series) {
                    List<List<Object>> values = serie.getValues();
                    List<String> columns = serie.getColumns();
                    // 构建Bean
                    list.addAll(getQueryData(clazz, columns, values));
                }
            }
            return Json.fromJsonAsList(clazz, Json.toJson(list));
        }
        return null;
    }

    /**
     * 自动转换对应Pojo
     *
     * @param values
     * @return
     */
    public <T> List<T> getQueryData(Class<T> clazz, List<String> columns, List<List<Object>> values) {
        List results = new ArrayList<>();
        for (List<Object> list : values) {
            BeanWrapperImpl bean = null;
            Object result = null;
            try {
                result = clazz.newInstance();
                bean = new BeanWrapperImpl(result);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < list.size(); i++) {
                // 字段名
                String filedName = columns.get(i);
                if (filedName.equals("Tag")) {
                    continue;
                }
                try {
                    Field field = clazz.getDeclaredField(filedName);
                } catch (NoSuchFieldException e) {
                    continue;
                }
                // 值
                Object value = list.get(i);
                bean.setPropertyValue(filedName, value);
            }
            results.add(result);
        }
        return results;
    }
}
