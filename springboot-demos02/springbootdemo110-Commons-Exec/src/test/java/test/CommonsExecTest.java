package test;

import org.apache.commons.exec.*;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.function.Consumer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/25 8:38
 * @description：
 * @modified By：
 * @version: $
 */
public class CommonsExecTest {

    /**
     * commons-exec 同步调用
     * @throws IOException
     */
    @Test
    public void testCommonExec() throws IOException {
        String command = "ping www.baidu.com";
        //接收正常结果流
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        //接收异常结果流
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();
        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        int code = exec.execute(commandLine);
        System.out.println("退出代码: " + code);
        System.out.println(susStream.toString("GBK"));
        System.out.println(errStream.toString("GBK"));
    }

    /**
     * JDK中的Runtime 同步调用
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void testJdk() throws InterruptedException, IOException {
        final Process process = Runtime.getRuntime().exec("cmd /c ping localhost");
        new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        process.exitValue();
                        break; // exitValue没有异常表示进程执行完成，退出循环
                    } catch (IllegalThreadStateException e) {
                        // 异常代表进程没有执行完
                    }
                    //
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        process.waitFor();
    }

    /**
     * commons exec 异步调用
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void testCommonExecAsync() throws InterruptedException, IOException {
        String command = "ping www.baidu.com";
        //接收正常结果流
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        //接收异常结果流
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();


        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        ExecuteResultHandler erh = new ExecuteResultHandler() {
            @Override
            public void onProcessComplete(int exitValue) {
                try {
                    String suc = susStream.toString("GBK");
                    System.out.println(suc);
                    System.out.println("3. 异步执行完成");
                } catch (UnsupportedEncodingException uee) {
                    uee.printStackTrace();
                }
            }
            @Override
            public void onProcessFailed(ExecuteException e) {
                try {
                    String err = errStream.toString("GBK");
                    System.out.println(err);
                    System.out.println("3. 异步执行出错");
                } catch (UnsupportedEncodingException uee) {
                    uee.printStackTrace();
                }
            }
        };
        System.out.println("1. 开始执行");
        exec.execute(commandLine, erh);
        System.out.println("2. 做其他操作");
        // 避免主线程退出导致程序退出
        Thread.currentThread().join();
    }


    /**
     *  JDK异步调用
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testJdkAsync() throws IOException, InterruptedException {
        System.out.println("1. 开始执行");
        String cmd = "cmd /c ping www.baidu.com"; // 假设是一个耗时的操作
        execAsync(cmd, processResult -> {
            System.out.println("3. 异步执行完成，success=" + processResult.success + "; msg=" + processResult.result);
            System.exit(0);
        });
        // 做其他操作 ... ...
        System.out.println("2. 做其他操作");
        // 避免主线程退出导致程序退出
        Thread.currentThread().join();
    }

    private void execAsync(String command, Consumer<ProcessResult> callback) throws IOException {
        final Process process = Runtime.getRuntime().exec(command);
        new Thread(() -> {
            StringBuilder successMsg = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"))) {
                // 存放临时结果
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        successMsg.append(line).append("\r\n");
                        int exitCode = process.exitValue();
                        ProcessResult pr = new ProcessResult();
                        if (exitCode == 0) {
                            pr.success = true;
                            pr.result = successMsg.toString();
                        } else {
                            pr.success = false;
                            pr.result = IOUtils.toString(process.getErrorStream(), "utf-8");
                        }
                        callback.accept(pr); // 回调主线程注册的函数
                        break; // exitValue没有异常表示进程执行完成，退出循环
                    } catch (IllegalThreadStateException e) {
                        // 异常代表进程没有执行完
                    }
                    try {
                        // 等待100毫秒在检查是否完成
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static class ProcessResult {
        boolean success;
        String result;
    }

    /**
     * 测试commons-exec超时处理
     * @throws IOException
     */
    @Test
    public void testCommonExecWatch() throws IOException {
        String command = "ping www.baidu.com";
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();
        //设置一分钟超时
        ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000L);
        exec.setWatchdog(watchdog);
        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        try {
            int code = exec.execute(commandLine);
            System.out.println("result code: " + code);
            // 不同操作系统注意编码，否则结果乱码
            String suc = susStream.toString("GBK");
            String err = errStream.toString("GBK");
            System.out.println(suc + err);
        } catch (ExecuteException e) {
            if (watchdog.killedProcess()) {
                // 被watchdog故意杀死
                System.err.println("超时了");
            }
        }
    }





}
