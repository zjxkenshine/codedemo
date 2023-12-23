# 参考地址
fluent-validator
- https://github.com/neoremind/fluent-validator
- http://neoremind.com/2016/02/java%E7%9A%84%E4%B8%9A%E5%8A%A1%E9%80%BB%E8%BE%91%E9%AA%8C%E8%AF%81%E6%A1%86%E6%9E%B6fluent-validator/
  
# 简介
- HibernateSupportedValidator：hibernate校验支持
- fluent-validator-jsr303：jsr303支持

# 回调函数
`doValidate(new DefaulValidateCallback()...)`
- onSuccess()
- onFail()
- onUncaughtException()

# 其他
- `putAttribute2Context`：验证时将属性注入到验证器中
- `context.getAttribute`：验证器中获取属
- 级联验证：`@FluentValid与@FluentValidate`配合使用
- 分组校验：` @FluentValidate(value = {xxx.class}, groups = {Add.class})`
    -  使用：`FluentValidator.checkAll(new Class<?>[] {Add.class})...`
- putClosure2Context：闭包传递
- context.getClosure：获取