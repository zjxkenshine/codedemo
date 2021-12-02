# 1.XStream简介
- XStream 是一种 OXMapping 技术，主要实现将 java 对象和 XML 绑定的功能，类似 JAXB
- 提供了所有的基础类型、数组、集合等类型直接转换的支持
- 官网：http://x-stream.github.io/

# 2.序列化重命名
在Java对象转XML的过程中，可以设置类或字段对应的XML节点名称、设置字段为XML的属性、隐藏字段等；
1. 包重命名：`XStream.aliasPackage`
2. 类重命名：`XStream.alias`
3. 字段重命名：`XStream.aliasField`
4. 省略集合根节点：`XStream.addImplicitCollection`
5. 字段设置成XML属性：`XStream.useAttributeFor`
6. 隐藏字段：`XStream.omitField`

# 3.自定义转换器
自定义转换器需实现com.thoughtworks.xstream.converters.Converter接口
```
public class MyConvert implements Converter {
    /**
     * Java对象转成XML
     */
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        ...
    }

    /**
     * XML转Java对象
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        ...
    }

    @Override
    public boolean canConvert(Class type) {
        ...
    }
}
```

# 4.XStream注解
使用Xstream注解前需要对XStream进行配置：应用某个JavaBean类的注解或自动使用检测类的注解
```
XStream xstream = new XStream();
xstream.processAnnotations(GradeXStream.class);
xstream.autodetectAnnotations(true);
```
1. 重命名：`@XStreamAlias`
2. 省略集合根节点：`@XStreamImplicit`
3. 字段设置成XML属性：`@XStreamAsAttribute`
4. 隐藏字段：`@XStreamOmitField`
5. 设置转换器：`@XStreamConverter`
