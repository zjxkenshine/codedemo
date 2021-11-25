# 1.参考文档
Apache commons-exec的使用
- https://blog.csdn.net/u011943534/article/details/120938888

Java 执行系统命令工具类（commons-exec）
- https://www.cnblogs.com/jonban/p/command.html

# 2.Commons-exec和Runtime.getRuntime().exec(command);对比
- 在调用SHELL命令或DOS命令时，使用Runtime.getRuntime().exec(command);这个方法。但是执行某些命令时，程序可能就卡在那了，需要在执行的过程中新开启几个线程来不断地读取标准输出，以及错误输出，这样很不方便，好在commons-exec提供了更加友好的使用方式
- commons-exec的command不需要考虑执行环境，比如windows下不需要添加"cmd /c "的前缀
- 可以使用自定义的流来接受结果，比如使用文件流将结果保存到文件，使用网络流保存到远程服务器上等
- commons-exec支持异步调用
- commons exec库提供了Watchdog来设监视进程的执行超时

# 目录
- CommandUtils：工具类
- CommonsExecTest：测试CommandExec及Runtime

