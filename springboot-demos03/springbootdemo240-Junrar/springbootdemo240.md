## 参考文档
java 提取(解压)rar文件中特定后缀的文件并保存到指定目录
- https://www.cnblogs.com/codecat/p/11078485.html

Java基于Junrar包实现rar文件解压缩
- https://blog.csdn.net/ZYQ_1004/article/details/119005467

使用junrar解压文件时，上报解压进度的具体实现
- https://blog.csdn.net/u010536377/article/details/79905707

## 踩坑
JUnrar 解压时报错UnsupportedRarV5Exception
- https://blog.csdn.net/Georgee1992/article/details/105481362
- 目前暂时没有Java第三方工具支持rar5，一个解决办法是直接调外部的命令行，调用winrar解压，但是要求宿主机必须安装了winrar
- 还有一个办法是在压缩的时候选择rar4，但是winrar默认压缩都是rar5，每次压缩必须都去点一下

D:\Setups\RA-1.2.1.0\RA-1.2.1.0 (拒绝访问。)
- RA-1.2.1.0不是一个文件，文件头中有这个，代码中排除就可以了