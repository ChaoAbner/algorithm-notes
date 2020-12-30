package com.fosuchao.type.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chao Ye on 2020/12/30
 * 寻找k值
 * k值为无序数组中的一项：所有左值都比它更小，所有右值都比它更大
 * [1, 3, 2, 5, 7, 7, 9]
 */
public class FindValue {

    public static List<Integer> findK(int[] arr) {
        int len = arr.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = arr[0];
        dpMin[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1], arr[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            dpMin[i] = Math.min(dpMin[i + 1], arr[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (dpMax[i] == dpMin[i] && (i == 0 || arr[i - 1] < arr[i]) && (i == len - 1 || arr[i + 1] > arr[i])) {
                res.add(dpMax[i]);
            }
        }
        return res;
    }
}
