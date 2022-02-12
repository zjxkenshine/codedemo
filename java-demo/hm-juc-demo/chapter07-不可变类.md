# 1.日期转换的问题
- SimpleDateFormat 不是线程安全的
- 如果一个对象不能够修改其内部状态（属性），那么它就是线程安全的，因为不存在并发修改！
- 这样的对象在 java 中有很多，例如在 Java 8 后，提供了一个新的日期格式化类 DateTimeFormatter

# 2.不可变设计
## final 的使用
String 类中不可变的体现：该类、类中所有属性都是 ﬁnal 的
- 属性用 ﬁnal 修饰保证了该属性是只读的，不能修改。
- 类用 ﬁnal 修饰保证了该类中的方法不能被覆盖，防止子类无意间破坏不可变性。

## 保护性拷贝
构造新字符串对象时，会生成新的`char[] value`，对内容进行复制。
- 这种通过创建副本对象来避免共享的手段称之为保护性拷贝

# 3.享元模式
需要重用数量有限的同一类对象时，将这些对象缓存

体现：在JDK中Boolean，Byte，Short，Integer，Long，Character等包装类提供了valueOf方法
- Byte, Short, Long 缓存的范围都是 -128~127。
- Character 缓存的范围是 0~127。
- Integer 的默认范围是 -128~127，最小值不能变，但最大值可以通过调整虚拟机参数 “-Djava.lang.Integer.IntegerCache.high “来改变。
- Boolean 缓存了 TRUE 和 FALSE

# 4.final的原理
- final 变量的赋值操作都必须在定义时或者构造器中进行初始化赋值，并且发现final变量的赋值也会通过putfield指令来完成
- 同样在这条指令之后也会加入写屏障，保证在其它线程读到它的值时不会出现为0的情况

