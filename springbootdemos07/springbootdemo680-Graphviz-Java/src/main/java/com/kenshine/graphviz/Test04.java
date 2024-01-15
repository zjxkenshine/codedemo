package com.kenshine.graphviz;

import guru.nidi.graphviz.attribute.Image;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.attribute.Size;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizCmdLineEngine;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

/**
 * @author by kenshine
 * @Classname Test04
 * @Description 设置背景图片
 * @Date 2024-01-15 11:20
 * @modified By：
 * @version: 1.0$
 *
 * 测试未通过
 */
public class Test04 {

    /**
     * 引入图片方式1
     */
    @Test
    public void test01() throws IOException {
        Graphviz.useEngine(new GraphvizCmdLineEngine());
        Graphviz g = Graphviz.fromGraph(graph()
                .with(node(Label.html("<table border='0'><tr><td><img src='graphviz.png' /></td></tr></table>"))));
        g.basedir(new File("example")).render(Format.PNG).toFile(new File("example/ex4.png"));
    }

    /**
     * 引入图片方式2
     */
    @Test
    public void test02() throws IOException {
        Graphviz g = Graphviz.fromGraph(graph()
                .with(node(" ").with(Size.std().margin(.8, .7), Image.of("src/main/resources/graphviz.png"))));
        g.basedir(new File("example")).render(Format.PNG).toFile(new File("example/ex4-1.png"));
    }


}
