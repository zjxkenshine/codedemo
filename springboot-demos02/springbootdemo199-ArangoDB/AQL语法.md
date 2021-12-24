# 1.基本CRUD(Document)
Characters为新创建的Document Collection
## 插入
```
INSERT {
    "name": "Ned",
    "surname": "Stark",
    "alive": true,
    "age": 41,
    "traits": ["A","H","C","N","P"]
} INTO Characters
```

## 查询
基本使用
```
FOR c IN Characters
RETURN c
```
使用文档ID检索
```
RETURN DOCUMENT("Characters", "1263")
RETURN DOCUMENT("Characters/1263")
```
检索多个：
```
RETURN DOCUMENT("Characters", ["2861650", "2861653"])
RETURN DOCUMENT(["Characters/2861650", "Characters/2861653"])
```

## 更新
```
UPDATE "1263" WITH { alive: false } IN Characters
```

## 删除
```
REMOVE "1263" IN Characters
```

# 2.匹配文件
相等条件
```
FOR c IN Characters
    FILTER c.name == "Ned"
    RETURN c
```
范围
```
FOR c IN Characters
    FILTER c.age >= 13
    RETURN c.name
```
多条件
```
FOR c IN Characters
    FILTER c.age < 13
    FILTER c.age != null
    RETURN { name: c.name, age: c.age }
```
OR
```
FOR c IN Characters
    FILTER c.name == "Jon" OR c.name == "Joffrey"
    RETURN { name: c.name, surname: c.surname }
```

# 3.排序与限制
LIMIT
```
FOR c IN Characters
    LIMIT 5
    RETURN c.name
FOR c IN Characters
    LIMIT 2, 5
    RETURN c.name
```
SORT：分类，排序
```
FOR c IN Characters
    SORT c.name[,c.sex] [DESC]
    LIMIT 10
    RETURN c.name
```

# 4.合并文档
MERGE()函数：
```
FOR c IN Characters
    RETURN MERGE(c, { traits: DOCUMENT("Traits", c.traits)[*].en } )
```
另一种方式：
```
FOR c IN Characters
  RETURN MERGE(c, {
    traits: (
      FOR key IN c.traits
        FOR t IN Traits
          FILTER t._key == key
          RETURN t.en
    )
  })
```

# 5.图遍历
可基于文档创建图
```
INSERT { _from: "Characters/robb", _to: "Characters/ned" } INTO ChildOf
```
父节点遍历 OUTBOUND
```
FOR v IN 1..1 OUTBOUND "Characters/2901776" ChildOf
    RETURN v.name
```
子节点遍历 INBOUND
```
FOR c IN Characters
    FILTER c.name == "Ned"
    FOR v IN 1..1 INBOUND c ChildOf
        RETURN v.name
```
遍历孙节点
```
FOR c IN Characters
    FILTER c.name == "Tywin"
    FOR v IN 2..2 INBOUND c ChildOf
        RETURN v.name
```

# 其他操作查看
https://www.arangodb.com/docs/stable/aql/
