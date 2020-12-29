package com.fosuchao.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 希尔排序
 * 简单插入排序的高效版本，也称为缩小增量排序
 * @author: Joker Ye
 * @create: 2020/2/29 22:18
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,5,6,11,63,2,54};
//        shellSortUseExchange(nums);
        shellSortUseShift(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 使用交换法的希尔排序
    public static void shellSortUseExchange(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (nums[j] > nums[j + gap]) {
                        int temp = nums[j + gap];
                        nums[j + gap] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

    // 使用移位法的希尔排序
    public static void shellSortUseShift(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                int temp = nums[j];
                while ((j - gap) >= 0 && nums[j] < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp;
            }
        }
    }

}
