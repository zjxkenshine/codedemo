# springbootdemo21 参考文档
SpringBoot2集成Log4j2并实现日志脱敏
- https://blog.csdn.net/ljy950914/article/details/103202895 参考
- https://blog.csdn.net/VcStrong/article/details/80527455
- https://blog.csdn.net/saytime/article/details/87282510 详细

Log4j2配置文档详解
- https://www.cnblogs.com/hafiz/p/6170702.html

Hutool文档
- https://hutool.cn/docs/#/


# 脱敏流程
自定义PatternLayout方式：
- 1.自定义Layout实现AbstractStringLayout
- 2.修改log4j2.xml中的PatternLayout为自定义的Layout
- 3.在 application.yml 中配置 log4j2.xml

其他方式：
- https://blog.csdn.net/saytime/article/details/87282510