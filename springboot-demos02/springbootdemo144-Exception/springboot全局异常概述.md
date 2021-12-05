# 相关注解
- `@ControllerAdvice`,`@RestControllerAdvice`：value可指定拦截范围
- `@ExceptionHandler(Exception.class)`：指定拦截的异常类型
   - 父类和子类都有处理器，则默认选择子类的
- `@ResponseBody`：与`@ControllerAdvice`配合使用，返回数据
- `@ResponseStatus(HttpStatus.xxx)`：指定响应状态

# 相关资料
springboot使用多个@RestControllerAdvice时的拦截顺序
- cnblogs.com/chongcheng/p/13058345.html