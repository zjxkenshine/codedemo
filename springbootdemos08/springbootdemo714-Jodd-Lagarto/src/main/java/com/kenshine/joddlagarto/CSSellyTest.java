package com.kenshine.joddlagarto;

import jodd.csselly.CSSelly;
import jodd.csselly.CssSelector;
import jodd.csselly.selector.PseudoClassSelector;
import jodd.csselly.selector.PseudoFunctionSelector;
import jodd.lagarto.dom.Document;
import jodd.lagarto.dom.LagartoDOMBuilder;
import jodd.lagarto.dom.Node;
import jodd.lagarto.dom.NodeSelector;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname CSSellyTest
 * @Description Csscss选择器支持
 * @Date 2024-02-28 13:00
 * @modified By：
 * @version: 1.0$
 */
public class CSSellyTest {

    /**
     * 简单使用
     */
    @Test
    public void test01(){
        CSSelly csselly = new CSSelly("div:nth-child(2n) span#jodd");
        List<CssSelector> selectors = csselly.parse();
        System.out.println(selectors);

        Document document = new LagartoDOMBuilder()
                .parse("<html><h1>Hello</h1></html>");
        NodeSelector nodeSelector = new NodeSelector(document);
        List<Node> selectedNodes = nodeSelector.select("div#jodd li");
        System.out.println(selectedNodes);
    }

    /**
     * 自定义伪类
     */
    @Test
    public void test02(){
        PseudoClassSelector.registerPseudoClass(MyPseudoClass.class);
    }

    /**
     * 自定义伪方法
     */
    @Test
    public void test03(){
        PseudoFunctionSelector.registerPseudoFunction(MyPseudoFunction.class);
    }


}
