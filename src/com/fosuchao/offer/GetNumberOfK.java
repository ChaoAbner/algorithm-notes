package com.fosuchao.offer;

/**
 * @Description: offer pdf 38题 找出排序数组中一个数出现的个次数
 * @Auther: Joker Ye
 * @Date: 2020/2/11 13:14
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int [] nums = {1,2, 3, 3, 3, 3, 5, 6, 7};
        int i = new GetNumberOfK().GetNumberOfK(nums, 3);
        System.out.println(i);
    }

    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if (array != null && array.length > 0) {
            int first = getFirstOfK(array, k, 0, array.length - 1);
            int last = getLastOfK(array, k, 0, array.length - 1);

            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    private int getFirstOfK(int [] array, int k, int start, int end) {
        // 查找第一个k
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        // 如果找到了k
        if (array[mid] == k) {
            if ((mid > 0 && array[mid - 1] != k)
                    || mid == 0)
                return mid;
            else
                end = mid - 1;
        }
        // 如果数字大于k，那么往前找
        if (array[mid] > k) {
            end = mid - 1;
        }
        // 小于k，往后找
        if (array[mid] < k) {
            start = mid + 1;
        }
        return getFirstOfK(array, k, start, end);
    }

    private int getLastOfK(int [] array, int k, int start, int end) {
        // 查找第一个k
        if (start > end)
            // 没找到
            return -1;
        int mid = (start + end) / 2;
        // 如果找到了k
        if (array[mid] == k) {
            if ((mid < array.length - 1 && array[mid + 1] != k)
                    || mid == array.length - 1)
                return mid;
            else
                start = mid + 1;
        }
        // 如果数字大于k，那么往后找
        if (array[mid] > k) {
            end = mid - 1;
        }
        // 小于k，往后找
        if (array[mid] < k) {
            start = mid + 1;
        }
        return getLastOfK(array, k, start, end);
    }
}
