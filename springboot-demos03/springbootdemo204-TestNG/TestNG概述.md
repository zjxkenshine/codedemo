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

# 6.预期异常
` @Test(expectedExceptions = Exception.class)`

# 7.依赖测试
测试方法B的执行，依赖测试方法A，就叫做依赖测试。分为硬依赖测试和软依赖测试
- 硬依赖测试：
    - 测试方法A先执行，若A执行成功，则B再执行。若A执行失败，则B不执行
    - `@Test(dependsOnMethods = {“test1”,“test2”...})`
- 软依赖测试：
    - 测试方法A先执行，无论A是否执行成功，A执行后B都会执行
    - `@Test(dependsOnMethods = {“test1”,“test2”...}, alwaysRun=true)`

# 8.参数化测试
通过XML/@Parameters/@DataProvider将参数传递给@Test方法,两种方式：
    - 使用testing.xml
    - 使用数据提供者@DataProvider

# 9.开启多个线程测试
传统的测试使用单线程执行，多线程可以提高测试用例的执行效率
- 注解实现
- xml实现

级别：
- methods级别：所有用例都可以在不同的线程去执行
- classs级别：不同class tag下的用例可以在不同的线程执行，相同class tag下的用例只能在同一个线程中执行
- tests级别：不同test tag下的用例可以在不同的线程执行，相同test tag下的用例只能在同一个线程中执行

# 10.超时测试
当测试用例超过timeOut设定的时间，则认为用例执行失败，继续运行下面的用例
- `@Test(timeout=“毫秒值”)`