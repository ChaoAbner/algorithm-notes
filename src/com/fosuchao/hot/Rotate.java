package com.fosuchao.hot;

/**
 * @Description: https://leetcode-cn.com/problems/rotate-image/
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * @Auther: Joker Ye
 * @Date: 2020/1/11 10:32
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int col_point = 0; col_point < n / 2; col_point++) {
            int row_point = col_point;

            while (row_point != (n - col_point - 1)) {
                int temp = matrix[col_point][row_point];
                matrix[col_point][row_point] = matrix[n - row_point - 1][col_point];
                matrix[n - row_point - 1][col_point] = matrix[n - col_point - 1][n - row_point - 1];
                matrix[n - col_point - 1][n - row_point - 1] = matrix[row_point][n - col_point - 1];
                matrix[row_point][n - col_point - 1] = temp;
                row_point++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
    }
}
