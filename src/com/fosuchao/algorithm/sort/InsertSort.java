package com.fosuchao.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: Joker Ye
 * @create: 2020/3/8 14:05
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {2, 1, 64, 24, 41, 3, 421, 11, 7, 4567, 35, 2, 33};
        insertSort(nums);
    }

    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int insertVal;
        int insertIndex;
        for (int i = 1; i < nums.length; i++) {
            insertVal = nums[i];    // 当前待插入的数
            insertIndex = i - 1;    // 待插入的数的前一个数的索引

            // 升序排序时，当插入的数比前面的数字小，则insertIndex--,并且前一个数后移
            while (insertIndex >= 0 && nums[insertIndex] > insertVal) {
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }

            // 跳出while循环，说明找到了插入的位置,insertIndex+1
            // 判断insertIndex的合法性
            if (insertIndex + 1 != i) {
                nums[insertIndex + 1] = insertVal;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
