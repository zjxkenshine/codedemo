# 参考地址
快试试用 API Key 来保护你的 SpringBoot 接口安全吧
- https://mp.weixin.qq.com/s/Ua6i3O7usclAmfCJVil_rQ

# REST API保护方式
## Basic Authentication
  Basic authentication是一种简单的认证方案。客户端发送HTTP请求，其中包含Authorization标头的值为Basic base64_url编码的用户名:密码。Basic authentication仅在HTTPS / SSL等其他安全机制下才被认为是安全的。
  
## OAuth2
OAuth2是REST API安全的行业标准。它是一种开放的认证和授权标准，允许资源所有者通过访问令牌将授权委托给客户端，以获得对私有数据的访问权限。

## API Keys
一些REST API使用API密钥进行身份验证。API密钥是一个标记，用于向API客户端标识API，而无需引用实际用户。标记可以作为查询字符串或在请求头中发送。

