package com.wuyu.day10.BasisMethods;

/**
 * 二分搜索逼近左边界，
 * 区间[left, right]被分为左区间
 * [left, mid]和右区间[mid + 1, right]。
 */
public class BinarySearch {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }

    /**
     * 二分搜索逼近右边界，
     * 区间[left, right]被分为左区间
     * [left, mid - 1]和右区间[mid, right]。
     */
    public int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        return nums[left];
    }


    /**
     * 暑假在LeetCode打卡的时候发现还有第三种模板,
     * nums[mid] == target 直接return，
     * 区间[left, right]被分为
     * [left, mid - 1]和[mid + 1, right]。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

}
