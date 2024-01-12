# 参考地址
json-rules 根据rule匹配jsonNodes
- https://github.com/santanusinha/json-rules

rule
```
   {
      "type": "equals",
      "value": "happy",
      "path": "$.mood"
   }
```

json
```
   {
      "name": "John Doe",
      "mood": "happy"
   }
```

# Operators type
对应Expression

## 基础：
- equals
- not_equals
- less_than
- greater_than
- less_than_equals
- greater_than_equals
- between (half-closed with lower bound included)

```json
  {
      "type": "equals",
      "value": "happy",
      "path": "$.mood"
   }
```

## 逻辑运算：
- and
- not
- or

```
   {
      "type": "and",
      "children": [
          {
             "type": "equals",
             "value": "happy",
             "path": "$.mood"
          },
          {
             "type": "less_than",
             "value": 1000,
             "path": "$.product.cost"
          }
      ]
   }
```

## 集合判定：
- not_in
- in
- contains_any
- contains_all

```json
  {
      "type": "in",
      "path": "$.mood",
      "values": [
        "happy",
        "sad"
      ]
   }
```

## 字符串判断：
- empty
- not_empty
- starts_with
- ends_with
- matches

```json
 {
        "type": "matches",
        "path": "$.s1",
        "value": ".* WORLD",
        "ignoreCase" : true
}
```

## path验证
```
   {
      "type": "equals",
      "value": "happy",
      "path": "$.mood",
      "defaultResult": true
   }
```

## 前置处理
- Datetime
    - Epoch - Mutation rules for unix timestamp 
    - DateTime - Mutation rules for textual dates
- Numeric 
    - Divide
    - Multiply
    - Sum
    - Difference
    - modulo
- Array
    - size
- String
    - length
    - sub_str

```json
    {
        "type": "in",
        "path": "$.time",
        "preoperation": {
          "operation": "epoch",
          "operand": "week_of_month",
          "zoneOffSet": "+05:30"
        },
        "values": [
          2,
          4
        ]
    }
```

## 动态值比较
```json
    {
        "type": "matches",
        "path": "$.s1",
        "value": "$.s2",
        "extractValueFromPath" : true
    }
```