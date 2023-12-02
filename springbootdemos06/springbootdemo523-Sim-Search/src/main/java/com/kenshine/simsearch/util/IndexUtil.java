package com.kenshine.simsearch.util;

import cn.langpy.simsearch.model.IndexContent;
import cn.langpy.simsearch.util.IndexManager;

import java.util.List;

/**
 * @author by kenshine
 * @Classname IndexUtil
 * @Description IndexManager索引工具类
 * @Date 2023-12-02 9:09
 * @modified By：
 * @version: 1.0$
 */
public class IndexUtil {
    /*创建索引*/
    public static void createIndex(IndexContent indexContent){
        IndexManager.createIndex(indexContent);
    }
    /*删除索引*/
    public static void deleteIndex(String idName, String idValue,Class entityClass){
        IndexManager.deleteIndex(idName,idValue,entityClass);
    }
    /*搜索 详见源码的demo项目*/
    public static <T> List<T> searchIndexIds(String name, String value, Class<?> entityClass){
        return searchIndexIds(name,value,entityClass);
    }
    /*搜索 详见源码的demo项目*/
    public static <T> List<T> searchIndexObjects(String name, String value,Class entityClass){
        return searchIndexObjects(name, value, entityClass);
    }
    public static void deleteAll(){
        IndexManager.deleteAll();
    }
    /*为对象创建索引*/
    public static void createIndex(Object entity){
        IndexManager.createIndex(entity);
    }
    public static void createIndexs(List<Object> entities){
        IndexManager.createIndex(entities);
    }

}
