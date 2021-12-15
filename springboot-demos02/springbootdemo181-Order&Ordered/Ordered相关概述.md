# 1.Ordered接口
- 用于排序的接口，主要对外接口 PriorityOrdered
- 提供了两个静态属性：HIGHEST_PRECEDENCE 和 LOWEST_PRECEDENCE
- 对比接口：OrderComparator

# 2.PriorityOrdered接口
- 表示优先级排序，总在Ordered之前调用，且PropertyOrdered对象和Ordered对象被视为两个独立的子集
- PriorityOrdered的PostProcess Bean在其他PostProcess之前,在

# 3.@Order注解
- 排序注解，默认值为Ordered.LOWEST_PRECEDENCE，最低优先级
- 值越小优先级越高

# 4.@Priority注解
- javax.annotation提供，用于设置优先级
- 通常为非负值，值越大优先级越高

# 5.OrderComparator类
- 用于Ordered接口实现类和PriorityOrdered接口实现类对比
- AnnotationAwareOrderComparator：唯一子类，支持@Order注解和@Priority注解
    - `AnnotationAwareOrderComparator -> OrderComparator -> Comparator`
- OrderComparator类主要方法：
    - withSourceProvider：提供一个具有OrderSourceProvider源的Comparator对象
    - compare：对比大小
    - sort：排序
    - getPriority：获取优先级，默认为null

# 6.OrderComparator.OrderSourceProvider
- OrderComparator内部接口，用于指定Order源的供给策略，可以返回一个数组或对象
- getOrderSource方法有返回则使用该对象(需实现Ordered接口)，无返回则使用原对象order值
- 示例实现类：DefaultListableBeanFactory中的FactoryAwareOrderSourceProvider
    - 根据传入的BeanMap以及定义的RootBeanDefinition返回符合的Bean对象List

# 7.AnnotationAwareOrderComparator类
提供了注解支持，会被Ordered实现覆盖，主要方法：
- findOrderFromAnnotation：私有方法，从注解中获取order值
- getPriority：获取优先级的值，只返回一个值


