# 1.Jline简介
Jline是java的命令行操作库，可以帮助你搭建一个命令行交互界面
- 要在 *nix 系统下访问 JVM 的主终端，不需要额外的依赖项
- 在 Windows 平台上需要额外依赖 Jansi 或 JNA 库以及jline-terminal-jansi或jline-terminal-jna，否则创建的终端没有高级功能

# 2.相关组件
- jline-terminal: Terminal api实现
- jline-terminal-jansi：利用Jansi库的终端实现
- jline-terminal-jna：利用JNA库的终端实现
- jline-reader: 行阅读器（包括完成、历史记录等...）
- jline-style: 样式 API
- jline-remote-ssh: 将 jline 与Mina SSHD一起使用的助手
- jline-remote-telnet：通过 telnet 使用 jline 的助手（包括 telnet 服务器实现）
- jline-builtins：几个高级工具：less寻呼机、nano编辑器、screen多路复用器等...
- jline-console：命令注册表、对象打印机和小部件实现
- jline-groovy:ScriptEngine使用 Groovy 实现

# 3.命令补全Completer
- SimpleCompletor: 对一系列指定的字符串进行自动补全。
- FileNameCompletor: 类似于bash中的文件名自动补全。
- ClassNameCompletor: 对classpath中出现的全路径类名进自动补全。
- NullCompletor: 不进行自动补全。
- ArgumentCompletor: 为每个属性使用指定的Completor
- 可以将不同补全方式组合起来

# 4.命令历史History
- History负责控制历史记录的行为，其默认实现为DefaultHistory
