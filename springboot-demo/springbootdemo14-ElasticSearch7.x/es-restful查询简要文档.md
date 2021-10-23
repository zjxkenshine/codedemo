# 1.创建索引 PUT
```http request
PUT /索引名/~类型名~/文档id
{请求体}
 
# PUT 创建命令  test1 索引 type1 类型 1 id
PUT test1/type1/1
{
  "name": "xiaofan",
  "age": 28
}

# 查看规则
GET test1

# 指定类型 创建规则
PUT test2
{
  "mappings":{
     "properties":{
        "name":{
           "type":"text"
        }
     }
  }
}

# 查看默认的规则
PUT /test3/_doc/1
{
  "name": "狂神说Java",
  "age": 28,
  "birthday": "1997-01-05"
}

```

# 2.修改索引 POST
```http request
POST /test3/_doc/1/_update
{
  "doc": {
    "name":"暴徒狂神"
  }
}

# GET test3/_doc/1
```

# 3.基本操作（简单的查询）
```
put /kuangshen/user/1
{
  "name": "狂神说",
  "age": 23,
  "desc": "一顿操作猛如虎，一看工资2500",
  "tags": ["码农", "技术宅", "直男"]
}
 
put /kuangshen/user/2
{
  "name": "张三",
  "age": 28,
  "desc": "法外狂徒",
  "tags": ["旅游", "渣男", "交友"]
}
 
put /kuangshen/user/3
{
  "name": "李四",
  "age": 30,
  "desc": "不知道怎么描述",
  "tags": ["旅游", "靓女", "唱歌"]
}
 
GET kuangshen/user/1
 
 
GET kuangshen/user/_search?q=name:狂神
```

# 4.复杂操作
## 4.1 排序、分页、高亮、模糊查询、标准查询
```
# 模糊查询
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "name": "狂神"
    }
  }
}
 
# 对查询结果进行字段过滤
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "name": "狂神"
    }
  },
  "_source": ["name", "desc"]
}
 
# 排序
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "name": "狂神"
    }
  },
  "sort":[{
    "age": "asc"
  }]
}
 
# 分页
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "name": "狂神"
    }
  },
  "sort":[{
    "age": "asc"
  }], 
  "from": 0,
  "size": 2
}
```

## 4.2 布尔值条件查询
```
# 多条件查询 must 相当于and
GET kuangshen/user/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {
          "name": "狂神"
        }},
        {"match": {
          "age": 23
        }}
      ]
    }
  }
}
 
# 多条件查询 should 相当于or
GET kuangshen/user/_search
{
  "query": {
    "bool": {
      "should": [
        {"match": {
          "name": "狂神说"
        }},
        {"match": {
          "age": 25
        }}
      ]
    }
  }
}
 
# 多条件查询 must_not 相当于 not
GET kuangshen/user/_search
{
  "query": {
    "bool": {
      "must_not": [
        {"match": {
          "age": 25
        }}
      ]
    }
  }
}
 
 
# 过滤查询1 age > 24
GET kuangshen/user/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {
          "name": "狂神"
        }}
      ],
      "filter": [
        {"range": {
          "age": {
            "gt": 24
          }
        }}
      ]
    }
  }
}
 
# 过滤器2  22<age<30 
GET kuangshen/user/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {
          "name": "狂神"
        }}
      ],
      "filter": [
        {"range": {
          "age": {
            "lt": 30,
            "gt": 22
          }
        }}
      ]
    }
  }
}
```

## 4.3 多条件查询
```
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "tags": "技术 男"
    }
  }
}
``` 

## 4.4 精确查询
keyword类型不会被分词器解析
term: 精确匹配
```
# 定义类型
PUT xiaofan_test_db
{
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "desc": {
        "type": "keyword"
      }
    }
  }
}
 
 
PUT /xiaofan_test_db/_doc/1
{
  "name": "小范说Java Name",
  "desc": "小范说Java Desc"
}
 
PUT /xiaofan_test_db/_doc/2
{
  "name": "小范说Java Name",
  "desc": "小范说Java Desc 2"
}
 
# 按照keyword类型精准匹配
GET xiaofan_test_db/_search
{
  "query": {
    "term": {
      "desc": "小范说Java Desc"
    }
  }
}
 
# 按照text类型匹配
GET xiaofan_test_db/_search
{
  "query": {
    "term": {
      "name": "小"
    }
  }
}
```

## 4.5 多个值匹配精确查询
```
PUT /test_db/_doc/3
{
  "t1": "22",
  "t2": "2020-09-10"
}
 
PUT /test_db/_doc/4
{
  "t1": "33",
  "t2": "2020-09-11"
}
 
GET test_db/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "term": {
            "t1": "22"
          }
        },
         {
          "term": {
            "t1": "33"
          }
        }
      ]
    }
  }
}
```

## 4.6 高亮查询
```
GET kuangshen/user/_search
{
  "query": {
    "match": {
      "name": "狂神"
    }
  },
  "highlight": {
    "pre_tags": "<p class='key' style='color:red'>",
    "post_tags": "</p>", 
    "fields": {
      "name": {}
    }
  }
}
 
# 结果显示：
#! Deprecation: [types removal] Specifying types in search requests is deprecated.
{
  "took" : 1,
  "timed_out" : false,
  "_shards" : {
    "total" : 1,
    "successful" : 1,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : {
      "value" : 2,
      "relation" : "eq"
    },
    "max_score" : 1.3862942,
    "hits" : [
      {
        "_index" : "kuangshen",
        "_type" : "user",
        "_id" : "1",
        "_score" : 1.3862942,
        "_source" : {
          "name" : "狂神说",
          "age" : 23,
          "desc" : "一顿操作猛如虎，一看工资2500",
          "tags" : [
            "码农",
            "技术宅",
            "直男"
          ]
        },
        "highlight" : {
          "name" : [
            "<p class='key' style='color:red'>狂</p><p class='key' style='color:red'>神</p>说"
          ]
        }
      },
      {
        "_index" : "kuangshen",
        "_type" : "user",
        "_id" : "4",
        "_score" : 1.0892314,
        "_source" : {
          "name" : "狂神说前端",
          "age" : 25,
          "desc" : "大王叫我来巡山",
          "tags" : [
            "码农1",
            "技术宅1",
            "直男1"
          ]
        },
        "highlight" : {
          "name" : [
            "<p class='key' style='color:red'>狂</p><p class='key' style='color:red'>神</p>说前端"
          ]
        }
      }
    ]
  }
}
```




