package com.fosuchao.type.math;

/**
 * Created by Chao Ye on 2020/12/29
 * <p>
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * 1103. 分糖果 II
 */
public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int i = 1;
        int idx = 0;
        while (candies > 0) {
            if (i > candies) {
                nums[idx] += candies;
                return nums;
            } else {
                nums[idx++] += i;
            }
            candies -= i;
            i++;
            if (idx == num_people) {
                idx = 0;
            }
        }
        return nums;
    }
}
