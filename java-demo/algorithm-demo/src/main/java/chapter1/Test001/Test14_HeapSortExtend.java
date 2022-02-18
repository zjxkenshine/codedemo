package chapter1.Test001;

import java.util.PriorityQueue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/17 19:48
 * @description：堆排序扩展
 * @modified By：
 * @version: $
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
 * 素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的
 * 排序算法针对这个数据进行排序。
 *
 * 思路：使用小根堆，HeapSize为K，每次弹出一个最小的数，进行排序，并插入一个新的数到堆中
 * java中有现成的PriorityQueue可以使用
 */
public class Test14_HeapSortExtend {
    // 使用大小为K的小根堆实现算法
    public void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 放入小根堆中
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        // 移出小根堆
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    // 小根堆用法
    public static void main(String[] args) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);
        heap.add(3);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

}
