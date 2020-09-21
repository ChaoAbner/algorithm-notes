package com.fosuchao.bytedance.enterprise;

/**
 *
 * 695. 岛屿的最大面积
 */

public class Num695 {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int maxCount = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    maxCount = Math.max(dfs(grid, i, j, r, c), maxCount);
                }
            }
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        for (int[] d : direction) {
            count += dfs(grid, i + d[0], j + d[1], r, c);
        }
        return count;
    }
}
