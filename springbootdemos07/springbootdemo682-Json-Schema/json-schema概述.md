# 1.JsonSchema概述
JsonSchema本质是一套规则，用来定义Json的数据格式
- 在线生成JsonSchema的工具：https://www.jsonschema.net/home
- 在线校验JsonSchema的工具：https://jsonschemalint.com/#!/version/draft-07/markup/json

JsonSchema版本有3个，draft-04、draft-06、draft-07
-  "$schema":"http://json-schema.org/draft-07/schema#"

示例：
```json
{
    "type":"object",
    "properties":{
        "name":{
            "type":"string"
        },
        "age":{
            "type":"integer"
        },
        "birthday":{
            "type":"string",
            "format":"date"
        }
    }
}
```

# 2.类型关键字
type：定义类型，具体数据可以是以下几种
- object 对象，可以包含多个字段
- string 字符串
- number 数字，包括浮点数和消暑
- integer 整数
- array 数组
- boolean 布尔，只有true和false两个合法值
- null 空，只有null一个合法值

# 3.类型额外特定参数
## 3.1 字符串string
- minLength：最小长度
- maxLength：最大长度
- pattern：正则表达式
- format：字符串格式，内容可以是date、time、data-time、email、hostname等

## 3.2 数值number和integer参数都相同
- 满足某个数的倍数：multipleOf
- 最小值：minimum
- 最大值：maximum
- 开区间最小值：exclusiveMinimum
- 开区间最大值：exclusiveMaximum

## 3.3 布尔boolean和空值null类型没有额外的类型特定参数

## 3.4 数组array
- items：成员类型，对应值可以是一个JsonSchema，规定数组元素的JsonSchema，也可以是一个JsonSchema数组，要求数组元素按照JsonSchema数组的要求一一对应。
- additionalItems：true/false，是否允许额外成员类型，仅当items是数组Schema才起作用，额外元素追加在数组后面。
- minItems：数组元素最小个数
- maxItems：数组元素最大个数
- uniqueItems：true/false，数组元素是否唯一
- contains：数组元素必须满足的schema样式
- minContains：数组必须满足contains样式的最少元素个数
- maxContains：数组必须满足contains样式的最多元素个数

## 3.5 对象object
最常用的类型，Json格式一层套一层
- properties：成员的schema，json格式，key是对象字段名，value是又一个schema
- patternProperties：批量定义成员的schema，正则匹配多个key对应一种schema
- required：必须出现的成员，数组格式
- dependencies：成员依赖关系，json格式，key是字符串，value是字符串数组，表示key属性出现value数组里的所有属性不能缺席
- additionalProperties：true/false，是否允许出现properties中没有定义的属性
- minProperties：最少属性个数
- maxProperties：最多属性个数

# 4.逻辑组合
- allOf：满足数组里所有的schema，数组格式
- anyOf：满足任意多个schema，数组格式
- oneOf：必须满足且仅满足其中一个schema，数组格式
- not：不能满足not对应的schema，json格式

# 5.复杂结构
- 定义：没有固定关键字，习惯在根节点的"definations"下定义可以多次引用的schema
- $id：唯一标识定义中的属性，可以通过id引用，而不需要根节点下的完整路径
- $ref：引用，路径以#开头代表根节点或者ID

# 6.通用关键字
- enum：枚举数组，值必须选择其中一个

仅用于描述的关键字，不影响校验：
- title：标题
- description：描述
- default：默认值
- example：举例说明
- "$comment"：批注