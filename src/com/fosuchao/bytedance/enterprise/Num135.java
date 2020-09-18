package com.fosuchao.bytedance.enterprise;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * 135. 分发糖果
 * 贪心思想
 */

public class Num135 {

    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] left = new int[len];
        int[] right = new int[len];
        // 先给所有小朋友发一个糖果
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // 左规则，ratings[i] > ratings[i - 1],则left[i] = left[i - 1] + 1
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 右规则同理
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int count = 0;
        // count += left和right的最大值
        for (int i = 0; i < len; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

}
