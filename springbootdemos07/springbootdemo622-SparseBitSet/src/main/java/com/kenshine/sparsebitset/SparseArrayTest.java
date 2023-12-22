package com.kenshine.sparsebitset;

/**
 * 当一个数组中的大部分元素为相同的值,可使用稀疏数组来保存该数组
 * 稀疏数组测试
 * @author kenshine
 */
public class SparseArrayTest {

    public static void main(String[] args) {
        // 用二维数组保存棋盘
        int[][] arr = saveChess();
        // 打印二维数组
        print(arr);
        // 将二维数组转化为稀疏数组
        int[][] sparseArr = castSparseArray(arr);
        // 打印稀疏数组
        print(sparseArr);
        // 稀疏数组转二位数组
        int[][] arr2 = castToArray(sparseArr);
        print(arr2);
    }

    /**
     * 打印普通数组
     */
    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }

    /**
     * 将棋盘数据保存为二维数组
     */
    public static int[][] saveChess() {
        // 初始化棋盘（大小为 15 * 15）
        int[][] arr = new int[15][15];
        // 保存白子（用1表示）
        arr[5][5] = 1;
        arr[7][5] = 1;
        arr[6][7] = 1;
        // 保存黑子（用2表示）
        arr[6][6] = 2;
        arr[7][6] = 2;
        arr[8][6] = 2;
        arr[7][7] = 2;
        return arr;
    }

    /**
     * 普通数组转稀疏数组
     * @return 稀疏数组
     */
    public static int[][] castSparseArray(int[][] arr) {
        // 原数组的总行数
        int row = arr.length;
        // 原数组的总列数
        int cloumn = arr[0].length;
        // 获取黑白子总数
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组（sum+1 行表示 sum 个黑白子 + 1行规模）
        int[][] sparseArray = new int[sum + 1][3];
        // 第 1 行原二维数组的行、列、棋子总数
        sparseArray[0][0] = row;
        sparseArray[0][1] = cloumn;
        sparseArray[0][2] = sum;
        // 第 2 行开始存具体数据（每行都是一个棋子数据）
        int sparseRow = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sparseRow++;
                    sparseArray[sparseRow][0] = i;
                    sparseArray[sparseRow][1] = j;
                    sparseArray[sparseRow][2] = arr[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转普通数组
     * @return 普通二维数组
     */
    public static int[][] castToArray(int[][] sparseArr) {
        // 获取稀疏数组第 1 行（记录了原数组的总行数和总列数）
        int[] rowFirst = sparseArr[0];
        // 初始化数组（棋盘）
        int row = rowFirst[0];
        int column = rowFirst[1];
        int[][] arr = new int[row][column];
        // 初始化数据（黑白子）
        for (int i = 1; i < sparseArr.length; i++) {
            int[] sparseRow = sparseArr[i];
            arr[sparseRow[0]][sparseRow[1]] = sparseRow[2];
        }
        return arr;
    }
}