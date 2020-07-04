package com.fosuchao.hot;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/17 10:51
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Rob rob = new Rob();
        rob.rob(nums);

    }

    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}
