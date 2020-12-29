package com.fosuchao.enterprise.bytedance.enterprise;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 60. 第k个排列
 */
public class Num60 {

    public static void main(String[] args) {
        System.out.println(new Num60().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        // 因为索引是从0开始的，k要减一
        k--;

        // 保存所有阶数的阶乘
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 保存1-n的数，用于取数
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            // 桶的索引
            int index = k / factorial[i];
            // 从高位到低位添加数字，并且移除被使用的数字
            sb.append(nums.remove(index));
            // 更新k值，减去相应的桶对应的阶乘
            k -= index * factorial[i];
        }
        return sb.toString();
    }
}
