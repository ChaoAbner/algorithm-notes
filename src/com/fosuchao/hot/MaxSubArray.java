package com.fosuchao.hot;

/**
 * @Description: �������� https://leetcode-cn.com/problems/maximum-subarray/
 * @Auther: Joker Ye
 * @Date: 2019/11/29 22:15
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);

    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            if(sum > 0){
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }

        return max;
    }

}
