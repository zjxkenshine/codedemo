package com.kenshine.joddlagarto;

import jodd.csselly.selector.PseudoClass;
import jodd.lagarto.dom.Node;

/**
 * 自定义选择器类
 * @author Administrator
 */
public class MyPseudoClass extends PseudoClass {
    @Override
    public boolean match(Node node) {
      return node.hasAttribute("jodd-attr");
    }

    @Override
    public String getPseudoClassName() {
      return "jodd";
    }
}