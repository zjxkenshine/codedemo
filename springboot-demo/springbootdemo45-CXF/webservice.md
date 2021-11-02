https://blog.csdn.net/c99463904/article/details/76018436
# 1.WebService概念
- Web Service技术， 能使得运行在不同机器上的不同应用无须借助附加的、专门的第三方软件或硬件， 就可相互交换数据或集成
- WebService就是一种跨编程语言和跨操作系统平台的远程调用技术
- XML,SOAP和WSDL就是构成WebService平台的三大技术 

# 2.JAVA WebService规范
Java 中共有三种WebService 规范，分别是JAXM&SAAJ、JAX-WS（JAX-RPC）、JAX-RS
- JAX-WS:JAX-WS（JSR 224）规范的API 位于javax.xml.ws.包，其中大部分都是注解，提供API 操作Web 服务（通常在客户端使用的较多，由于客户端可以借助SDK 生成，因此这个包中的API 我们较少会直接使用）
- JAXM&SAAJ:
    - JAXM包含了发送和接收消息所需的API，相当于Web 服务的服务器端,它是Java EE 的可选包，因此你需要单独下载
    - SAAJ是与JAXM 搭配使用的API，为构建SOAP 包和解析SOAP 包提供了重要的支持
- JAX-RS:JAVA 针对REST(Representation State Transfer)风格制定的一套Web 服务规范

# 3.其他概念：
- WSDL:WSDL, web服务描述语言，他是webservice服务端使用说明书，说明服务端接口、方法、参数和返回值，WSDL是随服务发布成功，自动生成，无需编写
- SOAP:SOAP即简单对象访问协议，他是使用http发送的XML格式的数据，它可以跨平台，跨防火墙，SOAP不是webservice的专有协议
- UDDI:UDDI 是一种目录服务，企业可以使用它对 Web services 进行注册和搜索。如果我们要使用一种服务，但是不知道地址（wsdl等），我们就可以在UDDI中查找