package com.fosuchao.offer;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了
 * ，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Offer03 {

    // 原地交换
    // 因为所有的数字都在0~n-1之间，可以对数组中的元素进行交换实现原地修改
    // 如果当前的curr不等于对应索引的时候，并且对应索引上的元素与当前的curr相同，说明重复了，则返回当前的curr
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != i && nums[curr] == curr) {
                return curr;
            } else {
                int temp = nums[i];
                nums[i] = nums[curr];
                nums[curr] = temp;
            }
        }
        return -1;
    }
}
