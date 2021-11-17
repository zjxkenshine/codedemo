# 参考地址
checker-framework
- https://github.com/typetools/checker-framework

Checker框架学习笔记
- https://blog.csdn.net/lonelymanontheway/article/details/107622927

# 简介
Checker提供了一套机制，可以通过编写插件来扩展Java编译器的功能

# 踩坑
maven更新依赖失败的原因 Plugin 'xxx' not found
- https://blog.csdn.net/loulanyue_/article/details/102524955

需要下载javac-9+181-r4173-1.jar到本地并安装到本地仓库
- `mvn install:install-file -DgroupId=com.google.errorprone -DartifactId=javac -Dversion=9+181-r4173-1 -Dpackaging=jar -Dfile=javac-9+181-r4173-1.jar`