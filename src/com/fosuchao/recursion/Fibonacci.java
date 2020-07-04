package com.fosuchao.recursion;

/**
 * @Description: 斐波那契数列
 * 斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34….，即第一项 f(1) = 1,第二项 f(2) = 1…..,第 n 项目为 f(n) = f(n-1) + f(n-2)。求第 n 项的值是多少。
 * @Auther: Joker Ye
 * @Date: 2020/1/3 14:35
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(f(7));
    }

    private static int f(int n){
        // 1、明确函数是求第n项递增数列的值 1 1 2 3 5 8 13
        // 3、函数的等价关系式为f(n) = f(n - 1) + f(n - 2)
        if (n <= 2){
            // 2、终止递归条件
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }
}
