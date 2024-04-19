# 参考地址
github：builder与freeze/thaw(冻结/解冻)模式支持
- https://github.com/fge/btf/tree/master

# Freeze/thaw模式
```
// Frozen
@Immutable
public interface Frozen<T extends Thawed<? extends Frozen<T>>>
{
    T thaw();
}

// Thawed
@NotThreadSafe
public interface Thawed<F extends Frozen<? extends Thawed<F>>>
{
    F freeze();
}
```
- 类F是不可变的，而类T是F的可修改版本
- F和T在同一个包中；任一类的所有实例变量都是包局部变量；
- F没有公开的构造函数； F有一个静态工厂方法，以便返回T的“原始”实例。
- 自由/解冻模式是一种“可逆”的构建器模式——也就是说，您可以从一个“冻结”的、不可变的实例创建一个具有相同特征的等效构建器实例
- 对象F不可变，构建器T可变