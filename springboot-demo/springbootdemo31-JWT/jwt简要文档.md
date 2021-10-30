# 1.基本概念
- JWT: JSON Web Token,也就是通过JSON形式作为Web应用中的令牌
- 作用：授权，信息交换

# 2.组成：
- 标头(Header) Base64编码
    - 令牌的类型（即JWT）
    - 使用的签名算法
- 有效载荷(Payload) Base64编码
    - 声明：有关实体（通常是用户）和其他数据
- 签名(Signature)
    - 使用编码后的 header 和 payload以及提供的一个密钥
    - 然后使用 header 中指定的签名算法（HS256）进行签名
    
# 3.注意
- Base64可逆, 需要传递非敏感数据
    
# 4.常见异常信息
- SignatureVerificationException:		签名不一致异常
- TokenExpiredException:    			令牌过期异常
- AlgorithmMismatchException:				算法不匹配异常
- InvalidClaimException:			失效的payload异常