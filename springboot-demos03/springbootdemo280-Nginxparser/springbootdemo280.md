# 参考地址
github
- https://github.com/odiszapc/nginx-java-parser

从零搭建开发脚手架 Java使用nginxparser编辑操作nginx.conf配置
- https://blog.csdn.net/abu935009066/article/details/119872800

官方示例
- test01

# 1.组件
- **块描述NgxBlock**：http {…}、server {…}、location / {…}，这种名称+{}
- **单行参数描述NgxParam**： listen 80，server_name www.nginx.cn，这种简单的文本key value
- **注释描述NgxComment**：# 注释

# 2.操作
## 2.1 加载配置
可以通过路径或者流的方式加载配置
- test01_Load

## 2.2 查找
- 查找Block：test02_Search/test01
- 查找单行参数：test02_Search/test02
- 查找具体K-V：test02_Search/test03

## 2.3 添加
- 添加块：test03_Add/test01
- 添加单行参数：test03_Add/test02、03
- 添加多行参数：test03_Add/test04
- 添加文本配置：test03_Add/test05
- 添加server示例：test03_Add/test06
- 添加location示例：test03_Add/test07

## 2.4 删除
- Test04_Del

## 2.5 修改
不支持，只能先删除后新增

# 3.nginx操作
```shell
nginx -c /usr/local/nginx/conf/nginx.conf 

nginx -s stop 强制关闭
nginx -s quit
nginx -s reload  重载配置
nginx -s reopen 日志切割

nginx -t -c /home/test/conf/nginx.conf 验证配置文件

```


