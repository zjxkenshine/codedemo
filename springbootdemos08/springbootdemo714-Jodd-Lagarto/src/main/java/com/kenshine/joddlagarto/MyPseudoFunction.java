package com.kenshine.joddlagarto;

import jodd.csselly.selector.PseudoFunction;
import jodd.lagarto.dom.Node;

public class MyPseudoFunction extends PseudoFunction {
    /**
     * 解析表达式
     */
    @Override
    public Object parseExpression(String expression) {
        return Integer.valueOf(expression);
    }

    @Override
    public boolean match(Node node, Object expression) {
        Integer size = (Integer) expression;
        return node.getNodeName().length() == size.intValue();
    }

    @Override
    public String getPseudoFunctionName() {
        return "len-fn";
    }
}