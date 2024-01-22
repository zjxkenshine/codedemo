# 参考地址
Rhino js引擎 jdk6、7默认引擎
- https://github.com/mozilla/rhino

Java引入Rhino依赖 rhino js教程
- https://blog.51cto.com/u_16099261/7973540

# Rhino特性
Rhino 定义了一些全局函数，这些函数不是 JavaScript 的核心组成部分： 
- print：将内容输出到控制台（可取代 console.log）
- version：指定 JavaScript 版本
- load：加载指定 JavaScript 文件
- readFile：读取文本文件，并以字符串形式返回内容
- readUrl：读取 URL 内容，并以字符串形式返回内容
- spawn：运行指定函数
- runCommand：运行指定系统命令
- quit：退出 Rhino
