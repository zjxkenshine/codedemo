package com.kenshine.graphviz;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 解析
 * @Date 2024-01-15 11:08
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {

    /**
     * 解析dot文件
     */
    @Test
    public void test01(){
        try (InputStream dot = new FileInputStream("dot\\color.dot")) {
            MutableGraph g = new Parser().read(dot);
            Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("example/ex2-1.png"));
            // 处理
            g.graphAttrs()
                    .add(Color.WHITE.gradient(Color.rgb("888888")).background().angle(90))
                    .nodeAttrs().add(Color.WHITE.fill())
                    .nodes().forEach(node ->
                    node.add(
                            Color.named(node.name().toString()),
                            Style.lineWidth(4), Style.FILLED));
            Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("example/ex2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
