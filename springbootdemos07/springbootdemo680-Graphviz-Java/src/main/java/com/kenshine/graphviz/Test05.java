package com.kenshine.graphviz;

import guru.nidi.graphviz.engine.*;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.SvgElementFinder;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

/**
 * @author by kenshine
 * @Classname Test05
 * @Description 配置
 * @Date 2024-01-15 11:32
 * @modified By：
 * @version: 1.0$
 */
public class Test05 {

    /**
     * 配置生成图像的大小、渲染引擎和输出格式
     */
    @Test
    public void test01() throws IOException {
        // Rasterizer.builtIn()只在CmdLineEngine工作
        Graphviz.useEngine(new GraphvizCmdLineEngine());
        Graph g = graph("example5").directed().with(node("abc").link(node("xyz")));
        Graphviz viz = Graphviz.fromGraph(g);
        viz.width(200).render(Format.SVG).toFile(new File("example/ex5.svg"));
        viz.width(200).rasterize(Rasterizer.BATIK).toFile(new File("example/ex5b.png"));
        viz.width(200).rasterize(Rasterizer.SALAMANDER).toFile(new File("example/ex5s.png"));
        viz.width(200).rasterize(Rasterizer.builtIn("pdf")).toFile(new File("example/ex5p"));
        String dot = viz.render(Format.DOT).toString();
        String json = viz.engine(Engine.NEATO).render(Format.JSON).toString();
        BufferedImage image = viz.render(Format.PNG).toImage();
    }

    /**
     * 注册处理器，以进一步自定义graphviz引擎的进出内容
     * preProcessor
     * postProcessor
     */
    @Test
    public void test02() throws IOException {
        Graph graph = graph().with(node("bad word").link("good word"));
        Graphviz g = Graphviz.fromGraph(graph)
                .preProcessor((source, options, processOptions) -> source.replace("bad word", "unicorn"))
                .postProcessor((result, options, processOptions) ->
                        result.mapString(svg ->
                                SvgElementFinder.use(svg, finder -> {
                                    Objects.requireNonNull(finder.findNode("unicorn")).setAttribute("class", "pink");
                                })));
        g.render(Format.PNG).toFile(new File("example/ex5-1.png"));
    }


}
