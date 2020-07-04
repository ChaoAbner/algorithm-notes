package com.fosuchao.algorithm;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/26 10:38
 * @noinspection Duplicates
 */
public class QuicklySort {
    public static void main(String[] args) {
        int[] list = {34,3,2,6,87,2,1,8};
        QuicklySort quicklySort = new QuicklySort();
        quicklySort.quicklySort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }

    // 递归实现
    public void quicklySort(int[] list, int start, int end){
        if (start > end) return;

        int l = start;
        int r = end;
        int key = list[start];

        while (l < r) {
            while (l < r && list[r] > key) {
                r--;
            }
            if (l < r) {
                list[l] = list[r];
                l++;
            }

            while (l < r && list[l] < key) {
                l++;
            }
            if (l < r) {
                list[r] = list[l];
                r--;
            }
        }

        list[l] = key;
        quicklySort(list, start, l - 1);
        quicklySort(list, l + 1, end);

    }

}
