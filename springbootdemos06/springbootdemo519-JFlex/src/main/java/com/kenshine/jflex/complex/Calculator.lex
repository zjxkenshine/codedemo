import java.io.*;
import java_cup.runtime.*;

%%

%public
%type		Symbol
%char


%{
	private int lineNumber = 1;
	public int lineNumber() { return lineNumber; }
	
    private Symbol token(int type) {
        return new Symbol(type);
    }
    private Symbol token(int type, Object value) {
        return new Symbol(type);
    }
%}

number		=	[0-9]+
ident		=	[A-Za-z][A-Za-z0-9]*
space		=	[\ \t]
newline		=	\r|\n|\r\n

%%

"="			{ return token( MySymbol.ASSIGN ); }
"+"			{ return token( MySymbol.PLUS ); }
"-"			{ return token( MySymbol.MINUS ); }
"*"			{ return token( MySymbol.TIMES ); }
"/"			{ return token( MySymbol.DIVIDE ); }
"("			{ return token( MySymbol.LEFT ); }
")"			{ return token( MySymbol.RIGHT ); }
{newline}	{ lineNumber++; return token( MySymbol.NEWLINE ); }
{space}		{ }

{number}	{ return token( MySymbol.NUMBER, new Integer(yytext()) ); }
{ident}		{ return token( MySymbol.IDENT,  yytext()); }

.			{ return token( MySymbol.error ); }
<<EOF>>		{ return token( MySymbol.EOF ); }