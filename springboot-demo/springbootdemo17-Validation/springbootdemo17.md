# 参考地址
- https://blog.csdn.net/RtxTitanV/article/details/119763108




# 常用校验
- @Null：必须为null。
- @NotNull：必须不为null。
- @AssertTrue：必须为true。
- @AssertFalse：必须为false。
- @Min(value)：必须是一个大于等于指定值的数字。
- @Max(value)：必须是一个小于等于指定值的数字。
- @DecimalMin(value)：必须是一个大于等于指定值的数字。
- @DecimalMax(value)：必须是一个小于等于指定值的数字。
- @Size(min=,max=)：大小必须在指定的范围内。
- @Digits(integer, fraction)：必须是一个数字，其值必须在可接受的范围内。
- @Past：必须是一个过去的日期。
- @Future：必须是一个将来的日期。
- @Pattern(regex=)：必须符合指定的正则表达式。
- @Email：必须是一个有效的email地址。
- @Length(min=,max=)：字符串长度是否在指定范围内。
- @NotBlank：必须非空且长度大于0。
- @NotEmpty：必须不为null或空。
- @URL(protocol=,host,port)：必须是一个有效的URL，如果提供了protocol，host等，则还需满足提供的条件


# 简单使用
- 校验请求体
    - 1.在bean中添加注解
    - 2.在请求方法中使用@Valid开启校验
    - 3.需要创建全局异常处理类捕获异常并进行处理

- 校验请求参数
    - 参考UserController GET和DELETE方法

- @Validated 和 @Valid 注解组合可以校验任何组件
- 使用Validator bean可以实现编程式校验
- 自定义校验注解
    - 定义注解, @Constraint 指定校验器
    - 编写自定义校验器实现 ConstraintValidator 接口
- 分组校验：针对不同的方法使用不同的校验规则
    - 使用 groups 属性进行区分,创建分组校验接口
    - @Validated(value = AddUserGroup.class) 指定分组
- 嵌套参数校验：一个实体中嵌套一个实体时
    ```
            @NotEmpty(message = "订单描述信息不能为空")
            private String orderDescription;
            @Valid
            private Account account;
    ```
