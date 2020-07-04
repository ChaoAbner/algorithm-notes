package com.fosuchao.offer;

import java.util.ArrayList;

/**
 * @Description: offer pdf 233页面 找出和为sum的所有连续子序列
 * @Auther: Joker Ye
 * @Date: 2020/2/11 16:42
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().findContinuousSequence(15));
    }


    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        if (sum < 3)
            return null;
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        int small = 1;
        int big = 2;
        int currentSum = small + big;
        int middle = (sum + 1) / 2;
        while (small < middle) {
            if (currentSum == sum) {
                addSubToResult(result, small, big);
            }

            while (currentSum > sum && small < middle) {
                currentSum -= small;
                small++;
                if (currentSum == sum) {
                    addSubToResult(result, small, big);
                }
            }
            big++;
            currentSum += big;
        }
        return result;
    }

    private int judge(int small, int big, int target) {
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum += i;
        }
        // 等于0， 相等， 大于0，偏大， 小于0，偏小
        return sum - target;
    }

    public void addSubToResult(ArrayList<ArrayList<Integer>> res,
                               int small, int big) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = small; i <= big; i++){
            list.add(i);
        }
        res.add(list);
    }
}
