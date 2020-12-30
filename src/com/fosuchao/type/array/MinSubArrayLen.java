package com.fosuchao.type.array;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 09. 长度最小的子数组
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= start;
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
