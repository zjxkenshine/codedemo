# 参考地址
dtd-parser
- https://github.com/eclipse-ee4j/jaxb-dtd-parser

DTD 简介
- https://www.runoob.com/dtd/dtd-intro.html

# DTD语法
- CDATA：不会被解析器解析的文本
- PCDATA：被解析的字符数据
## 元素
```
<!ELEMENT element-name category>
<!ELEMENT element-name EMPTY> 空
<!ELEMENT element-name (#PCDATA)> 字符数据
<!ELEMENT element-name (child1,child2,...)> 子元素列表
<!ELEMENT note (message+)> 至少出现一次
```

## 属性
```
<!ATTLIST element-name attribute-name attribute-type attribute-value>
```
默认值:
- `#REQUIRED`：属性值是必需的
- `#IMPLIED`：不是必须的
- `#FIXED value`：固定值

## 实体
```
内部实体
<!ENTITY entity-name "entity-value">

外部实体
<!ENTITY entity-name SYSTEM "URI/URL">
```

## 示例
```
<!DOCTYPE TVSCHEDULE [

<!ELEMENT TVSCHEDULE (CHANNEL+)>
<!ELEMENT CHANNEL (BANNER,DAY+)>
<!ELEMENT BANNER (#PCDATA)>
<!ELEMENT DAY (DATE,(HOLIDAY|PROGRAMSLOT+)+)>
<!ELEMENT HOLIDAY (#PCDATA)>
<!ELEMENT DATE (#PCDATA)>
<!ELEMENT PROGRAMSLOT (TIME,TITLE,DESCRIPTION?)>
<!ELEMENT TIME (#PCDATA)>
<!ELEMENT TITLE (#PCDATA)> 
<!ELEMENT DESCRIPTION (#PCDATA)>

<!ATTLIST TVSCHEDULE NAME CDATA #REQUIRED>
<!ATTLIST CHANNEL CHAN CDATA #REQUIRED>
<!ATTLIST PROGRAMSLOT VTR CDATA #IMPLIED>
<!ATTLIST TITLE RATING CDATA #IMPLIED>
<!ATTLIST TITLE LANGUAGE CDATA #IMPLIED>
]>
```
