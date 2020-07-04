package com.fosuchao.hot;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/16 10:43
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3,4,3};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement(nums);
        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : objectObjectHashMap.entrySet()) {

        }

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int temp = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count > nums.length / 2){
                return temp;
            }
            if(nums[i] != temp){
                temp = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        return temp;
    }
}
