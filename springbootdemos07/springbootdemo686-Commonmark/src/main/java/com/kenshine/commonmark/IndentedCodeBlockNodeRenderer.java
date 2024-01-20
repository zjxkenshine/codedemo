package com.kenshine.commonmark;

import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;

import java.util.Collections;
import java.util.Set;

/**
 * 自定义HTML渲染
 * @author kenshine
 */
public class IndentedCodeBlockNodeRenderer implements NodeRenderer {

    private final HtmlWriter html;

    IndentedCodeBlockNodeRenderer(HtmlNodeRendererContext context) {
        this.html = context.getWriter();
    }

    @Override
    public Set<Class<? extends Node>> getNodeTypes() {
        return Collections.<Class<? extends Node>>singleton(IndentedCodeBlock.class);
    }

    @Override
    public void render(Node node) {
        IndentedCodeBlock codeBlock = (IndentedCodeBlock) node;
        html.line();
        html.tag("pre");
        html.text(codeBlock.getLiteral());
        html.tag("/pre");
        html.line();
    }
}