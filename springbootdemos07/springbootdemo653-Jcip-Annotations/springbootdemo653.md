# 参考地址
jcip-annotations 完全基于javadocs提供的规范的JCIP注释的干净实现
- https://github.com/stephenc/jcip-annotations

线程同步的注解:@ThreadSafe、@Immutable、@NotThreadSafe、@GuardedBy
- https://blog.csdn.net/loliDapao/article/details/122473071

# 简介
- @ThreadSafe：类是线程安全的
- @Immutable：表示类是不可变的，包含了　@ThreadSafe　的意思
- @NotThreadSafe：表示这个类不是线程安全的
- @GuardedBy(lock)：这个状态变量，这个方法被哪个锁保护着
  1. @GuardedBy( "this" ) 受对象内部锁保护
  2. @GuardedBy( "fieldName" ) 受 与fieldName引用相关联的锁 保护。
  3. @GuardedBy( "ClassName.fieldName" ) 受 一个类的静态field的锁 保存。
  4. @GuardedBy( "methodName()" ) 锁对象是 methodName() 方法的返值，受这个锁保护。
  5. @GuardedBy( "ClassName.class" ) 受 ClassName类的直接锁对象保护。而不是这个类的某个实例的锁对象
