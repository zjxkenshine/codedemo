package com.kenshine.antlr4.use.loadTest;

import com.kenshine.antlr4.demo.DslBaseListener;
import com.kenshine.antlr4.demo.DslLexer;
import com.kenshine.antlr4.demo.DslParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 12:28
 * @description：监听器
 * @modified By：
 * @version: $
 */
public class ParseListener extends DslBaseListener {
    @Override
    public void enterSql(DslParser.SqlContext ctx) {
        //获取sql规则的第一个元素，为select或者load
        String keyword = ctx.children.get(0).getText();
        if("select".equalsIgnoreCase(keyword)){
            //第一个元素为selece的时候执行select
            execSelect(ctx);
        }else if("load".equalsIgnoreCase(keyword)){
            //第一个元素为load的时候执行load
            execLoad(ctx);
        }

    }
    public void execLoad(DslParser.SqlContext ctx){
        //获取该规则树的所有子节点
        List<ParseTree> children = ctx.children;
        String format = "";
        String path = "";
        String tableName = "";
        for (ParseTree c :children) {
            if(c instanceof DslParser.FormatContext){
                format = c.getText();
            }else if(c instanceof DslParser.PathContext){
                path = c.getText().substring(1,c.getText().length()-1);
            }else if(c instanceof DslParser.TableNameContext){
                tableName = c.getText();
            }
        }
        System.out.println(format);
        System.out.println(path);
        System.out.println(tableName);
        // spark load实现，省略
    }

    public void execSelect(DslParser.SqlContext ctx){

    }

    public static void main(String[] args) throws IOException {
        String len = "load json.`F:\\tmp\\user` as temp;";
        CodePointCharStream input = CharStreams.fromString(len);
        DslLexer lexer = new DslLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        DslParser.SqlContext tree = parser.sql();
        ParseListener listener = new ParseListener();
        //规则树遍历
        ParseTreeWalker.DEFAULT.walk(listener,tree);
    }
}
