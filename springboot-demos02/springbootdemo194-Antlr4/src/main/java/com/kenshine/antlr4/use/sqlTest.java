package com.kenshine.antlr4.use;

import com.kenshine.antlr4.demo.DslLexer;
import com.kenshine.antlr4.demo.DslParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 12:19
 * @description：sql语法规则测试
 * @modified By：
 * @version: $
 */
public class sqlTest {
    public static void main(String[] args) {
        String sql= "Select 'abc' as a, `hahah` as c  From a aS table;";
        //将输入转成antlr的input流
        CodePointCharStream input = CharStreams.fromString(sql);
        //词法分析
        DslLexer lexer = new DslLexer(input);
        //转成token流
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 语法分析
        DslParser parser = new DslParser(tokens);
        //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
        DslParser.StaContext tree = parser.sta();
        //打印规则树
        System.out.println(tree.toStringTree(parser));
    }
}
