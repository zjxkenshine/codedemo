package atguigu.DateTimeTest;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 19:02
 * @description：时间日期API测试1
 * @modified By：
 * @version: $
 *
 * 传统SimpleDateFormatter与DateTimeFormatter
 */
public class DateTimeTest01 {

    /**
     * 传统的日期格式化的安全问题
     */
    @Test
    public void test01(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = () -> sdf.parse("2020-05-17");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<Date> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    /**
     * 时间日期加锁
     */
    @Test
    public void test02(){
        Callable<Date> task = () -> DateFormatThreadLocal.convert("2020-05-17");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<Date> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }

    /**
     * DateFormatter格式化
     */
    @Test
    public void test03(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Callable<LocalDate> task = () -> LocalDate.parse("2020-05-17",dtf);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<LocalDate>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<LocalDate> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }


}
