# 参考文档
Spring Boot 整合 Sonar(分析项目)
- https://www.cnblogs.com/yi1036943655/p/15414955.html
- https://blog.csdn.net/qq_29897369/article/details/86555735
- https://www.cnblogs.com/alvin-perfect/p/11776245.html
- 详见最外层pom.xml

IDEA SonarLint插件方式(可以与上面的项目绑定)
- https://blog.csdn.net/qq_35550345/article/details/103589175

Sonar中文汉化
- https://github.com/xuhuisheng/sonar-l10n-zh
- https://www.cnblogs.com/dalianpai/p/12249618.html



# 踩坑
1. SonarQube的安装部署过程中踩过的坑
    - https://blog.csdn.net/weixin_41596463/article/details/106250621

2. SonarLint与SonarQube版本不一致: 离线安装sonarLint回退插件版本或升级SonarQube版本
    - http://plugins.jetbrains.com/plugin/7973-sonarlint/versions
    - sonarqube7.2.1,sonarlint4.5.0可以连接

3. SonarQube要求Mysql版本：5.6<=mysql版本<8.0
4. Invalid value for sonar.java.binaries
- https://blog.csdn.net/qq_42030932/article/details/88972835
- https://www.jianshu.com/p/921fcdf5b5bc
- 未找到Maven配置方式解决方法

5. No files nor directories matching 'target/classes'
- sonar.java.binaries指定其他目录

