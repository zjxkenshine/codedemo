# 参考地址
官网
- https://tinylog.org/

github tinylog
- https://github.com/tinylog-org/tinylog

# 配置
tinylog.properties
```
# 默认情况true,与程序一起关闭
autoshutdown = false
# 输出到文件
writer      = file
writer.file = ${HOME}/log.txt
# 转义
escaping.enabled = true

# 异常 配置
# strip: jdk.internal 丢弃这些包的异常
# keep: com.example 仅保留哪些包
exception = unpack, strip: jdk.internal，keep: com.example
writer.exception = drop cause/unpack Cause

# 输出格式
writer.format = {date} [{thread}] {class}.{method}()\n{level}: {message}.

# size 占位符大小
writer.format = {{level}:|min-size=8} {message}

```

输出格式：
```
{opening-curly-bracket}	 “{”
{closing-curly-bracket} "}"
{class}
{class-name}
{context: key}
{date}
{exception}
{file}
{level}	
{level-code}	
{line}	
{message}	
{message-only}
{method}	
{package}	
{pid}	
{pipe}	 “|”
{tag}	
{thread}	
{thread-id}	
{timestamp}	
{uptime} 运行时间
```
