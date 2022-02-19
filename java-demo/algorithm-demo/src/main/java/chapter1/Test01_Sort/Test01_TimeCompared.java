package chapter1.Test01_Sort;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/14 14:47
 * @description：常数项时间对比
 * @modified By：
 * @version: $
 */
public class Test01_TimeCompared {
    public static void process1(){
        int N = 1000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 2+5;
            a = 4*7;
            a = 6*8;
        }
    }

    public static void process2(){
        int N = 1000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 3|6;
            a = 3&4;
            a = 4^785;
        }
    }

    public static void main(String[] args) {

    }
}
