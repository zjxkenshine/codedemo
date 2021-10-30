# 参考地址
Springboot 返回数据提示语 国际化 （AOP实现）
- https://blog.csdn.net/qq_35387940/article/details/118992865 坑


# 踩坑(大坑)
messageSource读取不到数据,也不报错
- basename: 配置需要加classpath
- ecoding编码需要和i18n国际化文件统一