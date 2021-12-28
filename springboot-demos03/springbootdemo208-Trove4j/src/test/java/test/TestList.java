package test;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import org.junit.Test;

import java.util.Random;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 22:56
 * @description：
 * @modified By：
 * @version: $
 */
public class TestList {

    @Test
    public void test(){
        TIntArrayList list = new TIntArrayList();
        //只能添加int类型
        list.add(1);
        //可以添加int数组
        int arr[] = {4,2,3};
        list.add(arr);
        //从数组的某一位置添加，从第二个位置添加，添加两个数字
        list.add(arr,1,2);
        //判断集合是否为空
        if (!list.isEmpty()) {
            System.out.println("集合不为空！");
        }
        //集合的遍历1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //集合的遍历2
        System.out.println("第二种方式遍历结果为：");
        TIntIterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        //数组移除值
        list.removeAt(4); //下表从0开始
        list.remove(1); //下标从1开始
        System.out.println("移除后的结果为：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //获取最大值与最小值
        System.out.println("数组中最大值为：" + list.max());
        System.out.println("数组中最小值为：" + list.min());
        //集合排序,采用升序排序
        list.sort();
        System.out.println("排序后的结果为：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //转化成字符串
        String listToString = list.toString();
        System.out.println(listToString);
        //判断是否包含某值
        if (list.contains(3)) {
            System.out.println("集合包含3元素！！");
        }
        //集合求和
        int sumAll = list.sum();
        System.out.println("数组所有元素的和为:" + sumAll);
        //集合的子集合
        TIntList sublist = list.subList(1, 4);
        for (int i = 0; i < sublist.size(); i++) {
            System.out.println(sublist.get(i));
        }
        //集合反转
        list.reverse();
        System.out.println("集合反转后结果为：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //集合在某位置插入值
        list.insert(0, 5);
        System.out.println("插入值的结果为：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //集合随机打乱
        list.shuffle(new Random());
        System.out.println("集合打乱操作");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //集合清空
        list.clear();
    }
}
