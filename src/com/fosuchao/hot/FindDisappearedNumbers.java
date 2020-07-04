package com.fosuchao.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/23 18:11
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = nums[index] * -1;
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();

        findDisappearedNumbers.findDisappearedNumbers(nums);
    }
}
