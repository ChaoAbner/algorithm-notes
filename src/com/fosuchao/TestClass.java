package com.fosuchao;

import com.fosuchao.bytedance.datastructure.ListNode;
import com.fosuchao.random.MaxRotate;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/4 09:28
 * @noinspection Duplicates
 */
public class TestClass {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) { //——步骤二
                sum += i;
            }
            //——这里会阻塞
            LockSupport.park(); //——步骤四
            System.out.println(sum); //——步骤五
        });
        thread.start(); //——步骤一
        Thread.sleep(3000);
        LockSupport.unpark(thread); //——步骤三
    }

    private static void heapify(int[] nums, int i, int n) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;

        int max = i;
        if (c1 < n && nums[c1] > nums[max]) {
            max = c1;
        }
        if (c2 < n && nums[c2] > nums[max]) {
            max = c2;
        }
        if (max != i) {
            swap(nums, max, i);
            heapify(nums, max, n);
        }
    }

    private static void buildHeap(int[] nums, int n) {
        int lastIndex = n - 1;
        int parentIndex = (lastIndex - 1) / 2;
        for (int i = parentIndex; i >= 0; i--) {
            heapify(nums, i, n);
        }
    }

    private static void heapSort(int[] nums) {
        buildHeap(nums, nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            buildHeap(nums, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
