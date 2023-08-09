# 参考地址
springboot整合spring-vault实践(一个小demo)
- https://blog.csdn.net/qq_35746632/article/details/123815142

spring-vault官方文档
- https://spring.io/projects/spring-vault#overview
- https://www.vaultproject.io/

Spring系列学习之Spring Vault
- https://blog.csdn.net/boonya/article/details/85218941

详细：HashiCorp Vault学习总结
- https://juejin.cn/post/7068562044491923487

# 踩坑
Exception in thread "main" org.springframework.vault.VaultException: Status 404 Not Found: {"request_id":"2dbc3ac2-33b6-4804-ca09-2d0b41fa98b1","lease_id":"","renewable":false,"lease_duration":0,"data":null,"wrap_info":null,"warnings":["Invalid path for a versioned K/V secrets engine. See the API docs for the appropriate API endpoints to use. If using the Vault CLI, use 'vault kv put' for this operation."],"auth":null}; nested exception is org.springframework.web.client.HttpClientErrorException$NotFound: 404 Not Found: [{"request_id":"2dbc3ac2-33b6-4804-ca09-2d0b41fa98b1","lease_id":"","renewable":false,"lease_duration":0,"data":null,"wrap_info":null,"warnings":["Invalid path for a versioned K/V secrets engine. See the API docs for the appropriate API endpoints to use. If using the Vault CLI, use 'vault kv put' for this operation."],"auth":null}]
- 不要使用secret/引擎,该路径为v2版本方法
- 创建新引擎kvdemo，指定方法版本为v1
