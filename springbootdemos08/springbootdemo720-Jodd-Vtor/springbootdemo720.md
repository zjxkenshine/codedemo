# 参考地址
Jodd-vtor验证框架
- https://www.cnblogs.com/davidwang456/p/4648300.html

# 简介
VTor是一个编程式验证框架，适用于任意java对象的验证

# 过程
1. 定义校验检查规则
2. 在目标对象执行这些规则
3. 检查验证结果

# 通用验证条件
MaxConstraint，MinConstraint，RangeConstraint(定义了最大、最小范围的数字值)\
LengthConstraint，HasSubstringConstraint，LengthConstraint，WildcardMatchConstraint(检查string的值)\
EqualToFieldConstraint(检查两个field是否相等)

# profile
定义校验生成场景
```
  // match profiles 'p1' OR 'p2'
  @FooCheck(profiles = {"p1", "p2"})

  // match profiles 'default' OR 'p2'
  @FooCheck(profiles = {"default", "p2"})

  // match 'p1' OR 'p3' ONLY IF 'p2' does NOT match
  @FooCheck(profiles = {"p1", "-p2", "p3"})

  // match profiles 'p1' AND 'p2'
  @FooCheck(profiles = {"+p1", "+p2"})
```
# 目录
- test01：简单校验过程
- test02：注解校验
- test03：profile
- test04：自定义校验
- test05：直接执行校验
