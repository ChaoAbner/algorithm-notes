package com.fosuchao.type.array;

import java.util.ArrayDeque;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 581. 最短无序连续子数组
 */
public class FindUnsortedSubarray {

    /**
     * 单调栈
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int l = len - 1, r = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return l - r == len - 1 ? 0 : r - l + 1;
    }

    /**
     * 双指针
     */
    public int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int l = len - 1, r = 0;
        // TODO: 2020/12/30  
        return 0;
    }
}
