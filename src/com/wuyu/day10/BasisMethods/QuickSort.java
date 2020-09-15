package com.wuyu.day10.BasisMethods;

/**
 * 快速排序要注意x取值的边界情况。
 * 取x = nums[left], nums分为[left, j]和[j + 1, right]，
 * 或x = nums[right], nums分为[left, i - 1]和[i, right],
 * 否则会StackOverflow。
 */
public class QuickSort {

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int i = left - 1, j = right + 1, x = nums[left];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

}
