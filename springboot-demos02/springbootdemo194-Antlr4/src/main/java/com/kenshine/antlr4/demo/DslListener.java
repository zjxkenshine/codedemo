// Generated from F:/IDEAworkespace/codedemo/springboot-demos02/springbootdemo194-Antlr4/src/main/resources\Dsl.g4 by ANTLR 4.9.2
        //一种action,定义生成的词法语法解析文件的头，当使用java的时候，生成的类需要包名，可以在这里统一定义
 package com.kenshine.antlr4.demo;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DslParser}.
 */
public interface DslListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DslParser#sta}.
	 * @param ctx the parse tree
	 */
	void enterSta(DslParser.StaContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#sta}.
	 * @param ctx the parse tree
	 */
	void exitSta(DslParser.StaContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#ender}.
	 * @param ctx the parse tree
	 */
	void enterEnder(DslParser.EnderContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#ender}.
	 * @param ctx the parse tree
	 */
	void exitEnder(DslParser.EnderContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSql(DslParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSql(DslParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#as}.
	 * @param ctx the parse tree
	 */
	void enterAs(DslParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#as}.
	 * @param ctx the parse tree
	 */
	void exitAs(DslParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(DslParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(DslParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(DslParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(DslParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(DslParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(DslParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(DslParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(DslParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(DslParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DslParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(DslParser.QuotedIdentifierContext ctx);
}