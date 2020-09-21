package com.fosuchao.bytedance.enterprise;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Num128 {

    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 查出最小的那个值，通过set来判断当前的num减去1是否存在，如果不存在则对当前的num逐渐+1判断是否存在连续的序列
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int len = 0;
            if (set.contains(curr) && !set.contains(curr - 1)) {
                while (set.contains(curr++)) {
                    len++;
                }
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
}
