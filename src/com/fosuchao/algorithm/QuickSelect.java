package com.fosuchao.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/6/2 09:19
 */
public class QuickSelect {
    static final int size = 100;
    static int count = 0;
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] nums = new int[size];
        for (int i = size - 1; i > 0; i--) {
            nums[i] = i;
//            nums[i] = count++;
//            nums[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();
//        System.out.println(findKthLargest(nums, 2));
        findKthLargest(nums, 2);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start));
    }

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
