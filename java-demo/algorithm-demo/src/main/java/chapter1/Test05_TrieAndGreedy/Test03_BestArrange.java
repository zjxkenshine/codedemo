package chapter1.Test05_TrieAndGreedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/24 11:51
 * @description：最好的会议安排
 * @modified By：
 * @version: $
 *
 */
public class Test03_BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 根据结束时间最早来安排
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        // 根据结束时间排序
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        // 从左往右依次遍历所有会议
        for (int i = 0; i < programs.length; i++) {
            // 如果能够安排进去 时间不冲突
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }

}
