# 1.CouchDB概述
CouchDB 是一个开源的面向文档的数据库管理系统，可以通过 RESTful JSON API 访问
- Futon：couchdb内置管理界面，访问地址：http://127.0.0.1:5984/_utils/

# 2.创建数据库
```
curl -X PUT http://127.0.0.1:5984/dbname
```
```
-- 查看创建的数据库
curl -X GET http://127.0.0.1:5984/_all_dbs
```

# 3.删除数据库
```
curl -X DELETE http://127.0.0.1:5984/dbname
```

# 4.创建文档
```
curl -X PUT http://127.0.0.1:5984/dbname/"id" -d ' { document} '
```
- dbname：数据库名称
- id：文档ID
- {document}：文档的数据

返回值：
```
{"ok":true,"id":"001","rev":"1-1c2fae390fa5475d9b809301bbf3f25e"}
```
- rev:表示修订ID，每次修改（更新或修改）文档时，CouchDB都会生成_rev值
    - 每次查询需要该值

# 5.查询创建的文档
示例：
```
$ curl -X GET http://127.0.0.1:5984/my_database/ 001
{
   "_id": "001",
   "_rev": "1-3fcc78daac7a90803f0a5e383f4f1e1e",
   "Name": "Raju",
   "age": 23,
   "Designation": "Designer"
}
```

# 6.更新文档
```
curl -X PUT http://127.0.0.1:5984/dbname/id/ -d '{ "field" : "value", "_rev" : "revision id" }'
```
示例：
```
$ curl -X PUT http://127.0.0.1:5984/my_database/001/ -d ' { " age " : " 24 " , " _rev " : " 1-1c2fae390fa5475d9b809301bbf3f25e " } '
```

# 7.删除文档
```
curl -X DELETE http://127.0.0.1:5984/dbname/id? _rev
```
示例：
```
curl -X DELETE http://127.0.0.1:5984/my_database/001?rev=1-3fcc78daac7a90803f0a5e383f4f1e1e
```

# 8.附加文件
```
curl -vX PUT http://127.0.0.1:5984/dbname/id/filename?rev=document rev_id --data-binary @filename -H "Content-Type:
```



