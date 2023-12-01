package com.kenshine.javacup.test01;

import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.SymbolFactory;
import java_cup.sym;

/**
 * @author by kenshine
 * @Classname scanner
 * @Description 扫描器
 * @Date 2023-12-01 11:37
 * @modified By：
 * @version: 1.0$
 */
public class Scanner implements java_cup.runtime.Scanner {
    public Scanner(){};
    /* 单向前遍历字符 */
    protected  int next_char;
    // 自cup v11以来，我们使用SymbolFactories而不是Symbols
    private  SymbolFactory sf = new DefaultSymbolFactory();

    /* 提前输入一个字符 */
    protected  void advance() throws java.io.IOException { next_char = System.in.read(); }

    /* 初始化扫描枪*/
    public  void init() throws java.io.IOException { advance(); }

    /* 识别并返回下一个完整的标记 */
    @Override
    public  java_cup.runtime.Symbol next_token() throws java.io.IOException {
        for (;;) {
            switch (next_char) {
                case '0': case '1': case '2': case '3': case '4':
                case '5': case '6': case '7': case '8': case '9':
                /* 十进制数解析 */
                int i_val = 0;
                do {
                    i_val = i_val * 10 + (next_char - '0');
                    advance();
                } while (next_char >= '0' && next_char <= '9');
                return sf.newSymbol("NUMBER",Symbol.NUMBER, new Integer(i_val));

                case ';': advance(); return sf.newSymbol("SEMI", sym.SEMI);
                case '+': advance(); return sf.newSymbol("PLUS", Symbol.PLUS);
                case '-': advance(); return sf.newSymbol("MINUS", Symbol.MINUS);
                case '*': advance(); return sf.newSymbol("TIMES",Symbol.TIMES);
                case '/': advance(); return sf.newSymbol("DIVIDE",Symbol.DIVIDE);
                case '%': advance(); return sf.newSymbol("MOD", Symbol.MOD);
                case '(': advance(); return sf.newSymbol("LPAREN", Symbol.LPAREN);
                case ')': advance(); return sf.newSymbol("RPAREN", Symbol.RPAREN);

                case -1: return sf.newSymbol("EOF",sym.EOF);

                default:
                    /* 忽略*/
                    advance();
                    break;
            }
        }
    }
}
