# 参考地址
jflex The fast scanner generator for Java™ with full Unicode support
扫描器生成，一般与javacup配合使用
- https://github.com/jflex-de/jflex
- https://github.com/johnidm/compiler-jflex-javacup-examples

# 简介
编译： simple
```
java -jar java-cup-11a.jar -parser MyParser -symbols MySymbol D:\Github\codedemo\springbootdemos06\springbootdemo519-JFlex\src\main\java\com\kenshine\jflex\simple\MyParser.cup
java -jar jflex-1.6.1.jar D:\Github\codedemo\springbootdemos06\springbootdemo519-JFlex\src\main\java\com\kenshine\simple\jflex\MyScanner.lex
```

编译： complex
```
java -jar java-cup-11a.jar -parser MyParser -symbols MySymbol D:\Github\codedemo\springbootdemos06\springbootdemo519-JFlex\src\main\java\com\kenshine\jflex\complex\Calculator.cup
java -jar jflex-1.6.1.jar D:\Github\codedemo\springbootdemos06\springbootdemo519-JFlex\src\main\java\com\kenshine\jflex\complex\Calculator.lex
```

