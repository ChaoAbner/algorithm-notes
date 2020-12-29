package com.fosuchao.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Joker Ye
 * @create: 2020/3/8 15:24
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 5, 6, 11, 63, 2, 54};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 往后面找一个最小的，再替换掉当前索引上的
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }
}
