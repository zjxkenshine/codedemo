// Generated from F:/IDEAworkespace/codedemo/springboot-demos02/springbootdemo194-Antlr4/src/main/resources\Dsl.g4 by ANTLR 4.9.2
        //一种action,定义生成的词法语法解析文件的头，当使用java的时候，生成的类需要包名，可以在这里统一定义
 package com.kenshine.antlr4.demo;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, AS=3, LOAD=4, SELECT=5, STRING=6, IDENTIFIER=7, BACKQUOTED_IDENTIFIER=8, 
		SIMPLE_COMMENT=9, BRACKETED_EMPTY_COMMENT=10, BRACKETED_COMMENT=11, WS=12, 
		UNRECOGNIZED=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "AS", "LOAD", "SELECT", "DIGIT", "LETTER", "STRING", 
			"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
			"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", null, null, null, null, null, null, null, "'/**/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "AS", "LOAD", "SELECT", "STRING", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", 
			"SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", 
			"UNRECOGNIZED"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dsl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\7\t=\n\t\f\t\16\t@\13\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"G\n\t\f\t\16\tJ\13\t\3\t\5\tM\n\t\3\n\3\n\3\n\6\nR\n\n\r\n\16\nS\3\13"+
		"\3\13\3\13\3\13\7\13Z\n\13\f\13\16\13]\13\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\7\fe\n\f\f\f\16\fh\13\f\3\f\5\fk\n\f\3\f\5\fn\n\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16~\n\16\f\16\16\16\u0081"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\17\6\17\u0089\n\17\r\17\16\17\u008a"+
		"\3\17\3\17\3\20\3\20\3\177\2\21\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23"+
		"\t\25\n\27\13\31\f\33\r\35\16\37\17\3\2\22\4\2CCcc\4\2UUuu\4\2NNnn\4\2"+
		"QQqq\4\2FFff\4\2GGgg\4\2EEee\4\2VVvv\3\2\62;\4\2C\\c|\4\2))^^\4\2$$^^"+
		"\3\2bb\4\2\f\f\17\17\3\2--\5\2\13\f\17\17\"\"\2\u009c\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t(\3\2\2\2\13-\3\2\2\2\r"+
		"\64\3\2\2\2\17\66\3\2\2\2\21L\3\2\2\2\23Q\3\2\2\2\25U\3\2\2\2\27`\3\2"+
		"\2\2\31q\3\2\2\2\33x\3\2\2\2\35\u0088\3\2\2\2\37\u008e\3\2\2\2!\"\7=\2"+
		"\2\"\4\3\2\2\2#$\7\60\2\2$\6\3\2\2\2%&\t\2\2\2&\'\t\3\2\2\'\b\3\2\2\2"+
		"()\t\4\2\2)*\t\5\2\2*+\t\2\2\2+,\t\6\2\2,\n\3\2\2\2-.\t\3\2\2./\t\7\2"+
		"\2/\60\t\4\2\2\60\61\t\7\2\2\61\62\t\b\2\2\62\63\t\t\2\2\63\f\3\2\2\2"+
		"\64\65\t\n\2\2\65\16\3\2\2\2\66\67\t\13\2\2\67\20\3\2\2\28>\7)\2\29=\n"+
		"\f\2\2:;\7^\2\2;=\13\2\2\2<9\3\2\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3"+
		"\2\2\2?A\3\2\2\2@>\3\2\2\2AM\7)\2\2BH\7$\2\2CG\n\r\2\2DE\7^\2\2EG\13\2"+
		"\2\2FC\3\2\2\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2"+
		"\2\2KM\7$\2\2L8\3\2\2\2LB\3\2\2\2M\22\3\2\2\2NR\5\17\b\2OR\5\r\7\2PR\7"+
		"a\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\24"+
		"\3\2\2\2U[\7b\2\2VZ\n\16\2\2WX\7b\2\2XZ\7b\2\2YV\3\2\2\2YW\3\2\2\2Z]\3"+
		"\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7b\2\2_\26\3\2\2\2"+
		"`a\7/\2\2ab\7/\2\2bf\3\2\2\2ce\n\17\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2"+
		"fg\3\2\2\2gj\3\2\2\2hf\3\2\2\2ik\7\17\2\2ji\3\2\2\2jk\3\2\2\2km\3\2\2"+
		"\2ln\7\f\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\f\2\2p\30\3\2\2\2qr\7\61"+
		"\2\2rs\7,\2\2st\7,\2\2tu\7\61\2\2uv\3\2\2\2vw\b\r\2\2w\32\3\2\2\2xy\7"+
		"\61\2\2yz\7,\2\2z{\3\2\2\2{\177\n\20\2\2|~\13\2\2\2}|\3\2\2\2~\u0081\3"+
		"\2\2\2\177\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0082\u0083\7,\2\2\u0083\u0084\7\61\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\b\16\2\2\u0086\34\3\2\2\2\u0087\u0089\t\21\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\b\17\2\2\u008d\36\3\2\2\2\u008e\u008f\13\2"+
		"\2\2\u008f \3\2\2\2\21\2<>FHLQSY[fjm\177\u008a\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}