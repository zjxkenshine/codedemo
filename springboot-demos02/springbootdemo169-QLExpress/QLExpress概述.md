# 1.QLExpress简介
- 由阿里的电商业务规则、表达式（布尔组合）、特殊数学公式计算（高精度）、语法分析、脚本二次定制等强需求而设计的一门动态脚本引擎解析工具。

# 2.QL语法
与java语法相比
- 不支持try{}catch{}
- 注释目前只支持 /** **/，不支持单行注释 //
- 不支持java8的lambda表达式
- 不支持for循环集合操作for (GRCRouteLineResultDTO item : list)
- 弱类型语言，请不要定义类型声明,更不要用Templete（Map<String,List>之类的）
- array的声明不一样
- min,max,round,print,println,like,in 都是系统默认函数的关键字，请不要作为变量名
