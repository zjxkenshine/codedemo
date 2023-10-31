package com.kenshine.gctoolkit;

import com.kenshine.gctoolkit.aggregation.CollectionCycleCountsSummary;
import com.kenshine.gctoolkit.aggregation.HeapOccupancyAfterCollectionSummary;
import com.kenshine.gctoolkit.aggregation.PauseTimeSummary;
import com.microsoft.gctoolkit.GCToolKit;
import com.microsoft.gctoolkit.io.GCLogFile;
import com.microsoft.gctoolkit.io.SingleGCLogFile;
import com.microsoft.gctoolkit.jvm.JavaVirtualMachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author by kenshine
 * @Classname GcLogTest
 * @Description 测试
 * @Date 2023-10-31 8:46
 * @modified By：
 * @version: 1.0$
 */
public class GcLogTest {
    public static void main(String[] args) throws IOException {

        String gcLogFile = "D:\\Github\\codedemo\\springbootdemos05\\springbootdemo441-Gctoolkit\\gc.log";

        if (Files.notExists(Paths.get(gcLogFile))) {
            throw new IllegalArgumentException(String.format("File %s not found.", gcLogFile));
        }

        GcLogTest main = new GcLogTest();
        main.analyze(gcLogFile);
    }

    public void analyze(String gcLogFile) throws IOException {
        /**
         * GC日志文件有两种类型:单个或一系列滚动日志，这里是单个日志
         */
        GCLogFile logFile = new SingleGCLogFile(Paths.get(gcLogFile));
        GCToolKit gcToolKit = new GCToolKit();

        /**
         * 加载所有Aggregation
         */
        gcToolKit.loadAggregationsFromServiceLoader();

        /**
         *
         * JavaVirtualMachine 包含聚合器
         * 它还包含关于如何为运行时配置JVM的配置信息
         */
        JavaVirtualMachine machine = gcToolKit.analyze(logFile);

        // 检索HeapOccupancyAfterCollectionSummary并处理
        String message = "The XYDataSet for %s contains %s items.\n";
        machine.getAggregation(HeapOccupancyAfterCollectionSummary.class)
                .map(HeapOccupancyAfterCollectionSummary::get)
                .ifPresent(summary -> {
                    summary.forEach((gcType, dataSet) -> {
                        System.out.printf(message, gcType, dataSet.size());
                        switch (gcType) {
                            case DefNew:
                                defNewCount = dataSet.size();
                                break;
                            case InitialMark:
                                initialMarkCount = dataSet.size();
                                break;
                            case Remark:
                                remarkCount = dataSet.size();
                                break;
                            default:
                                System.out.println(gcType + " not managed");
                                break;
                        }
                    });
                });

        Optional<CollectionCycleCountsSummary> summary = machine.getAggregation(CollectionCycleCountsSummary.class);
        summary.ifPresent(s -> s.printOn(System.out));
        // 搜索PauseTimeSummary并进行调用
        machine.getAggregation(PauseTimeSummary.class).ifPresent(pauseTimeSummary -> {
            System.out.printf("Total pause time  : %.4f\n", pauseTimeSummary.getTotalPauseTime());
            System.out.printf("Total run time    : %.4f\n", pauseTimeSummary.getTotalPauseTime());
            System.out.printf("Percent pause time: %.2f\n", pauseTimeSummary.getPercentPaused());
        });

    }

    private int initialMarkCount = 0;
    private int remarkCount = 0;
    private int defNewCount = 0;

    public int getInitialMarkCount() {
        return initialMarkCount;
    }

    public int getRemarkCount() {
        return remarkCount;
    }

    public int getDefNewCount() {
        return defNewCount;
    }
}
