package com.fosuchao.offer;

import java.util.Arrays;

/**
 * @Description: offer pdf 184页 第三十题 最小的k个数
 * @Auther: Joker Ye
 * @Date: 2020/2/4 20:04
 */
public class GetLastNumbers {

    public static void main(String[] args) {
        int[] list = {4, 5, 1, 6, 2, 7, 3, 8};
        GetLastNumbers getLastNumbers = new GetLastNumbers();
//        int[] sortList = getLastNumbers.quicksort(list, 0, list.length - 1);
//        System.out.println(Arrays.toString(sortList));
        int[] result = getLastNumbers.getLastNumbers(list, 4);
        System.out.println(Arrays.toString(result));
    }

    public int[] getLastNumbers(int[] list, int k) {
        // 排序法（只有能修改原数组的情况下可以使用）
        quicksort(list, 0, list.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list[i];
        }
        return result;
    }

    public int[] quicksort(int[] list, int start, int end) {
        if (start > end) {
            return null;
        }
        // 基准值
        int key = list[start];
        int l = start;
        int r = end;
        while (l < r) {
            // 找出右边比基准值小的索引
            while (l < r && list[r] > key) {
                r--;
            }
            if (l < r) {
                list[l] = list[r];
            }
            // 找出左边比基准值大的索引
            while (l < r && list[l] < key) {
                l++;
            }
            if (l < r) {
                list[r] = list[l];
            }

        }
        list[l] = key;
        // 向左递归
        quicksort(list, start, l - 1);
        // 向右递归
        quicksort(list, l + 1, end);

        return list;
    }

}
