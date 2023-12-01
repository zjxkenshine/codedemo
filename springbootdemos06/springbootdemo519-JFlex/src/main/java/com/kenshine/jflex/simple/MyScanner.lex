/* JFlex Scanner for CUP example. */
import java_cup.runtime.*;
%%
%class MyScanner
%cupsym MySymbol
%cup
%unicode
%line
%column
%{
private Symbol symbol(int type) {
return new Symbol(type, yyline, yycolumn);
}
private Symbol symbol(int type, Object value) {
return new Symbol(type, yyline, yycolumn, value);
}
%}

WhiteSpace = [ \t\f\r\n]
Number = [0-9]+
%%
";" { return symbol(MySymbol.SEMI); }
"+" { return symbol(MySymbol.PLUS); }
"-" { return symbol(MySymbol.MINUS); }
"*" { return symbol(MySymbol.TIMES); }
"/" { return symbol(MySymbol.DIVIDE); }
"%" { return symbol(MySymbol.MOD); }
"(" { return symbol(MySymbol.LPAREN); }
")" { return symbol(MySymbol.RPAREN); }
{Number} { return symbol(MySymbol.NUMBER, new Integer(yytext()) ); }
{WhiteSpace} { /* ignore */ }
. { return symbol(MySymbol.ERROR, yytext()); }

<<EOF>>		{ return symbol( MySymbol.EOF ); }