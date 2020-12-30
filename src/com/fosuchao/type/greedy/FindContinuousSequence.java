package com.fosuchao.type.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *  输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int start = 1;      // 滑动窗口的左边界
        int end = 1;        // 滑动窗口的有边界
        List<int[]> res = new ArrayList<>();
        while (end <= (target / 2) + 1) {
            int sum = getSum(start, end);
            if (sum < target) {
                end++;
            } else if (sum > target) {
                start++;
            } else {
                int[] arr = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    arr[i - start] = i;
                }
                res.add(arr);
                start++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private int getSum(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }


    public int[][] findContinuousSequence1(int target) {
        int start = 1;
        int end = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (start <= target / 2) {
            if (sum < target) {
                sum += end;
                end++;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                int[] arr = new int[end - start];
                for (int i = start; i < end; i++) {
                    arr[i - start] = i;
                }
                res.add(arr);
                sum -= start;
                start++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
