package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 */

public class Num54 {

    public static void main(String[] args) {
        int[][] m = {{1, 2 ,3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(m));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        // 定义上下左右边界
        int d = 0;
        int l = 0;
        int u = matrix.length - 1;
        int r = matrix[0].length - 1;

        while (true) {
            // 左至右
            for (int i = l; i <= r; i++) {
                res.add(matrix[d][i]);
            }
            if (++d > u) break;
            // 上至下
            for (int i = d; i <= u; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) break;
            // 右至左
            for (int i = r; i >= l; i--) {
                res.add(matrix[u][i]);
            }
            if (--u < d) break;
            // 下至上
            for (int i = u; i >= d; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }
}
