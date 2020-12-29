package com.fosuchao.type.greedy;

import java.util.Arrays;

/**
 * Created by Chao Ye on 2020/12/29
 * https://leetcode-cn.com/problems/candy/
 * 135. 分发糖果
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int len = ratings.length;
        int [] candies = new int[len];
        // 先给每个孩子都分配一颗糖
        Arrays.fill(candies, 1);
        // 左规则，ratings[i - 1] < ratings[i]的时候，加1
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 右规则，ratings[i] > ratings[i + 1]的时候，加1
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += candies[i];
        }
        return count;
    }
}
