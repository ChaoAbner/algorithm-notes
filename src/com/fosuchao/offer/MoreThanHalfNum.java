package com.fosuchao.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: offer pdf 183页 29题 找出数组中出现次数超过数组长度一半的数字
 * @Auther: Joker Ye
 * @Date: 2020/2/4 19:41
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] nums = {15, 2, 2, 2, 2, 2, 2, 1, 2, 7, 3, 2, 4, 1, 9};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
//        System.out.println(moreThanHalfNum.moreThanHalfNum1(nums));
//        Arrays.sort(nums);
        System.out.println(moreThanHalfNum.moreThanHalfNum2(nums));
//        System.out.println(moreThanHalfNum.moreThanHalfNum3(nums));
    }

    public int moreThanHalfNum1(int[] nums) {
        // 使用排序取中位数的方法(会改变数组结构）
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int moreThanHalfNum2(int[] nums) {
        // 使用计数法
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (result == nums[i]) {
                times++;
            } else {
                times--;
            }
        }
        // 验证数组的有效性
        times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result)
                times++;
        }
        return times > nums.length / 2 ? result : 0;
    }

    public int moreThanHalfNum3(int[] nums) {
        // 使用哈希表, 或者数组都行
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }


}
