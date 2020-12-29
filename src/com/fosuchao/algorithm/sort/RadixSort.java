package com.fosuchao.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 基数排序
 * 根据元素的位数进行排序，由个位到最高位
 * @author: Joker Ye
 * @create: 2020/3/8 15:56
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = { 53, 3, 542, 748, 14, 214};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int getMaxNumLength(int [] nums) {
        int maxNum = getMaxNum(nums);
        int length = 0;
        while (maxNum != 0) {
            length++;
            maxNum /= 10;
        }
        return length;
    }

    private static int getMaxNum(int [] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void radixSort(int[] nums) {
        // 定义一个二维数组
        int [][] bucket = new int[10][nums.length];
        // 获取最大位数
        int maxNumLength = getMaxNumLength(nums);
        // 记录每个桶中实际存放了多少元素
        int [] bucketRealLength = new int[10];

        for (int l = 0, div = 1; l < maxNumLength; l++, div *= 10) {
            int index = 0;

            // 根据数字的位数排序，并放在相应的桶中
            for (int i = 0; i < nums.length; i++) {
                int hash = nums[i] / div % 10;
                int realLength = bucketRealLength[hash];
                bucket[hash][realLength] = nums[i];
                bucketRealLength[hash]++;
            }

            // 按顺序将桶中的元素取出放回nums数组
            for (int i = 0; i < bucketRealLength.length; i++) {
                if (bucketRealLength[i] != 0) {
                    // 有元素才添加
                    for (int j = 0; j < bucketRealLength[i]; j++) {
                        nums[index++] = bucket[i][j];
                    }
                    bucketRealLength[i] = 0;
                }
            }
        }
    }
}
