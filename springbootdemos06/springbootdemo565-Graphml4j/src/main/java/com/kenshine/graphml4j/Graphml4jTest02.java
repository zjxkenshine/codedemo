package com.kenshine.graphml4j;

import com.github.fritaly.graphml4j.EdgeStyle;
import com.github.fritaly.graphml4j.GraphMLWriter;
import com.github.fritaly.graphml4j.NodeStyle;
import com.github.fritaly.graphml4j.yed.*;
import com.github.fritaly.graphml4j.yed.Shape;
import org.junit.Test;


import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author by kenshine
 * @Classname Graphml4jTest02
 * @Description 图样式
 * @Date 2023-12-09 18:18
 * @modified By：
 * @version: 1.0$
 */
public class Graphml4jTest02 {

    private static void customizeEdges(GraphMLWriter graphWriter) {
        // 创建新的默认边样式并进行自定义
        final EdgeStyle edgeStyle = EdgeStyle.builder()
                .color(Color.BLUE)
                .smoothed(true)
                .sourceArrow(Arrow.CIRCLE)
                .targetArrow(Arrow.DELTA)
                .type(LineType.DASHED)
                .width(2.0f)
                .build();

        // 添加到图形的所有后续边都将使用此样式
        graphWriter.setEdgeStyle(edgeStyle);
    }

    private static void customizeNodes(GraphMLWriter graphWriter) {
        // 创建新的默认节点样式并进行自定义
        final NodeStyle nodeStyle = new NodeStyle();
        nodeStyle.setBackgroundColor(Color.BLACK);
        nodeStyle.setBorderColor(Color.BLACK);
        nodeStyle.setBorderDistance(5.0f);
        nodeStyle.setBorderType(LineType.LINE);
        nodeStyle.setBorderWidth(2.0f);
        nodeStyle.setFillColor(Color.ORANGE);
        nodeStyle.setFontFamily("Arial");
        nodeStyle.setFontSize(14);
        nodeStyle.setFontStyle(FontStyle.BOLD_AND_ITALIC);
        nodeStyle.setHeight(100.0f);
        nodeStyle.setInsets(10);
        nodeStyle.setPlacement(Placement.INTERNAL);
        nodeStyle.setPosition(Position.TOP);
        nodeStyle.setRotationAngle(0.0f);
        nodeStyle.setShadowColor(Color.ORANGE.darker());
        nodeStyle.setShadowOffsetX(5);
        nodeStyle.setShadowOffsetY(5);
        nodeStyle.setShape(Shape.ROUNDED_RECTANGLE);
        nodeStyle.setSizePolicy(SizePolicy.NODE_WIDTH);
        nodeStyle.setTextAlignment(Alignment.LEFT);
        nodeStyle.setTextColor(Color.WHITE);
        nodeStyle.setUnderlinedText(true);
        nodeStyle.setVisible(true);
        nodeStyle.setWidth(100.0f);

        // 添加到图形中的所有后续节点都将使用此样式
        graphWriter.setNodeStyle(nodeStyle);
    }

    /**
     * 定义节点和边的样式
     */
    @Test
    public void test() throws Exception {
        final File file = new File("graph\\testp03.graphml");
        System.out.println("Writing GraphML file to " + file.getAbsolutePath() + " ...");
        final List<String> nodeIds = new ArrayList<>();
        final FileWriter fileWriter = new FileWriter(file);
        final GraphMLWriter graphWriter = new GraphMLWriter(fileWriter);
        try {
            graphWriter.graph();
            // 定义图样式
            customizeEdges(graphWriter);
            customizeNodes(graphWriter);

            for (int i = 0; i < 3; i++) {
                final boolean open = new Random().nextBoolean();
                graphWriter.group(String.format("Group #%d", i + 1), open);
                for (int j = 0; j < 5; j++) {
                    nodeIds.add(graphWriter.node(String.format("N%d", (i * 5) + j + 1)));
                }
                graphWriter.closeGroup();
            }

            for (int i = 0; i < 15; i++) {
                Collections.shuffle(nodeIds);
                graphWriter.edge(nodeIds.get(0), nodeIds.get(1));
            }
            graphWriter.closeGraph();
            System.out.println("Done");
        } finally {
            graphWriter.close();
            fileWriter.close();
        }
    }
}
