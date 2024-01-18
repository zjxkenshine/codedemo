# 参考地址
jqwik junit平台属性测试(PBT)框架
- https://github.com/jqwik-team/jqwik
- https://jqwik.net/

# 目录
- JqwikTest01：示例1
- JqwikTest02：示例2
- ReportTest：结果打印
- EnableFootnotesTest：失败结果打印
- PropertyDefaultTest：@Property设置
- ExampleBasedTests：@Example仅执行一次
- lifecycle：生命周期
    - SimpleLifecycleTests：简单生命周期示例
    - FullLifecycleExamples：注解生命周期
    - BeforeTryMemberExample：生命周期注解修饰变量、异常断言
- group：测试
    - TestsWithGroups：分组测试
    - NamingExamples：命名测试
    - TaggingExamples：标签测试
    - DisablingExamples：关闭测试
- parameter：参数生成约束
    - CollectionsTest：集合约束
    - VariableTypedPropertyExamples：？通配符支持
    - ProvideTest：自定义约束，provide方式
    - SupplierTest：自定义约束，ArbitrarySupplier方式
    - EmbeddedProvideTest：@From 嵌入式数据参数提供
    - VariableTypedPropertyExamples：静态方法
    - ArbitraryTypesTest：Arbitrary类型
    - RandomDistributionTest：随机数生成
    

# 1.@Property属性
- int tries：生成参数次数，默认1000，可在junit-platform.properties中重写
- String seed：用于生成值的随机种子
- FixedSeedMode whenFixedSeed：固定种子模式
    - FixedSeedMode.ALLOW：仅使用种子
    - FixedSeedMode.WARN：打印提示
    - FixedSeedMode.FAIL：失败并抛出异常
- int maxDiscardRatio：最大故障比率，超过就报告为异常
- ShrinkingMode shrinking：收缩方式
    - ShrinkingMode.OFF：不收缩
    - ShrinkingMode.FULL：一直收缩直到找不到更小的值来伪造属性为止
    - ShrinkingMode.BOUNDED：收缩尝试最多10秒，然后超时
- GenerationMode generation：生成模式
    - GenerationMode.AUTO：默认，自动选择
    - GenerationMode.RANDOMIZED：随机生成
    - GenerationMode.EXHAUSTIVE：穷举
    - GenerationMode.DATA_DRIVEN：使用@FromData提供的数据
- AfterFailureMode afterFailure：确定jqwik将如何生成在上一次运行中失败的属性的值
    - AfterFailureMode.SAMPLE_FIRST：默认，首先使用最后一组收缩的参数，成功则随机
    - AfterFailureMode.SAMPLE_ONLY：仅使用最后一组收缩的参数
    - AfterFailureMode。PREVIOUS_SEED：jqwik将使用相同的种子，从而生成与前一次失败运行中相同的参数序列
    - AfterFailureMode.RANDOM_SEED：直接使用新的随机种子
- EdgeCasesMode edgeCases:确定jqwik是否以及何时生成边的排列
    - EdgeCasesMode.MIXIN：默认，边缘情况将与随机生成的参数集混合，直到所有已知的排列都已混合
    - EdgeCasesMode.FIRST：在jqwik开始使用随机生成的样本之前生成所有的边情况
    - EdgeCasesMode.NONE：将根本不会为整个参数集生成边情况
    
# 2.@Example
- junit风格测试，仅执行一次

# 3.断言
- jqwik不支持断言，需要第三方库支持，如Hamcrest和AssertJ

# 4.生命周期
- lifecycle包

测试元素树，由两种元素构成
- Containers：根引擎容器、容器类和嵌入式容器类（用@Group注释的）
- Properties：用@Property或@Example注释的方法。一个例子就是一个只需一次尝试的属性

注解生命周期：
- @BeforeContainer：静态方法，容器创建前执行
- @AfterContainer：静态方法，容器创建启动时执行
- @BeforeProperty：每个property或example之前运行一次
- @AfterProperty：每个property或example运行结束
- @BeforeTry：每次尝试前
- @AfterTry：每次尝试后

# 5.测试相关注解
- @Group 分组测试：TestsWithGroups
- @Label 测试命名：NamingExamples
- @Tag 标签测试：TaggingExamples
- @Disabled：关闭测试：DisablingExamples

# 6.默认参数生成
- 为@ForAll注释的参数生成值，没有value的话会使用默认生成器
- 参考：JqwikTest01

## 6.1 控制生成策略：
- `@WithNull(double value = 0.1)`：以0.1概率生成null值
- `@StringLength(int value = 0, int min = 0, int max = 0)`：设置固定长度或配置最小值和最大值
- `@NotEmpty`：最小值为1
- `@NotBlank`：不能为空
- 字符集设置：
    - `@Chars(chars[] value = {})`
    - `@CharRange(char from = 0, char to = 0)`
    - `@NumericChars`：数字0到9
    - `@LowerChars`：字母a到z
    - `@UpperChars`：A到Z
    - `@AlphaChars`：大小写字母都可以
    - `@Whitespace`：允许使用所有空白字符

## 6.2 集合或数组Size
- `@Size(int value = 0, int min = 0, int max = 0)`：固定长或最大最小值
- `@NotEmpty`：最小值为1
- `@UniqueElements`：独立数据 不重复

## 6.3 Integer约束
- `@ByteRange(byte min = 0, byte max = Byte.MAX_VALUE)`：仅支持Byte/byte
- `@ShortRange(short min = 0, short max = Short.MAX_VALUE)`：仅支持Short/short
- `@IntRange(int min = 0, int max = Integer.MAX_VALUE)`：仅支持Integer/int
- `@LongRange(long min = 0L, long max = Long.MAX_VALUE)`
- `@BigRange(String min = "", String max = "")`：BigInteger
- `@Positive`：大于0的任意数字
- `@Negative`：低于0

## 6.4 Decimal约束
- `@FloatRange(float min = 0.0f, minIncluded = true, float max = Float.MAX_VALUE, maxIncluded = true)`
- `@DoubleRange(double min = 0.0, minIncluded = true, double max = Double.MAX_VALUE, boolean maxIncluded = true)`
- `@BigRange(String min = "", minIncluded = true, String max = "", maxIncluded = true)`：BigDecimal
- `@Scale(int value)`：指定小数位数的最大值。适用于所有十进制类型。
- `@Positive`：大于0
- `@Negative`：小于0

## 6.5 自定义参数生成
- provide方法
- 实现ArbitrarySupplier
- @From 为嵌入式数据提供参数

Arbitraries静态方法生成：
- randomValue
- fromGenerator
- fromGeneratorWithSize
- of
- just
- create
- frequency：加权概率

生成string与char
- CharacterArbitrary chars()
- StringArbitrary strings()

其他：
- `randoms()`：java random
- `shuffle`：排列

ArbitraryType类型
- FloatArbitrary floats()
- DoubleArbitrary doubles()
- BigDecimalArbitrary bigDecimals()
- ByteArbitrary bytes()
- ShortArbitrary shorts()
- IntegerArbitrary integers()
- LongArbitrary longs()
- BigIntegerArbitrary bigIntegers()
- ListArbitrary<T> Arbitrary.list()
- SetArbitrary<T> Arbitrary.set()
- StreamArbitrary<T> Arbitrary.streamOf()
- IteratorArbitrary<T> Arbitrary.iterator()
- ArrayArbitrary<T, A> Arbitrary.array(Class<A> arrayClass)

## 6.6 随机数字分布
- RandomDistribution

Arbitrary用法与stream相似

# 文档超全，后续看文档