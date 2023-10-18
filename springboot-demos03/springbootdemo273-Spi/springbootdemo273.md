# 参考地址
SPI 框架实现之旅一：背景介绍
- https://my.oschina.net/u/566591/blog/911054

# 一般流程
1. 定义 spi 接口 ： IXxx
2. 具体的实现类: AXxx, BXxx
3. 在 jar 包的 META-INF/services/ 目录下新建一个文件，命名为 spi 接口的完整类名，内容为 spi 接口实现的完整类名，一个实现类占一行