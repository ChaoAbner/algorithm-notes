package com.fosuchao.offer;

/**
 * @Description: offer pdf 229页 找出一个数组中只出现过一次的两个数字，其它数字都出现过两次
 * @Auther: Joker Ye
 * @Date: 2020/2/11 15:42
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int [] array = {2, 2, 3, 3, 4, 5, 5, 6};
        int [] num1 = new int[1];
        int [] num2 = new int[1];
        new FindNumsAppearOnce().findNumsAppearOnce(array, num1, num2);
    }

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 将整个数组异或计算一遍
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            num ^= array[i];
        }

        // 找到结果中的最后一位1
        int indexOf1 = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            indexOf1++;
        }

        // 求出结果
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >> indexOf1 & 1) == 1) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
