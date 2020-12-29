package com.fosuchao.algorithm.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @Auther: Joker Ye
 * @Date: 2020/2/10 22:00
 */
public class MergeSort {
    public static void main(String[] args) throws Exception {
        int size = 20;
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * size);
        }
        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(nums));
        MergeSort mergeSort = new MergeSort();
        int[] temp = new int[nums.length];
        mergeSort.sort1(nums, 0, nums.length - 1, temp);
//        int[] sort = mergeSort.sort2(nums);
        long end = System.currentTimeMillis();
        System.out.println(size + "数据排序花费时间（豪秒）" + (end - start));
        System.out.println(Arrays.toString(nums));
    }

    public void sort1(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            // 向左拆分
            sort1(nums, left, mid, temp);
            // 向右拆分
            sort1(nums, mid + 1, right, temp);
            // 开始合并
            merge1(nums, left, mid, right, temp);
        }
    }

    private void merge1(int[] nums, int left, int mid, int right, int[] temp) {
        int l = left;
        int j = mid + 1;
        int tempIndex = 0;

        while (l <= mid && j <= right) {
            // 继续判断
            if (nums[l] >= nums[j]) {
                temp[tempIndex++] = nums[j++];
            } else {
                temp[tempIndex++] = nums[l++];
            }
        }

        while (l <= mid) {
            temp[tempIndex++] = nums[l++];
        }

        while (j <= right) {
            temp[tempIndex++] = nums[j++];
        }

        for (int i = 0; i < tempIndex; i++) {
            nums[i + left] = temp[i];
        }

    }

    public int[] sort2(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge2(sort2(left), sort2(right));
    }

    protected int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


}
