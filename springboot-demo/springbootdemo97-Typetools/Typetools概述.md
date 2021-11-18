# 1.参考地址
typetools
- https://github.com/jhalterman/typetools

# 2.TypeResolver提供的方法
- `Type reify(Type type, Class<S> context)`：返回完全具体化type test04
- `Type reify(Type genericType)`：通过泛型类型具体类型信息
- `Class<?>[] resolveRawArguments(Class<T> type, Class<S> subType)`：获取每行的泛型类型 test01,02
- `Class<?> resolveRawArgument(Class<T> type, Class<S> subType)`：单个泛型参数 test03
- `Type resolveGenericType(Class<?> type, Type subType)`： 通过泛型类型具体类型信息
- `Class<?> resolveRawClass(Type genericType, Class<?> subType)`：可解析字段和方法上的泛型类型 test05
- test06：使用示例


