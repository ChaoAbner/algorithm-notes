package com.fosuchao.algorithm;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/26 11:22
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {34,3,2,6,87,2,1,8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }

    public void bubbleSort(int[] list){
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j < list.length - i - 1; j++){
                // 升序list[j] > list[j+1]    降序list[j] < list[j+1]
                if(list[j] > list[j + 1]){
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
