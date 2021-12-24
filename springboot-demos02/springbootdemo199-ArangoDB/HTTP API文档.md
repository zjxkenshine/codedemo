# 1.概述
可视化页面中的Support->rest api中可以看到完整API文档

# 2.JWT处理
- 生成用户令牌：`/_open/auth`
- 之后再HTTP请求头中使用`Authorization: bearer xxxxx`

# 3.文档：
## 读取文档
单个文档
```
GET /_api/document/{collection}/{key}
```
单个文件头
```
HEAD /_api/document/{collection}/{key}
```
读取多个
```
GET /_api/document/{collection}
```

## 创建文档
```
POST /_api/document/{collection}
```

## 替换文件
```
PUT /_api/document/{collection}/{key}
```

## 更新文档
```
PATCH /_api/document/{collection}/{key}
```

## 删除文档
```
DELETE /_api/document/{collection}/{key}
```

# 4.图，Edge等其他用法
https://www.arangodb.com/docs/stable/http/