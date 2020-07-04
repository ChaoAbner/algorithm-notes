package com.fosuchao.hot;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/2/25 10:35
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println();
        new CountBits().countBits(2);
    }

    public int[] countBits(int num) {
        int [] res = new int[num + 1];
        for (int i = 0; i < num; i++) {
            res[i] = getOneNum(i);
        }
        return res;
    }

    private int getOneNum(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num = (num - 1) & num;
        }
        return res;
    }
}
