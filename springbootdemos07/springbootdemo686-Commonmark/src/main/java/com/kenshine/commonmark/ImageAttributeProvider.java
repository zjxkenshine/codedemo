package com.kenshine.commonmark;

import org.commonmark.node.Image;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.AttributeProvider;

import java.util.Map;

/**
 * Provider HTML属性设置
 * @author kenshine
 */
public class ImageAttributeProvider implements AttributeProvider {
    @Override
    public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
        if (node instanceof Image) {
            attributes.put("class", "border");
        }
    }
}
