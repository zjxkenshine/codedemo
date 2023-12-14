# 参考文档
github
- https://github.com/dreamhead/moco

Moco框架的搭建使用
- https://blog.csdn.net/manbskjabgkb/article/details/131838865

# 使用方式
jar包：
- 编写配置文件moco-get.json
- 运行jar包：`java -jar moco-runner-1.5.0-standalone.jar http -p 8899 -c moco-get.json`
- 浏览器输入地址测试：http://localhost:8899/login

多配置文件 -g参数
- `java -jar moco-runner-1.5.0-standalone.jar http -p 8899 -g config.json`

maven插件：
- moco-maven-plugin

java代码方式MocoTest
- test01：jsonHttpServer+单个配置文件
- test02：多配置文件 -g参数
- test03：WebSocketServer
- test04：socketServer
