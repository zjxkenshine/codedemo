package com.kenshine.graphviz;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Attributes.attr;
import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.*;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description  Graphviz画图
 * @Date 2024-01-15 10:32
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    /**
     * 使用示例1
     */
    @Test
    public void test01() throws IOException {
        Graph g = graph("example1").directed()
                // 全局属性设置使用 graphAttr、nodeAttr、linkAttr 方法
                .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                .nodeAttr().with(Font.name("arial"))
                .linkAttr().with("class", "link-class")
                .with(
                        node("a").with(Color.RED).link(node("b")),
                        node("b").link(
                                // 使用to方法设置边的样式 虚线
                                to(node("c")).with(attr("weight", 5), Style.DASHED)
                        )
                );
        Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("example/ex1.png"));
    }

    /**
     * 动态API使用
     */
    @Test
    public void test02() throws IOException {
        MutableGraph g = mutGraph("example1").setDirected(true).add(
                mutNode("a").add(Color.RED).addLink(mutNode("b")));
        Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example/ex1m.png"));
    }

    /**
     * 第三种方式
     */
    @Test
    public void test03() throws IOException {
        MutableGraph g = mutGraph("example1").setDirected(true).use((gr, ctx) -> {
            mutNode("b");
            nodeAttrs().add(Color.RED);
            mutNode("a").addLink(mutNode("b"));
        });
        Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example/ex1i.png"));
    }

}
