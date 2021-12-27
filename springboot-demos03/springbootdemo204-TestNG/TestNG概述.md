# 1.TestNG简介
- TestNG是Java中的一个测试框架， 类似于JUnit 和NUnit,   功能都差不多， 只是功能更加强大，使用也更方便
- 测试人员一般用TestNG来写自动化测试,开发人员一般用JUnit写单元测试

# 2.TestNG优点
- 漂亮的HTML格式测试报告
- 支持并发测试
- 参数化测试更简单
- 支持输出日志
- 支持更多功能的注解

# 3.自动化测试流程
- 在生成的程序框架中编写测试代码逻辑
- 根据测试代码逻辑，插入TestNG注解标签
- 配置Testng.xml文件，设定测试类、测试方法、测试分组的执行信息，添加监听器
    - 详见test.xml文件
- 右键运行test.xml，执行TestNG的测试程序

# 4.TestNG常用注解
- `@BeforeSuite`：在测试套件前运行
- `@AfterSuite`
- `@BeforeClass`：当前类测试前
- `@AfterClass`
- `@BeforeTest`
- `@AfterTest`
- `@BeforeGroups`：测试组之前
- `@AfterGroups`
- `@BeforeMethod`：每个测试方法之前
- `@DataProvider`：提供数据的方法，必须返回一个`Object[] []`
- `@Factory`：工厂方法，必须返回Object[]
- `@Listeners`：监听器
- `@Parameters`：将参数传递给@Test方法
- `@Test`

# 5.Test.xml
用于设置测试集
- 右键run可直接运行
- Edit Configure->Listeners->勾选使用默认reporters
