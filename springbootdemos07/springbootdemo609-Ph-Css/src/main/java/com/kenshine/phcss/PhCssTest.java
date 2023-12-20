package com.kenshine.phcss;

import com.helger.commons.io.file.SimpleFileIO;
import com.helger.commons.state.ESuccess;
import com.helger.css.ECSSVersion;
import com.helger.css.decl.*;
import com.helger.css.decl.shorthand.CSSShortHandDescriptor;
import com.helger.css.decl.shorthand.CSSShortHandRegistry;
import com.helger.css.property.ECSSProperty;
import com.helger.css.reader.CSSReader;
import com.helger.css.reader.CSSReaderDeclarationList;
import com.helger.css.writer.CSSWriter;
import com.helger.css.writer.CSSWriterSettings;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * @author by kenshine
 * @Classname PhCssTest
 * @Description phCss使用测试
 * @Date 2023-12-20 14:18
 * @modified By：
 * @version: 1.0$
 */
public class PhCssTest {

    /**
     * 从String读取
     */
    @Test
    public void test01(){
        //从String中读取
        CascadingStyleSheet styleSheet = CSSReader.readFromString("#div1{\n" +
                "    background-image:url('1.png');\n" +
                "    height:100px;\n" +
                "    width:100px;\n" +
                "}\n" +
                "#div2{\n" +
                "    background-image:url('2.png');\n" +
                "    height:100px;\n" +
                "    width:100px;\n" +
                "}", ECSSVersion.CSS30);
        System.out.println(styleSheet.getRuleAtIndex(0).getAsCSSString());
    }

    /**
     * 从文件中读取
     */
    @Test
    public void test02(){
        //从File中读取
        CascadingStyleSheet styleSheet = CSSReader.readFromFile(new File("css\\test.css"), StandardCharsets.UTF_8, ECSSVersion.CSS30);
        System.out.println(styleSheet.getRuleAtIndex(1).getAsCSSString());
    }

    /**
     * 遍历rule
     */
    @Test
    public void test03(){
        CascadingStyleSheet styleSheet = CSSReader.readFromFile(new File("css\\test.css"), StandardCharsets.UTF_8, ECSSVersion.CSS30);
        List<ICSSTopLevelRule> rules = styleSheet.getAllRules();
        for (ICSSTopLevelRule rule : rules) {
            if (rule instanceof CSSStyleRule){
                //处理styleRule
                System.out.println(rule.getAsCSSString());
            }
            if(!(rule instanceof CSSStyleRule)) {
                //处理其他rule
                System.out.println(rule.toString());
            }
        }
    }

    /**
     * 替换css内容
     */
    @Test
    public void test04(){
        CascadingStyleSheet styleSheet = CSSReader.readFromFile(new File("css\\test.css"), StandardCharsets.UTF_8, ECSSVersion.CSS30);
        ICSSTopLevelRule rule=styleSheet.getRuleAtIndex(0);
        //处理styleRule
        CSSStyleRule styleRule = (CSSStyleRule) rule;
        //获取所有declaration的方法
        CSSDeclaration cssDeclaration = styleRule.getDeclarationOfPropertyName("background-image");
        if (cssDeclaration != null) {
            CSSExpression expression = cssDeclaration.getExpression();
            expression.removeAllMembers();
            // 换成url('11.png')
            expression.addTermSimple("url('11.png')");
        }
        System.out.println(styleRule.getAsCSSString());
        System.out.println(cssDeclaration.getAsCSSString());
    }

    /**
     * CSSShortHandDescriptor 快速属性处理
     */
    @Test
    public void test05(){
        final CSSDeclaration aDecl = Objects.requireNonNull(CSSReaderDeclarationList.readFromString("border:1px dashed", ECSSVersion.CSS30)).getDeclarationAtIndex (0);
        // border属性处理
        final CSSShortHandDescriptor aSHD = CSSShortHandRegistry.getShortHandDescriptor(ECSSProperty.BORDER);
        final List <CSSDeclaration> aSplittedDecls = aSHD.getSplitIntoPieces (aDecl);
        for(CSSDeclaration cssDeclaration:aSplittedDecls){
            System.out.println(cssDeclaration.getAsCSSString());
        }
    }

    /**
     * 从HTML中读取
     */
    @Test
    public void test06(){
        final String sStyle = "color:red; background:fixed !important";
        final CSSDeclarationList aDeclList = CSSReaderDeclarationList.readFromString (sStyle, ECSSVersion.CSS30);
        if (aDeclList == null) {
            throw new IllegalStateException ("Failed to parse CSS: " + sStyle);
        }
        System.out.println(aDeclList.getAsCSSString());
    }

    /**
     * CSS文件写
     */
    @Test
    public void test07(){
        CascadingStyleSheet styleSheet = CSSReader.readFromFile(new File("css\\test.css"), StandardCharsets.UTF_8, ECSSVersion.CSS30);
        ICSSTopLevelRule rule=styleSheet.getRuleAtIndex(0);
        //处理styleRule
        CSSStyleRule styleRule = (CSSStyleRule) rule;
        //获取所有declaration的方法
        CSSDeclaration cssDeclaration = styleRule.getDeclarationOfPropertyName("background-image");
        if (cssDeclaration != null) {
            CSSExpression expression = cssDeclaration.getExpression();
            expression.removeAllMembers();
            // 换成url('11.png')
            expression.addTermSimple("url('11.png')");
        }
        // 输出css文件
        ESuccess eSuccess = writeCSS30(styleSheet,new File("css\\testout.css"));
        System.out.println(eSuccess.isSuccess());
    }

    /**
     * CSS文件输出
     */
    public ESuccess writeCSS30 (final CascadingStyleSheet aCSS, final File aFile) {
        // 版本，false==non-optimized
        final CSSWriterSettings aSettings = new CSSWriterSettings(ECSSVersion.CSS30, false);
        try {
            final CSSWriter aWriter = new CSSWriter (aSettings);
            // @charset规则
            aWriter.setContentCharset (StandardCharsets.UTF_8.name ());
            // header
            aWriter.setHeaderText ("This file was generated by kenshine");
            // 转换为String
            final String sCSSCode = aWriter.getCSSAsString (aCSS);
            // 写入到文件
            return SimpleFileIO.writeFile (aFile, sCSSCode, StandardCharsets.UTF_8);
        }catch (final Exception ex) {
            System.out.println("Failed to write the CSS to a file "+ex);
            return ESuccess.FAILURE;
        }
    }

}
