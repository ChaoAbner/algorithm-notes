package com.fosuchao.offer;

/**
 * @Description: offer 189页 31题 找到数组中和最大的连续子数组的和
 * @Auther: Joker Ye
 * @Date: 2020/2/4 22:16
 */
public class FindGreatestSumOfArray {
    public static void main(String[] args) {
        int[] list = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new FindGreatestSumOfArray().findGreatestSumOfArray(list));
    }

    public int findGreatestSumOfArray(int[] list) {
        if (list == null)
            return 0;
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < list.length; i++) {
            if (sum < 0)
                sum = list[i];
            else
                sum += list[i];

            result = Math.max(result, sum);
        }
        return result;
    }


}
