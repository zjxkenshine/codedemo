# 参考地址
文件实时监控--jnotify的使用（Windows环境下）
- https://blog.csdn.net/stalin_/article/details/80234979

# 概述
jnotify可以对指定目录下的文件进行监听，常用的有文件创建，文件重命名，文件删除，文件内容修改。这些都可以通过jnotify的API进行实时监测。

# 使用
1. 下载jnotify的jar包，引入
2. 书写监听程序及主函数
3. 在本机的jdk的安装目录下的bin目录下将之前下载的jar包中的jnotify.dll文件放入，如果是64位放jnotify_64bit.dll
4. 运行