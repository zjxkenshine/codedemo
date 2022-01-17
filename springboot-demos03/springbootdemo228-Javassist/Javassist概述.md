# 1.Javassist概述
- Javassist 是一个用来 处理 Java 字节码的类库。
- 它可以在一个已经编译好的类中添加新的方法，或者是修改已有的方法，并且不需要对字节码方面有深入的了解

# 2.主要类
- CtClass：表示 class 文件
- ClassPool：CtClass 对象的容器。它按需读取类文件来构造 CtClass 对象，并且保存 CtClass 对象以便以后使用
    - 当 CtClass 数量过多时，会占用大量的内存，需要有意识的调用CtClass的detach()方法以释放内存
- CtMethod：代表类中的某个方法
- CtField：操作属性
- CtNewMethod：创建CtMethod
- CtConstructor：构造器
- CtBehavior：表示方法、构造函数或静态构造函数（类初始值设定项）
- CtMember：表示字段、构造函数或方法，以上成员的父类


# 3.主要方法
CClassPool：
- getDefault()：返回默认ClassPool
- appendClassPath, insertClassPath：将一个ClassPath加到类搜索路径的末尾位置 或 插入到起始位置
- toClass：将修改后的CtClass加载至当前线程的上下文类加载器中，通过调用本方法实现。
    - 一旦调用该方法，则无法继续修改已经被加载的class
- get,getCtClass : 根据类路径名获取该类的CtClass对象

CtClass：
- freeze : 冻结一个类，使其不可修改
- isFrozen : 判断一个类是否已被冻结
- prune : 删除类不必要的属性，以减少内存占用，慎用
- defrost : 解冻一个类，使其可以被修改
- detach : 将该class从ClassPool中删除
- writeFile : 根据CtClass生成 .class 文件
- toClass : 通过类加载器加载该CtClass

CtMethod：
- insertBefore : 在方法的起始位置插入代码；
- insertAfter : 在方法的所有 return 语句前插入代码以确保语句能够被执行，除非遇到exception；
- insertAt : 在指定的位置插入代码
- setBody : 将方法的内容设置为要写入的代码，当方法被 abstract修饰时，该修饰符被移除
    - 符号：以$开头，有很多种类型
- make : 创建一个新的方法。

# 4.调用创建的类的方式
demo01
1. 通过反射的方式调用 CreatePerson
2. 通过读取 .class 文件的方式调用 InvokePerson test01
3. 通过接口的方式调用 InvokePerson test02

# 5.修改现有的类对象
demo02 

