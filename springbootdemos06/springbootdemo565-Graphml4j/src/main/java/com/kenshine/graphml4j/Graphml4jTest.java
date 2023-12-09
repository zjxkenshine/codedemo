package com.kenshine.graphml4j;

import com.github.fritaly.graphml4j.GraphMLException;
import com.github.fritaly.graphml4j.GraphMLWriter;
import com.github.fritaly.graphml4j.datastructure.Graph;
import com.github.fritaly.graphml4j.datastructure.Node;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author by kenshine
 * @Classname Graphml4jTest
 * @Description 创建Graphml
 * @Date 2023-12-09 18:05
 * @modified By：
 * @version: 1.0$
 */
public class Graphml4jTest {

    /**
     * GraphMLWriter简单图生成
     */
    @Test
    public void test01() throws IOException, GraphMLException {
        final File file = new File("graph\\testp01.graphml");
        System.out.println("Writing GraphML file to " + file.getAbsolutePath() + " ...");

        // 此列表将存储添加到图中的节点的标识符
        final List<String> nodeIds = new ArrayList<>();
        final FileWriter fileWriter = new FileWriter(file);
        final GraphMLWriter graphWriter = new GraphMLWriter(fileWriter);
        try {
            // 打开图
            graphWriter.graph();
            // 生成3组（节点），每组5个节点
            for (int i = 0; i < 3; i++) {
                // 随机决定组应呈现为打开还是关闭
                final boolean open = new Random().nextBoolean();
                // 打开一组新的节点
                graphWriter.group(String.format("Group #%d", i + 1), open);
                // 向组中添加5个节点
                for (int j = 0; j < 5; j++) {
                    nodeIds.add(graphWriter.node(String.format("N%d", (i * 5) + j + 1)));
                }
                // 关闭组
                graphWriter.closeGroup();
            }
            // 在节点之间随机生成15条边
            for (int i = 0; i < 15; i++) {
                Collections.shuffle(nodeIds);
                graphWriter.edge(nodeIds.get(0), nodeIds.get(1));
            }
            // 关闭图
            graphWriter.closeGraph();
            System.out.println("Done");
        }finally {
            // 必须关闭
            graphWriter.close();
            fileWriter.close();
        }
    }


    /**
     * FileWriter创建图
     */
    @Test
    public void test02() throws GraphMLException, IOException {
        final File file = new File("graph\\testp02.graphml");
        System.out.println("Writing GraphML file to " + file.getAbsolutePath() + " ...");
        final FileWriter fileWriter = new FileWriter(file);
        final Graph graph = new Graph();
        try {
            // 3组每组5节点
            for (int i = 0; i < 3; i++) {
                final Node groupNode = graph.addNode(String.format("Group #%d", i + 1));
                for (int j = 0; j < 5; j++) {
                    graph.addNode(String.format("N%d", (i * 5) + j + 1)).setParent(groupNode);
                }
            }
            final List<Node> nodes = graph.getNodes();
            for (int i = 0; i < 15; i++) {
                Collections.shuffle(nodes);
                graph.addEdge("Depends on", nodes.get(0), nodes.get(1));
            }
            graph.toGraphML(fileWriter);
            System.out.println("Done");
        }finally {
            fileWriter.close();
        }
    }
}
