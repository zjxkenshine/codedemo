package com.kenshine.symbolsolver.learn.support;

import com.github.javaparser.ast.Node;

/**
 * 节点遍历 方式
 * @author kenshine
 */
public class NodeIterator {
    public interface NodeHandler {
        boolean handle(Node node);
    }
    private NodeHandler nodeHandler;
    public NodeIterator(NodeHandler nodeHandler) {
        this.nodeHandler = nodeHandler;
    }
    public void explore(Node node) {
        if (nodeHandler.handle(node)) {
            for (Node child : node.getChildNodes()) {
                explore(child);
            }
        }else{
            System.out.println(node);
        }
    }
}