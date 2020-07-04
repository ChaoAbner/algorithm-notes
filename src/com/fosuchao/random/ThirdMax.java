package com.fosuchao.random;

import java.util.Arrays;

/**
 * @Description: �õ������е������������û���򷵻�������������
 * @Auther: Joker Ye
 * @Date: 2019/11/13 10:42
 */
public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,1};
        int i = thirdMax(nums);
        System.out.println(i);
    }

    public static int thirdMax(int[] nums) {

        Arrays.sort(nums);
        if(nums.length < 3){
            return nums[nums.length - 1];
        }
        int cursor = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] != nums[i+1]){
                cursor++;
            }
            if(cursor == 2){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
