package com.fosuchao.hot;

import java.util.LinkedList;

/**
 * @Description: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @Auther: Joker Ye
 * @Date: 2020/1/26 16:59
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int unsortedSubarray = findUnsortedSubarray.findUnsortedSubarray(nums);

    }

    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int r = -1;
        int l = 0;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for(int i = 0; i < nums.length; i++){
            // 左边开始遍历，找到比前面小的，则找到了边界
            if(nums[i] < min){
                l = i ;
            } else {
                min = nums[i];
            }

            // 右边开始遍历，找到比后面大的，则找到了边界
            if(nums[nums.length - i - 1] > max){
                r = nums.length - i - 1;
            } else {
                max = nums[nums.length - i - 1];
            }
        }

        return r - l + 1;
    }
}
