package com.kenshine.xchart;

import org.junit.Test;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author by kenshine
 * @Classname XchartTest01
 * @Description XChart使用示例
 * @Date 2024-03-10 14:07
 * @modified By：
 * @version: 1.0$
 */
public class XchartTest01 {

    /**
     * 入门使用 QuickChart创建
     */
    @Test
    public void test01() throws InterruptedException, IOException {
        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };
        // 创建chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
        // 显示
        new SwingWrapper(chart).displayChart();
        // 保存方式1
        BitmapEncoder.saveBitmap(chart, "img\\Sample_Chart", BitmapEncoder.BitmapFormat.PNG);
        // 保存方式2 设置DPI
        BitmapEncoder.saveBitmapWithDPI(chart, "img\\Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);
        Thread.sleep(5000);
    }

    /**
     * XYChartBuilder创建并设置样式
     */
    @Test
    public void test() throws InterruptedException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(600).height(500).title("Gaussian Blobs").xAxisTitle("X").yAxisTitle("Y").build();

        // 自定义表格样式
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);

        // 数据
        chart.addSeries("Gaussian Blob 1", getGaussian(1000, 1, 10), getGaussian(1000, 1, 10));
        XYSeries series = chart.addSeries("Gaussian Blob 2", getGaussian(1000, 1, 10), getGaussian(1000, 0, 5));
        series.setMarker(SeriesMarkers.DIAMOND);

        new SwingWrapper(chart).displayChart();
        Thread.sleep(5000);
    }

    /**
     * 高级用法，创建并嵌入swing程序
     */
    @Test
    public void test03() throws InterruptedException {
        // 创建chart
        final XYChart chart = new XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build();

        // 自定义Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);

        // 序列
        chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
        chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
        chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });

        // 创建并显示此应用程序的GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // 创建并设置窗口
                JFrame frame = new JFrame("Advanced Example");
                frame.setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // chart
                JPanel chartPanel = new XChartPanel<>(chart);
                frame.add(chartPanel, BorderLayout.CENTER);
                // 标签
                JLabel label = new JLabel("Blah blah blah.", SwingConstants.CENTER);
                frame.add(label, BorderLayout.SOUTH);
                // 显示
                frame.pack();
                frame.setVisible(true);
            }
        });
        Thread.sleep(5000);
    }



    static final Random random = new Random();
    private static List<Double> getGaussian(int number, double mean, double std) {
        List<Double> seriesData = new LinkedList<Double>();
        for (int i = 0; i < number; i++) {
            seriesData.add(mean + std * random.nextGaussian());
        }

        return seriesData;
    }
}
