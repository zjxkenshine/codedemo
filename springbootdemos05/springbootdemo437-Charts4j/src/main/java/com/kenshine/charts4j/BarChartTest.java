package com.kenshine.charts4j;

import com.googlecode.charts4j.*;
import org.junit.Test;

import java.util.logging.Logger;

import static com.googlecode.charts4j.Color.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/29 15:09
 * @description：
 * @modified By：
 * @version: $
 * 更多示例：https://github.com/julienchastang/charts4j/blob/master/src/test/java/com/googlecode/charts4j/example
 */
public class BarChartTest {
    @Test
    public void testNoLabel() {
        final BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE);
        final BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        final BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
    }

    @Test
    public void test0() {
        final BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        final BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        final BarChart chart = GCharts.newBarChart(data1, data2);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2000", "2001", "2002", "2003"));
        chart.addYAxisLabels((AxisLabelsFactory.newAxisLabels("$0", "$100")));
        chart.setSize(400, 200);
        chart.setTitle("Quarterly Revenue|(in billions of dollars)", GREEN, 15);
        chart.setBackgroundFill(Fills.newSolidFill(LIGHTGREY));
        chart.setAreaFill(Fills.newSolidFill(LIGHTSEAGREEN));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
    }

    @Test
    public void test01(){
        BarChartPlot team1 = Plots.newBarChartPlot(Data.newData(25, 43, 12, 30), BLUEVIOLET, "Team A");
        BarChartPlot team2 = Plots.newBarChartPlot(Data.newData(8, 35, 11, 5), ORANGERED, "Team B");
        BarChartPlot team3 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 30), LIMEGREEN, "Team C");

        BarChart chart = GCharts.newBarChart(team1, team2, team3);

        AxisStyle axisStyle = AxisStyle.newAxisStyle(BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Score", 50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year.setAxisStyle(axisStyle);

        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2002", "2003", "2004", "2005"));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 100));
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);

        chart.setSize(600, 450);
        chart.setBarWidth(100);
        chart.setSpaceWithinGroupsOfBars(20);
        chart.setDataStacked(true);
        chart.setTitle("Team Scores", BLACK, 16);
        chart.setGrid(100, 10, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, LAVENDER, 100);
        fill.addColorAndOffset(WHITE, 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
    }

}
