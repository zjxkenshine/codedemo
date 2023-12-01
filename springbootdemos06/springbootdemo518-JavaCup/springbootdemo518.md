# 参考地址
javacup解析器
- https://github.com/ultimate-pa/javacup
- https://rawgit.com/ultimate-pa/javacup/master/manual.html
- https://www2.cs.tum.edu/projects/cup/manual.html

# 简介
1. 需要创建语法规范.cup文件和scanner扫描器
2. .cup文件编译
```shell
java -jar java-cup-11a.jar -parser Parser -symbols Symbol D:\Github\codedemo\springbootdemos06\springbootdemo518-JavaCup\src\main\java\com\kenshine\javacup\test01\MyParser.cup
```
3. 生成文件：
- Parser：解析器
- Symbol：符号

# .cup文件
.cup文件解析:
```
// 用于简单表达式求值器的CUP规范(无操作)
import java_cup.runtime.*;

/*设置和使用扫描器的准备工作*/
init with {: scanner.init();              :};
scan with {: return scanner.next_token(); :};

/* 终端(扫描器返回的符号) */
terminal            SEMI, PLUS, MINUS, TIMES, DIVIDE, MOD;
terminal            UMINUS, LPAREN, RPAREN;
terminal Integer    NUMBER;

/* 非终端 */
non terminal            expr_list, expr_part;
non terminal Integer    expr, term, factor;

/* 优先级 */
precedence left PLUS, MINUS;
precedence left TIMES, DIVIDE, MOD;
precedence left UMINUS;

/* 语法 */
expr_list ::= expr_list expr_part | 
              expr_part;
expr_part ::= expr SEMI;
expr      ::= expr PLUS expr 
            | expr MINUS expr  
            | expr TIMES expr  
            | expr DIVIDE expr  
            | expr MOD expr 
	    | MINUS expr %prec UMINUS
            | LPAREN expr RPAREN
	    | NUMBER
	    ;
```
