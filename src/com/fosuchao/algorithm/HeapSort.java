package com.fosuchao.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/3/16 15:12
 */
public class HeapSort {
    private final static int SIZE = 10;

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        int[] nums = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            nums[i] = random.nextInt(SIZE * 10);
        }

        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] heapSort(int[] arr) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}