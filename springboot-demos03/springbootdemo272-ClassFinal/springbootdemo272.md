# 参考地址
官网
- https://gitee.com/roseboy/classfinal

ClassFinal对项目进行加密处理
- https://blog.csdn.net/WC949464367/article/details/124123974

使用ClassFinal对java项目加密
- https://blog.csdn.net/liuxiao723846/article/details/127899930

## 1.配置项：
- file        加密的jar/war完整路径
- packages    加密的包名(可为空,多个用","分割)
- libjars     jar/war包lib下要加密jar文件名(可为空,多个用","分割)
- cfgfiles    需要加密的配置文件，一般是classes目录下的yml或properties文件(可为空,多个用","分割)
- exclude     排除的类名(可为空,多个用","分割)
- classpath   外部依赖的jar目录，例如/tomcat/lib(可为空,多个用","分割)
- pwd         加密密码，如果是#号，则使用无密码模式加密
- code        机器码，在绑定的机器生成，加密后只可在此机器上运行
- Y           无需确认，不加此参数会提示确认以上信息

## 2.打包
maven package
- 注意-encrypted.jar结尾的才是加密文件，不带-encrypted是未加密的

## 3.打包后jar包运行方式
```shell
java -javaagent:HelloWorld.jar='-pwd 123' -jar HelloWorld.jar
# 无密码
java -javaagent:HelloWorld.jar -jar HelloWorld.jar
```

机器绑定，只允许加密的项目在特定的机器上运行
```shell
# 生成机器码
java -jar classfinal-fatjar.jar -C
# 加密时用-code指定机器码。机器绑定可同时支持机器码+密码的方式加密
```

## 4.支持图形化界面以及命令行方式
```shell
# 导出jar
jar cvfm ClassFinal.jar manifest.txt com 
# 命令行运行
java -jar ClassFinal.jar -d HelloWorld.jar
```


