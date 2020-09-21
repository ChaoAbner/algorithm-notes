package com.fosuchao.bytedance.enterprise;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 33. 搜索旋转排序数组
 */

public class Num33 {

    /**
     * [4,5,6,7,0,1,2]
     * 分四种条件
     * 1、旋转点左边
     *    1.1 大于target
     *    1.2 小于target
     * 2、旋转点右边
     *    2.1 大于target
     *    2.2 小于target
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int curr = nums[mid];
            if (curr == target) {
                return mid;
            }
            if (nums[0] <= curr) {
                if (nums[0] <= target && target < curr) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && curr < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
