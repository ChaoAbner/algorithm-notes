package com.fosuchao.type.dp;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53. 最大子序和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                max = Math.max(sum, max);
                sum += nums[i];
            }
        }
        return max;
    }
}
