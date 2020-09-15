package com.wuyu.day10.BasisMethods;

/**
 * mergeSort时间复杂度是稳定O(nlogn)，
 * 空间复杂度O(n)，稳定的。
 * quickSort时间复杂度平均O(nlogn)，
 * 最坏O(n^2)，最好O(nlogn)，空间复杂度O(nlogn)，不稳定的。
 */
public class GuiBingSort {

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int k = 0;
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left, j = 0; i <= right; i++, j++) {
            nums[i] = temp[j];
        }
    }
}
