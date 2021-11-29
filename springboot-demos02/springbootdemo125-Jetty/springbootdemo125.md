# 参考
SpringBoot 2.1.x整合Jetty容器
- https://blog.csdn.net/weixin_44187730/article/details/101602192


# Jetty与Tomcat的区别
1. Jetty的架构比Tomcat的更为简单。
    - Jetty的架构是基于Handler来实现的，主要的扩展功能都可以用Handler来实现，扩展简单。
    - Tomcat的架构是基于容器设计的，进行扩展是需要了解Tomcat的整体设计结构，不易扩展。
2. Jetty可以同时处理大量连接而且可以长时间保持连接，适合于web聊天应用等等。
   - Tomcat适合处理少数非常繁忙的链接


