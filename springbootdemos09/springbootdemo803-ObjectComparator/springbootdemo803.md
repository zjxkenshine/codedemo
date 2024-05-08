# 参考地址
object-comparator 对象属性比对工具，用来对比两个对象的所有属性差别，可以是不同类的对象进行比较。
- https://github.com/Verlif/object-comparator

# 简介
- 可以通过CompareCore.addEqualJudge()来添加对应类的判断方法
- 通过@CompareField注解来控制属性是否被忽略或是否递归对比`@CompareField(deep = true)`
- EqualJudge接口控制值对比逻辑
- 结果中的Type有7个值，分别表示了7种对比状态：
    - NEW_FIELD - 新属性，从没有属性到有属性
    - DROPPED_FIELD - 无属性，从有属性到没有属性 
    - MODIFY_VALUE - 值修改
    - MODIFY_FILL - 旧值为空
    - MODIFY_NULL - 新值为空
    - MODIFY_TYPE - 属性类型修改
    - NO - 未修改

