package com.fosuchao.random;

import java.util.Arrays;

/**
 * @Description: ɾ�����������е��ظ���
 * @Auther: Joker Ye
 * @Date: 2019/11/24 15:42
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println("���ȣ�" + i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
}
