package hppcTest;

import com.carrotsearch.hppc.SuppressForbidden;

import java.util.Locale;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 18:38
 * @description：输出格式化
 * @modified By：
 * @version: $
 */
public class Helpers {

    @SuppressForbidden
    public static void printf(String msg, Object... args) {
        System.out.printf(Locale.ROOT, msg, args);
    }

    @SuppressForbidden
    public static void printfln(String msg, Object... args) {
        System.out.printf(Locale.ROOT, msg, args);
        System.out.println();
    }

}
