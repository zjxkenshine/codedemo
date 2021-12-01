# 1.JAXB简介
- JAXB（Java Architecture for XML Binding）是J2SE和J2EE平台的一部分，能够快速完成Java类和XML的互相映射
- JAXB为XML节点和属性提供提供了各种面向对象的处理方式，可以基于注解或适配器将XML转换为Java对象。因为其优雅的处理方式，从JRE6开始，JAXB就已经成为了JRE的内置模块

# 2.JAXB相关的重要类与接口
- JAXBContext类：应用的入口，用于管理XML/Java绑定信息
- Marshaller接口：将Java对象序列化为XML数据
- Unmarshaller接口：将XML数据反序列化为Java对象

# 3.JAXB注解
- `@XmlRootElement`：类级别注解；将类映射为xml全局元素，也就是根元素
- `@XmlType`：类级别注解；常与@XMLRootElement，@XmlAccessorType一起使用
- `@XmlAccessorType`：类级别注解；定义这个类中的何种类型需要映射到XML
- `@XmlElement`：字段，方法，参数级别注解；该注解可以将被注解的（非静态）字段，或者被注解的get/set方法对应的字段映射为本地元素，也就是子元素
- `@XmlAttribute`：字段和方法级别的注解。该注解会将字段或get/set方法对应的字段映射成本类对应元素的属性
- `@XmlTransient`：类，字段，方法级别的注解。定义某一字段或属性不需要被映射
