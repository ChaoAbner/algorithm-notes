package com.fosuchao.type.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * 491. 递增子序列
 */
public class FindSubSequences {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return res;
        }
        dfs(nums, -1, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int last, List<Integer> curr) {
        if (curr.size() > 1) {
            res.add(new ArrayList<>(curr));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = last + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (last == -1 || nums[i] > nums[last]) {
                curr.add(nums[i]);
                dfs(nums, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
