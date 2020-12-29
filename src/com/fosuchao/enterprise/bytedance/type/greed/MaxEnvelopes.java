package com.fosuchao.enterprise.bytedance.type.greed;

import java.util.Arrays;

/**
 * @description: 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 要求信封的宽和高都必须比之前的要大
 * 可以对于宽进行排序，如果宽相等，那么按照高降序排序，这样问题就转化成了求求最长上升序列的问题（参考leetcode 300）
 *
 * @author: Joker Ye
 * @create: 2020/7/4 17:20
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] en = {{5,4}, {6,4}, {6,7}, {2,3}};
        int i = maxEnvelopes(en);
        System.out.println(i);
    }

    public static int maxEnvelopes(int[][] en) {
        if (en == null || en.length == 0) return 0;

        int len = en.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(en, (o1, o2) ->
                o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        for (int[] ints : en) {
            System.out.println(Arrays.toString(ints));
        }

        return lengthOfLIS(en);
    }

    /**
     * 求最长上升序列
     * @Param [nums]
     * @return int
     */
    private static int lengthOfLIS(int[][] nums) {
        int len = nums.length;

        int[] tails = new int[len];
        tails[0] = nums[0][1];
        int end = 0;

        for (int i = 1; i < len; i++ ) {
            int target = nums[i][1];

            if (target > tails[end]) {
                end++;
                tails[end] = target;
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = target;
            }
        }

        return end + 1;
    }
}
