# 参考地址
Spring Aop和AspectJ 面向切面技术
- https://www.jianshu.com/p/08f411ef0525

AspectJ使用介绍（分享）
- https://www.jianshu.com/p/3c5b09f6f563

# 1.Spring AOP与AspectJ区别
- Spring AOP: 基于代理(Proxying),Spring Aop 很多地方都是直接用到AspectJ里面的代码
- AspectJ: 基于字节码操作(Bytecode Manipulation)

# 2.三种织入方式
- compile-time：编译期织入，在编译的时候一步到位，直接编译出包含织入代码的 .class 文件
- post-compile：编译后织入，增强已经编译出来的类，如我们要增强依赖的 jar 包中的某个类的某个方法
- load-time：在 JVM 进行类加载的时候进行织入


