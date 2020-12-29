package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 739. 每日温度
 */

public class Num739 {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(T);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
