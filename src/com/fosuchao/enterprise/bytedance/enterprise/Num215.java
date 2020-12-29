package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 215. 数组中的第K个最大元素
 */

public class Num215 {

    static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;
        while (true) {
            int curr = partition(nums, left, right);
            if (curr == target) {
                return nums[curr];
            } else if (curr < target) {
                left = curr + 1;
            } else {
                right = curr - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        // 随机索引
        if (left < right) {
            int randomIdx = random.nextInt(right - left) + left + 1;
            swap(nums, left, randomIdx);
        }
        int pivot = nums[left];
        int l = left;
        for (int i = l + 1; i < right; i++) {
            if (nums[i] < pivot) {
                l++;
                swap(nums, l, i);
            }
        }
        swap(nums, l, left);
        return l;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] n = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(n, 4));
    }
}
