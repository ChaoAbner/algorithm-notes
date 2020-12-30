package com.fosuchao.type.array;

import java.util.Random;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * 384. 打乱数组
 *
 * 方法一：Fisher-Yates算法
 */
public class Shuffle {

    private int[] originArr;
    private int[] resArr;

    public Shuffle(int[] nums) {
        this.originArr = nums.clone();
        this.resArr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originArr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int len = resArr.length;
        for (int i = 0; i < len; i++) {
            int r = random.nextInt(len);
            int temp = resArr[i];
            resArr[i] = resArr[r];
            resArr[r] = temp;
        }
        return resArr;
    }
}
