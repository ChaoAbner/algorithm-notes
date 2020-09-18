package com.fosuchao.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */

public class Offer10 {

    public int fib(int n) {
        int a = 0; // 1  1
        int b = 1; // 1
        int c = 1; // 2

        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % 1000000007;
        }
        return a;
    }
}
