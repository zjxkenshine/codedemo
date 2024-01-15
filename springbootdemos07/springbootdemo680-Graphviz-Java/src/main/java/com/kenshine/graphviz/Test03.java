package com.kenshine.graphviz;

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.Node;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Rank.RankDir.*;
import static guru.nidi.graphviz.attribute.Records.*;
import static guru.nidi.graphviz.model.Compass.*;
import static guru.nidi.graphviz.model.Factory.*;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 复杂使用
 * @Date 2024-01-15 11:14
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {
    /**
     * 复杂示例
     */
    @Test
    public void test01() throws IOException {
        Node main = node("main").with(Label.html("<b>main</b><br/>start"), Color.rgb("1020d0").font()),
                init = node(Label.markdown("**_init_**")),
                execute = node("execute"),
                compare = node("compare").with(Shape.RECTANGLE, Style.FILLED, Color.hsv(.7, .3, 1.0)),
                mkString = node("mkString").with(Label.lines(Label.Justification.LEFT, "make", "a", "multi-line")),
                printf = node("printf");

        Graph g = graph("example2").directed().with(
                main.link(
                        to(node("parse").link(execute)).with(LinkAttr.weight(8)),
                        to(init).with(Style.DOTTED),
                        node("cleanup"),
                        to(printf).with(Style.BOLD, Label.of("100 times"), Color.RED)),
                execute.link(
                        graph().with(mkString, printf),
                        to(compare).with(Color.RED)),
                init.link(mkString));
        Graphviz.fromGraph(g).width(900).render(Format.PNG).toFile(new File("example/ex3.png"));
    }

    /**
     * recode节点
     */
    @Test
    public void test02() throws IOException {
        Node
                node0 = node("node0").with(Records.of(rec("f0", ""), rec("f1", ""), rec("f2", ""), rec("f3", ""), rec("f4", ""))),
                node1 = node("node1").with(Records.of(turn(rec("n4"), rec("v", "719"), rec("")))),
                node2 = node("node2").with(Records.of(turn(rec("a1"), rec("805"), rec("p", "")))),
                node3 = node("node3").with(Records.of(turn(rec("i9"), rec("718"), rec("")))),
                node4 = node("node4").with(Records.of(turn(rec("e5"), rec("989"), rec("p", "")))),
                node5 = node("node5").with(Records.of(turn(rec("t2"), rec("v", "959"), rec("")))),
                node6 = node("node6").with(Records.of(turn(rec("o1"), rec("794"), rec("")))),
                node7 = node("node7").with(Records.of(turn(rec("s7"), rec("659"), rec(""))));
        Graph g = graph("example3").directed()
                .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                .with(
                        node0.link(
                                between(port("f0"), node1.port("v", SOUTH)),
                                between(port("f1"), node2.port(WEST)),
                                between(port("f2"), node3.port(WEST)),
                                between(port("f3"), node4.port(WEST)),
                                between(port("f4"), node5.port("v", NORTH))),
                        node2.link(between(port("p"), node6.port(NORTH_WEST))),
                        node4.link(between(port("p"), node7.port(SOUTH_WEST))));
        Graphviz.fromGraph(g).width(900).render(Format.PNG).toFile(new File("example/ex3-1.png"));
    }
}
