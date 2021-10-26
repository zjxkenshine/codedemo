## 使用
使用方式一：XML方式
- 定义global-dozer.xml
- 定义dozer.xml
- application.yml 指定配置文件位置
- 通过mapper接口实例使用Dozer

注解方式配置映射：使用@Mapping注解可以进行一些简单的映射处理

自定义转换器 converter
- 自定义converter继承DozerConverter 或者实现 CustomConverter
- 在xml中配置如下转换器
```
 <custom-converters> 
      <converter type="com.kenshine.converter.LocalDateTimeToDateDozerConverter" >
        <class-a>java.time.LocalDateTime</class-a>
        <class-b>java.util.Date</class-b>
      </converter>
    </custom-converters> 
```