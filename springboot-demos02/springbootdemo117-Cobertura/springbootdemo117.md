# 参考文档
maven 之 cobertura 简单使用
- https://blog.csdn.net/iteye_5753/article/details/82607736

Cobertura 统计多模块maven项目测试覆盖率
- https://blog.csdn.net/shymi1991/article/details/52849947

Maven单元测试报告及测试覆盖率
- https://blog.csdn.net/weixin_34122548/article/details/85808062

与Jacoco功能相同

# cobertura常用命令
- mvn cobertura:help          查看cobertura插件的帮助
- mvn cobertura:clean         清空cobertura插件运行结果
- mvn cobertura:check         运行cobertura的检查任务
- mvn cobertura:cobertura     运行cobertura的检查任务并生成报表，报表生成在target/site/cobertura目录下
- cobertura:dump-datafile     Cobertura Datafile Dump Mojo
- mvn cobertura:instrument    Instrument the compiled classes

# 踩坑
SLF4J: Class path contains multiple SLF4J bindings
- https://blog.csdn.net/luo15242208310/article/details/100098274

