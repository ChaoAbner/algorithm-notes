package com.fosuchao.enterprise.bytedance.type.string;

import java.util.Arrays;

/**
 * @description: 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: Joker Ye
 * @create: 2020/7/4 16:26
 */
public class LIS {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = lengthOfLIS1(nums);
        System.out.println(i);
    }

    // n^2的动态规划
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

    // 贪心 + 二分查找
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int[] tails = new int[len];
        int res = 0;

        for (int num : nums) {
            int start = 0, end = res;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (tails[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            tails[start] = num;
            if (res == end) res++;
        }

        return res;
    }
}
