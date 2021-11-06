# 1.基本注解
- 字符类型
    - @AsserURL(是否是URL格式)、@Email、@Length
    - @MaxLength、@MinLength
    - @NotNull、@NotBlank、@NotEmpty
    - @Digits(字符串数字范围)、@HasSubstring
- 数值类型
    - @Range、@Max、@Min、@NotNegative
- 布尔类型
    - @AssertFalse、@AssertTrue
- 集合数组
    - @Size、@MaxSize、@MinSize、@MemberOf、@NotMemberOf
- 表达式或自定义
    - @Assert、@CheckWith(指明验证类)、@NotMatchPatternCheck
    - @MatchPatternCheck、@ValidateWithMethod
- @Past和@Future不能验证字符串类型的日期,需要自定义@CPast和@CFuture
- 其他注解：
    - @IsInvariant：声明为getter方法添加返回值约束,不声明不校验
- @Guarded 开启自动参数校验
    - @AssertFieldConstraints：校验域
    - @Pre：前置脚本条件
    - @Post：后置脚本条件

# 2.补充
- OVal 本身不是符合 JSR303/JSR380,但是可以配置标准Bean验证约束
    - BeanValidationAnnotationsConfigurer
