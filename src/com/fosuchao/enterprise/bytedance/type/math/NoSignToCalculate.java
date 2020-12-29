package com.fosuchao.enterprise.bytedance.type.math;

/**
 * @description: 无加号实现加法，无除号实现除法
 * @author: Joker Ye
 * @create: 2020/7/1 15:19
 */
public class NoSignToCalculate {

    public static void main(String[] args) {
        System.out.println(add(4, 5));
        System.out.println(divide(-49, 5));

    }

    public static int add(int num1, int num2) {
        int result = 0;
        int carry = 0;

        do{
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        }while(carry != 0);

        return result;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new RuntimeException("divisor can not be negative");
        if (divisor == 1) return dividend;
        if (dividend == 0) return 0;
        if (dividend == divisor) return 1;

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    private static int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tb = b;

        // 11 3
        // count tb
        // 1      3
        // 2      6
        // 4      12
        while (a <= tb + tb) {
            count += count;
            tb += tb;
        }

        return count + div(a - tb, b);
    }
}
