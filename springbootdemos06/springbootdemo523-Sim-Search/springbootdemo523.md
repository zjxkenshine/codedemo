# 参考文档
sim-search 一个轻量级的springboot项目索引构建工具，实现高性能的模糊搜索
- https://gitee.com/huoyo/sim-search
- https://blog.csdn.net/qq_21120275/article/details/128234194

# 索引工具类
IndexManager
```
public class IndexManager{
    /*创建索引*/
    public static void createIndex(IndexContent indexContent);
    /*删除索引*/
    public static void deleteIndex(String idName, String idValue,Class entityClass);
    /*搜索 详见源码的demo项目*/
    public static <T> List<T> searchIndexIds(String name, String value,Class<?> entityClass);
    /*搜索 详见源码的demo项目*/
    public static <T> List<T> searchIndexObjects(String name, String value,Class entityClass);
    public static void deleteAll();
    /*为对象创建索引*/
    public static void createIndex(Object entity);
    public static void createIndexs(List<Object> entities);
}
```

