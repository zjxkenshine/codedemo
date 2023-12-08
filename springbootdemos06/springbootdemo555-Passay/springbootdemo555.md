# 参考地址
Java开源工具库使用之密码安全策略库passay
- https://blog.csdn.net/qq_23091073/article/details/126847782
  
官网
- http://www.passay.org/
- https://github.com/vt-middleware/passay

# 密码
规则是密码校验和生成的基础，规则可分为两种：
- 正匹配，要求密码满足规则
- 负匹配，拒绝满足规则的密码

正匹配规则
- AllowedCharacterRule：要求密码只包含在给定集合中的字符
- AllowedRegexRule：要求密码符合正则表达式
- CharacterCharacteristicsRule：要求密码包含M个N类字符；例如，以下4种字符中的3个：数字、大写字母、小写字母、符号
- CharacterRule：要求密码包含来自给定字符集的至少N个字符（例如，数字、大写字母、小写字母、符号）
- LengthRule：要求使用密码长度
- LengthComplexityRule：要求密码满足基于密码长度的特定规则。例如，长度为8-12个字符的密码必须同时包含一个数字和符号。密码13个字符及更长的密码只能包含字母字符

负匹配规则：
- DictionaryRule：拒绝与字典中的条目相匹配的密码（精确匹配语义）
- DictionarySubstringRule：拒绝包含字典中的条目的密码（子字符串匹配语义）
- DigestDictionaryRule：拒绝与字典中摘要条目匹配的密码（哈希/摘要比较）
- HistoryRule：拒绝与以前的密码相匹配的密码（明文比较）
- DigestHistoryRule：拒绝与以前的密码摘要相匹配的密码（散列/摘要比较）
- CharacterOccurrencesRule：拒绝包含过多相同字符的密码
- IllegalCharacterRule：拒绝包含集合中任意字符的密码
- IllegalRegexRule：拒绝符合正则表达式的密码
- IllegalSequenceRule：拒绝包含N个字符序列的密码（例如，12345）
- NumberRangeRule：拒绝包含在定义范围内的任何数字的密码（例如，1000-9999）
- SourceRule：拒绝与来自其他来源的密码相匹配的密码（明文比较）
- DigestSourceRule：拒绝与其他来源的摘要匹配的密码（散希/摘要比较）
- RepeatCharacterRegexRule：拒绝包含重复的ASCII字符的密码，默认的序列长度为5个字符。
- RepeatCharactersRule：拒绝包含多个重复字符序列的密码
- UsernameRule：拒绝包含提供该密码的用户的用户名的密码
- WhitespaceRule：拒绝包含空白字符的密码

# 目录
- test01：qq 密码校验
- test02：gmail 密码要求
- test03：黑名单
- test04：密码匹配 是其中之一不通过
- test05：字符序列检测
- test06：passay国际化
- test07：PasswordGenerator密码生成
- test08：自定义字符集生成密码
