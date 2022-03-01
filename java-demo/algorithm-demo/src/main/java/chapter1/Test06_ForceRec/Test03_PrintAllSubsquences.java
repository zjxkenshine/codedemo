package chapter1.Test06_ForceRec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 10:11
 * @description：打印所有字符串子序列
 * @modified By：
 * @version: $
 */
public class Test03_PrintAllSubsquences {
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    // 暴力递归尝试方法一 省空间方式
    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    // 暴力递归尝试方法二 从左往右，每个字符判断要和不要
    /**
     * @param chs
     * @param i    到i位置
     * @param res 之前选择所形成的的结果
     */
    public static void process(char[] chs, int i, List<Character> res) {
        // 终止位置，打印之前的选择
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        // 添加当前字符
        resKeep.add(chs[i]);
        // 要当前字符的路
        process(chs, i+1, resKeep);
        List<Character> resNoInclude = copyList(res);
        // 不要当前字符的路
        process(chs, i+1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);
    }
}
