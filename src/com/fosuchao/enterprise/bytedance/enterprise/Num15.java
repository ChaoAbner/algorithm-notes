package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 15. 三数之和
 */

public class Num15 {

    /**
     * 1、先排序
     * 2、遍历数组，取每个元素作为基准值
     * 3、使用双指针进行求和，如果等于0则添加到结果中，并使用while循环过滤掉重复的元素
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 排序数组
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 元素需要不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[l], nums[r], nums[i]));
                    res.add(list);
                    // 过滤重复
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
