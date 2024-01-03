# 参考地址
classmembersorter 根据Java的方法和类对象的实际源代码行号对它们进行排序。
- https://github.com/luontola/classmembersorter

# 简介
行号排序策略
- BcelLineNumberStrategy：BCEL策略
- AsmLineNumberStrategy：ASM策略

主要类：ClassMemberSorter
- setStrategy：设置排序策略
- getDeclaredClasses：获取类，但顺序与定义顺序相同
- getDeclaredMethods：获取自己声明的任何权限的方法，包括私有方法，顺序与定义的顺序相同
- getMethods：是获取类中所有公共方法，包括继承自父类的，顺序与定义顺序相同