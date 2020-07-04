package com.fosuchao.offer;

/**
 * @Description: offer pdf 191页 第三十二题
 * 从1到n的整数中1出现的次数
 * @Auther: Joker Ye
 * @Date: 2020/2/6 21:18
 */
public class NumberOfOneBetweenOneAndN {
    public static void main(String[] args) {
        System.out.println(new NumberOfOneBetweenOneAndN().numberOf1Beteen1AndN(12));
        System.out.println(new NumberOfOneBetweenOneAndN().NumberOf1Between1AndN_Solution(12));
    }

    public int numberOf1Beteen1AndN(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0){
                if ((temp % 10) == 1) {
                    num++;
                }
                temp = temp / 10;
            }
        }
        return num;
    }


    public int NumberOf1Between1AndN_Solution(int n) {
        // https://blog.csdn.net/yi_afly/article/details/52012593
        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0) {
            int weight = round % 10;  //round的最后一位数,从个位数开始
            round /= 10;
            count += round * base;
            if (weight == 1)
                count += (n % base) + 1;
            else if (weight > 1)
                count += base;
            base *= 10;
        }
        return count;
    }

}
