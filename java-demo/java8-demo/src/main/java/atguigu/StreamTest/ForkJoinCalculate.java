package atguigu.StreamTest;

import java.util.concurrent.RecursiveTask;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 18:21
 * @description：    Fork/Join 实现
 * @modified By：
 * @version: $
 * TODO: 该类有bug需要修改
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = 1234567890L;

    private long start;
    private long end;
    /**
     * 临界点
     */
    private static final long THRESHPLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if (length <= THRESHPLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinCalculate left = new ForkJoinCalculate(start, end);
            left.fork(); //拆分子任务 压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
