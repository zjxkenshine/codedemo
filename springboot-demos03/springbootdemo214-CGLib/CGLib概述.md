# 1.概述
CGLIB是一个强大的、高性能的代码生成库。其被广泛应用于AOP框架中，用以提供方法拦截操作
- CGLIB底层使用了ASM来操作字节码生成新的类

# 2.CGLib动态代理与Java动态代理对比
- CGLIB代理主要通过对字节码的操作，为对象引入间接级别，以控制对象的访问
- JDK动态代理只能对接口进行代理。如果要代理的类为一个普通类、没有接口，那么Java动态代理就没法使用了
- Java动态代理使用Java原生的反射API进行操作，在生成类上比较高效；CGLIB使用ASM框架直接对字节码进行操作，在类的执行过程中比较高效

# 3.常用的API
## Enhancer
CGLIB中最常用的一个类，既能够代理普通的class，也能够代理接口
- FixedValue：用来对所有拦截的方法返回相同的值
- InvocationHandler：在代理类实例上调用其代理接口中声明的方法时，最终都会由InvocationHandler的invoke方法执行
- CallbackFilter：只拦截特定方法

## ImmutableBean
不可变的Bean，允许创建一个原来对象的不可变包装类

## Bean generator
在运行时动态的创建一个bean

## Bean Copier
cglib提供的能够从一个bean复制到另一个bean中，而且其还提供了一个转换器，用来在转换的时候对bean的属性进行操作

## BulkBean
相比于BeanCopier，BulkBean将copy的动作拆分为getPropertyValues和setPropertyValues两个方法，允许自定义处理属性

## BeanMap
BeanMap类实现了Java Map，将一个bean对象中的所有属性转换为一个String-to-Obejct的Java Map

## keyFactory
keyFactory类用来动态生成接口的实例，接口需要只包含一个newInstance方法，返回一个Object

## Mixin(混合)
Mixin能够让我们将多个对象整合到一个对象中去，前提是这些对象必须是接口的实现。

## String switcher
用来模拟一个String到int类型的Map类型。如果在Java7以后的版本中，类似一个switch语句

## Interface Maker
创建一个新的Interface

## Method delegate
MethodDelegate主要用来对方法进行代理

## MulticastDelegate
1. 多重代理和方法代理差不多，都是将代理类方法的调用委托给被代理类。使用前提是需要一个接口，以及一个类实现了该接口
2. 通过这种interface的继承关系，我们能够将接口上方法的调用分散给各个实现类上面去
3. 多重代理的缺点是接口只能含有一个方法，如果被代理的方法拥有返回值，那么调用代理类的返回值为最后一个添加的被代理类的方法返回值

## Constructor delegate
- 对构造函数进行代理
- 需要一个接口，这个接口只含有一个Object newInstance(…)方法，用来调用相应的构造函数

## Parallel Sorter(并行排序器)
能够对多个数组同时进行排序，目前实现的算法有归并排序和快速排序

## FastClass
- FastClass就是对Class对象进行特定的处理，比如通过数组保存method引用
- 因此FastClass引出了一个index下标的新概念，通过index获取method
- 通过数组存储method,constructor等class信息，从而将原先的反射调用，转化为class.index的直接调用，从而体现所谓的FastClass