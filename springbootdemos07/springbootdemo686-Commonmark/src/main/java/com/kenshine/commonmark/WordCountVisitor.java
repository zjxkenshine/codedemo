package com.kenshine.commonmark;

import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Text;

/**
 * visitor节点处理
 * 统计字符个数
 * @author kenshine
 */
public class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        wordCount += text.getLiteral().split("\\W+").length;
        visitChildren(text);
    }
}