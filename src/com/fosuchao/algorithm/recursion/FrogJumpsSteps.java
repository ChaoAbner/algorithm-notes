package com.fosuchao.algorithm.recursion;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Auther: Joker Ye
 * @Date: 2020/1/3 14:38
 */
public class FrogJumpsSteps {
    public static void main(String[] args) {
        System.out.println(jump(3));
    }

    private static int jump(int n){
        // 1、函数功能，获取n阶楼梯有几种跳法
        if (n <= 1){
            // 2、终止条件，一阶楼梯，1中跳法
            return 1;
        }
        // 3、等价关系式
        return jump(n - 2) + jump(n - 1);

    }
}
