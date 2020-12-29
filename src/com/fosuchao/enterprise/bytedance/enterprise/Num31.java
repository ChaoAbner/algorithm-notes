package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.Arrays;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Num31 {

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3};
        nextPermutation(list);
        System.out.println(Arrays.toString(list));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int len = nums.length;
        int i = len - 2;
        // 查找相邻升序的元素
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            // 有后往前查找第一个比nums[i]大的元素
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
