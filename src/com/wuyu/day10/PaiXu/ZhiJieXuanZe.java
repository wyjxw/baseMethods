package com.wuyu.day10.PaiXu;

public class ZhiJieXuanZe {

    /**
     * 直接选择排序：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，
     * 如此循环到倒数第二个数和最后一个数比较为止
     * 最好，最坏，平均O(n2)，不稳定
     * @param args
     */
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        // 直接选择排序
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minindex = i; // 最小数的索引
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) { // 找出最小的数
                    min = a[j];
                    minindex = j;
                }
            }
            a[minindex] = a[i];
            a[i] = min;

        }
    }


}
