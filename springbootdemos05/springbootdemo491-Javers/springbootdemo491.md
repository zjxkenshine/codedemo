# 参考地址
DDD中Diff的应用(JAVERS)的封装
- https://weihubeats.blog.csdn.net/article/details/120110072

官网：
- https://javers.org/
- https://github.com/javers/javers

7.0.3版本 需要切换到java11+环境

# 简介
## 比较算法
- Levenshtein：最智能的比较算法，一般推荐使用。但是需要注意的是如果比较元素超过300个以上效率就会变得很慢
- Simple：主要优点是速度快，计算复杂度线性，主要缺点是输出过于冗长
- Set：不关心集合的顺序可以选择，在进行比较之前，JaVers 会将所有 list 转换为 set

## changes改变
- NewObject 新增
- ObjectRemoved 删除
- PropertyChange 修改
    - ContainerChange 集合修改
    - MapChange map修改
    - ReferenceChange 实体引用修改
    - ValueChange 普通值的修改

## 集合比较
`javers.compareCollections()`

## 自定义比较器
参考 CustomBigDecimalComparator

## 注解
类注解：

    @Entity
    将给定的类(及其所有子类)声明为 Entity 类型
    @ValueObject
    将给定的类(及其所有子类)声明为 Value Object 类型。
    @Value
    @DiffIgnore
    @ShallowReference
    @IgnoreDeclaredProperties
    @TypeName

属性注解：

    @Id
    声明一个实体的 id 属性,没有id无法比对出是否为新增对象
    @DiffIgnore
    比对时可以忽略的属性
    @DiffInclude
    @ShallowReference
    声明一个属性为浅引用。只能用于实体类型属性。目标 Entity 实例的所有属性(Id 除外)都被忽略。
    @PropertyName

## 待学习
springboot 3.x
- javers-spring-boot-starter-sql
- javers-spring-boot-starter-mongo