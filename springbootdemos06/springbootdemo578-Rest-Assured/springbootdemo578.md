# 参考地址
github
- https://github.com/rest-assured/rest-assured

Rest-assured框架详解
- https://blog.csdn.net/wxsyj/article/details/127068752

# 接口自动化测试流程
- 理解业务需求
- 分析接口测试范围
- 接口测试用例设计
- 接口测试框架选择，常见的如 RestAssured
- 接口测试用例编写
- 框架与用例维护
- 持续集成

# 语法
```
# 设置测试预设，包括请求头、请求参数、请求体、cookie等
given().
XXXX
# 所要执行的操作，即发起请求的网址（GET / POST 请求）
when().
XXXX
# 解析结果、断言
then().
XXXX
```

# 基本自动化过程
比如登录注册的测试用例写在了同一个 Excel 文件中，可以使用 @BeforeMethod 注解标记注册方法（先注册后登录），@Test 注解标记登录方法，定义两个 dataprovider 方法，分别读取 Excel 的某几行作为登录或注册的测试用例，将这些测试用例放在对应的测试方法中按顺序运行

# 目录
- test01：基本使用
- test02：queryParam 添加参数
- test03：form类型参数
- test04：json类型参数
- test05：xml类型参数
- test06：上传文件
- test07：响应


