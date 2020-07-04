package com.fosuchao.random;

import java.util.Arrays;

/**
 * @Description: �Ƴ�ָ��Ԫ�� https://leetcode-cn.com/problems/remove-element/
 * @Auther: Joker Ye
 * @Date: 2019/11/25 18:21
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
//        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLength] = nums[i];
                newLength++;
            }
        }
        return newLength;
    }
}
