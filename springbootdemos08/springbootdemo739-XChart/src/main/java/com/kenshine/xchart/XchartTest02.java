package com.kenshine.xchart;

import org.junit.Test;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author by kenshine
 * @Classname XchartTest02
 * @Description 各种图表
 * @Date 2024-03-10 14:33
 * @modified By：
 * @version: 1.0$
 */
public class XchartTest02 {

    /**
     * 柱状图
     */
    @Test
    public void test01() throws InterruptedException {
        CategoryChart chart =
                new CategoryChartBuilder()
                        .width(800)
                        .height(600)
                        .title("Score Histogram")
                        .xAxisTitle("Score")
                        .yAxisTitle("Number")
                        .build();
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.addSeries("test 1", Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 5, 9, 6, 5));
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 区域折线图
     */
    @Test
    public void test02() throws InterruptedException {
        XYChart chart =
                new XYChartBuilder()
                        .width(800)
                        .height(600)
                        .title(getClass().getSimpleName())
                        .xAxisTitle("X")
                        .yAxisTitle("Y")
                        .build();
        // 样式
        chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
        chart.getStyler().setAxisTitlesVisible(false);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);
        // 数据
        chart.addSeries("a", new double[] {0, 3, 5, 7, 9}, new double[] {-3, 5, 9, 6, 5});
        chart.addSeries("b", new double[] {0, 2, 4, 6, 9}, new double[] {-1, 6, 4, 0, 4});
        chart.addSeries("c", new double[] {0, 1, 3, 8, 9}, new double[] {-2, -1, 1, 0, 1});
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 气泡图
     */
    @Test
    public void test03() throws InterruptedException {
        BubbleChart chart =
                new BubbleChartBuilder()
                        .width(800)
                        .height(600)
                        .title("BubbleChart01")
                        .xAxisTitle("X")
                        .yAxisTitle("Y")
                        .build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideN);
        chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);
        double[] xData = new double[] {1.5, 2.6, 3.3, 4.9, 5.5, 6.3, 1, 2.0, 3.0, 4.0, 5, 6};
        double[] yData = new double[] {10, 4, 7, 7.7, 7, 5.5, 10, 4, 7, 1, 7, 9};
        double[] bubbleData = new double[] {17, 40, 50, 51, 26, 20, 66, 35, 80, 27, 29, 44};

        double[] xData2 = new double[] {1, 2.0, 3.0, 4.0, 5, 6, 1.5, 2.6, 3.3, 4.9, 5.5, 6.3};
        double[] yData2 = new double[] {1, 2, 3, 4, 5, 6, 10, 8.5, 4, 1, 4.7, 9};
        double[] bubbleData2 = new double[] {37, 35, 80, 27, 29, 44, 57, 40, 50, 33, 26, 20};

        chart.addSeries("A", xData, yData, bubbleData);
        chart.addSeries("B", xData2, yData2, bubbleData2);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 时序图
     */
    @Test
    public void test04() throws InterruptedException {
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Millisecond Scale").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
        chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);
        Random random = new Random();
        List<Date> xData1 = new ArrayList<Date>();
        List<Double> yData1 = new ArrayList<Double>();
        List<Date> xData2 = new ArrayList<Date>();
        List<Double> yData2 = new ArrayList<Double>();

        DateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
        Date date = null;
        for (int i = 1; i <= 14; i++) {
            try {
                date = sdf.parse("23:45:31." + (100 * i + random.nextInt(20)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            xData1.add(date);
            xData2.add(date);
            yData1.add(Math.random() * i);
            yData2.add(Math.random() * i * 100);
        }
        XYSeries series = chart.addSeries("series 1", xData1, yData1);
        series.setMarker(SeriesMarkers.NONE);
        chart.addSeries("series 2", xData2, yData2).setMarker(SeriesMarkers.NONE).setYAxisGroup(1);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 仪表盘
     */
    @Test
    public void test05() throws InterruptedException {
        DialChart chart = new DialChartBuilder().width(800).height(600).title("Radar Chart").build();
        chart.addSeries("Rate", 0.9381, "93.81 %");
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setLegendVisible(false);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 折线图
     */
    @Test
    public void test06() throws InterruptedException {
        List<Integer> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        for (int i = -3; i <= 3; i++) {
            xData.add(i);
            yData.add(Math.pow(10, i));
        }
        XYChart chart =
                new XYChartBuilder()
                        .width(800)
                        .height(600)
                        .title("Powers of Ten")
                        .xAxisTitle("Power")
                        .yAxisTitle("Value")
                        .build();
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
        chart.getStyler().setYAxisLogarithmic(true);
        chart.getStyler().setXAxisLabelRotation(45);
        chart.addSeries("10^x", xData, yData);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * OHLC图
     */
    @Test
    public void test07() throws InterruptedException {
        OHLCChart chart = new OHLCChartBuilder().width(800).height(600).title("Prices").build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
        chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);

        List<Date> xData = new ArrayList<Date>();
        List<Double> openData = new ArrayList<Double>();
        List<Double> highData = new ArrayList<Double>();
        List<Double> lowData = new ArrayList<Double>();
        List<Double> closeData = new ArrayList<Double>();

        populateData(xData, openData, highData, lowData, closeData);

        xData = null;
        chart.addSeries("Series", xData, openData, highData, lowData, closeData)
                .setOhlcSeriesRenderStyle(OHLCSeries.OHLCSeriesRenderStyle.HiLo);
        chart.getStyler().setToolTipsEnabled(true);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 饼图
     */
    @Test
    public void test08() throws InterruptedException {
        PieChart chart = new PieChartBuilder().width(800).height(600).title("Pie Chart with 4 Slices").build();
        chart.getStyler().setCircular(false);
        chart.addSeries("Pennies", 100);
        chart.addSeries("Nickels", 100);
        chart.addSeries("Dimes", 100);
        chart.addSeries("Quarters", 100);
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    /**
     * 雷达图
     */
    @Test
    public void test09() throws InterruptedException {
        RadarChart chart = new RadarChartBuilder().width(800).height(600).title("Radar Chart").build();
        chart.getStyler().setToolTipsEnabled(true);
        // 数据
        chart.setRadiiLabels(
                new String[] {
                        "Sales",
                        "Marketing",
                        "Development",
                        "Customer Support",
                        "Information Technology",
                        "Administration"
                });
        chart.addSeries(
                "Old System",
                new double[] {0.78, 0.85, 0.80, 0.82, 0.93, 0.92},
                new String[] {"Lowest varible 78%", "85%", null, null, null, null});
        chart.addSeries("New System", new double[] {0.67, 0.73, 0.97, 0.95, 0.93, 0.73});
        chart.addSeries("Experimental System", new double[] {0.37, 0.93, 0.57, 0.55, 0.33, 0.73});
        new SwingWrapper<>(chart).displayChart();
        Thread.sleep(3000);
    }

    public static void populateData(
            List<Date> xData,
            List<Double> openData,
            List<Double> highData,
            List<Double> lowData,
            List<Double> closeData) {
        // 生成数据
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2017-01-01");
            populateData(date, 5000.0, 20, xData, openData, highData, lowData, closeData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void populateData(
            Date startDate,
            double startPrice,
            int count,
            List<Date> xData,
            List<Double> openData,
            List<Double> highData,
            List<Double> lowData,
            List<Double> closeData) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        double data = startPrice;
        for (int i = 1; i <= count; i++) {

            // add 1 day
            // startDate = new Date(startDate.getTime() + (1 * 1000 * 60 * 60 * 24));
            // xData.add(startDate);
            cal.add(Calendar.DATE, 1);
            xData.add(cal.getTime());

            double previous = data;

            data = getNewClose(data, startPrice);

            openData.add(previous);

            highData.add(getHigh(Math.max(previous, data), startPrice));
            lowData.add(getLow(Math.min(previous, data), startPrice));

            closeData.add(data);
        }
    }

    private static double getHigh(double close, double orig) {
        return close + (orig * Math.random() * 0.02);
    }

    private static double getLow(double close, double orig) {
        return close - (orig * Math.random() * 0.02);
    }

    private static double getNewClose(double close, double orig) {
        return close + (orig * (Math.random() - 0.5) * 0.1);
    }
}
