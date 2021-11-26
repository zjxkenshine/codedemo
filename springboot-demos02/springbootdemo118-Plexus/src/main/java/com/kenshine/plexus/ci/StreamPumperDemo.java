package com.kenshine.plexus.ci;

import org.codehaus.plexus.util.cli.StreamConsumer;
import org.codehaus.plexus.util.cli.StreamPumper;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 16:15
 * @description：
 * @modified By：
 * @version: $
 * Stream抽取器
 */
public class StreamPumperDemo {

    public static void main(String[] args) {
        String line1 = "line1";
        String line2 = "line2";
        String lines = line1 + "\n" + line2;
        ByteArrayInputStream inputStream = new ByteArrayInputStream( lines.getBytes() );

        TestConsumer consumer = new TestConsumer();
        StreamPumper pumper = new StreamPumper(inputStream, consumer);
        new Thread(pumper).run();
    }

    static class TestConsumer implements StreamConsumer {
        private List<String> lines = new ArrayList<>();

        /**
         * 流水线是否被消费
         * @param testLine
         * @param timeout
         * @return
         */
        public boolean wasLineConsumed(String testLine, long timeout) {

            long start = System.currentTimeMillis();
            long trialTime = 0;

            do{
                if(lines.contains(testLine)){
                    return true;
                }
                try {
                    Thread.sleep( 10 );
                } catch ( InterruptedException e ) {
                    //忽略
                }
                //等待时间
                trialTime = System.currentTimeMillis() - start;
            }while ( trialTime < timeout );

            return false;
        }

        @Override
        public void consumeLine(String line ) {
            lines.add(line);
            System.out.println("消费了"+line);
        }
    }
}
