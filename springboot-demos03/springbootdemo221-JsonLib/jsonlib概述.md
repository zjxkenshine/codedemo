# 日期格式化处理
三种方式：
- jsonConfig的setExcludes的方法
- jsonConfig的setJsonPropertyFilter进行属性过滤
- jsonConfig的registerJsonValueProcessor()进行属性转换设置

封装转换器：DateConverter