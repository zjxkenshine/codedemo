# 参考地址
json-schema-validator json格式校验
- https://github.com/java-json-tools/json-schema-validator

# json schema简介
- https://www.codingdict.com/article/21382
- https://json-schema.org/draft/2020-12/json-schema-validation

````json
{
   "$schema": "http://json-schema.org/draft-04/schema#",
   "title": "Product",
   "description": "A product from Acme's catalog",
   "type": "object",

   "properties": {

      "id": {
         "description": "The unique identifier for a product",
         "type": "integer"
      },

      "name": {
         "description": "Name of the product",
         "type": "string"
      },

      "price": {
         "type": "number",
         "minimum": 0,
         "exclusiveMinimum": true
      }
   },

   "required": ["id", "name", "price"]
}
````
- $ schema关键字声明此模式是根据草案v4规范编写的
- title：此架构标题
- description：描述
- type：必须是一个JSON对象
- properties：定义要在JSON文件中使用的各种键及其值类型，最小值和最大值
- required：保留所需属性的列表
- minimum：这是要对值进行约束并表示最小可接受值
- exclusiveMinimum：如果“exclusiveMinimum”存在且布尔值为true，则实例有效，如果它严格大于“minimum”的值。
- maximum：这是要放在值上的约束，表示最大可接受值
- exclusiveMaximum：如果“exclusiveMaximum”存在且布尔值为true，则实例有效，如果它严格低于“maximum”的值。
- multipleOf：如果通过此关键字的值对实例进行除法的结果是整数，则数字实例对“multipleOf”有效
- maxLength：字符串实例的长度定义为其最大字符数
- minLength：字符串实例的长度定义为其字符的最小数量
- pattern：正则表达式与实例成功匹配，则实例有效
